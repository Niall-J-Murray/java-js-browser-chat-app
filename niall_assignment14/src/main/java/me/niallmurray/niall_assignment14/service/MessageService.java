package me.niallmurray.niall_assignment14.service;

import me.niallmurray.niall_assignment14.domain.Channel;
import me.niallmurray.niall_assignment14.domain.Message;
import me.niallmurray.niall_assignment14.repository.ChannelRepository;
import me.niallmurray.niall_assignment14.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class MessageService {
  @Autowired
  private MessageRepository messageRepository;
  @Autowired
  private ChannelRepository channelRepository;


  public List<Message> getMessagesByChannel(Long channelId) {
    return messageRepository.findMessagesByChannel(channelId).orElse(new ArrayList<>());
  }

  public void addMessageToChannel(Message message) {
    Channel channel = channelRepository.findById(message.getChannelId());
    List<Message> messagesByChannel = getMessagesByChannel(message.getChannelId());
      messagesByChannel.add(message);
      messageRepository.saveMessagesByChannel(message.getChannelId(), messagesByChannel);
  }

}