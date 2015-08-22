package psyco.db;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.sql.*;
import java.util.List;

/**
 * Created by lipeng on 15/8/22.
 */
public class Db {
    static final String DB_URL = "jdbc:mysql://localhost:3306/project-pro?characterEncoding=UTF-8";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, "root", "");
    }

    public DatabaseMetaData getDBMetadata(Connection connection) throws SQLException {
        return connection.getMetaData();
    }

    public List<String> getTableNames(DatabaseMetaData databaseMetaData) throws SQLException {
        List<String> re = Lists.newLinkedList();
        for (ResultSet result = databaseMetaData.getTables(null, "%", "%", new String[]{"TABLE"}); result.next(); re.add(result.getString(3)))
            ;
        return re;
    }

    public void listTableInfos() throws SQLException {
        DatabaseMetaData databaseMetaData = getDBMetadata(getConnection());
        getTableNames(databaseMetaData).forEach(e -> {
            try {
                tableInfo(databaseMetaData, e);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        });
    }

    public void tableInfo(DatabaseMetaData databaseMetaData, String table) throws SQLException {
        String columnName;
        String columnType;
        ResultSet colRet = databaseMetaData.getColumns(null, "%", table, "%");
        System.out.printf("%s----------------\n", table);
        while (colRet.next()) {
            columnName = colRet.getString("COLUMN_NAME");
            columnType = colRet.getString("TYPE_NAME");
            int datasize = colRet.getInt("COLUMN_SIZE");
            int digits = colRet.getInt("DECIMAL_DIGITS");
            int nullable = colRet.getInt("NULLABLE");
            System.out.println(columnName + " " + columnType + " " + datasize + " " + digits + " " +
                    nullable);
        }
    }


    @Test
    public void test() throws SQLException {
//        System.out.println(getTableNames(getDBMetadata(getConnection())));
        listTableInfos();
    }

}
