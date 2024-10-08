package org.aguprasath.moiapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private LocalDateTime eventDate;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User createdBy; // Who created the event

    @JsonIgnore
    @OneToMany(mappedBy = "event",cascade = CascadeType.ALL)
    private List<Contribution> contributions;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}

