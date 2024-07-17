package org.enrichment.talent_scouting_backend.helper;

import org.springframework.http.HttpStatus;

public class AppException extends RuntimeException{
    private final HttpStatus code;

    public AppException(HttpStatus code, String message) {
        super(message);
        this.code = code;
    }

    public HttpStatus getCode() {
        return code;
    }
}
