package edu.blazeskill.event.controllers;

import edu.blazeskill.event.dtos.ApiResponse;
import edu.blazeskill.event.dtos.UserRequestDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("api/v1/users")
@Slf4j
public class UserController {

    // User
    @PostMapping
    public ApiResponse createUserAccount(@RequestBody UserRequestDTO userRequest){
        log.info("Received request to create user account");
        return ApiResponse.builder().build();
    }
}
