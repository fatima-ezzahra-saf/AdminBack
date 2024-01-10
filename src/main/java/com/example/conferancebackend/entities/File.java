package com.example.conferancebackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] contenu;
    private String status;
    private String type;
    @OneToOne
    @JoinColumn(name = "participant_id")
    private Participant participant;

    public Participant getParticipant() {
        return participant;
    }
}