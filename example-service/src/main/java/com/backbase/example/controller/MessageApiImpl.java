package com.backbase.example.controller;

import com.backbase.message.api.MessageApi;
import com.backbase.message.api.model.MessageItem;
import com.backbase.message.api.model.MessageId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageApiImpl implements MessageApi {

    private final static Logger LOGGER = LoggerFactory.getLogger(MessageApiImpl.class);

    @Override
    public ResponseEntity<MessageItem> getMessage(String id) {
        LOGGER.info("Start getMessage");
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> deleteMessage(String id) {
        LOGGER.info("Start deleteMessage");
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<MessageId> postMessage(MessageItem messageItem) {
        LOGGER.info("Start postMessage");
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> putMessage(MessageItem messageItem) {
        LOGGER.info("Start putMessage");
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<MessageItem>> getMessages() {
        LOGGER.info("Start getMessages");
        return ResponseEntity.ok().build();
    }
}
