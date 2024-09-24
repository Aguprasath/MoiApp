package org.aguprasath.moiapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Contribution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User contributor;

    @ManyToOne
    @JoinColumn(name = "event_id")
    @JsonIgnore
    private Event event;

    private BigDecimal amount;
    private BigDecimal repaidAmount;
    private String status; // "PAID" or "UNPAID"
    private String repaidDescription;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;



    // Constructors, Getters, Setters
}
