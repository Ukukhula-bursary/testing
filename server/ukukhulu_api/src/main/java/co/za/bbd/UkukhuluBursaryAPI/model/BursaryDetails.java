package co.za.bbd.UkukhuluBursaryAPI.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class BursaryDetails {
    private int bursaryDetailsId;
    private BigDecimal totalAmount;
    private int year;
}
