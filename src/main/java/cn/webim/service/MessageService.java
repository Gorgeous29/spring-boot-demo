package cn.webim.service;

import cn.webim.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    /**
     * 查找大于id的消息
     */
    public List<Message> findByIdGreaterThan(long id) {
        return messageRepository.findByIdGreaterThan(id);
    }

    /**
     * 发消息
     */
    public void sendMessage(Message message) {
        messageRepository.save(message);
    }

    /**
     * 查找最大id
     */
    public Long findMaxMessageId() {
        return messageRepository.findMaxMessageId();
    }
}
