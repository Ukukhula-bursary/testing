package co.za.bbd.UkukhuluBursaryAPI.model;

import lombok.Data;

@Data
public class Student {
  private int studentId;
  private int userId;
  private String IDNumber;
  private int ethnicityId;
  private int universityId;
  private int departmentId;

  // public University(int id, String name) {
  //   this.id = id;
  //   this.name = name;
  // }
}
