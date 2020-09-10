package com.example.demo.Incidental;

import com.example.demo.Category.CategoryDto;
import com.example.demo.Category.CategoryService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IncidentalController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping("/")
    public String index(){
        return "Incidental/index";
    }

    @RequestMapping("/leftSidebar")
    public String loadSidebar(Model model) {
        //카테고리를 다 가져와서 leftSidebar에 다 전달해줘야한다.
        List<CategoryDto> categoryDtoList = categoryService.GetCategoryList();

        model.addAttribute("categoryList",categoryDtoList);

        return "Incidental/leftSidebar";
    }

    @RequestMapping("/header")
    public String loadHeader() {
        return "Incidental/header";
    }


    @RequestMapping("/Content/leftSidebar")
    public String DailyLife_loadSidebar1(Model model) {
        List<CategoryDto> categoryDtoList = categoryService.GetCategoryList();

        model.addAttribute("categoryList",categoryDtoList);
        return "Incidental/leftSidebar";
    }

    @RequestMapping("/Content/header")
    public String DailyLife_loadHeader1() {
        return "Incidental/header";
    }

    @RequestMapping("/Content/ContentShow/leftSidebar")
    public String DailyLife_loadSidebar2(Model model) {
        List<CategoryDto> categoryDtoList = categoryService.GetCategoryList();

        model.addAttribute("categoryList",categoryDtoList);
        return "Incidental/leftSidebar";
    }

    @RequestMapping("/Content/ContentShow/header")
    public String DailyLife_loadHeader2() {
        return "Incidental/header";
    }

    @RequestMapping("/Content/ContentModify/leftSidebar")
    public String DailyLife_loadSidebar3(Model model) {
        List<CategoryDto> categoryDtoList = categoryService.GetCategoryList();

        model.addAttribute("categoryList",categoryDtoList);
        return "Incidental/leftSidebar";
    }

    @RequestMapping("/Content/ContentModify/header")
    public String DailyLife_loadHeader3() {
        return "Incidental/header";
    }

}
