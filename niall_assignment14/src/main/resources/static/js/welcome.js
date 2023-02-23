var user = sessionStorage.getItem('user')

if (user == null) {
  let randomUserNumber = Math.floor(Math.random() * 100)
  let username = prompt(
    'Welcome! Please choose a username:',
    'New User-#' + randomUserNumber
  )
  while (username === '' || username == null) {
    username = prompt(
      'Welcome! Please choose a username:',
      'New User-#' + randomUserNumber
    )
  }
  fetch('/register', {
    method: 'POST',
    body: username
  })
    .then(response => response.json())
    .then(user => {
      sessionStorage.setItem('user', JSON.stringify(user))
    })
} else {
  user = JSON.parse(sessionStorage.getItem('user'))
  console.log(user)
}
