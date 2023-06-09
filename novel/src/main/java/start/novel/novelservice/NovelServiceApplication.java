package start.novel.novelservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import start.novel.novelservice.config.Memoryconfig;
import start.novel.novelservice.repository.NovelDataRepository;

@Import(Memoryconfig.class)
@SpringBootApplication(scanBasePackages = "hello.novelservice.web")
public class NovelServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(NovelServiceApplication.class, args);

    }

    @Bean
    @Profile("local")
    public TestDataInit testDataInit(NovelDataRepository novelDataRepository) {
        return new TestDataInit(novelDataRepository);
    }
}
