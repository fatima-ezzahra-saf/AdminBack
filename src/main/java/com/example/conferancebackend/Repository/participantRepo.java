package com.example.conferancebackend.Repository;

import com.example.conferancebackend.entities.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface participantRepo extends JpaRepository<Participant,Long> {
    @Query("SELECT p FROM Participant p WHERE p.email = :email")
    public Optional<Participant> findByEmail(@Param("email") String email);
}
