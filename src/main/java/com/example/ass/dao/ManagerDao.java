package com.example.ass.dao;

import com.example.ass.database.ConnectionU;
import com.example.ass.model.Manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManagerDao {

    static Connection connection = ConnectionU.getConnection();

    public static List<Manager> getManagerId(int id) {
        List<Manager> list = new ArrayList<>();
        String sql = "SELECT * FROM manager where id = ?";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Manager manager = new Manager();
                manager.setName(rs.getString("name"));
                manager.setEmail(rs.getString("email"));
                manager.setAddress(rs.getString("address"));
                manager.setPhone(rs.getString("phone"));
                list.add(manager);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List <Manager> getAllManager() {
        List< Manager > list = new ArrayList< >();
        String sql = "SELECT * FROM manager";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Manager manager = new Manager();
                manager.setId(rs.getInt("id"));
                manager.setName(rs.getString("name"));
                manager.setEmail(rs.getString("email"));
                manager.setAddress(rs.getString("address"));
                manager.setPhone(rs.getString("phone"));
                list.add(manager);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }



    public static String updateManager(Manager manager){
        String sql = "UPDATE manager SET name = ?, email = ?, address = ?, phone = ? WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, manager.getName());
            ps.setString(2, manager.getEmail());
            ps.setString(2, manager.getAddress());
            ps.setString(2, manager.getPhone());
            ps.setInt(3, manager.getId());
            int isSuccess = ps.executeUpdate();
            if (isSuccess > 0){
                return "Success";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "Fail";
    }


    public static String deleteManager(int id){
        String sql = "DELETE FROM manager WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            int Success = ps.executeUpdate();
            if (Success > 0 ){
                return "Success";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Fail";
    }

    public static String insertManager(Manager m){
        String sql = "INSERT INTO manager (name, email, address, phone) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, m.getName());
            ps.setString(2, m.getEmail());
            ps.setString(3, m.getAddress());
            ps.setString(4, m.getPhone());
            int Success = ps.executeUpdate();
            if (Success > 0){
                return "Success";
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
