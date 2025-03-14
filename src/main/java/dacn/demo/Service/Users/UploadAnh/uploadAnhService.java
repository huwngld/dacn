package dacn.demo.Service.Users.UploadAnh;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.MultipartFilter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
@Service
public class uploadAnhService {
    private static final String UPLOAD_DIR = "uploads/";

    public String uploadAnh(MultipartFile file) throws IOException {

        if (file.isEmpty()) {
            throw new IOException("File không được để trống!");
        }
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        String originalFilename = file.getOriginalFilename();
        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        String randomFilename = UUID.randomUUID().toString() + extension;
        String fileName = java.util.UUID.randomUUID() + "_" + randomFilename;
        Path filePath = Paths.get(UPLOAD_DIR + fileName);
        Files.write(filePath, file.getBytes());

        // Trả về đường dẫn có thể truy cập
        return "/uploads/" + fileName;
    }
}
