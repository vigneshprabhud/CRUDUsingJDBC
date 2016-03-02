package org.vignesh.sqljobs;

import org.vignesh.database.jdbc1.sqlbuilders.InsertQueryBuilder;
import org.vignesh.database.jdbc1.sqlbuilders.SelectQueryBuilder;
import org.vignesh.database.jdbc1.sqloperations.Insert;
import org.vignesh.database.jdbc1.sqloperations.Select;
import org.vignesh.database.jdbc1.utilities.CSVReader;

import java.util.List;
import java.util.Map;

/**
 * Created by vignesh.prabhu@outlook.com on 3/2/16.
 */
public class CreateNewEntitlementEventsJob implements Runnable {
    @Override
    public void run() {

        //Select
        String selectSQL = SelectQueryBuilder.buildSelectSQLForCreateEntitlementEventsNo1("cache_xpass_enttl");
        Select select = new Select();
        List<String> bindVariablesForSelectCreateEntitlementEvents = CSVReader.read("filePath");
        Map<String, String> selectResultSet = select.doSelect(selectSQL,bindVariablesForSelectCreateEntitlementEvents);
        System.out.println("Rows selected " + selectResultSet.size());

        //Select
        String selectSQL1 = SelectQueryBuilder.buildSelectSQLForCreateEntitlementEventsNo2("cache_xpass_enttl_sts");
        Select select1 = new Select();
        List<String> bindVariablesForSelectCreateEntitlementEvents1 = CSVReader.read("filePath");
        Map<String, String> selectResultSet1 = select.doSelect(selectSQL,bindVariablesForSelectCreateEntitlementEvents1);
        System.out.println("Rows selected " + selectResultSet1.size());

        //Select
        String selectSQL2 = SelectQueryBuilder.buildSelectSQLForCreateEntitlementEventsNo3("cache_gxp_loc");
        Select select2 = new Select();
        List<String> bindVariablesForSelectCreateEntitlementEvents2 = CSVReader.read("filePath");
        Map<String, String> selectResultSet2 = select.doSelect(selectSQL,bindVariablesForSelectCreateEntitlementEvents2);
        System.out.println("Rows selected " + selectResultSet2.size());

        //Select
        String selectSQL3 = SelectQueryBuilder.buildSelectSQLForCreateEntitlementEventsNo4("cache_gxp_entrtn");
        Select select3 = new Select();
        List<String> bindVariablesForSelectCreateEntitlementEvents3 = CSVReader.read("filePath");
        Map<String, String> selectResultSet3 = select.doSelect(selectSQL,bindVariablesForSelectCreateEntitlementEvents3);
        System.out.println("Rows selected " + selectResultSet3.size());

        //Insert
        String insertSQL = InsertQueryBuilder.builInsertSQLForCreateEntitlementEventsNo1("cache_xpass_enttl");
        Insert insert = new Insert();
        List<String> bindVariablesForInsertCreateEntitlementEvents = CSVReader.read("filePath");
        int rowsAffected = insert.doInsert(insertSQL, bindVariablesForInsertCreateEntitlementEvents);
        System.out.println("Rows inserted " + rowsAffected);

        //Insert
        String insertSQL1 = InsertQueryBuilder.builInsertSQLForCreateEntitlementEventsNo2("xpass_actvy_log");
        Insert insert1 = new Insert();
        List<String> bindVariablesForInsertCreateEntitlementEvents1 = CSVReader.read("filePath");
        int rowsAffected1 = insert.doInsert(insertSQL, bindVariablesForInsertCreateEntitlementEvents1);
        System.out.println("Rows inserted " + rowsAffected1);

        //Insert
        String insertSQL2 = InsertQueryBuilder.builInsertSQLForCreateEntitlementEventsNo3("cache_xpass_enttl_entrtn_loc");
        Insert insert2 = new Insert();
        List<String> bindVariablesForInsertCreateEntitlementEvents2 = CSVReader.read("filePath");
        int rowsAffected2 = insert.doInsert(insertSQL, bindVariablesForInsertCreateEntitlementEvents2);
        System.out.println("Rows inserted " + rowsAffected2);

    }
}
