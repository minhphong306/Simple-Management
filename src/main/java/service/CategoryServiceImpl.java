/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Category;
import util.DBUtil;

public class CategoryServiceImpl implements CategoryService {

    private static Connection connection;

    @Override
    public List<Category> getListCategory() {
        connection = DBUtil.getConnection();
        String sql = " SELECT id, name, picture, note from category where is_deleted = false";
        Statement stmt;
        List<Category> categories = new ArrayList<>();
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            Category category;
            while (rs != null && rs.next()) {
                category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                category.setPicture(rs.getString("picture"));
                category.setNote(rs.getString("note"));

                categories.add(category);
            }

            if (rs != null) {
                rs.close();
            }
            stmt.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return categories;
    }

    @Override
    public Category getCategory(String username) {
        connection = DBUtil.getConnection();
        String sql = " SELECT id, name, picture, note from category where is_deleted = false and id = ?";
        Category category = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs != null && rs.next()) {
                category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                category.setPicture(rs.getString("picture"));
                category.setNote(rs.getString("note"));
            }

            if (rs != null) {
                rs.close();
            }
            
            if(ps != null){
                ps.close();
            }
            
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return category;
    }

    @Override
    public boolean updateCategory(Category category) {
        connection = DBUtil.getConnection();
        boolean result = false;
        String sql = " UPDATE category "
                + " SET "
                + " name = ?, "
                + " picture = ?, "
                + " note = ? "
                + " WHERE "
                + " id = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, category.getName());
            ps.setString(2, category.getPicture());
            ps.setString(3, category.getNote());
            ps.setInt(4, category.getId());

            int exec_result = ps.executeUpdate();

            ps.close();
            if (exec_result > 0) {
                result = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return result;
    }

    @Override
    public boolean removeCategory(int categoryID) {
        connection = DBUtil.getConnection();
        boolean result = false;
        String sql = " UPDATE category "
                + " SET "
                + " is_deleted = true "
                + " WHERE "
                + " id = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, categoryID);

            int exec_result = ps.executeUpdate();

            ps.close();
            if (exec_result > 0) {
                result = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return result;
    }

}
