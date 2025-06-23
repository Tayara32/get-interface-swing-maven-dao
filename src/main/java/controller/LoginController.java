package controller;


import model.Utilizador;
import view.LoginView;

import javax.swing.JOptionPane;

/**
 * Controlador do processo de autenticação.
 */
public class LoginController {

    private final LoginView loginView;

    public LoginController() {
        loginView = new LoginView();
        loginView.setVisible(true);

        loginView.getBtnEntrar().addActionListener(e -> {
            Utilizador utilizador = new Utilizador();
            utilizador.setUtilizador(loginView.getUtilizador());
            utilizador.setPalavraChave(loginView.getPalavraChave());

            if (utilizador.isLoginValido()) {
                System.out.println("Login aceite: " + utilizador.getUtilizador());
                loginView.dispose();
                new MenuController();
            } else {
                JOptionPane.showMessageDialog(loginView,
                        "Credenciais inválidas.",
                        "Erro de Autenticação",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}



