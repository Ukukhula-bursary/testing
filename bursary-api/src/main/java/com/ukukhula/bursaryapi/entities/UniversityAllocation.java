package com.ukukhula.bursaryapi.entities;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class UniversityAllocation {
    private int id;
    private int universityId;
    private int bursaryDetailsId;
    private BigDecimal amount;

    public UniversityAllocation(int id, int universityId, BigDecimal amount, int bursaryDetailsId) {
        this.id = id;
        this.universityId = universityId;
        this.amount = amount;
        this.bursaryDetailsId = bursaryDetailsId;
    }

}
