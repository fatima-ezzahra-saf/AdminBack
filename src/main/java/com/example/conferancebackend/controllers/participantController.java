package com.example.conferancebackend.controllers;

import com.example.conferancebackend.entities.Participant;
import com.example.conferancebackend.service.participantServiceImp;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
@AllArgsConstructor
@RequestMapping("/participant")
@CrossOrigin("http://localhost:3000")
public class participantController {
         @Autowired
         private participantServiceImp participantServiceImp;
         @GetMapping("/get_all")
         public List<Participant> gatAll(){
             return participantServiceImp.getAllPartic();
         }
         @DeleteMapping("/delete/{id}")
         public void deletePart(@PathVariable Long id){
             participantServiceImp.deletePartic(id);
         }
         @PostMapping("/add")
         public void addPartic(@RequestBody Participant p){
             participantServiceImp.Register(p);
         }
}
