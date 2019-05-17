package Repository;


import Config.MySQLConnection;
import Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.management.Query;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
@Repository
public class AdminRepo {
    AdminService admService;
    Connection con;
    MySQLConnection msc;

    public AdminRepo(MySQLConnection msc){
        this.msc=msc;
        this.msc= (MySQLConnection) msc.create();
    }
    public ResultSet confirmLogin() throws NoSuchAlgorithmException, SQLException {
        String username = "Nils";
        String password = admService.checkPassword();
        String q =
                "SELECT from stairwaydatabase.admin WHERE username = '" +username+ "AND password= '"+password+"'";
        try {
            ResultSet rs = new Query(q);
            return rs;
        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    private

}
