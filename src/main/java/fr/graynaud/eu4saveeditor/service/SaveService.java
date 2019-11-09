package fr.graynaud.eu4saveeditor.service;

import fr.graynaud.eu4saveeditor.controller.object.DataObject;
import fr.graynaud.eu4saveeditor.service.object.data.AbstractData;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public interface SaveService {

    List<AbstractData> saveToData(MultipartFile multipartFile) throws IOException;

    void dataToSave(DataObject dataObject, OutputStream outputStream) throws IOException;
}
