package org.vignesh.sqlbuilders;

/**
 * Created by vignesh.prabhu@outlook.com on 3/2/16.
 */
public final class UpdateQueryBuilder {

    public static String builUpdateSQLForUpdateEntitlementEvents(String tableName){
        StringBuilder updateSqlString = new StringBuilder();
        updateSqlString.append("update ");
        updateSqlString.append(tableName); //cache_xpass_enttl
        updateSqlString.append(" set ");
        return updateSqlString.toString();
    }
}
