package com.backbase.example.controller;

import com.backbase.dbs.messaging_service.api.service.v2.model.MessageItem;
import com.backbase.example.domain.Greeting;
import com.backbase.example.mapper.GreetingsMapper;
import com.backbase.example.service.GreetingsService;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    private final GreetingsService greetingsService;

    @Autowired
    public ExampleController(GreetingsService greetingsService) {
        this.greetingsService = greetingsService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/message/{id}", produces = {
            "application/json"
    })
    @ResponseStatus(HttpStatus.OK)
    public MessageItem getMessage(@PathVariable String id) {
        Greeting greeting = greetingsService.getGreetingById(id);
        return GreetingsMapper.INSTANCE.greetingToMessage(greeting);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/messages", produces = {
            "application/json"
    })
    @ResponseStatus(HttpStatus.OK)
    public List<MessageItem> getMessages() {
        List<Greeting> greetings = greetingsService.getGreetings();
        return GreetingsMapper.INSTANCE.greetingsToMessages(greetings);
    }

    // tag::addMessage[]
    @RequestMapping(method = RequestMethod.POST, value = "/message")
    @ResponseStatus(HttpStatus.CREATED)
    public String addMessage(@RequestBody MessageItem message) {
        Greeting greeting = GreetingsMapper.INSTANCE.messageToGreeting(message);
        String id = UUID.randomUUID().toString();
        greeting.setId(id);
        greetingsService.addNewGreeting(greeting);
        return id;
    }
// end::addMessage[]
}