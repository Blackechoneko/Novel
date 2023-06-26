package start.novel.novelservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import start.novel.domain.BookMarkData;
import start.novel.novelservice.repository.BookMarkRepository;
import start.novel.novelservice.repository.BookMarkRepositoryDto;

@Service
@RequiredArgsConstructor
public class BookMarkServiceV1 implements BookMarkService {

    private final BookMarkRepository bookMarkRepository;
    @Override
    public BookMarkData save(BookMarkData bookMarkData) {
        return null;
    }

    @Override
    public void update(int BookMark_Noveldata_id, BookMarkRepositoryDto updateParem) {

    }
}
