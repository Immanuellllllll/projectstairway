package com.example.demo.Service;

import com.example.demo.Models.Admin;
import com.example.demo.Repository.AdminRepo;
import com.mysql.cj.protocol.Resultset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.transform.Result;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class AdminService implements AdminServiceI {
    @Autowired
    AdminRepo admRepo;


    // En metode kaldet "hashpassword" der har en String af typen password som parameter.
    public String hashPassword(String password) throws NoSuchAlgorithmException {
        //Vi laver en ny instance af MessageDigest.
        //getInstance("SHA-224") giver MessageDigest besked om hvilken Messagedigest vi vil have.
        MessageDigest md = MessageDigest.getInstance("SHA-224");
        // Updaterer md med de bytes vi vil have, password i det her tilfælde.
        md.update(password.getBytes());
        //Laver et byte array med de bytes fra md.digest.
        byte[] b = md.digest();
        //En Stringbuffer gør det muligt at indsætte ting i en String.
        StringBuffer sb = new StringBuffer();
        for (byte b1 : b) {
            //Vi fortæller vores StringBuffer hvad der skal lægges ind i vores String.
            //Vi siger den skal lægger hexkode versionen af en integer ind.
            // Jeg ved ikk helt hvad b1 & 0xff gør, men det skal være der.
            //Noget med om det er 8 eller 16 bit.
            sb.append(Integer.toHexString(b1 & 0xff));
        }
        //Vi kommer tilbage med en .toString version af vores StringBuffer object.
        return sb.toString();
    }

    @Override
    public void confirmLogin(Admin admin) throws SQLException, NoSuchAlgorithmException {
        admin.setPassword(hashPassword(admin.getPassword()));
        ResultSet rs =admRepo.confirmLogin(admin);
        rs.next();
        String checkLoginuser = rs.getString("username");
        String checkLoginpass = rs.getString("password");


    }

/*
        public void kodeord() {
            //Vi definerer passwordet, det kunne også være indput.
            String password = "12345";
            try {
                //Vi printer hashPassword metoden ud med vores password som parameter.
                System.out.println(hashPassword(password));

            } catch (NoSuchAlgorithmException e) {
                System.out.println(e);
            }
        }

    public static void main(String[] args) {
        AdminService adminService = new AdminService();
        adminService.kodeord();
    }
    */
}

