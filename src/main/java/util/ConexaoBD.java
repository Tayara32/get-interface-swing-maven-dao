package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoBD {

    public static Connection obterLigacao() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/database", "root", "pass");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}