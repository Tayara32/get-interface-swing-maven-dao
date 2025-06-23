package controller;

import view.ListarEquipamentosView;

/**
 * Controlador responsável por gerir a janela de listagem de equipamentos.
 */
public class ListarController {

    private final ListarEquipamentosView listarView;

    public ListarController() {
        listarView = new ListarEquipamentosView();
        listarView.setVisible(true);

        //Logica de listagem aqui

        // Ação do botão "Voltar" → fecha esta janela e abre novamente o Menu
        listarView.adicionarAcaoVoltar(e -> {
            listarView.dispose();        // Fecha a janela atual de listagem
            new MenuController();        // Volta ao menu principal
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
}