package com.example.demo.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContentService {

    @Autowired
    private ContentRepository contentRepository;
    private static final int BLOCK_PAGE_NUM_COUNT = 5;  //블럭에 존재하는 페이지 수
    private static final int PAGE_POST_COUNT = 4;       //한 페이지에 존재하는 게시글 수

    @Transactional
    public Long SaveContent(ContentDto studyContentDto){
        return contentRepository.save(studyContentDto.toEntity()).getId();
    }

    @Transactional
    public List<ContentDto> GetContentList(Integer pageNum, String category , String subCategory){
        Page<ContentEntity> page;

        if (category.equals("total")){
            page = contentRepository.
                    findAll(
                            PageRequest.of(pageNum-1,PAGE_POST_COUNT, Sort.by(Sort.Direction.ASC, "createDate")));
        }
        else{
            if(subCategory.equals("total"))
                page = contentRepository.
                        findByCategory(category,
                                PageRequest.of(pageNum-1,PAGE_POST_COUNT, Sort.by(Sort.Direction.ASC, "createDate")));
            else
                page = contentRepository.
                        findByCategoryAndSubCategory(category, subCategory,
                                PageRequest.of(pageNum-1,PAGE_POST_COUNT, Sort.by(Sort.Direction.ASC, "createDate")));
        }
        List<ContentEntity> contentEntities = page.getContent();
        List<ContentDto> contentDtoList = new ArrayList<>();

        for(ContentEntity contentEntity : contentEntities){

            contentDtoList.add(this.convertEntityToDto(contentEntity));

        }
        return contentDtoList;
    }

    @Transactional
    public ContentDto GetContent(Long id){
        Optional<ContentEntity> contentEntityWrapper = contentRepository.findById(id);
        ContentEntity contentEntity = contentEntityWrapper.get();

        ContentDto contentDto = ContentDto.builder()
                .id(contentEntity.getId())
                .title(contentEntity.getTitle())
                .content(contentEntity.getContent())
                .category(contentEntity.getCategory())
                .subCategory(contentEntity.getSubCategory())
                .writer(contentEntity.getWriter())
                .createDate(contentEntity.getCreateDate())
                .build();
        return contentDto;
    }

    @Transactional
    public void DeleteContent(Long id){
        contentRepository.deleteById(id);
    }

    @Transactional
    public List<ContentDto> SearchContents(String keyword,String category ,String subCategory){
        //category: 반드시 들어옴
        //subCategory : total로 들어올 수도 있음
        List<ContentEntity> contentEntities;

        if (subCategory.equals("total"))
            contentEntities = contentRepository.findByCategoryAndTitleContaining(category, keyword);
        else
            contentEntities = contentRepository.findByCategoryAndSubCategoryAndTitleContaining(category, subCategory, keyword);

        List<ContentDto> contentDtoList = new ArrayList<>();

        if(contentEntities.isEmpty()) return contentDtoList;

        for(ContentEntity contentEntity : contentEntities){
            contentDtoList.add(this.convertEntityToDto(contentEntity));
        }

        return contentDtoList;
    }

    private ContentDto convertEntityToDto(ContentEntity contentEntity){
        return ContentDto.builder()
                .id(contentEntity.getId())
                .title(contentEntity.getTitle())
                .content(contentEntity.getContent())
                .writer(contentEntity.getWriter())
                .category(contentEntity.getCategory())
                .subCategory(contentEntity.getSubCategory())
                .createDate(contentEntity.getCreateDate())
                .build();
    }

    public Integer[] GetPageList(Integer currentPageNum, String category, String subCategory){
        Integer[] pageList = new Integer[BLOCK_PAGE_NUM_COUNT];

        //총 게시글 수
        Double postTotalCount = Double.valueOf(this.GetStudyContentCount(category, subCategory));

        //총 게시글 수를 기준으로 계산한 마지막 페이지 번호 계산
        Integer totalLastPageNum = (int)(Math.ceil((postTotalCount/PAGE_POST_COUNT)));

        //현재 페이지를 기준으로 블럭의 마지막 페이지 번호 계산
        Integer blockLastPageNum = (totalLastPageNum+1 > currentPageNum + BLOCK_PAGE_NUM_COUNT)
                ? currentPageNum + BLOCK_PAGE_NUM_COUNT
                : totalLastPageNum+1;

        //페이지 시작 번호 조정
        currentPageNum = (currentPageNum <=3)? 1:currentPageNum-2;

        //페이지 번호 할당
        for(int val = currentPageNum, i = 0; val<blockLastPageNum && i<5;val++,i++){
            pageList[i] = val;
        }
        return pageList;
    }


    @Transactional
    public Long GetStudyContentCount(String category, String subCategory) {
        if (category.equals("total")){
            return contentRepository.count();
        }
        else{
            if (subCategory.equals("total"))
                return contentRepository.countByCategory(category);
            else
                return new Long(contentRepository.countByCategoryAndSubCategory(category, subCategory));
        }
    }


    @Transactional
    public Long titleOverlapCheck(String title, String category, String subCategory){
        if(contentRepository.findByTitleAndCategoryAndSubCategory(title,category,subCategory).size() != 0)
            return new Long(1);
        else
            return new Long(-1);
    }
}
