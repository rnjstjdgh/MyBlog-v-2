package com.example.demo.Category;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@SequenceGenerator(name = "Category_SEQ_GENERATOR", sequenceName = "Category_SEQ", initialValue = 1, allocationSize = 1)
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "category")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE , generator="Category_SEQ_GENERATOR")
    private Long id;

    @Column(length = 100, nullable = false)
    private String category1;

    @Column(length = 225, nullable = false)
    private String category2;

    @Builder
    public CategoryEntity(Long id, String category1, String category2){
        this.id = id;
        this.category1 = category1;
        this.category2 = category2;
    }
}
