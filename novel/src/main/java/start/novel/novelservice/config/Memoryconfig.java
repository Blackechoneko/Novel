package start.novel.novelservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import start.novel.novelservice.memory.MemoryNovelDataRepository;
import start.novel.novelservice.memory.MemoryUserRepository;
import start.novel.novelservice.repository.NovelDataRepository;
import start.novel.novelservice.repository.UserRepository;
import start.novel.novelservice.service.NovelService;
import start.novel.novelservice.service.NovelServiceV1;
import start.novel.novelservice.service.UserService;
import start.novel.novelservice.service.UserServiceV3;

@Configuration
public class Memoryconfig {

    @Bean
    public NovelService novelService() {
        return new NovelServiceV1(novelRepository());
    }

    @Bean
    public NovelDataRepository novelRepository() {
        return new MemoryNovelDataRepository();
    }

    @Bean
    UserService userService() {
        return new UserServiceV3(userRepository());
    }

    @Bean
    UserRepository userRepository() {
        return new MemoryUserRepository();
    }
}
