package org.vignesh;

import org.vignesh.database.jdbc1.sqljobs.CancelEntitlementEventsJob;
import org.vignesh.database.jdbc1.sqljobs.CreateNewEntitlementEventsJob;
import org.vignesh.database.jdbc1.sqljobs.UpdateEntitlementEventsJob;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by vignesh.prabhu@outlook.com on 3/1/16.
 */
public class JDBCMain {

    public static void main(String[] args){

       ExecutorService executorService = Executors.newFixedThreadPool(10);

       executorService.submit(new UpdateEntitlementEventsJob());
       executorService.submit(new CancelEntitlementEventsJob());
       executorService.submit(new CreateNewEntitlementEventsJob());

    }
}
