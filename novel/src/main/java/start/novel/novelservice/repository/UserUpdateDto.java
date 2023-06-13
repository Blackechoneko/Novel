package start.novel.novelservice.repository;


import lombok.Data;

@Data
public class UserUpdateDto {

    private String user_id;
    private String user_NickName;
    private String user_Email;
    private String user_Password;

    public UserUpdateDto() {

    }
    public UserUpdateDto(String user_id, String user_NickName, String user_Email, String user_Password) {
        this.user_id = user_id;
        this.user_NickName = user_NickName;
        this.user_Email = user_Email;
        this.user_Password = user_Password;
    }
}