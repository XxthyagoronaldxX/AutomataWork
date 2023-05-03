package com.tajad.automata_work.api.handles;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ApiException {
    private LocalDateTime time;
    private String message;
}
