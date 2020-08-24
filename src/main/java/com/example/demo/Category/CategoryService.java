package com.example.demo.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<CategoryDto> GetCategoryList(){
        List<CategoryEntity> categoryEntityList = categoryRepository.findAll();
        List<CategoryDto> categoryDtoList = new ArrayList<>();

        for(CategoryEntity categoryEntity : categoryEntityList){
            CategoryDto categoryDto = this.convertEntityToDto(categoryEntity);
            categoryDto.ChangeCategory2List();
            categoryDtoList.add(categoryDto);
        }
        return categoryDtoList;
    }

    private CategoryDto convertEntityToDto(CategoryEntity categoryEntity){
        return CategoryDto.builder()
                .id(categoryEntity.getId())
                .category1(categoryEntity.getCategory1())
                .category2(categoryEntity.getCategory2())
                .build();
    }

}
