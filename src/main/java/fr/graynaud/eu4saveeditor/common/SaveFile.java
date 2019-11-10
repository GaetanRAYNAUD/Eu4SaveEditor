package fr.graynaud.eu4saveeditor.common;

import fr.graynaud.eu4saveeditor.service.object.data.DataType;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Function;

public enum SaveFile {
    AI("ai", Keys::getTypeAi), GAMESTATE("gamestate", Keys::getTypeGamestate), META("meta", Keys::getTypeMeta);

    public final String fileName;

    public final Function<String, DataType> getType;

    SaveFile(String fileName, Function<String, DataType> getType) {
        this.fileName = fileName;
        this.getType = getType;
    }

    public static boolean isValidFile(String fileName) {
        return Arrays.stream(SaveFile.values())
                     .map(SaveFile::getFileName)
                     .anyMatch(name -> name.equalsIgnoreCase(fileName));
    }

    public static Optional<SaveFile> getFromFileName(String fileName) {
        if (!isValidFile(fileName)) {
            return Optional.empty();
        }

        return Arrays.stream(SaveFile.values())
                     .filter(saveFile -> saveFile.fileName.equalsIgnoreCase(fileName))
                     .findFirst();
    }

    public String getFileName() {
        return fileName;
    }
}
