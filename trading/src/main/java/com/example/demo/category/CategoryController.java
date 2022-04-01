package com.example.demo.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("getcategories")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("getcategory")
    public Category getCategory(String categoryName) {
        return categoryService.getCategory(categoryName);
    }

    @PostMapping("addcategory")
    public Category addCategory(@Valid @RequestBody Category category) {
        return categoryService.addCategory(category);
    }
}
