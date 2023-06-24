package start.novel.domain;


import lombok.Data;

@Data
public class NovelChapterData {

    private int Novel_id;

    private String Novel_title;

    private String Novel_content;

    public NovelChapterData(int novel_id, String novel_title, String novel_content) {

        this.Novel_id = novel_id;
        this.Novel_title = novel_title;
        this.Novel_content = novel_content;
    }
}
