package edu.blazeskill.event.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@AllArgsConstructor
@ToString
public class EventsRequestDTO {
    private String title;
    private String description;
    private String organizer;

    private String eventType;

    private String eventLocation;

    private String eventCategory;

    private String eventDuration;

    private LocalDateTime eventDate;
}
