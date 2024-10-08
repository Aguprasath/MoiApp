package org.aguprasath.moiapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contribution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contributorName;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    private BigDecimal amount;
    private BigDecimal repaidAmount;
    private String status; // "PAID" or "UNPAID"
    private String repaidDescription;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;




}
