package org.vignesh.utilities;


/**
 * Created by vignesh.prabhu@outlook.com on 3/1/16.
 */
public final class ConnectionDetails {

    public static String DBDRIVER = null;
    public static String DBURL = null;
    public static String USERNAME = null;
    public static String PASSWORD = null;

    private static ConnectionDetails connectionDetails = new ConnectionDetails();

    public static ConnectionDetails getInstance() {

        return connectionDetails;
    }

    private ConnectionDetails() {
    }

    private static void setConnectionDetails(){
        DBDRIVER = "com.mysql.jdbc.Driver";
        DBURL = "jdbc:mysql://localhost:3306/vignesh";
        USERNAME = "root";
        PASSWORD = "passme";
    }

    private static void loadDriver() throws ClassNotFoundException {
        Class.forName(DBDRIVER);
    }

    public static void initializeDBSettings() throws ClassNotFoundException {
        setConnectionDetails();
        loadDriver();
    }

}
