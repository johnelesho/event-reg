package edu.blazeskill.event.exceptions;



public class ApiNotFoundException extends RuntimeException {
    private String message;

    public ApiNotFoundException(Long id) {
        super("Record not Found with id " + id);
        this.message = "Record not Found with id " + id;
    }
}
