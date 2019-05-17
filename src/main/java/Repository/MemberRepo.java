package Repository;

import Config.MySQLConnection;
import Models.Member;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class MemberRepo {
    Connection con;
    MySQLConnection msc;

    public MemberRepo(MySQLConnection msc) throws Exception
    {
        this.msc=msc;
        this.con=msc.create();
        //Lets load the driver

    }
    /**
     *
     * @param member
     */
    public void registerMember(Member member) {
        // TODO - implement MemberRepository.registerMember
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param member
     */
    public void editMember(Member member) {
        // TODO - implement MemberRepository.editMember
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param memberid
     */
    public void deleteMember(int memberid) {
        // TODO - implement MemberRepository.deleteMember
        throw new UnsupportedOperationException();
    }

    //Metoden prøver at sende en SQL sætning til databasen og lykkedes det sender den et resultset af alle patienter tilbage.

    public ResultSet viewMembers() throws Exception {
            String sql = "SELECT * FROM members";
            try {
                ResultSet rs = Query(sql);
                return rs;
            }catch (Exception e){
                System.out.println(e);
            }
            return null;
        // TODO - implement MemberRepository.viewMembers
    }

    //Metoden beder om en String og returnerer en ordre til at udføre den i databasen.
    private ResultSet Query (String query) throws SQLException
    {
        Statement stmt = con.createStatement();
        return (stmt.executeQuery(query));
    }

}

