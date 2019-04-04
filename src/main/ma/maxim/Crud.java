package main.ma.maxim;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import java.lang.reflect.Field;

class DatabaseInfo {

    public static final String URL = "jdbc:mysql://localhost:8889/MI6?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static final String USER = "root";
    public static final String PASSWORD = "root";

}

public class Crud {

    Connection conn = null;

    public Crud() {
        createConnection();
    }

    private void createConnection() {
        try {
            // create a connection to the database
            conn = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.USER, DatabaseInfo.PASSWORD);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    private PreparedStatement prepareAndBind(String sql, List<Object> bindParameters) throws SQLException {

        PreparedStatement stmt = null;
            stmt = conn.prepareStatement(sql);

            var i = 1;
            for (Object item : bindParameters) {
                if (item instanceof Integer) {

                    stmt.setInt(i,(int) item);

                } else if (item instanceof String) {

                    stmt.setString(i, item.toString());

                } else if (item instanceof Boolean) {

                    stmt.setBoolean(i, (Boolean) item);

                } else if (item instanceof java.sql.Timestamp) {

                    stmt.setTimestamp(i,(Timestamp) item);

                } else {
                    System.out.println("throw error please");
                }
                i ++;
            }

        return stmt;
    }

    public Integer createRow(String sql, List<Object> bindParameters) {

        Integer result = null;
        try {
            var stmt = prepareAndBind(sql,bindParameters);
            result = stmt.executeUpdate();
        } catch (SQLException e) {

        }
        return result;
    }

    public <T extends Object> List<T> readMultiRows(String sql, List<Integer> bindParameters, Class clazz) {



        return null;
    }

    public <T extends Object> T readOneRow(String sql,List<Object> bindParamaters, Class<T> clazz) {

        T returnObj = null;


        ResultSet result = null;
        try {
            var stmt = prepareAndBind(sql,bindParamaters);
            result = stmt.executeQuery();

            if (result.next()) {


                try {
                    returnObj = clazz.getConstructor().newInstance();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }



                for (Field field : clazz.getFields()) {
                    if (hasColumn(result,field.getName())) {
                        var obj = result.getObject(field.getName(), field.getType());
                        var i = obj;
                        try {
                            field.set(returnObj,obj);
                        }catch (IllegalAccessException e) {

                        }
                    }



                }

            }

        } catch(SQLException e) {

        }


        return returnObj;
    }

    private  boolean hasColumn(ResultSet rs, String columnName) throws SQLException {
        ResultSetMetaData rsmd = rs.getMetaData();
        int columns = rsmd.getColumnCount();
        for (int x = 1; x <= columns; x++) {
            if (columnName.equals(rsmd.getColumnName(x))) {
                return true;
            }
        }
        return false;
    }


    public Integer updateRow(String sql, List<String> bindParameters) {

        return null;
    }

    public Integer deleteRows(String sql, List<String> bindParameters) {
        return null;
    }
}
