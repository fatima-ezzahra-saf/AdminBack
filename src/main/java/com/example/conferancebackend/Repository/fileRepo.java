package com.example.conferancebackend.Repository;


import com.example.conferancebackend.entities.File;
import org.springframework.data.jpa.repository.JpaRepository;



public interface fileRepo extends JpaRepository<File,Long> {
}
