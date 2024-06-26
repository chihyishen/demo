package uploadfilesys.demo.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.v3.oas.annotations.tags.Tag;
import uploadfilesys.demo.services.picturehandle.PictureUploadAndDownloadInterface;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/pic")
@Tag(name = "MemberPicture Api")
@CrossOrigin(origins = "*")
public class PictureHandleController 
{
    @Autowired
    private PictureUploadAndDownloadInterface pictureUploadAndDownloadInterface;

    @PostMapping()
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            String fileUrl = pictureUploadAndDownloadInterface.uploadFile(file);
            return ResponseEntity.ok(fileUrl);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Failed to upload file");
        }
    }

    @GetMapping()
    public ResponseEntity<byte[]> downloadFile(@PathVariable String fileName) {
        byte[] fileData = pictureUploadAndDownloadInterface.downloadFile(fileName);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(fileData);
    }
}
