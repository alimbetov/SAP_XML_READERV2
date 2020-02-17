/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

public interface ETL_DAO {
    public static final String DB_URL = "jdbc:postgresql://192.168.196.198:5432/dwh_pg";
            /*"jdbc:oracle:thin:@"+" (DESCRIPTION =\n" +
                    "    (ADDRESS_LIST =\n" +
                    "      (ADDRESS = (PROTOCOL = TCP)(Host = dm01-scan.kcell.kz)(Port = 1521))\n" +
                    "    )\n" +
                    "    (CONNECT_DATA =\n" +
                    "      (SERVICE_NAME = acrm)\n" +
                    "    )\n" +
                    "  )";
    */

    /*public static final String DRIVER ="oracle.jdbc.driver.OracleDriver";*/
    public static final String DRIVER ="org.postgresql.Driver";
    public static final String USER = "tester";
    public static final String PASS = "TESTER";


}

