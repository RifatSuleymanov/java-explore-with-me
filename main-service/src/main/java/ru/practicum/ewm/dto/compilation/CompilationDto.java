package ru.practicum.ewm.dto.compilation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.practicum.ewm.dto.event.EventShortDto;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CompilationDto {
    private Long id;
    private boolean pinned;
    private String title;
    private List<EventShortDto> events;
}