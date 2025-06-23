package controller;


import view.InserirEquipamentoView;

public class InserirController {

    private final InserirEquipamentoView inserirView;

    public InserirController() {
        inserirView = new InserirEquipamentoView();
        inserirView.setVisible(true);
        inserirView.adicionarAcaoVoltar(e -> {
            inserirView.dispose();         // Fecha a janela atual
            new MenuController();          // Abre novamente o Menu
        });

        inserirView.adicionarAcaoInserir(e -> {
            System.out.println("Inserção ainda não implementada.");
            // Futuro: lógica de DAO
        });
    }
}
