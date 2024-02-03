package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.LinhaBean;

public class LinhaDAO {
    private String SELECT_ALL_LINHA = "SELECT * FROM Linha";
    private Connection conn;

    public LinhaDAO() {
        conn = SingletonConnection.getConnection();
    }

    public List<LinhaBean> selectAllLinhas() {
        List<LinhaBean> linhas = new ArrayList<>();

        try {
            PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_LINHA);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                LinhaBean l = new LinhaBean();

                l.setId(rs.getLong("id"));
                l.setNome(rs.getString("nome"));
                l.setRegiao(rs.getString("regiao"));

                linhas.add(l);
            }
        } catch (SQLException e) {
            SingletonConnection.printSQLException(e);
        }

        return linhas;
    }

}