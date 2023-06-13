package start.novel.novelservice.memory;

import org.springframework.stereotype.Repository;
import start.novel.domain.User;
import start.novel.novelservice.repository.UserRepository;
import start.novel.novelservice.repository.UserUpdateDto;
import org.springframework.util.ObjectUtils;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class MemoryUserRepository implements UserRepository {

    private static final Map<String, User> store = new HashMap<>();

    private static long sequence = 0L;

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public void update(String user_id, UserUpdateDto updateParam) {

    }

    @Override
    public Optional<User> findById(String user_id) {
        return Optional.empty();
    }

    public void ClearStore() {

        store.clear();
    }

    public void clearStore() {
    }
}
