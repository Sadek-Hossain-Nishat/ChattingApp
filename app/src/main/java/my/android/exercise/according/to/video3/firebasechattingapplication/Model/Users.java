package my.android.exercise.according.to.video3.firebasechattingapplication.Model;

public class Users {
    private String id;
    private String userName;
    private String imageUrl;
    private String status;

    //Constructors

    public Users() {
    }

    public Users(String id, String userName, String imageUrl,String status) {
        this.id = id;
        this.userName = userName;
        this.imageUrl = imageUrl;
        this.status=status;
    }

    //getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
