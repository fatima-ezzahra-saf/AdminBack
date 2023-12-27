package com.example.conferancebackend.Repository;

import com.example.conferancebackend.entities.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface participantRepo extends JpaRepository<Participant,Long> {
}
