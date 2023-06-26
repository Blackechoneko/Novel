package start.novel.novelservice.service;

import start.novel.domain.BookMarkData;
import start.novel.novelservice.repository.BookMarkRepositoryDto;

public interface BookMarkService {

    BookMarkData save(BookMarkData bookMarkData);

    void update(int BookMark_Noveldata_id , BookMarkRepositoryDto updateParem);
}
