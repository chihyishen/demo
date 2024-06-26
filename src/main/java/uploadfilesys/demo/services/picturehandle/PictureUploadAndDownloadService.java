package uploadfilesys.demo.services.picturehandle;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
public class PictureUploadAndDownloadService implements PictureUploadAndDownloadInterface
{
    private final Storage storage = StorageOptions.getDefaultInstance().getService();
    private final String bucketName = "pictureupload"; // 替换为你的桶名称

    public String uploadFile(MultipartFile file) throws IOException {
        String fileName = UUID.randomUUID().toString() + "-" + file.getOriginalFilename();
        Bucket bucket = storage.get(bucketName);
        Blob blob = bucket.create(fileName, file.getBytes(), file.getContentType());
        return blob.getMediaLink();
    }

    public byte[] downloadFile(String fileName) {
        Bucket bucket = storage.get(bucketName);
        Blob blob = bucket.get(fileName);
        return blob.getContent();
    }
}
