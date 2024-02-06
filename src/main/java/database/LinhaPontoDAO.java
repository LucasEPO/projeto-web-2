package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.LinhaPontoBean;

public class LinhaPontoDAO {
    private String SELECT_LINHA_PONTO = "SELECT * "
            + "FROM Linha_Ponto LP "
            + "JOIN Linha L ON LP.linha_id = L.id "
            + "WHERE ponto_id = (?) ORDER BY horario_chegada";

    private String UPDATE_HORARIO = "UPDATE Linha_Ponto "
            + "SET horario_chegada = (?) "
            + "WHERE linha_id = (?) AND ponto_id = (?)";
    private Connection conn;

    public LinhaPontoDAO() {
        conn = SingletonConnection.getConnection();
    }

    public List<LinhaPontoBean> selectLinhaPonto(Long ponto) {
        List<LinhaPontoBean> linhas = new ArrayList<>();

        try {
            PreparedStatement pstmt = conn.prepareStatement(SELECT_LINHA_PONTO);
            pstmt.setLong(1, ponto);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                LinhaPontoBean lp = new LinhaPontoBean();

                lp.setLinha_id(rs.getLong("linha_id"));
                lp.setPonto_id(rs.getLong("ponto_id"));
                lp.setHorario_chegada(rs.getString("horario_chegada"));
                lp.setNome_linha(rs.getString("nome"));

                linhas.add(lp);
            }
            
        } catch (SQLException e) {
            SingletonConnection.printSQLException(e);

        }

        return linhas;
    }

    public void updateHorario(String novo_horario_chegada, Long linha_id, Long ponto_id) {
        try {
            PreparedStatement pstmt = conn.prepareStatement(UPDATE_HORARIO);
            pstmt.setString(1, novo_horario_chegada);
            pstmt.setLong(2, linha_id);
            pstmt.setLong(3, ponto_id);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            SingletonConnection.printSQLException(e);

        }
    }

}
