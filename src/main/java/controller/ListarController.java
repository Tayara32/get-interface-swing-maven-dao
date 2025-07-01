package controller;

import dao.EquipamentoDAO;
import model.Equipamento;
import model.Utilizador;
import util.ConexaoBD;
import view.ListarEquipamentosView;

import javax.swing.table.DefaultTableModel;
import java.util.List;

/**
 * Controlador responsável por gerir a janela de listagem de equipamentos.
 */
public class ListarController {

    private final ListarEquipamentosView listarView;
    private int idResponsavel;
    private Utilizador utilizador;

    public ListarController(Utilizador utilizador) {
        this.utilizador = utilizador;
        listarView = new ListarEquipamentosView();
        listarView.setVisible(true);


        //Logica de listagem aqui



        if (ConexaoBD.obterLigacao() == null) {
            listarView.mostrarMensagem("Erro na ligação à base de dados.");
            return;
        }

        carregarEquipamentos();

        // Ação do botão "Voltar" → fecha esta janela e abre novamente o Menu
        listarView.adicionarAcaoVoltar(e -> {
            listarView.dispose();        // Fecha a janela atual de listagem
            new MenuController(utilizador);        // Volta ao menu principal
        });

        // Ação do botão "Editar" (por implementar)
        listarView.adicionarAcaoEditar(e ->
                System.out.println("Editar ainda não implementado."));

        // Ação do botão "Remover" (por implementar)
        listarView.adicionarAcaoRemover(e ->
                System.out.println("Remover ainda não implementado."));

        // Ação do botão "Filtrar" (por implementar)
        listarView.adicionarAcaoFiltrar(e ->
                System.out.println("Filtrar ainda não implementado."));
    }

    private void carregarEquipamentos() {
        try {
            EquipamentoDAO dao = new EquipamentoDAO(); // Sem conn
            List<Equipamento> lista = dao.listarEquipamentos();

            DefaultTableModel modelo = (DefaultTableModel) listarView.getTabela().getModel();
            modelo.setRowCount(0);

            for (Equipamento eq : lista) {
                modelo.addRow(new Object[]{
                        eq.getNome(),
                        eq.getEstado().getDescricao(),
                        eq.getNumeroSerie(),
                        eq.getDataAquisicao(),
                        eq.getSala()
//                        eq.getResponsavel().getUtilizador(),

                });
            }

        } catch (Exception ex) {
            listarView.mostrarMensagem("Erro ao carregar dados: " + ex.getMessage());
        }
    }
}