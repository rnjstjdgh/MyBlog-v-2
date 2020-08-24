package com.example.demo.Content;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ContentDto {

    private Long id;
    private String writer;
    private String title;
    private String category;
    private String subCategory;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;

    public ContentEntity toEntity(){
        ContentEntity build = ContentEntity.builder()
                .id(id)
                .writer(writer)
                .title(title)
                .category(category)
                .subCategory(subCategory)
                .content(content)
                .build();
        return build;
    }

    @Builder
    public ContentDto(Long id, String title, String content, String writer, String category ,String subCategory
                            , LocalDateTime createDate, LocalDateTime modifiedDate){
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.category = category;
        this.subCategory = subCategory;
        this.content = content;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
    }
}
