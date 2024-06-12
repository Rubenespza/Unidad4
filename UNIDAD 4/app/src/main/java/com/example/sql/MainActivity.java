package com.example.sql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {
Connection connect;
String ConnectionResults="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("hola");
    }
    public void GetTextFromSql(View v){
        TextView tx1= (TextView) findViewById(R.id.txt1);
        TextView tx2= (TextView) findViewById(R.id.txt2);
        EditText ed1= (EditText) findViewById(R.id.editTextText2);
        EditText ed2= (EditText) findViewById(R.id.editTextText3);

        try{
          ConnectionHelper connectionHelper =new ConnectionHelper();
          connect = connectionHelper.connectionclass();
          if(connect!=null){
              String query = "select *from carrera";
              Statement st= connect.createStatement();
              ResultSet rs= st.executeQuery(query);
              while(rs.next()) {
                  tx1.setText(rs.getString(2));
                  tx2.setText(rs.getString(3));
                  Toast.makeText(this, "Consulta realizada correctamente", Toast.LENGTH_SHORT).show();

              }

          }
          else{
              ConnectionResults="check connection";
          }

        }
        catch(Exception ex){

        }

    }
    public void insertsql(View v) {
        System.out.println("sex");
        EditText ed1 = (EditText) findViewById(R.id.editTextText2);
        EditText ed2 = (EditText) findViewById(R.id.editTextText3);

        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionclass();
            if (connect != null) {
                String nombre = ed1.getText().toString(); // Obtener el texto del EditText
                String duracion = ed2.getText().toString(); // Obtener el texto del EditText
                String query = "INSERT INTO carrera (nombre, duracion) VALUES ('" + nombre + "', '" + duracion + "')";
                Statement st = connect.createStatement();
                int rowsAffected = st.executeUpdate(query); // Ejecutar la consulta de inserción
                if (rowsAffected > 0) {
                    System.out.println("Inserción exitosa");
                } else {
                    System.out.println("No se pudo insertar");
                }
                Toast.makeText(this, "Carrera ingresado correctamente", Toast.LENGTH_SHORT).show();

            } else {
                ConnectionResults = "check connection";
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

}