package co.za.bbd.UkukhuluBursaryAPI.model;

import java.math.BigDecimal;
import java.sql.Date;

import lombok.Data;

@Data
public class StudentApplication {
  private int studentApplicationId;
  private int studentID;
  private String motivation;
  private BigDecimal bursaryAmount;
  private int statusId;
  private int reviewer_UserId;
  private String reviewerComment;
  private Date date;
  private int universityStaffId;
  private int bursaryDetailsId;

  // public StudentApplications(int id, int studentID, String motivation, BigDecimal bursaryAmount, String status,
  //     String rejectionReason, Date date) {
  //   this.id = id;
  //   this.studentID = studentID;
  //   this.motivation = motivation;
  //   this.bursaryAmount = bursaryAmount;
  //   this.status = status;
  //   this.rejectionReason = rejectionReason;
  //   this.date = date;
  // }
}
