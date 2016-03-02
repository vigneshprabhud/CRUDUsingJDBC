package org.vignesh.sqloperations;

import org.vignesh.database.jdbc1.utilities.ConnectionDetails;

import java.sql.*;
import java.util.Iterator;
import java.util.List;

/**
 * Created by vignesh.prabhu@outlook.com on 3/2/16.
 */
public class Insert {

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private StringBuilder insertStringBuilder = new StringBuilder();
    private int rowsAffected;

    /*insert xpass_actvy_log
    insert cache_xpass_enttl
    insert xpass_actvy_log
    insert cache_xpass_enttl_entrtn_loc*/

    public int doInsert(String insertSqlString, List<String> insertValues){

        insertStringBuilder.append(insertSqlString);

        try{
            ConnectionDetails.initializeDBSettings();
            conn = DriverManager.getConnection(ConnectionDetails.DBURL, ConnectionDetails.USERNAME, ConnectionDetails.PASSWORD);

            Iterator iterator = insertValues.iterator();
            while(iterator.hasNext()){
                insertStringBuilder.append("?, ");
                iterator.next();
            }

            insertStringBuilder.deleteCharAt(insertStringBuilder.length()-2);
            insertStringBuilder.append(")");

            ps = conn.prepareStatement(insertStringBuilder.toString());
            //Other values to be updated
            int i=1;
            Iterator iterator1 = insertValues.iterator();
            while(iterator1.hasNext()){
                ps.setString(i, String.valueOf(iterator1.next()));
                i++;
            }

            rowsAffected = ps.executeUpdate();

        } catch (ClassNotFoundException e) {e.printStackTrace();}
        catch (SQLException e) {e.printStackTrace();}
        finally {
            try {if (rs != null) rs.close();} catch (Exception e) {e.printStackTrace();};
            try {if (ps != null) ps.close();} catch (Exception e) {e.printStackTrace();};
            try {if (conn != null) conn.close();} catch (Exception e) {e.printStackTrace();};
        }

        return rowsAffected;

    }
}
