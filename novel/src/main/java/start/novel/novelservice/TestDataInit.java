package start.novel.novelservice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import start.novel.domain.NovelData;
import start.novel.novelservice.repository.NovelDataRepository;

@Slf4j
@RequiredArgsConstructor
public class TestDataInit {

    private final NovelDataRepository novelDataRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void initData() {
        log.info("test init");
        novelDataRepository.save(new NovelData("novel_image_link1", "title1" , 1 , 1 , "nickname1" , "hello" , 2 ));
        novelDataRepository.save(new NovelData("novel_image_link2", "title1" , 1 , 1 ,"nickname2" ,"well done" , 3));
    }

}
