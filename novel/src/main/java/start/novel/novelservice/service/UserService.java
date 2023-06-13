package start.novel.novelservice.service;

import start.novel.domain.User;
import start.novel.novelservice.repository.UserUpdateDto;

import java.util.Optional;

public interface UserService {

    User save(User user);

    void update(String user_id, UserUpdateDto updateParam);

    Optional<User> findById(String user_id);
}
