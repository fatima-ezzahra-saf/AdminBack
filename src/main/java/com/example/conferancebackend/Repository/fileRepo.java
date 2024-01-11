package com.example.conferancebackend.Repository;


import com.example.conferancebackend.entities.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface fileRepo extends JpaRepository<File,Long> {
    @Query("SELECT f FROM File f LEFT JOIN FETCH f.participant")
    List<File> findAllWithParticipant();
}
