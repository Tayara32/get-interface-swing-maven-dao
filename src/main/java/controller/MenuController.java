package controller;

import model.Utilizador;
import view.MenuView;

public class MenuController {

    private final MenuView menuView;
    private final Utilizador utilizadorLogado;


    public MenuController(Utilizador utilizadorLogado) {
        this.utilizadorLogado = utilizadorLogado;
        menuView = new MenuView();
        menuView.setVisible(true);

        // Botão "Inserir Equipamento"
        menuView.getBtnInserir().addActionListener(e -> {
            menuView.dispose(); // Fecha o menu atual
            new InserirController(utilizadorLogado); // Abre a janela de inserção (controlador responsável)
        });

        // Botão "Listar Equipamentos"
        menuView.getBtnListar().addActionListener(e -> {
            menuView.dispose(); // Fecha o menu atual
            new ListarController(utilizadorLogado); // Abre a janela de listagem (controlador responsável)
        });

        // Botão "Logout"
        menuView.getBtnLogout().addActionListener(e -> {
            menuView.dispose(); // Fecha o menu atual
            new LoginController(); // Volta ao login
        });
    }
}
