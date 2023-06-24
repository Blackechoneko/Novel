package start.novel.novelservice.repository;


import lombok.Data;

@Data
public class LikeDataRepositoryDto {

    private int Likenoveldata_id;

    private int Novel_likecount;

    public LikeDataRepositoryDto(int likenoveldata_id, int novel_likecount) {
        this.Likenoveldata_id = likenoveldata_id;
        this.Novel_likecount = novel_likecount;
    }
}
