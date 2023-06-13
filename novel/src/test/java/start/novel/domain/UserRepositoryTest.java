package start.novel.domain;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import start.novel.novelservice.memory.MemoryNovelDataRepository;
import start.novel.novelservice.repository.UserRepository;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @AfterEach
        // User 테스트 종료후 초기화
    void afterEach() {
        //원래의 인스턴스형이 일치하는지 일치하지 않는지 테스트
        if (userRepository instanceof MemoryNovelDataRepository) {
            ((MemoryNovelDataRepository) userRepository).clearStore();
        }
    }

}
