package start.novel.novelservice.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import start.novel.domain.LikeData;
import start.novel.novelservice.repository.LikeDataRepository;
import start.novel.novelservice.repository.LikeDataRepositoryDto;


@Service
@RequiredArgsConstructor
public class LikeDataServiceV1 implements LikeDataService {

    private final LikeDataRepository likeDataRepository;

    @Override
    public LikeData save(LikeData likeData) {
        return null;
    }

    @Override
    public void update(int Like_noveldata_id, LikeDataRepositoryDto updateParem) {
    }
}
