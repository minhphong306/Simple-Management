/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.Product;

/**
 *
 * @author phongdm
 */
public interface ProductService {
     public List<Product> getListProduct();
    
    public Product getProduct(String username);
    
    public boolean updateProduct(Product account);
    
    public boolean removeProduct(Product account);
}
