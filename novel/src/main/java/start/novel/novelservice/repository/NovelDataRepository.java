package start.novel.novelservice.repository;

import start.novel.domain.NovelData;

import java.util.List;
import java.util.Optional;

public interface NovelDataRepository {

        NovelData save(NovelData novelData);

        void update(Long novel_id, NovelUpdateDto updateParam);

        //Optional 클래스
        Optional<NovelData> findById(Long novel_id);

        List<NovelData> findAll(NovelDataSearchCond cond);
    }


