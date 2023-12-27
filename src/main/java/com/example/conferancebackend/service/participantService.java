package com.example.conferancebackend.service;

import com.example.conferancebackend.Repository.participantRepo;
import com.example.conferancebackend.entities.Participant;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public interface participantService{
    public List<Participant> getAllPartic();
    public void Register(Participant p);
    public void deletePartic(Long id);

}
