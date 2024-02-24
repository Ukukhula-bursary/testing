package co.za.bbd.UkukhuluBursaryAPI.model;

import lombok.Data;

@Data
public class Tester {
    private int testerId;
    private String feels;
    private int working;
    private String push;


    public Tester(String feels, int working, String push) {
        this.feels = feels;
        this.working = working;
        this.push = push;
    }
    
}
