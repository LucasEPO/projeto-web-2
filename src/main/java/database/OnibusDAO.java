package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.OnibusBean;

public class OnibusDAO {
    private String SELECT_ALL_ONIBUS = "SELECT * FROM Onibus";
    private Connection conn;

    public OnibusDAO() {
        conn = SingletonConnection.getConnection();
    }

    public List<OnibusBean> selectAllOnibus(){
        List<OnibusBean> frota = new ArrayList<>();

        try{
            PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_ONIBUS);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                OnibusBean o = new OnibusBean();
                
                o.setId(rs.getInt("id"));
                o.setModelo(rs.getString("modelo"));
                o.setLinha(rs.getLong("linha_id"));
                o.setTerminal(rs.getString("terminal"));
                o.setCaracteristicas(rs.getString("caracteristicas"));
                o.setLotacaoMax(rs.getInt("lotacao_max"));
                o.setUltimaManutencao(rs.getDate("ultima_manutencao"));
                o.setAtrasos(rs.getInt("atrasos"));

                frota.add(o);
            }
        } catch (SQLException e) {
            SingletonConnection.printSQLException(e);
        }
        
        return frota;
    }


}
