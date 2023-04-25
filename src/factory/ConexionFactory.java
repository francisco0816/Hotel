package factory;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConexionFactory {

    private final DataSource dataSource;
    

    public ConexionFactory() {

        var comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/hotel_alura"+ "?useTimezone=true&serverTimezone=UTC");
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("skafj1608");
        comboPooledDataSource.setMaxPoolSize(10);

        this.dataSource = comboPooledDataSource;
    }

    public Connection getConexion() {
        try {
            return this.dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
