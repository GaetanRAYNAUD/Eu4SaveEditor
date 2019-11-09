package fr.graynaud.eu4saveeditor.controller;

import fr.graynaud.eu4saveeditor.controller.object.DataObject;
import fr.graynaud.eu4saveeditor.service.SaveService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(value = "/api/save")
public class Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);

    private final SaveService saveService;

    public Controller(SaveService saveService) {
        this.saveService = saveService;
    }

    @PostMapping("/parse")
    public ResponseEntity parse(@RequestPart("save") MultipartFile save) throws IOException {
        return new ResponseEntity<>(new DataObject(saveService.saveToData(save)), HttpStatus.OK);
    }
}
