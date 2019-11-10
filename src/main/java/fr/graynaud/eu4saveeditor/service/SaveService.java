package fr.graynaud.eu4saveeditor.service;

import fr.graynaud.eu4saveeditor.controller.object.DataObject;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;

public interface SaveService {

    DataObject saveToData(MultipartFile multipartFile) throws IOException;

    void dataToSave(DataObject dataObject, OutputStream outputStream) throws IOException;
}
