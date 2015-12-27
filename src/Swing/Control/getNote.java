package Swing.Control;

import Swing.util.DBConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by qiuxin on 15/12/27.
 */
public class getNote {

    public static String get(int id) {
        Connection con = DBConnect.Connect();
        String sqlStr = "SELECT notes FROM notes WHERE " +
                "(noteid=(SELECT MAX(noteid) FROM notes WHERE userid=" +
                id+"));";
        Statement stat = null;
        String str = null;
        try {
            stat = con.createStatement();
            ResultSet rs = stat.executeQuery(sqlStr);
            rs.next();
            str = rs.getString("notes");
            System.out.println(str);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return str;
    }
}
