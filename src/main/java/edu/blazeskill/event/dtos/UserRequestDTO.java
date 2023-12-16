package edu.blazeskill.event.dtos;

import edu.blazeskill.event.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Data
@AllArgsConstructor
@ToString
public class UserRequestDTO {
    private String fullName;
    private String email;

    private UserType userTypw;

    private  String address;

    private String phone;
}
