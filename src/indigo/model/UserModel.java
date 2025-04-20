package indigo.model;

public class UserModel {
    private String userId;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private String role;

//    public UserModel(String userId, String username)
    public void setEmail(String email) {
        this.email = email;
    }
}
