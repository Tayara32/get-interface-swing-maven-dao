package dao;

import model.Estado;
import model.Perfil;
import util.ConexaoBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PerfilDAO {

    public List<Perfil> listarPerfis() {
        List<Perfil> lista = new ArrayList<>();

        String sql = """
            SELECT est.id AS perfil_id, est.descricao AS perfil_desc
            FROM perfil est
        """;

        try (Connection conn = ConexaoBD.obterLigacao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                int perfil_id = rs.getInt("perfil_id");
                String perfil_desc = rs.getString("perfil_desc");
                Perfil perfil = new Perfil(perfil_id, perfil_desc);

                lista.add(perfil);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

}
