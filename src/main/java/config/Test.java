/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.util.List;
import model.Category;
import service.CategoryService;
import service.CategoryServiceImpl;

/**
 *
 * @author phongdm
 */
public class Test {

    public static void main(String[] args) {
        CategoryService catService = new CategoryServiceImpl();

//        Get list
//        List cat = catService.getListCategory();
//        System.out.println(cat.size());
        
        // Update
        Category cat = new Category();
        cat.setId(1);
        cat.setName("updated");
        cat.setNote("abc");
        cat.setPicture("updated.jpg");
        System.out.println(catService.updateCategory(cat));
    }
}
