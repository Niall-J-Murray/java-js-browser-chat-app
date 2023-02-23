package me.niallmurray.niall_assignment14.repository;

import me.niallmurray.niall_assignment14.domain.Message;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class MessageRepository {
  private Map<Long, List<Message>> messages = new HashMap<>();

  public Optional<List<Message>> findMessagesByChannel (Long channelId) {
    List<Message> messagesByChannel = messages.get(channelId);
    return Optional.ofNullable(messagesByChannel);
  }

  public void saveMessagesByChannel(Long channelId, List<Message> messagesByChannel) {
    messages.put(channelId, messagesByChannel);
  }
}
