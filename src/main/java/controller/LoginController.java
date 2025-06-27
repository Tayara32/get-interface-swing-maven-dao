package controller;

import dao.UtilizadorDAO;
import model.Utilizador;
import view.LoginView;
import view.InterfaceWidgetsView;

import javax.swing.*;

public class LoginController {

    private final LoginView loginView;

    public LoginController() {
        loginView = new LoginView(this); // Passa referência ao controlador
        loginView.setVisible(true);

        loginView.getBtnEntrar().addActionListener(_ -> {
            Utilizador credenciais = loginView.getDadosLogin();

            if (!credenciais.isLoginValido()) {
                JOptionPane.showMessageDialog(loginView, "Por favor, preencha todos os campos.");
                return;
            }

            UtilizadorDAO dao = new UtilizadorDAO();
            Utilizador utilizadorAutenticado = dao.autenticar(credenciais);

            if (utilizadorAutenticado != null) {
                JOptionPane.showMessageDialog(loginView, "Login bem-sucedido!");
                loginView.dispose();
                new MenuController();
            } else {
                JOptionPane.showMessageDialog(loginView, "Credenciais inválidas.");
            }
        });
    }

    // Método chamado pelo botão adicional para abrir a interface de widgets
    public void abrirInterfaceExemplo() {
        new InterfaceWidgetsView(loginView); // Passa a referência da janela login
        loginView.setVisible(false);         // Esconde temporariamente
    }
}