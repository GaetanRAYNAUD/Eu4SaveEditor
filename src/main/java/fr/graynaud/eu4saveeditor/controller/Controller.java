package fr.graynaud.eu4saveeditor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/api/save")
public class Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);

    @PostMapping
    public ResponseEntity cleanVo(@RequestPart("save") MultipartFile save) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
