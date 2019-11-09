package fr.graynaud.eu4saveeditor.common;

import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public final class FileUtils {

    private FileUtils() {
    }

    public static Map<SaveFile, String> unZipSave(MultipartFile multipartFile) throws IOException {
        Map<SaveFile, String> content = new HashMap<>();

        try (ZipInputStream zipInputStream = new ZipInputStream(multipartFile.getInputStream())) {
            ZipEntry entry = zipInputStream.getNextEntry();

            while (entry != null) {
                Optional<SaveFile> saveFile = SaveFile.getFromFileName(entry.getName());

                if (!entry.isDirectory() && saveFile.isPresent()) {
                    content.put(saveFile.get(), new String(zipInputStream.readNBytes((int) entry.getSize()), "Windows-1252"));
                }

                entry = zipInputStream.getNextEntry();
            }

            return content;
        }
    }
}
