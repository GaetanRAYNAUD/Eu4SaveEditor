package fr.graynaud.eu4saveeditor.controller;

import fr.graynaud.eu4saveeditor.controller.object.ErrorCode;
import fr.graynaud.eu4saveeditor.controller.object.ErrorObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class ExceptionManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionManager.class);

    @ExceptionHandler
    public ResponseEntity handleIoException(IOException e) {
        LOGGER.error(e.getMessage(), e);

        return new ResponseEntity<>(new ErrorObject(ErrorCode.DEFAULT_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
