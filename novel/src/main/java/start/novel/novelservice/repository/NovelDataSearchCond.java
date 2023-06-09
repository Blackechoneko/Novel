package start.novel.novelservice.repository;


import lombok.Data;

@Data
public class NovelDataSearchCond {

    //검색 조건 : 소설 이름 , 작자 닉네임
    private String NovelTitle;
    private String author_nickname;

    public NovelDataSearchCond() {

    }
    public NovelDataSearchCond(String NovelTitle ,String author_nickname) {
        this.NovelTitle = NovelTitle;
        this.author_nickname = author_nickname;
    }
}
