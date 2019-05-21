package com.example.demo.Service;

import com.example.demo.Models.Admin;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public interface AdminServiceI {
    void confirmLogin(Admin admin) throws SQLException, NoSuchAlgorithmException;
}
