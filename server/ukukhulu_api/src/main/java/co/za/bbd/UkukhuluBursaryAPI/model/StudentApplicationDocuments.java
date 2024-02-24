package co.za.bbd.UkukhuluBursaryAPI.model;

import lombok.Data;

@Data
public class StudentApplicationDocuments {
    private int studentDocumentId;
    private int studentApplicationId;
    private String IDCopy;
    private String AcademicTranscript;
    private String CurriculumVitae;

    // public StudentDocuments(int id, int applicationId,
    //         byte[] amount,
    //         byte[] IDCopy,
    //         byte[] AcademicTranscript,
    //         byte[] CurriculumVitae) {
    //     this.id = id;
    //     this.applicationId = applicationId;
    //     this.amount = amount;
    //     this.AcademicTranscript = AcademicTranscript;
    //     this.CurriculumVitae = CurriculumVitae;
    // }
}