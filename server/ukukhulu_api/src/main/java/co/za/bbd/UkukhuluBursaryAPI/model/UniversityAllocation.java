package co.za.bbd.UkukhuluBursaryAPI.model;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class UniversityAllocation{
    private int universityAloocationId;
    private int universityId;
    private BigDecimal amount;
    private int bursaryDetailsId;

    // public UniversityAllocation(int id, int universityId, BigDecimal amount, int bursaryDetailsId) {
    //     this.id = id;
    //     this.universityId = universityId;
    //     this.bursaryDetailsId = bursaryDetailsId;
    //     this.amount = amount;

    // }

}
