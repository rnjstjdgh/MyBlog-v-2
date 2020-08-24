package com.example.demo.Category;


import lombok.*;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CategoryDto {

    private Long id;
    private String category1;
    private String category2;
    private List<String> category2List;

    public CategoryEntity toEntity(){
        CategoryEntity build = CategoryEntity.builder()
                                    .id(id)
                                    .category1(category1)
                                    .category2(category2)
                                    .build();
        return build;
    }

    @Builder
    public CategoryDto(Long id, String category1, String category2){
        this.id = id;
        this.category1 = category1;
        this.category2 = category2;
    }

    public void ChangeCategory2List(){
        category2List = Arrays.asList(category2.split("/"));
    }

}
