package start.novel.novelservice.service;

import start.novel.domain.NovelData;
import start.novel.novelservice.repository.NovelDataSearchCond;
import start.novel.novelservice.repository.NovelUpdateDto;

import java.rmi.NotBoundException;
import java.util.List;
import java.util.Optional;

public interface NovelService {

    NovelData save(NovelData novelData);

    void update(Long novel_id, NovelUpdateDto updateParam);

    Optional<NovelData> findById(Long novel_id);

    List<NovelData> findNovelData(NovelDataSearchCond novelDataSearch);

    
}
