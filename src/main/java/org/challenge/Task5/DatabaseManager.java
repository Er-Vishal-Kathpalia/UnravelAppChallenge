package org.challenge.Task5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component
public class DatabaseManager {

    @Autowired
    private DataSource dataSource;

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public void closeConnection( Connection connection ) {
        try {
            if ( connection != null && !connection.isClosed() ) {
                connection.close(); // return to pool
            }
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
    }
}
