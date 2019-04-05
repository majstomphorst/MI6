package main.ma.maxim;

import java.util.List;

public interface ICrud {

    /**
     * Insert a row of values into from the database
     *
     * @param sql String the SQL string with for example '?' for parameters
     * @param bindParameters List<String>>  List ( '0' => '1' );
     * @return int the inserted id or 0 if failed
     *
     */
    Integer createRow(String sql, List<Object> bindParameters);


    /**
     * Read an array of objects from the database
     *
     * @param sql the SQL string with for example '?' for parameters
     * @param bindParameters List<String>>  List ( '0' => '1' );
     * @return List<Object> or an empty list
     *
     */
    <T extends Object> List<T> readMultiRows(String sql, List<Object> bindParameters, Class<T> clazz);


    /**
     * Read one objects from the database
     *
     * @param sql the SQL string with for example '?' for parameters
     * @param bindParameters List<String>>  List ( '0' => '1' );
     * @return Object otherwise null
     *
     */
    <T extends Object> T readOneRow(String sql,List<Object> bindParameters, Class<T> clazz);
    /**
     * Update values into from the database
     *
     * @param sql the SQL string with for example '?' for parameters
     * @param bindParameters List<String>>  List ( '0' => '1' );
     * @return int number of updated rows or 0 if failed
     *
     */
    Integer updateRow(String sql, List<String> bindParameters);

    /**
     * Removes rows from the database
     *
     * @param sql the SQL string with for example '?' for parameters
     * @param bindParameters List<String>>  List ( '0' => '1' );
     * @return int number of deleted rows or 0 if failed
     *
     */
    Integer deleteRows(String sql, List<String> bindParameters);
}
