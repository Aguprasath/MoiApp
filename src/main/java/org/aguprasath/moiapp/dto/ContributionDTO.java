package org.aguprasath.moiapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContributionDTO {
    private Long id;
    private String contributorName;
    private BigDecimal amount;
    private BigDecimal repaidAmount;
    private String status;
    private String repaidDescription;
    private Long eventId;
}
