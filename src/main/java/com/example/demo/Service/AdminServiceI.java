package com.example.demo.Service;

import com.example.demo.Models.Admin;

import java.security.NoSuchAlgorithmException;

public interface AdminServiceI {
    String confirmLogin(Admin admin) throws NoSuchAlgorithmException;
}
