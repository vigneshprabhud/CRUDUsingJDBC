package org.vignesh.sqlbuilders;

/**
 * Created by vignesh.prabhu@outlook.com on 3/2/16.
 */
public final class SelectQueryBuilder {

    public static String buildSelectSQLForUpdateEntitlementEvents(String tableName){
        StringBuilder selectSqlString = new StringBuilder();
        selectSqlString.append("select * from ");
        selectSqlString.append(tableName); //cache_xpass_enttl
        selectSqlString.append(" where ");
        selectSqlString.append("cache_xpass_enttl_id");
        selectSqlString.append(" = ?");
        return selectSqlString.toString();
    }

    public static String buildSelectSQLForCancelEntitlementEventsNo1(String tableName){
        StringBuilder selectSqlString = new StringBuilder();
        selectSqlString.append("select * from ");
        selectSqlString.append(tableName); //cache_xpass_enttl
        selectSqlString.append(" where ");
        selectSqlString.append("xpass_enttl_id");
        selectSqlString.append(" = ?");
        return selectSqlString.toString();
    }

    public static String buildSelectSQLForCancelEntitlementEventsNo2(String tableName){
        StringBuilder selectSqlString = new StringBuilder();
        selectSqlString.append("select * from ");
        selectSqlString.append(tableName); //cache_xpass_enttl_sts
        selectSqlString.append(" where ");
        selectSqlString.append("cache_xpass_enttl_sts_cd");
        selectSqlString.append(" = ?");
        return selectSqlString.toString();
    }

    public static String buildSelectSQLForCreateEntitlementEventsNo1(String tableName){
        StringBuilder selectSqlString = new StringBuilder();
        selectSqlString.append("select * from ");
        selectSqlString.append(tableName); //cache_xpass_enttl
        selectSqlString.append(" where ");
        selectSqlString.append("xpass_enttl_id");
        selectSqlString.append(" = ? ");
        selectSqlString.append("AND ");
        selectSqlString.append("exprnc_band_id");
        selectSqlString.append(" = ? ");
        selectSqlString.append("logical_del_in");
        selectSqlString.append(" =N");
        return selectSqlString.toString();
    }

    public static String buildSelectSQLForCreateEntitlementEventsNo2(String tableName){
        StringBuilder selectSqlString = new StringBuilder();
        selectSqlString.append("select * from ");
        selectSqlString.append(tableName); //cache_xpass_enttl_sts
        selectSqlString.append(" where ");
        selectSqlString.append("cache_xpass_enttl_sts_cd");
        selectSqlString.append(" = ? ");
        return selectSqlString.toString();
    }

    public static String buildSelectSQLForCreateEntitlementEventsNo3(String tableName){
        StringBuilder selectSqlString = new StringBuilder();
        selectSqlString.append("select * from ");
        selectSqlString.append(tableName); //cache_gxp_loc
        selectSqlString.append(" where ");
        selectSqlString.append("cache_gxp_loc_id");
        selectSqlString.append(" = ? ");
        return selectSqlString.toString();
    }

    public static String buildSelectSQLForCreateEntitlementEventsNo4(String tableName){
        StringBuilder selectSqlString = new StringBuilder();
        selectSqlString.append("select * from ");
        selectSqlString.append(tableName); //cache_gxp_entrtn
        selectSqlString.append(" where ");
        selectSqlString.append("cache_gxp_entrtn_id");
        selectSqlString.append(" = ? ");
        return selectSqlString.toString();
    }
}
