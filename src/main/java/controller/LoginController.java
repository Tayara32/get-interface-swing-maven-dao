package controller;

import dao.UtilizadorDAO;
import model.Utilizador;
import view.LoginView;

import javax.swing.*;

public class LoginController {

    private final LoginView loginView;

    public LoginController() {
        loginView = new LoginView();
        loginView.setVisible(true);

        loginView.getBtnEntrar().addActionListener(_ -> {
            Utilizador credenciais = loginView.getDadosLogin();

            // Verifica se os campos estão preenchidos
            if (!credenciais.isLoginValido()) {
                JOptionPane.showMessageDialog(loginView, "Por favor, preencha todos os campos.");
                return;
            }

            // Autenticação através do DAO
            UtilizadorDAO dao = new UtilizadorDAO();
            Utilizador utilizadorAutenticado = dao.autenticar(credenciais);

            if (utilizadorAutenticado != null) {
                JOptionPane.showMessageDialog(loginView, "Login bem-sucedido!");
                loginView.dispose();
                new MenuController(); // Entrar no menu principal
            } else {
                JOptionPane.showMessageDialog(loginView, "Credenciais inválidas.");
            }
        });
    }
}




