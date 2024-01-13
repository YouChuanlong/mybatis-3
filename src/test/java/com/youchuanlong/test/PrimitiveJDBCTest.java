package com.youchuanlong.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 原始的 JDBC
 * @author Ryan You <br/> Created at 2024/1/10 16:03
 */
public class PrimitiveJDBCTest {



    private final static String URL = "jdbc:hsqldb:mem:automapping";
    private final static String USER = "sa";
    private final static String PWD = "";
    private final static String DRIVER_CLAZZ = "";
    
    // private final static String sql = "";

    private static Connection conn;


    @BeforeAll
    public static void setup()
        throws Exception {
        conn = getConnection();

    }

    /**
     * {@link java.sql.ResultSet} Java 数据库查询结果集
     * @throws SQLException
     */
    @Test
    public void executeQuery() throws SQLException {
        String sql = "SELECT * FROM user";
        ResultSet resultSet = executeQuery(sql);
        assertNotNull(resultSet);
        // assertEquals(1, resultSet.getRow());
    }

    @Test
    public void useMyBatisResultHandler() {
    }


    private ResultSet executeQuery(final String sql) throws SQLException {
        Statement stat = conn.createStatement();
        stat.execute(sql);
        return stat.getResultSet();
    }

    private static Connection getConnection()
        throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        // Connection connection =
        // DataSource dataSource = new DataSource();
        Class<?> dbClass = Class.forName("org.hsqldb.jdbcDriver");
        DriverManager.registerDriver((java.sql.Driver) dbClass.newInstance());
        Connection conn = DriverManager.getConnection(URL, USER, PWD);
        return null;
    }

}
