package co.za.bbd.UkukhuluBursaryAPI.model;

import lombok.Data;

@Data
public class University {
  private int universityId;
  private String universityName;
  private int isActiveId;



  public University(String universityName, int isActiveId) {
    this.universityName = universityName;
    this.isActiveId = isActiveId;
  }

  public int defaultIsActiveId() {
    return 2;
  }

  // public boolean addUniversity(String name) {

  // }

  // public University(int id, String name) {
  //   this.id = id;
  //   this.name = name;
  // }
}
