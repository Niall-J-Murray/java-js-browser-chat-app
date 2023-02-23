package me.niallmurray.niall_assignment14.web;

import me.niallmurray.niall_assignment14.domain.Channel;
import me.niallmurray.niall_assignment14.domain.Message;
import me.niallmurray.niall_assignment14.service.ChannelService;
import me.niallmurray.niall_assignment14.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ChannelController {
  @Autowired
  private ChannelService channelService;
  @Autowired
  private MessageService messageService;


  @GetMapping("/")
  public String welcomeRedirect() {
    return "redirect:/welcome";
  }

  @GetMapping("/welcome")
  public String getWelcome(ModelMap model) {
    List<Channel> channels = channelService.findAll();
    if (channels.isEmpty()) {
      channelService.createRandomChannel();
    }
    model.addAttribute("channels", channels);

    return "welcome";
  }

  @GetMapping("/channels/{channelId}")
  public String getChannel(ModelMap model, @PathVariable Long channelId) {
    Channel channel = channelService.findChannelById(channelId);
    List<Message> messagesByChannel = messageService.getMessagesByChannel(channelId);
    model.addAttribute("channel", channel);
    model.addAttribute("messages", messagesByChannel);

    return "channel";
  }

  @PostMapping("/channels/new")
  public String createChannel (@RequestParam String channelName) {
    channelService.save(channelName);

    return "redirect:/welcome";
  }
}
