package com.example.demo.Service;

import com.example.demo.Models.Admin;
import org.springframework.stereotype.Service;

public interface AdminServiceI {
    Boolean confirmLogin(Admin admin);
}
