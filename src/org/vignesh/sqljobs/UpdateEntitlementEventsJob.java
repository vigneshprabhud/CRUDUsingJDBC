package org.vignesh.sqljobs;

import org.vignesh.database.jdbc1.sqlbuilders.SelectQueryBuilder;
import org.vignesh.database.jdbc1.sqlbuilders.UpdateQueryBuilder;
import org.vignesh.database.jdbc1.sqloperations.Select;
import org.vignesh.database.jdbc1.sqloperations.Update;
import org.vignesh.database.jdbc1.utilities.CSVReader;

import java.util.List;
import java.util.Map;

/**
 * Created by vignesh.prabhu@outlook.com on 3/2/16.
 */
public class UpdateEntitlementEventsJob implements Runnable {

    @Override
    public void run() {

        //Select
        String selectSQL = SelectQueryBuilder.buildSelectSQLForUpdateEntitlementEvents("cache_xpass_enttl");
        Select select = new Select();
        List<String> bindVariablesForSelectUpdateEntitlementEvents = CSVReader.read("filePath");
        Map<String, String> selectResultSet = select.doSelect(selectSQL,bindVariablesForSelectUpdateEntitlementEvents);
        System.out.println("Rows selected " + selectResultSet.size());

        //Update
        String updateSQL = UpdateQueryBuilder.builUpdateSQLForUpdateEntitlementEvents("cache_xpass_enttl");
        Update update = new Update();
        List<String> bindVariablesForUpdateUpdateEntitlementEvents = CSVReader.read("filePath");
        int rowsAffected = update.doUpdate(updateSQL,selectResultSet,"id",bindVariablesForUpdateUpdateEntitlementEvents);
        System.out.println("Rows updated " + rowsAffected);

    }
}
