package fr.graynaud.eu4saveeditor.common;

import java.util.Arrays;
import java.util.Optional;

public enum SaveFile {
    AI("ai"), GAMESTATE("gamestate"), META("meta");

    public final String fileName;

    SaveFile(String fileName) {
        this.fileName = fileName;
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
