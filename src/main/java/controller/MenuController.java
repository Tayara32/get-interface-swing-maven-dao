package controller;

import view.MenuView;

public class MenuController {

    private final MenuView menuView;


    public MenuController() {
        menuView = new MenuView();
        menuView.setVisible(true);

        // Botão "Inserir Equipamento"
        menuView.getBtnInserir().addActionListener(e -> {
            menuView.dispose(); // Fecha o menu atual
            new InserirController(); // Abre a janela de inserção (controlador responsável)
        });

        // Botão "Listar Equipamentos"
        menuView.getBtnListar().addActionListener(e -> {
            menuView.dispose(); // Fecha o menu atual
            new ListarController(); // Abre a janela de listagem (controlador responsável)
        });

        // Botão "Logout"
        menuView.getBtnLogout().addActionListener(e -> {
            menuView.dispose(); // Fecha o menu atual
            new LoginController(); // Volta ao login
        });
    }
}
