package fr.graynaud.eu4saveeditor.common;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public final class FileUtils {

    private FileUtils() {
    }

    public static String unZipSave(MultipartFile multipartFile) throws IOException {

        try (ZipInputStream zipInputStream = new ZipInputStream(multipartFile.getInputStream())) {
            ZipEntry entry = zipInputStream.getNextEntry();

            while (entry != null) {
                if (!entry.isDirectory() && entry.getName().equals("gamestate")) {
                    return new String(zipInputStream.readNBytes((int) entry.getSize()), "Windows-1252");
                }

                entry = zipInputStream.getNextEntry();
            }

            return null;
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
