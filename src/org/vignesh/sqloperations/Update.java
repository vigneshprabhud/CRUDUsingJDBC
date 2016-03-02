package org.vignesh.sqloperations;


import org.vignesh.utilities.ConnectionDetails;

import java.sql.*;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by vignesh.prabhu@outlook.com on 3/2/16.
 */
public class Update {

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private StringBuilder updateStringBuilder = new StringBuilder();
    private int rowsAffected;

/*
    update cache_xpass_enttl set {all columns} where cache_xpass_enttl_id = ?
*/

    public int doUpdate(String updateSqlString, Map<String, String> updateMap, String primaryKey, List<String> bindVariables){

        updateStringBuilder.append(updateSqlString);

        try{
            ConnectionDetails.initializeDBSettings();
            conn = DriverManager.getConnection(ConnectionDetails.DBURL, ConnectionDetails.USERNAME, ConnectionDetails.PASSWORD);

            Iterator<Map.Entry<String, String>> iterator = updateMap.entrySet().iterator() ;
            while(iterator.hasNext()){
                Map.Entry<String, String> updateEntitlementEventEntry = iterator.next();
                //Ignore Primary key for update
                if(updateEntitlementEventEntry.getKey().compareTo(primaryKey)!=0) {
                    updateStringBuilder.append(updateEntitlementEventEntry.getKey());
                    updateStringBuilder.append("=?, ");
                }
            }

            updateStringBuilder.deleteCharAt(updateStringBuilder.length()-2);
            updateStringBuilder.append("where ");
            //Primary Key
            updateStringBuilder.append(primaryKey);
            updateStringBuilder.append(" = ");
            //Primary Key Value
            updateStringBuilder.append("?");

            ps = conn.prepareStatement(updateStringBuilder.toString());
            //Other values to be updated

            int i=1;
            Iterator iterator1 = bindVariables.iterator();
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
