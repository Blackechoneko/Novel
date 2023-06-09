package start.novel.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import start.novel.novelservice.memory.MemoryNovelDataRepository;
import start.novel.novelservice.repository.NovelDataRepository;
import start.novel.novelservice.repository.NovelUpdateDto;

@SpringBootTest
public class NovelRepositoryTest {

    @Autowired
    NovelDataRepository novelDataRepository;

    @AfterEach
    void afterEach() {

        if (novelDataRepository instanceof MemoryNovelDataRepository) {
            ((MemoryNovelDataRepository) novelDataRepository).clearStore();
        }
    }

    @Test
    void save() {
        //give
        NovelData novelData = new NovelData("novel_image_link1", "title1", 1, 1, "nickname1", "hello", 2);

        //when
        NovelData savedNovelData = novelDataRepository.save(novelData);

        //then
        NovelData findNovelData = novelDataRepository.findById(novelData.getNovel_id()).get();
        Assertions.assertThat(findNovelData).isEqualTo(savedNovelData);

    }

    @Test
    void updateNovelData() {
        //give
        NovelData novelData = new NovelData("novel_image_link3", "title3", 1, 1, "3", "hello", 2);
        NovelData savedNovelData = novelDataRepository.save(novelData);

        long novelId = savedNovelData.getNovel_id();

        //when
        NovelUpdateDto updateParam = new NovelUpdateDto("novel_image_link5", "title5", 1, 1, "3", "hello", 5);
        novelDataRepository.update(novelId, updateParam);

        //then
        NovelData findNovelData = novelDataRepository.findById(novelId).get();

        Assertions.assertThat(findNovelData.getNovelTitle()).isEqualTo(updateParam.getNovelTitle());
        Assertions.assertThat(findNovelData.getAuthor_Nickname()).isEqualTo(updateParam.getAuthor_Nickname());
        Assertions.assertThat(findNovelData.getNovelImage()).isEqualTo(updateParam.getNovelImage());

    }

    @Test
    void findNovelData() {

        NovelData NovelData1 = new NovelData("novel_image_link1-1", "title1-1", 1, 1, "nickname1-1", "hello-1", 2);
        NovelData NovelData2 = new NovelData("novel_image_link1-2", "title1-2", 1, 1, "nickname1-2", "hello-2", 2);
        NovelData NovelData3 = new NovelData("novel_image_link1-3", "title1-3", 1, 1, "nickname1-3", "hello-3", 2);

        novelDataRepository.save(NovelData1);
        novelDataRepository.save(NovelData2);
        novelDataRepository.save(NovelData3);

        //둘 다 없을때 체크
        //
    }
}


