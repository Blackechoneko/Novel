package start.novel.novelservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import start.novel.novelservice.memory.MemoryNovelDataRepository;
import start.novel.novelservice.repository.NovelDataRepository;
import start.novel.novelservice.service.NovelService;
import start.novel.novelservice.service.NovelServiceV1;

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
}
