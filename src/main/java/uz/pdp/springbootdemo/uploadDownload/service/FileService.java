package uz.pdp.springbootdemo.uploadDownload.service;

import jakarta.annotation.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.pdp.springbootdemo.uploadDownload.entitys.Upload;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class FileService {

    private final Path root = Paths.get("uploads");

    public Upload uploadFile(MultipartFile file) throws IOException {
        if (!Files.exists(root)) {
            Files.createDirectories(root);
        }

        String originalName = file.getOriginalFilename();
        String generatedName = UUID.randomUUID() + "_" + originalName;
        Path filePath = root.resolve(generatedName);
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        return new Upload(
            originalName,
            generatedName,
            file.getSize(),
            file.getContentType(),
            "/api/files/" + generatedName
        );
    }

    public Resource downloadFile(String filename) throws IOException {
        Path filePath = root.resolve(filename);
        return new UrlResource(filePath.toUri());
    }
}
