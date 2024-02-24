package co.za.bbd.UkukhuluBursaryAPI.model;

import lombok.Data;

@Data
public class UniversityApplication {
    private int universityAplicationId;
    private int universityId;
    private String motivation;
    private int reviewer_UserId;
    private String reviewerComment;

    // public UniversityApplication(int id, int universityId, String motivation, String status, String rejectionReason) {
    //     this.id = id;
    //     this.universityId = universityId;
    //     this.motivation = motivation;
    //     this.status = status;
    //     this.rejectionReason = rejectionReason;
    // }
}
