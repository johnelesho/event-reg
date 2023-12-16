package edu.blazeskill.event.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Data
@AllArgsConstructor
@ToString
public class RegisterEventDTO {
    private Long eventId;
    private Long userId;

    private UserRequestDTO userRequestD;
}
