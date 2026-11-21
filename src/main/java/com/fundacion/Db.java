package com.fundacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Db {
    public static void probar() {
        String url = "jdbc:sqlite:auditoria.db";
        try (Connection c = DriverManager.getConnection(url);
             Statement s = c.createStatement()) {
            s.execute("CREATE TABLE IF NOT EXISTS equipo ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT NOT NULL)");
            s.execute("INSERT INTO equipo (nombre) VALUES ('Equipo de prueba')");
            try (ResultSet rs = s.executeQuery("SELECT id, nombre FROM equipo ORDER BY id DESC LIMIT 1")) {
                if (rs.next()) {
                    System.out.println("SQLite OK -> id=" + rs.getInt("id") + ", nombre=" + rs.getString("nombre"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}