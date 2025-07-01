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

/**
 * DAO responsável por aceder à tabela de Equipamentos na base de dados.
 */
public class EquipamentoDAO {

    /**
     * Insere um novo equipamento na base de dados.
     */
    public boolean inserirEquipamento(Equipamento equipamento) {
        String sql = "INSERT INTO equipamento (nome, estado_id, sala, numero_serie, data_aquisicao) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoBD.obterLigacao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, equipamento.getNome());
            stmt.setInt(2, equipamento.getEstado().getId());
            stmt.setString(3, equipamento.getSala());
//            stmt.setInt(4, equipamento.getResponsavel().getId());
            stmt.setString(4, equipamento.getNumeroSerie());
            stmt.setDate(5, java.sql.Date.valueOf(equipamento.getDataAquisicao()));

            stmt.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Lista todos os equipamentos da base de dados.
     */
    public List<Equipamento> listarEquipamentos() {
        List<Equipamento> lista = new ArrayList<>();

        String sql = """
          SELECT e.nome, e.sala, e.numero_serie, e.data_aquisicao,
                   est.id AS estado_id, est.descricao AS estado_desc
            FROM equipamento e
            INNER JOIN estado est ON e.estado_id = est.id
        """;

        try (Connection conn = ConexaoBD.obterLigacao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Equipamento equipamento = new Equipamento();
                equipamento.setNome(rs.getString("nome"));
                equipamento.setSala(rs.getString("sala"));
                equipamento.setNumeroSerie(rs.getString("numero_serie"));
                equipamento.setDataAquisicao(rs.getDate("data_aquisicao").toLocalDate());

                Estado estado = new Estado();
                estado.setId(rs.getInt("estado_id"));
                estado.setDescricao(rs.getString("estado_desc"));
                equipamento.setEstado(estado);

//                Utilizador utilizador = new Utilizador();
//                utilizador.setUtilizador(rs.getString("user_nome")); // Nome do responsável
//                utilizador.setId(rs.getInt("user_id"));              // ‘ID’ do responsável
//                equipamento.setResponsavel(utilizador);

                lista.add(equipamento);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
