package ru.practicum.ewm.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import ru.practicum.ewm.dto.request.RequestDto;
import ru.practicum.ewm.model.Request;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface RequestMapper {

    List<RequestDto> toRequestDtoList(List<Request> allByEventWithInitiator);

    @Mapping(source = "event.id", target = "eventId")
    @Mapping(source = "requester.id", target = "requesterId")
    RequestDto toRequestDto(Request save);
}