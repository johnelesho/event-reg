package edu.blazeskill.event.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class EventResponseDTO {
    private String title;
    private String description;
    private String organizer;

    private String eventType;

    private String eventLocation;

    private String eventCategory;

    private String eventDuration;

    private LocalDateTime eventDate;

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
