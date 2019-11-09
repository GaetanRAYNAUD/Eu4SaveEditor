package fr.graynaud.eu4saveeditor.common;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

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
                    content.put(saveFile.get(),
                                new String(zipInputStream.readNBytes((int) entry.getSize()), "Windows-1252"));
                }

                entry = zipInputStream.getNextEntry();
            }

            return content;
        }
    }

    public static void zipData(OutputStream outputStream, Map<SaveFile, String> content) throws IOException {
        try (ZipOutputStream zos = new ZipOutputStream(outputStream)) {
            for (Map.Entry<SaveFile, String> saveFileEntry : content.entrySet()) {
                ZipEntry entry = new ZipEntry(saveFileEntry.getKey().fileName);

                zos.putNextEntry(entry);
                zos.write(saveFileEntry.getValue().getBytes("Windows-1252"));
                zos.closeEntry();
            }
        }
    }
}
