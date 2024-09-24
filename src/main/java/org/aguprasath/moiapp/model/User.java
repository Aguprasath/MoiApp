package org.aguprasath.moiapp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name="users")
public class User {

//    @Id
//    private int id;
//    private String username;
//    private String password;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(nullable = false)
    private String username;

//    @Column(nullable = false, unique = true)
    private String email;

//    @Column(nullable = false)
    private String password;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Relationships
    @OneToMany(mappedBy = "createdBy")
    private List<Event> events;

//    @OneToMany(mappedBy = "contributor")
//    private List<Contribution> contributions;


}
