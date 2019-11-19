package DAO;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DatabaseConnection {
    public DataSource databaseConnection;

    public DatabaseConnection() {
        try{
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            this.databaseConnection = (DataSource) envContext.lookup("jdbc/cs472-201911-project-rentandrest-db");
        }catch (NamingException e){
            System.out.println(e);
        }
    }
}
