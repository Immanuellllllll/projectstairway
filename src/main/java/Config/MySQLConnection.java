package Config;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


@Configuration
public class MySQLConnection {

    //Her ligger oplysningerne brugt til at forbinde til vores database.
    // De er gemt som datatypen String og bruges af metoderne.
    private String db_host = "den1.mysql2.gear.host";
    private String db_database = "stairwaydatabase";
    private String db_user = "stairwaydatabase";
    private String db_password = "Zo1zeb?zSf!6";
    private Connection con;

    // constructor
    public MySQLConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    // create db connection. returns null on failure
    public Connection create() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://"+db_host+"/"+db_database, db_user, db_password);
            return con;
        } catch(Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void connClose() throws SQLException {
        this.con.close();
    }


}
