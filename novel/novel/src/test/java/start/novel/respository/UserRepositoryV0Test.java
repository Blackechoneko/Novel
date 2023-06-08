package start.novel.respository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import start.novel.domain.User;
import start.novel.repository.UserRepositoryV0;

import java.sql.SQLException;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Slf4j
class UserRepositoryV0Test {

    UserRepositoryV0 repository = new UserRepositoryV0();

    @Test
    void crud() throws SQLException {
        // 저장
        // 저장 잘 됬는지 확인 후 삭제하는 try catch 사용가능?
        User user = new User("UserV2", "NicknameV2", "EmailV2", "PasswordV2");
        repository.save(user);

        // 유저 아이디 찾기
        User findUser = repository.findById(user.getUser_Id());
        log.info("findUser={}", findUser);
        assertThat(findUser).isEqualTo(user);

        // 업데이트/수정
        repository.updatePassword(user.getUser_Id() , "0123");
        User updatedUser = repository.findById(user.getUser_Id());
        assertThat(updatedUser.getUser_Password()).isEqualTo("0123");

        repository.updateNickname(user.getUser_Id() , "tjqehdtest");
        repository.findById(user.getUser_Id());
        assertThat(updatedUser.getUser_NickName()).isEqualTo("tjqehdtest");

        //삭제
        repository.delete(user.getUser_Id());
        assertThatThrownBy(() -> repository.findById(user.getUser_Id())).isInstanceOf(NoSuchElementException.class);
    }

}

