package fr.graynaud.eu4saveeditor.controller;

import fr.graynaud.eu4saveeditor.controller.object.DataObject;
import fr.graynaud.eu4saveeditor.service.SaveService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
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
    public ResponseEntity parse(@RequestPart("save") MultipartFile save, HttpServletResponse response) throws IOException {
        return new ResponseEntity<>(saveService.saveToData(save), HttpStatus.OK);
    }

    @PostMapping(value = "/convert", produces = "application/zip")
    public void convert(@RequestBody DataObject dataObject, HttpServletResponse response) throws IOException {
        response.setContentType("application/zip");
        response.setHeader("Content-Disposition", "attachment; filename=edited_" + "test");

        saveService.dataToSave(dataObject, response.getOutputStream());
        response.getOutputStream().flush();
    }
}
