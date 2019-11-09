package fr.graynaud.eu4saveeditor.service;

import fr.graynaud.eu4saveeditor.service.object.data.AbstractData;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface SaveService {

    List<AbstractData> saveToData(MultipartFile multipartFile) throws IOException;
}
