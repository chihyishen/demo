package uploadfilesys.demo.services.picupload;

import java.io.IOException;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class picupload 
{
    @Value("${spring.cloud.gcp.storage.bucket}")
    private String bucketName;

    private final Storage storage;

    public GoogleCloudStorageService() {
        this.storage = StorageOptions.getDefaultInstance().getService();
    }

    public String uploadFile(MultipartFile file) throws IOException {
        String blobName = file.getOriginalFilename();
        BlobId blobId = BlobId.of(bucketName, blobName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType(file.getContentType()).build();
        storage.create(blobInfo, file.getBytes());
        return String.format("gs://%s/%s", bucketName, blobName);
    }

    public byte[] downloadFile(String blobName) {
        Blob blob = storage.get(BlobId.of(bucketName, blobName));
        return blob.getContent();
    }
}
