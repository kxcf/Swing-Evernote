package Swing.Control;

import Swing.util.DBConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by qiuxin on 15/12/27.
 */
public class saveNote {
    public static void save(String content, int id) {
        Connection con = DBConnect.Connect();
        String sqlStr = "INSERT INTO notes (notes, userid) VALUES (" + '"' +
                content + "\"," + id + ");";
        Statement stat = null;
        try {
            stat = con.createStatement();
            int rs = stat.executeUpdate(sqlStr);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
