package kz.alex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class Main {
    public static void main(String args[]) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres",
                            "postgres", "111");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");




        try {

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM ne_tr;");
            while ( rs.next() ) {
                int id = rs.getInt("id");
                String  n = rs.getString("n");
                int e  = rs.getInt("e");
                String  t = rs.getString("t");
                int r = rs.getInt("r");
                System.out.println( "ID = " + id );
                System.out.println( "n = " + n );
                System.out.println( "e = " + e );
                System.out.println( "t = " + t );
                System.out.println( "r = " + r );
                System.out.println();
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");






    }
}



