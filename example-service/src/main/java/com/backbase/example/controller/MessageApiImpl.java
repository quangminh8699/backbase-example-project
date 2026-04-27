package com.backbase.example.controller;

import com.backbase.dbs.messaging_service.api.service.v2.MessageApi;
import com.backbase.dbs.messaging_service.api.service.v2.model.MessageId;
import com.backbase.dbs.messaging_service.api.service.v2.model.MessageItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageApiImpl implements MessageApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageApiImpl.class);

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
