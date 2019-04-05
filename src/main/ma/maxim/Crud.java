package main.ma.maxim;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.List;

import java.lang.reflect.Field;

class DatabaseInfo {
    public static final String URL = "jdbc:mysql://localhost:8889/MI6?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static final String USER = "root";
    public static final String PASSWORD = "root";
}

public class Crud implements ICrud {

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
                    //todo BAD CODE!!!!!
                    stmt.setString(i,null);

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

    public <T extends Object> T readOneRow(String sql, List<Object> bindParameters, Class<T> clazz) {

        // the object to return
        T returnObj = null;

        // the result of the SQL stmt
        ResultSet sqlResult = null;

        try {

            var stmt = prepareAndBind(sql, bindParameters);
            sqlResult = stmt.executeQuery();

            if (sqlResult.next()) {

                try {
                    // create a new instance of the type of clazz
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

                // for every field or attribute in the clazz
                for (Field field : clazz.getFields()) {

                    // check if the sql and the new object have the same attribute
                    if (hasColumn(sqlResult,field.getName())) {
                        // get the object from the sqlResult of the correct type
                        var obj = sqlResult.getObject(field.getName(), field.getType());

                        try {
                            // put the obj attribute inside the clazz.object
                            field.set(returnObj,obj);
                        } catch (IllegalAccessException e) {

                        }
                    }

                }

            }

        } catch(SQLException e) {

        }

        // return the filled in object
        return returnObj;
    }


    public Integer updateRow(String sql, List<String> bindParameters) {

        return null;
    }

    public Integer deleteRows(String sql, List<String> bindParameters) {
        return null;
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
}
