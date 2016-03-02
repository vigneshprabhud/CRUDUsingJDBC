package org.vignesh.sqlbuilders;

/**
 * Created by vignesh.prabhu@outlook.com on 3/2/16.
 */
public final class InsertQueryBuilder {

    public static String builInsertSQLForCancelEntitlementEvents(String tableName){
        StringBuilder insertSqlString = new StringBuilder();
        insertSqlString.append("insert");
        insertSqlString.append(" into ");
        insertSqlString.append(tableName); //xpass_actvy_log
        insertSqlString.append(" values (");
        return insertSqlString.toString();
    }

    public static String builInsertSQLForCreateEntitlementEventsNo1(String tableName){
        StringBuilder insertSqlString = new StringBuilder();
        insertSqlString.append("insert");
        insertSqlString.append(" into ");
        insertSqlString.append(tableName); //cache_xpass_enttl
        insertSqlString.append(" values (");
        return insertSqlString.toString();
    }

    public static String builInsertSQLForCreateEntitlementEventsNo2(String tableName){
        StringBuilder insertSqlString = new StringBuilder();
        insertSqlString.append("insert");
        insertSqlString.append(" into ");
        insertSqlString.append(tableName); //xpass_actvy_log
        insertSqlString.append(" values (");
        return insertSqlString.toString();
    }

    public static String builInsertSQLForCreateEntitlementEventsNo3(String tableName){
        StringBuilder insertSqlString = new StringBuilder();
        insertSqlString.append("insert");
        insertSqlString.append(" into ");
        insertSqlString.append(tableName); //cache_xpass_enttl_entrtn_loc
        insertSqlString.append(" values (");
        return insertSqlString.toString();
    }
}
