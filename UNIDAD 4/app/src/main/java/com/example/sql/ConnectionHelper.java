package com.example.sql;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionHelper {
    Connection con;
    String username, pass, ip, port, database;
@SuppressLint("NewApi")
    public Connection connectionclass() {
        ip = "192.168.1.7";
        database = "Uni";
        username = "sa";
        pass = "123";
        port = "1433";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        java.sql.Connection connection = null;
        String ConnectionUrl = null;

        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            ConnectionUrl = "jdbc:jtds:sqlserver://" + ip + ":" + port + ";" + "databasename=" + database + ";user=" + username + ";password=" + pass + ";";
            connection = DriverManager.getConnection(ConnectionUrl);
        } catch (Exception Ex) {
            Log.e("Error", Ex.getMessage());
        }
        return connection;
    }
}
