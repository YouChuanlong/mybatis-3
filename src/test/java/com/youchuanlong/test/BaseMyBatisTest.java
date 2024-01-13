package com.youchuanlong.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.sql.DataSource;
import org.apache.ibatis.BaseDataTest;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeAll;

import java.io.Reader;

/**
 * @author YouChuanlong
 * Created at 2023/6/3 23:42
 */
public class BaseMyBatisTest {

    private final static String CONFIG_FILE = "com/youchuanlong/example/mybatis-config.xml";

    private final static String SQL_SCRIPT = "com/youchuanlong/example/user_example.sql";

    protected static SqlSessionFactory sqlSessionFactory;

    @BeforeAll
    static void setUp() throws Exception {
        try (Reader reader = Resources.getResourceAsReader(CONFIG_FILE)) {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        }

        assertNotNull(sqlSessionFactory);

        // populate in-memory database
        Configuration config = sqlSessionFactory.getConfiguration();
        Environment env = config.getEnvironment();
        DataSource ds = env.getDataSource();
        BaseDataTest.runScript(ds, SQL_SCRIPT);
    }
}
