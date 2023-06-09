package start.novel.novelservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import start.novel.domain.NovelData;
import start.novel.novelservice.repository.NovelDataRepository;
import start.novel.novelservice.repository.NovelDataSearchCond;
import start.novel.novelservice.repository.NovelUpdateDto;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NovelServiceV1 implements NovelService{
    private final NovelDataRepository novelDataRepository;

    @Override
    public NovelData save(NovelData novelData) {
        return novelDataRepository.save(novelData);
    }

    @Override
    public void update(Long novel_id, NovelUpdateDto updateParam) {
        novelDataRepository.update(novel_id, updateParam);
    }

    @Override
    public Optional<NovelData> findById(Long novel_id) {
        return novelDataRepository.findById(novel_id);
    }

    @Override
    public List<NovelData> findNovelData(NovelDataSearchCond novelDataSearch) {
        return novelDataRepository.findAll(novelDataSearch);
    }
}
