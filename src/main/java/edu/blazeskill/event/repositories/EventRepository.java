package edu.blazeskill.event.repositories;

import edu.blazeskill.event.entities.Events;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Events, Long> {
    Page<Events> findByOrganizerContainsIgnoreCase(String organizer, Pageable pageable);

    void deleteByIdAndOrganizerEqualsIgnoreCase(Long eventId, String organizer);
}
