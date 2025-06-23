package dao;

import model.Equipamento;
import model.Estado;
import model.Utilizador;
import util.ConexaoBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstadoDAO {

    public List<Estado> listarEstados() {
        List<Estado> lista = new ArrayList<>();

        String sql = """
            SELECT est.id AS estado_id, est.descricao AS estado_desc
            FROM estado est
        """;

        try (Connection conn = ConexaoBD.obterLigacao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Estado estado = new Estado();
                estado.setId(rs.getInt("estado_id"));
                estado.setDescricao(rs.getString("estado_desc"));

                lista.add(estado);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

}

