package co.za.bbd.UkukhuluBursaryAPI.model;
import lombok.Data;

@Data
public class User {
    private int userId;
    private String firstName;
    private String lastName;
    private int contactId;
    private int isActiveId;

    // public Users(int id, String firstName, String lastName, int contactId,
    //             int userRoleId, boolean isUserActive) {
    //     this.id = id;
    //     this.firstName = firstName;
    //     this.lastName = lastName;
    //     this.contactId = contactId;
    //     this.userRoleId = userRoleId;
    //     this.isUserActive = isUserActive;
    // }
}
