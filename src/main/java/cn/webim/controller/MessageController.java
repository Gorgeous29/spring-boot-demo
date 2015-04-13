package cn.webim.controller;

import cn.webim.domain.Message;
import cn.webim.domain.User;
import cn.webim.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("message")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @RequestMapping(method = RequestMethod.POST)
    public void sendMessage(@Valid Message message, HttpSession session) {
        message.setSender((User) session.getAttribute("user"));
        messageService.sendMessage(message);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Message> getMessage(long id) {
        return messageService.findByIdGreaterThan(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "maxId")
    public Long maxId() {
        return messageService.findMaxMessageId();
    }
}
