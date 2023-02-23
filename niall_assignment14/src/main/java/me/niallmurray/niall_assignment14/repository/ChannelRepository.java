package me.niallmurray.niall_assignment14.repository;

import me.niallmurray.niall_assignment14.domain.Channel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class ChannelRepository {
  private List<Channel> channels = new ArrayList<>();

  public Channel findById (Long channelId) {
    return channels.stream()
            .filter(c -> c.getChannelId().equals(channelId))
            .findFirst().orElse(new Channel());
  }

  public List<Channel> findAll() {
    return channels;
  }

  public void createRandomChannel(){
    Channel random = new Channel();
    random.setChannelId(1L);
    random.setChannelName("Random Chat");
    channels.add(random);
  }

  public Channel save(String channelName) {
    Channel channel = new Channel();
    channel.setChannelId((long) (channels.size() +1));
    channel.setChannelName(channelName);
    channels.add(channel);

    return channel;
  }


}