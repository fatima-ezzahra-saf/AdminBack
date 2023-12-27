package com.example.conferancebackend.service;

import com.example.conferancebackend.Repository.fileRepo;
import com.example.conferancebackend.entities.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class fileService {
    @Autowired
    private fileRepo fileRepository;

    public void saveFile(String filename, MultipartFile file) throws IOException {
        File fileEntity = new File();
        fileEntity.setName(filename);
        fileEntity.setContenu(file.getBytes());
        fileEntity.setStatus("non valide");
        fileRepository.save(fileEntity);
    }
    public List<File> getAllFile(){
        return fileRepository.findAll();
    }
    public Optional<File> getFileById(Long id){
        return fileRepository.findById(id);
    }
    public void delete(Long id){
        fileRepository.deleteById(id);
    }
    public void save(Optional<File> file){
        File f = file.orElse(null);
        fileRepository.save(f);
    }
}
