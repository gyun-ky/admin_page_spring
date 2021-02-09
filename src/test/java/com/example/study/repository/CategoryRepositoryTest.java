package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Category;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

public class CategoryRepositoryTest extends StudyApplicationTests {

    @Autowired
    private CategoryRepository categoryRepository;

//    @Test
//    @Transactional
//    public void create(){
//        String type = "computer";
//        String title = "컴퓨터";
//        LocalDateTime createdAt = LocalDateTime.now();
//        String createdBy = "AdminServer";
//
//        Category category = new Category();
//        category.setType(type);
//        category.setTitle(title);
//        category.setCreatedAt(createdAt);
//        category.setCreatedBy(createdBy);
//        System.out.println(category);
//        Category newCategory = categoryRepository.save(category);
//        System.out.println("여");
//
//        Assert.assertNotNull(newCategory);
//        Assert.assertEquals(newCategory.getType(), type);
//        Assert.assertEquals(newCategory.getTitle(), title);
//
//    }

}
