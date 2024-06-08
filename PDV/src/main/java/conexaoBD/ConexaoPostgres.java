package conexaoBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vsemp
 */
public class ConexaoPostgres {

    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/PDV";
    private static final String USER = "postgres";
    private static final String PASSWORD = "2704";

    //abrir conexão com o BD
    public static Connection getConection() {

        try {
            Class.forName(DRIVER);

            return DriverManager
                    .getConnection(URL,
                            USER,
                            PASSWORD);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexaoPostgres.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoPostgres.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(
                        ConexaoPostgres.class.getName())
                        .log(Level.SEVERE,
                                null,
                                ex);
            }
        }
    }

    public static void closeTransaction(Connection conn,
            PreparedStatement ps) {

        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(
                        ConexaoPostgres.class.getName())
                        .log(Level.SEVERE,
                                null,
                                ex);
            }
        }
        closeConnection(conn);
    }

}
