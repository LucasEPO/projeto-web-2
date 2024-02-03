package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Onibus;

public class OnibusDAO {
    private static final String URL = "jdbc:mysql://sql.freedb.tech:3306/freedb_DW_projFinal";
    private static final String USER = "freedb_group_user";
    private static final String PASS = "JRqTyb!Nm*9s2$$";

    private String SELECT_ALL_ONIBUS = "SELECT * FROM Onibus";

    protected Connection getConnection() {
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return conn;
    }

    private void printSQLException(SQLException ex) {
        for(Throwable e : ex) {
            if(e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());

                Throwable t = ex.getCause();
                while(t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    public List<Onibus> selectAllOnibus(){
        System.out.println("3");
        List<Onibus> frota = new ArrayList<>();

        try{
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_ONIBUS);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                Onibus o = new Onibus();
                
                o.setId(rs.getInt("id"));
                o.setModelo(rs.getString("modelo"));
                o.setLinha(rs.getString("linha"));
                o.setTerminal(rs.getString("terminal"));
                o.setCaracteristicas(rs.getString("caracteristicas"));
                o.setLotacaoMax(rs.getInt("lotacao_max"));
                o.setUltimaManutencao(rs.getDate("ultima_manutencao"));
                o.setAtrasos(rs.getInt("atrasos"));
                o.setItinerario(rs.getString("itinerario"));

                frota.add(o);
                System.out.println("4");
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        
        System.out.println("5-" + frota);
        return frota;
    }


}
