package edu.blazeskill.event.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ApiResponse {

    @Builder.Default
    private boolean success = true;

    @Builder.Default
    private String description = "Operation Successful";


    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();

    private Object data;
}
