package ru.practicum.ewm.dto.request;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.practicum.ewm.model.UpdateRequestStatus;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestStatusUpdateDto {
    private List<Long> requestIds;
    private UpdateRequestStatus status;
}