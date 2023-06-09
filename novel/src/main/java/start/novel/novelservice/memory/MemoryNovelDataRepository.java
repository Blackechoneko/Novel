package start.novel.novelservice.memory;

import org.springframework.stereotype.Repository;
import start.novel.domain.NovelData;
import start.novel.novelservice.repository.NovelDataRepository;
import start.novel.novelservice.repository.NovelUpdateDto;
import start.novel.novelservice.repository.NovelDataSearchCond;
import org.springframework.util.ObjectUtils;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class MemoryNovelDataRepository implements NovelDataRepository {

    private static final Map<Long, NovelData> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public NovelData save(NovelData novelData) {
        novelData.setNovel_id(++sequence);
        store.put(novelData.getNovel_id(), novelData);
        return novelData;
    }

    @Override
    public void update(Long novel_id, NovelUpdateDto updateParam) {
        //orElseThrow : id의 값이 없을때 에러가 나지 않게 사용
        NovelData findNovelData = findById(novel_id).orElseThrow();
        findNovelData.setNovelImage(updateParam.getNovelImage());
        findNovelData.setNovelTitle(updateParam.getNovelTitle());
        findNovelData.setAuthor_id(updateParam.getAuthor_id());
        findNovelData.setThis_novel_Serialization(updateParam.getThis_novel_Serialization());
        findNovelData.setAuthor_Nickname(updateParam.getAuthor_Nickname());
        findNovelData.setNovel_Description(updateParam.getNovel_Description());
        findNovelData.setNovel_genre(updateParam.getNovel_genre());
    }

    @Override
    public Optional<NovelData> findById(Long novel_id) {
        return Optional.ofNullable(store.get(novel_id));
    }

    @Override
    public List<NovelData> findAll(NovelDataSearchCond cond) {
        String novelTitle = cond.getNovelTitle();
        String author_nickname = cond.getAuthor_nickname();
        return store.values().stream().filter(novelData -> {
            if (ObjectUtils.isEmpty(novelTitle)) {
                return true;
            }
            return novelData.getNovelTitle().contains(novelTitle);
        }).filter(novelData -> {
            if(ObjectUtils.isEmpty(author_nickname)) {
                return true;
            }
                    return novelData.getNovelTitle().contains(author_nickname);
        })
                .collect(Collectors.toList());

    }

    public void ClearStore() {

        store.clear();
    }

    public void clearStore() {
    }
}
