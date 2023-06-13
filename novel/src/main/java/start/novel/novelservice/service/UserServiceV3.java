package start.novel.novelservice.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import start.novel.domain.User;
import start.novel.novelservice.repository.UserRepository;
import start.novel.novelservice.repository.UserUpdateDto;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceV3 implements UserService {

    private final UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void update(String user_id, UserUpdateDto updateParam) {
        userRepository.update(user_id, updateParam);
    }

    @Override
    public Optional<User> findById(String user_id) {
        return userRepository.findById(user_id);
    }
}