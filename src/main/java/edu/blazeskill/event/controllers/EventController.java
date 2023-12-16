package edu.blazeskill.event.controllers;

import edu.blazeskill.event.dtos.ApiResponse;
import edu.blazeskill.event.dtos.EventResponseDTO;
import edu.blazeskill.event.dtos.EventsRequestDTO;
import edu.blazeskill.event.dtos.RegisterEventDTO;
import edu.blazeskill.event.services.EventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("api/v1/events")
@Slf4j
@RequiredArgsConstructor
public class EventController {



   final EventService eventService;
    // Organizer
    @PostMapping
    public ResponseEntity<ApiResponse> createNewEvent(@RequestBody EventsRequestDTO event){
        log.info("Received request to create new events");
        EventResponseDTO response = eventService.createEvent(event);
        return new ResponseEntity<>(ApiResponse.builder().data(response).build(), HttpStatus.CREATED);
    }

    //Organizer

    @PutMapping("{eventId}/{organizer}")
    public ApiResponse editEventByOrganizer(@PathVariable Long eventId,
                                          @PathVariable String organizer,
                                          @RequestBody EventsRequestDTO eventsDTO){
        log.info("Received request to edit an event");
        return ApiResponse.builder().build();
    }

    //organizer
    @DeleteMapping("{eventId}/{organizer}")
    public ResponseEntity<ApiResponse> deleteOrganizerEvent(@PathVariable Long eventId, @PathVariable String organizer){
        log.info("Received request to delete an event");
        eventService.deleteOrganizerEvent(eventId, organizer);
        return ResponseEntity.noContent().build();
    }


// User
    @GetMapping
    public ApiResponse getAllEvent(Pageable pageable, @RequestParam(required = false) String organizer){
        log.info("Received request to get all events");
        Page<EventResponseDTO> response = eventService.fetchAllEvent(organizer, pageable);

        return ApiResponse.builder().data(response).build();
    }
    // User
    @GetMapping("{id}")
    public ResponseEntity<ApiResponse> getOneEventDetails(@PathVariable Long id){
        log.info("Received request to get event by Id");
      EventResponseDTO response = eventService.getDetailsById(id);
        return ResponseEntity.ok(ApiResponse.builder().data(response).build());
    }
    // User

    @PostMapping("{id}/register")
    public ApiResponse registerForEvent(@PathVariable Long id, @RequestBody RegisterEventDTO registerEventDTO){
         log.info("Received request to register event");
        return ApiResponse.builder().build();
    }
}
