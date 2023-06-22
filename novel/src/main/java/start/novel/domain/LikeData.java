package start.novel.domain;

import lombok.Data;

@Data
public class LikeData {

    private long novel_id;

    private Integer author_id;

    private int LikeCount;

}
