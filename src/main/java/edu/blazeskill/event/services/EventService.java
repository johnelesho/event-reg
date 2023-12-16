package edu.blazeskill.event.services;

import edu.blazeskill.event.dtos.EventResponseDTO;
import edu.blazeskill.event.dtos.EventsRequestDTO;
import edu.blazeskill.event.entities.Events;
import edu.blazeskill.event.exceptions.ApiNotFoundException;
import edu.blazeskill.event.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EventService {
    final EventRepository eventRepository;

    public EventResponseDTO createEvent(EventsRequestDTO eventsDTO){
        Events events = new Events();
        BeanUtils.copyProperties(eventsDTO, events);
        log.info(events.toString());
        Events savedEntity = eventRepository.save(events);

        EventResponseDTO response = new EventResponseDTO();
        BeanUtils.copyProperties(savedEntity, response);
        return response;
    }

    public Page<EventResponseDTO> fetchAllEvent(String organizer, Pageable pageable) {
        Page<Events> events;
        if (organizer == null || organizer.isEmpty()) {
            events = eventRepository.findAll(pageable);
        } else {
            events = eventRepository.findByOrganizerContainsIgnoreCase(organizer, pageable);
        }

        return events.map(ev -> {
            EventResponseDTO responseDTO = new EventResponseDTO();
            BeanUtils.copyProperties(ev, responseDTO);
            return responseDTO;
        });

    }



    public EventResponseDTO getDetailsById(Long id) {
        Events events = eventRepository.findById(id).orElseThrow(()->  new ApiNotFoundException(id));
        EventResponseDTO response = new EventResponseDTO();
        BeanUtils.copyProperties(events,response);
        return response;

    }

    public void deleteOrganizerEvent(Long eventId, String organizer) {
        eventRepository.deleteByIdAndOrganizerEqualsIgnoreCase(eventId, organizer);

    }
}
