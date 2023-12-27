package com.example.conferancebackend.service;

import com.example.conferancebackend.Repository.participantRepo;
import com.example.conferancebackend.entities.Participant;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data @AllArgsConstructor

public class participantServiceImp implements participantService{
    @Autowired
    private participantRepo participantRepo;
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
       participantRepo.deleteById(id);
    }
}
