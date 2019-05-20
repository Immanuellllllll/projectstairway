package com.example.demo.Service;

import com.example.demo.Models.Admin;
import com.example.demo.Repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class AdminService implements AdminServiceI {
    @Autowired
    AdminRepo admRepo;


    // En metode kalled "hashpassword" der har en String af typen password som parameter.
    public static String hashPassword(String password) throws NoSuchAlgorithmException {
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

    /*
        public void kodeord() {
            //Vi definerer passwordet, det kunne også være indput.
            String password = "Stairwaypassword1";
            try {
                //Vi printer hashPassword metoden ud med vores password som parameter.
                System.out.println(hashPassword(password));

            } catch (NoSuchAlgorithmException e) {
                System.out.println(e);
            }
        }


    public String checkLogin(Admin admin) throws NoSuchAlgorithmException {
        //Vi tjekker lige og ser om det er det samme.
        //Vi tager passwordet, hasher det og ser om det er det samme som er i vores database.
        //Her udskifter vi selvfølgelig med SQL kald og hvad vi ellers har brug for.
        String password = admin.getPassword();//Indput fra hjemmeside.
        String hashedPassword = hashPassword(admin.getPassword());
        if (hashPassword(password).equals(hashedPassword)) {
            System.out.println("Correct Password");

        } else {
            System.out.println("Incorrect Password");

        }
        return password;
    }
*/
    @Override
    public String confirmLogin(Admin admin) throws NoSuchAlgorithmException {
        //Vi tjekker lige og ser om det er det samme.
        //Vi tager passwordet, hasher det og ser om det er det samme som er i vores database.
        //Her udskifter vi selvfølgelig med SQL kald og hvad vi ellers har brug for.
        String password = admin.getPassword();//Indput fra hjemmeside.
        String hashedPassword = hashPassword(admin.getPassword());
        if (hashPassword(admin.getPassword()).equals(hashedPassword)) {
            System.out.println("Correct Password");
            return password;
        } else {
            System.out.println("Incorrect Password");
            //return false;
        }
        return password;
    }
}

