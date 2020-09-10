package com.example.demo.Content;

import com.example.demo.Utils.TimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@SequenceGenerator(name = "content_SEQ_GENERATOR", sequenceName = "content_SEQ", initialValue = 1, allocationSize = 1)
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "content")
public class ContentEntity extends TimeEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE , generator="content_SEQ_GENERATOR")
    private Long id;

    @Column(length = 10, nullable = false)
    private String writer;

    @Lob
    @Column(nullable = false)
    private String title;

    @Column(length = 10, nullable = false)
    private String category;

    @Column(length = 10, nullable = false)
    private String subCategory;

    @Lob
    @Column(nullable = false)
    private String content;

    @Builder
    public ContentEntity(Long id, String title, String content, String writer, String category, String subCategory){
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.category = category;
        this.subCategory = subCategory;
    }
}
