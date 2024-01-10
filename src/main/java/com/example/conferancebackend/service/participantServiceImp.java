package com.example.conferancebackend.service;

import com.example.conferancebackend.Repository.fileRepo;
import com.example.conferancebackend.Repository.participantRepo;
import com.example.conferancebackend.entities.File;
import com.example.conferancebackend.entities.Participant;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Service
@Data @AllArgsConstructor
@CrossOrigin
public class participantServiceImp implements participantService {
    @Autowired
    private participantRepo participantRepo;
@Autowired
private com.example.conferancebackend.Repository.fileRepo fileRepo;
    @Override
    public List<Participant> getAllPartic() {
        List<Participant> participants=participantRepo.findAll();
        return participants;
    }

    @Override
    public void Register(Participant p) {
        participantRepo.save(p);
    }


    @Override
    public void deletePartic(Long id) {


        List<File> files = fileRepo.findAll();


        // Supprimer chaque fichier
        for (File fichier : files) {
            if (fichier.getParticipant() != null && fichier.getParticipant().getId().equals(id)) {
                fileRepo.delete(fichier);
            }
        }


        participantRepo.deleteById(id);
    }
}
