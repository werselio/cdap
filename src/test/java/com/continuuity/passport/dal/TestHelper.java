package com.continuuity.passport.dal;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.hsqldb.Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *  Test Helper for unit/integration tests
 *  Uses HSQLDB instance for testing
 */
public class TestHelper {

  private  static Server server = null;
  private static final String CREATE_TABLE = "CREATE TABLE account (name VARCHAR(100), email_id VARCHAR(100) )";

  private static final String DROP_TABLE = "DROP TABLE account";
  protected static Connection connection;


  public static void startHsqlDB() throws SQLException, ClassNotFoundException {

    System.out.println("======================================START======================================");
    server = new Server();
    server.setLogWriter(null);
    server.setPort(1234);
    server.setSilent(true);
    server.setDatabaseName(0, "xdb");
    server.setDatabasePath(0, "mem:test");
    server.start();
    Class.forName("org.hsqldb.jdbcDriver");
    connection = DriverManager.getConnection("jdbc:hsqldb:mem:test;" +
                                            "hsqldb.default_table_type=cached;hsqldb.sql.enforce_size=false", "sa", "");
    connection.createStatement().execute(CREATE_TABLE);


  }


  public static void stopHsqlDB() throws SQLException {
    System.out.println("======================================STOP=======================================");

    connection.createStatement().execute(DROP_TABLE);
    connection.close();
    server.stop();
  }

}
