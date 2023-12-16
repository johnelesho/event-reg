package edu.blazeskill.event.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Auditable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Table
@Entity
@Getter
@Setter
@ToString
@EntityListeners(AuditingEntityListener.class)
public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    private String title;
    private String description;
    private String organizer;

    private String eventType;

    private String eventLocation;

    private String eventCategory;

    private String eventDuration;

    private LocalDateTime eventDate;

    @CreatedDate
    @Column(columnDefinition = "Timestamp default CURRENT_TIMESTAMP")
    private LocalDateTime createdDate;

      @LastModifiedDate
    @Column(columnDefinition = "Timestamp default CURRENT_TIMESTAMP")
    private LocalDateTime updatedDate;



}
