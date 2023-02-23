package me.niallmurray.niall_assignment14.web;

import me.niallmurray.niall_assignment14.domain.Message;
import me.niallmurray.niall_assignment14.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {
  @Autowired
  private MessageService messageService;

  @GetMapping("/messages/{channelId}")
  public List<Message> getMessagesByChannelId (@PathVariable Long channelId) {

    return messageService.getMessagesByChannel(channelId);
  }

  @PostMapping("/messages")
  public void postMessagesToUserId (@RequestBody Message message) {
    messageService.addMessageToChannel(message);
  }
}
