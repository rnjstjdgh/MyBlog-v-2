package com.example.demo.Content;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@Controller
public class ContentController {

    @Autowired
    private ContentService contentService;

    @RequestMapping("Content/ContentBoard")
    public String ShowContentBoard(Principal principal, Model model, @RequestParam(value = "Page",defaultValue = "1") Integer pageNum, HttpServletRequest request){
        String category = request.getParameter("category");
        String subCategory = request.getParameter("subCategory");

        if(subCategory.equals("커리어일기") && principal == null)
            return "Incidental/NoGrant";    //커리어 일기인데 익명의 사용자이면 => 접근 권한이 없음

        if (category == null)
            category = "total";
        if (subCategory == null)
            subCategory = "total";

        List<ContentDto> contentDtoList;
        Integer[] pageList;
        contentDtoList = contentService.GetContentList(pageNum, category ,subCategory);
        pageList = contentService.GetPageList(pageNum,category,subCategory);

        model.addAttribute("subCategory",subCategory);
        model.addAttribute("category",category);
        model.addAttribute("contentDtoList",contentDtoList);
        model.addAttribute("pageList",pageList);
        model.addAttribute("currentPageNum",pageNum);

        return "Content/ContentBoard";
    }

    @GetMapping("Content/ContentSearch")
    public String SearchContent(Principal principal ,Model model, HttpServletRequest request){
        String keyword = request.getParameter("keyword");
        String category = request.getParameter("category");
        String subCategory = request.getParameter("subCategory");
        if(subCategory.equals("커리어일기") && principal == null)
            return "Incidental/NoGrant";    //커리어 일기인데 익명의 사용자이면 => 접근 권한이 없음

        List<ContentDto> contentDtoList;
        contentDtoList = contentService.SearchContents(keyword,category,subCategory);
        model.addAttribute("contentDtoList", contentDtoList);
        model.addAttribute("category",category);
        model.addAttribute("subCategory",subCategory);
        return "Content/ContentBoard";
    }

    @GetMapping("Content/ContentShow/{contentId}")
    public String ShowSingleContent(Principal principal, @PathVariable("contentId") Long id, Model model){
        ContentDto contentDto = contentService.GetContent(id);
        if(contentDto.getSubCategory().equals("커리어일기") && principal == null)
            return "Incidental/NoGrant";    //커리어 일기인데 익명의 사용자이면 => 접근 권한이 없음

        model.addAttribute("contentDto",contentDto);
        return "Content/ContentShow";
    }

    @PostMapping("Content/ContentCreate")
    public String CreateSingleContent(ContentDto contentDto, Model model){
        contentService.SaveContent(contentDto);
        return "redirect:/";
    }

    @GetMapping("Content/ContentCreate")
    public String CreateSingleContentPage(){
        return "Content/ContentCreate";
    }


    @GetMapping("Content/ContentCreate/titleOverlapCheck")
    @ResponseBody
    public Long titleCheck(HttpServletRequest request){
        String title = request.getParameter("title");
        String category = request.getParameter("category");
        String subCategory = request.getParameter("subCategory");
        Long isPresent = contentService.titleOverlapCheck(title, category, subCategory);
        return isPresent;
    }

    @GetMapping("Content/ContentModify/{contentId}")
    public String ModifySingleContent(@PathVariable("contentId") Long id, Model model, HttpServletRequest request){
        ContentDto contentDto = contentService.GetContent(id);
        String category = request.getParameter("category");
        String subCategory = request.getParameter("subCategory");

        model.addAttribute("contentDto",contentDto);
        model.addAttribute("category",category);
        model.addAttribute("subCategory",subCategory);

        return "Content/ContentModify";
    }

    @PutMapping("Content/ContentModifyUpdate/{contentId}")
    public String ModifySingleUpdate(ContentDto contentDto){
        contentService.SaveContent(contentDto);
        return "redirect:/";
    }

    @DeleteMapping("Content/ContentDelete/{contentId}")
    public String DeleteSingleContent(@PathVariable("contentId") Long id){
        contentService.DeleteContent(id);
        return "redirect:/";
    }


}
