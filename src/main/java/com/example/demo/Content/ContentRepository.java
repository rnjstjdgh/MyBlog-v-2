package com.example.demo.Content;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContentRepository extends JpaRepository<ContentEntity, Long> {

    Page<ContentEntity> findByCategory(String category, Pageable createDate);
    long countByCategory(String category);

    Page<ContentEntity> findByCategoryAndSubCategory(String category, String subCategory, Pageable createDate);

    long countByCategoryAndSubCategory(String category, String subCategory);

    List<ContentEntity> findByTitle(String title);

    List<ContentEntity> findByTitleAndCategoryAndSubCategory(String title,String category, String subCategory);
    //-------------------------------------------------------------

    List<ContentEntity> findByTitleContaining(String keyword);

    List<ContentEntity> findByCategoryAndTitleContaining(String category, String keyword);

    List<ContentEntity> findByCategoryAndSubCategoryAndTitleContaining(String category,String subCategory, String keyword);

    List<ContentEntity> findBySubCategory(String subCategory);
}
