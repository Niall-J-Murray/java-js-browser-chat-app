var user = sessionStorage.getItem('user')
if (user == null) {
  window.location.href = '/welcome'
} else {
  user = JSON.parse(sessionStorage.getItem('user'))
}
setInterval(getMessages, 500)

var channelId = document.getElementById('channelId').getAttribute('data-id')
var chatInput = document.querySelector('#chat-input')

chatInput.addEventListener('keyup', e => {
  if (e.keyCode === 13) {
    let message = {
      channelId: channelId,
      user: user,
      timestamp: new Date().toISOString().substring(11, 19),
      messageContent: chatInput.value
    }
    chatInput.value = ''
    fetch('/messages', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(message)
    }).then(response => {
      getMessages()
    })
    return false
  }
})

function getMessages () {
  let postedMessages = document.querySelector('#posted-messages')
  fetch(`/messages/${channelId}`)
    .then(response => response.json())
    .then(messages => {
      postedMessages.innerHTML = ''
      messages.forEach(message => {
        postedMessages.innerHTML += `<div>
        <div>
        <span id="username">${message.user.username}</span>
        <span id="timestamp">${message.timestamp}</span>
        </div>
		  	  <span id="messageContent">${message.messageContent}</span>
			</div>`
      })
    })
}
