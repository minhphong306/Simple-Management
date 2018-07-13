/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.Category;

/**
 *
 * @author phongdm
 */
public interface CategoryService {
    public List<Category> getListCategory();
    
    public Category getCategory(String categoryName);
    
    public boolean updateCategory(Category category);
    
    public boolean removeCategory(int categoryID);
}
