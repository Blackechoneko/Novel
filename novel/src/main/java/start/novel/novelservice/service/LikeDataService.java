package start.novel.novelservice.service;

import start.novel.domain.LikeData;
import start.novel.novelservice.repository.LikeDataRepositoryDto;

public interface LikeDataService {

    LikeData save(LikeData likeData);

    void update(int Like_noveldata_id, LikeDataRepositoryDto updateParem);
}
