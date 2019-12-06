package fr.graynaud.eu4saveeditor.service;

import fr.graynaud.eu4saveeditor.common.Constants;
import fr.graynaud.eu4saveeditor.common.FileUtils;
import fr.graynaud.eu4saveeditor.common.ParseUtils;
import fr.graynaud.eu4saveeditor.common.SaveFile;
import fr.graynaud.eu4saveeditor.controller.object.DataObject;
import fr.graynaud.eu4saveeditor.service.object.save.Gamestate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

@Service
public class SaveServiceImpl implements SaveService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SaveServiceImpl.class);

    //TODO Same for all specific data ? (ex: culture, religions, goods, etc..., will be easier to do a dropdown in front)
    //TODO add ProgressData extends FloatData (Front = progress bar)
    //TODO add ListBoolData (ex: buildings)
    //TODO create type "DuplicatedObjectData" (unit_templates)

    @Override
    public Gamestate saveToData(MultipartFile multipartFile) throws IOException {
        String content = FileUtils.unZipSave(multipartFile);
        Gamestate gamestate = new Gamestate();

        if (content == null) {
            return null;
        }

        if (content.startsWith(Constants.STARTING_TEXT)) {
            content = content.substring(Constants.STARTING_TEXT.length());
        }

        gamestate.parse(content);

        return gamestate;
    }

    @Override
    public void dataToSave(DataObject dataObject, OutputStream outputStream) throws IOException {
        Map<SaveFile, String> map = new HashMap<>();
        //        map.put(SaveFile.GAMESTATE, dataObject.getGamestateToSave());

        FileUtils.zipData(outputStream, map);
    }
}
