package fr.graynaud.eu4saveeditor.common;

import fr.graynaud.eu4saveeditor.service.object.data.DataType;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public enum SaveFile {
    AI("ai", Keys::getTypeAi, Keys::ignoredKeyAIContains),
    GAMESTATE("gamestate", Keys::getTypeGamestate, Keys::ignoredKeyGamestateContains),
    META("meta", Keys::getTypeMeta, Keys::ignoredKeyMetaContains);

    public final String fileName;

    public final Function<String, DataType> getType;

    public final Function<String, Boolean> ignoredKeys;

    SaveFile(String fileName, Function<String, DataType> getType, Function<String, Boolean> ignoredKeys) {
        this.fileName = fileName;
        this.getType = getType;
        this.ignoredKeys = ignoredKeys;
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
