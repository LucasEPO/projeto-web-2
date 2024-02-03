package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.PontoBean;

public class PontoDAO {
    private String SELECT_ALL_PONTO = "SELECT * FROM Ponto";
    private Connection conn;

    public PontoDAO() {
        conn = SingletonConnection.getConnection();
    }

    public List<PontoBean> selectAllPontos(){
        List<PontoBean> pontos = new ArrayList<>();

        try{
            PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_PONTO);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                PontoBean p = new PontoBean();
                
                p.setId(rs.getLong("id"));
                p.setNome(rs.getString("nome"));

                pontos.add(p);
            }
        } catch (SQLException e) {
            SingletonConnection.printSQLException(e);
        }
        
        return pontos;
    }

}
