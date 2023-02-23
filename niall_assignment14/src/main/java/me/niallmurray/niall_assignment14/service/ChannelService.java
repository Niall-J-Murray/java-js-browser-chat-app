package me.niallmurray.niall_assignment14.service;

import me.niallmurray.niall_assignment14.domain.Channel;
import me.niallmurray.niall_assignment14.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelService {

    @Autowired
    private ChannelRepository channelRepository;

    public void createRandomChannel(){
        channelRepository.createRandomChannel();
    }

    public Channel findChannelById(Long channelId) {
        return channelRepository.findById(channelId);
    }

    public List<Channel> findAll() {
        return channelRepository.findAll();
    }

    public void save(String channelName) {
        channelRepository.save(channelName);
    }
}