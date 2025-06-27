package dao;

import model.Utilizador;
import util.ConexaoBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Classe DAO responsável por aceder à tabela 'utilizador' na base de dados.
 */
public class UtilizadorDAO {

    /**
     * Autentica um utilizador com base nas credenciais fornecidas.
     *
     * @param credenciais Objeto com o nome de utilizador e palavra-chave inseridos no formulário.
     * @return Um objeto Utilizador com os dados completos (incluindo ‘ID’) se autenticado, ou null se falhar.
     */
    public Utilizador autenticar(Utilizador credenciais) {
        String sql = "SELECT * FROM utilizador WHERE utilizador = ? AND palavra_chave = ?";

        try (Connection conn = ConexaoBD.obterLigacao()) {
            assert conn != null;
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {

                // Define os parâmetros da consulta
                stmt.setString(1, credenciais.getUtilizador());
                stmt.setString(2, credenciais.getPalavraChave());

                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    // Se existir um registo válido, devolve objeto Utilizador com ‘ID’
                    Utilizador utilizador = new Utilizador();
                    utilizador.setId(rs.getInt("id"));  // Pega o ID da BD
                    utilizador.setPerfil_id(rs.getInt("perfil_id"));
                    utilizador.setUtilizador(rs.getString("utilizador"));
                    utilizador.setPalavraChave(rs.getString("palavra_chave"));

                    return utilizador;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null; // Autenticação falhou
    }
}
