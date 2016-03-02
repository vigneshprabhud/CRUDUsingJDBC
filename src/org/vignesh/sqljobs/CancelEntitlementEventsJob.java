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
public class CancelEntitlementEventsJob implements Runnable {
    @Override
    public void run() {
        //Select
        String selectSQL = SelectQueryBuilder.buildSelectSQLForCancelEntitlementEventsNo1("cache_xpass_enttl");
        Select select = new Select();
        List<String> bindVariablesForSelectCancelEntitlementEvents = CSVReader.read("filePath");
        Map<String, String> selectResultSet = select.doSelect(selectSQL,bindVariablesForSelectCancelEntitlementEvents);
        System.out.println("Rows selected " + selectResultSet.size());

        //Select
        String selectSQL1 = SelectQueryBuilder.buildSelectSQLForCancelEntitlementEventsNo2("cache_xpass_enttl_sts");
        Select select1 = new Select();
        List<String> bindVariablesForSelectCancelEntitlementEvents1 = CSVReader.read("filePath");
        Map<String, String> selectResultSet1 = select.doSelect(selectSQL,bindVariablesForSelectCancelEntitlementEvents1);
        System.out.println("Rows selected " + selectResultSet1.size());

        //Insert
        String insertSQL = InsertQueryBuilder.builInsertSQLForCancelEntitlementEvents("xpass_actvy_log");
        Insert insert = new Insert();
        List<String> bindVariablesForInsertCancelEntitlementEvents = CSVReader.read("filePath");
        int rowsAffected = insert.doInsert(insertSQL, bindVariablesForInsertCancelEntitlementEvents);
        System.out.println("Rows inserted " + rowsAffected);

    }
}
