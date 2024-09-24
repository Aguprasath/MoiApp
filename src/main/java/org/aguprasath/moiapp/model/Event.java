package org.aguprasath.moiapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private LocalDateTime eventDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User createdBy; // Who created the event

    @JsonIgnore
    @OneToMany(mappedBy = "event")
    private List<Contribution> contributions;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Constructors, Getters, Setters
}

