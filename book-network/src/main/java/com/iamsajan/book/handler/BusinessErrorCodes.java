package com.iamsajan.book.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
@AllArgsConstructor
public enum BusinessErrorCodes {

    NO_CODE(0, NOT_IMPLEMENTED, "No code found"),
    INCORRECT_CURRENT_PASSWORD(300, BAD_REQUEST, "Incorrect current password"),
    NEW_PASSWORD_DOES_NOT_MATCH(301, BAD_REQUEST, "New password does not match"),
    ACCOUNT_DISABLED(303, FORBIDDEN, "User account is disabled"),
    BAD_CREDENTIALS(304, UNAUTHORIZED, "Bad credentials"),
    ACCOUNT_LOCKED(302, HttpStatus.FORBIDDEN, "User account is locked");

    private final int code;
    private final HttpStatus httpStatus;
    private final String description;

}
