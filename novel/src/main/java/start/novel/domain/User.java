package start.novel.domain;

import lombok.Data;

@Data
public class User {
    private String user_Id;
    private String user_NickName;
    private String user_Email;
    private String user_Password;

    public User() {

    }

    public User(String user_Id, String user_NickName, String user_Email, String user_Password) {
        this.user_Id = user_Id;
        this.user_NickName = user_NickName;
        this.user_Email = user_Email;
        this.user_Password = user_Password;
    }


}
