package uploadfilesys.demo.services.picturehandle;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface PictureUploadAndDownloadInterface 
{
    public String uploadFile(MultipartFile file) throws IOException;;

    public byte[] downloadFile(String fileName);
}
