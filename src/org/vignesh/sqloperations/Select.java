package org.vignesh.sqloperations;

import org.vignesh.database.jdbc1.utilities.ConnectionDetails;

import java.sql.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by vignesh.prabhu@outlook.com on 3/2/16.
 */
public class Select {

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    private Map selectMap = new HashMap();

    /*select * from cache_xpass_enttl where cache_xpass_enttl_id = ?
    select * from cache_xpass_enttl where xpass_enttl_id = ?
    select * from cache_xpass_enttl_sts where cache_xpass_enttl_sts_cd = ?
    select * from cache_xpass_enttl where xpass_enttl_id = ? and exprnc_band_id = ? and logical_del_in = 'N'
    select * from cache_xpass_enttl_sts where cache_xpass_enttl_sts_cd = ?
    select * from cache_gxp_loc where cache_gxp_loc_id = ?
    select * from cache_gxp_entrtn where cache_gxp_entrtn_id = ?
    */
    public Map<String, String> doSelect(String selectSqlString, List<String> bindVariables){

        try {
            ConnectionDetails.initializeDBSettings();
            conn = DriverManager.getConnection(ConnectionDetails.DBURL, ConnectionDetails.USERNAME, ConnectionDetails.PASSWORD);
            ps = conn.prepareStatement(selectSqlString);

            int i=1;
            Iterator iterator = bindVariables.iterator();
            while(iterator.hasNext()){
                ps.setString(i, String.valueOf(iterator.next()));
                i++;
            }

            rs = ps.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();

            while (rs.next()) {
                for (int j = 1; j <= columnsNumber; j++) {
                    selectMap.put(rsmd.getColumnName(j), rs.getString(j));
                }
            }

        } catch (ClassNotFoundException e) {e.printStackTrace();}
          catch (SQLException e) {e.printStackTrace();}
          finally {
            try {if (rs != null) rs.close();} catch (Exception e) {e.printStackTrace();};
            try {if (ps != null) ps.close();} catch (Exception e) {e.printStackTrace();};
            try {if (conn != null) conn.close();} catch (Exception e) {e.printStackTrace();};
        }
        return selectMap;
    }
}
