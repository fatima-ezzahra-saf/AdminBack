package com.example.conferancebackend.controllers;

import com.example.conferancebackend.entities.File;
import com.example.conferancebackend.service.fileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
public class fileController {
    @Autowired
    fileService fileService;

    @PostMapping("/upload")
    public String AddFile(@RequestParam("file") MultipartFile file,@RequestBody String email,@RequestBody String type) {
        try {
            fileService.saveFile(file.getOriginalFilename(), file,email,type);
            return "File uploaded successfully!";
        } catch (IOException e) {
            return "Error uploading file: " + e.getMessage();
        }
    }

    @GetMapping("/getAllFile")
    public List<File> getAllFile(){
        return fileService.getAllFile();
    }

    @GetMapping("/downloadFile/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable Long fileId) {
        Optional<File> fileOptional = fileService.getFileById(fileId);

        if (fileOptional.isPresent()) {
            File file = fileOptional.get();

            ByteArrayResource resource = new ByteArrayResource(file.getContenu());

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + file.getName())
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .contentLength(file.getContenu().length)
                    .body(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/modifierFile/{id}")
    public void modifierFile(@PathVariable Long id){
        Optional<File> f=fileService.getFileById(id);
        f.get().setStatus("valide");
        fileService.save(f);
    }
}
