package com.backbase.example.mapper;

import com.backbase.dbs.messaging_service.api.service.v2.model.MessageItem;
import com.backbase.example.domain.Greeting;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface GreetingsMapper {

    GreetingsMapper INSTANCE = Mappers.getMapper(GreetingsMapper.class);

    MessageItem greetingToMessage(Greeting greeting);

    List<MessageItem> greetingsToMessages(List<Greeting> greetings);

    Greeting messageToGreeting(MessageItem message);
}