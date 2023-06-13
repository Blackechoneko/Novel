package start.novel.novelservice.repository;
import start.novel.domain.User;

import java.util.Optional;

public interface UserRepository {

    User save(User user);

    void update(String user_id, UserUpdateDto updateParam);

    Optional<User> findById(String user_id);
}
