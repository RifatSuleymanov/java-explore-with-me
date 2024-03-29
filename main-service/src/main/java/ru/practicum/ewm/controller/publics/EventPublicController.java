package ru.practicum.ewm.controller.publics;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.ewm.dto.event.EventFullDto;
import ru.practicum.ewm.dto.event.EventShortDto;
import ru.practicum.ewm.model.EventSortValue;
import ru.practicum.ewm.service.EventService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@Slf4j
@RequestMapping("/events")
public class EventPublicController {
    private final EventService eventService;

    @GetMapping
    public List<EventShortDto> getEventsWithParams(
            @RequestParam(name = "text", required = false) String text,
            @RequestParam(name = "categories", required = false) List<Long> categories,
            @RequestParam(name = "paid", required = false) Boolean paid,
            @RequestParam(name = "rangeStart", required = false) String rangeStart,
            @RequestParam(name = "rangeEnd", required = false) String rangeEnd,
            @RequestParam(name = "onlyAvailable", required = false) boolean onlyAvailable,
            @RequestParam(name = "sort", required = false) EventSortValue sort,
            @RequestParam(name = "from", required = false, defaultValue = "0") @PositiveOrZero Integer from,
            @RequestParam(name = "size", required = false, defaultValue = "10") @Positive Integer size,
            HttpServletRequest request) {
        return eventService.getAllEventsByPublic(
                text,
                categories,
                paid,
                rangeStart,
                rangeEnd,
                onlyAvailable,
                sort,
                PageRequest.of(from / size, size),
                request.getRequestURI(),
                request.getRemoteAddr());
    }

    @GetMapping("/{id}")
    public EventFullDto getEvent(@PathVariable Long id, HttpServletRequest request) {
        log.info(String.format("Получен запрос GET /events/{id} = %s на получение категории", id));
        return eventService.getEvent(id, request);
    }

}