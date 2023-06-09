package start.novel.novelservice.repository;

import lombok.Data;

@Data
public class NovelUpdateDto {
    private String novelImage;

    private String novelTitle;

    private Integer author_id;

    private Integer this_novel_Serialization;

    private String author_Nickname;

    private String novel_Description;

    private Integer novel_genre;

    public NovelUpdateDto() {

    }

    public NovelUpdateDto(String novelImage, String novelTitle, Integer author_id, Integer this_novel_Serialization, String author_Nickname, String novel_Description, Integer novel_genre) {
        this.novelImage = novelImage;
        this.novelTitle = novelTitle;
        this.author_id = author_id;
        this.this_novel_Serialization = this_novel_Serialization;
        this.author_Nickname = author_Nickname;
        this.novel_Description = novel_Description;
        this.novel_genre = novel_genre;
    }
}
