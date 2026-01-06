package com.codesnippet.controller;

import com.codesnippet.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class S3Controller {
    @Autowired
    private S3Service s3Service;

    @PostMapping("/upload")
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) {
        try {
            System.out.println("File name: " + file.getOriginalFilename());
            s3Service.uploadFile(file);
            return ResponseEntity.ok("File uploaded successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Upload failed: " + e.getMessage());
        }
    }


    @GetMapping("/download/{filename}")
    public ResponseEntity<byte[]> download(@PathVariable String filename) {
        byte[] data = s3Service.downloadFile(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .body(data);
    }
}