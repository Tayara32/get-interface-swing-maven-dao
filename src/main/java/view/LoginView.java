package view;

import model.Utilizador;
import controller.LoginController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginView extends JFrame {

    private final JTextField txtUtilizador;
    private final JPasswordField txtPalavraChave;
    private final JButton btnEntrar;

    public LoginView(LoginController controller) {
        setTitle("Login - GET");
        setSize(350, 270);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel painel = new JPanel(new GridLayout(4, 2, 10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        painel.add(new JLabel("Utilizador (Email):"));
        txtUtilizador = new JTextField();
        painel.add(txtUtilizador);

        painel.add(new JLabel("Palavra-chave:"));
        txtPalavraChave = new JPasswordField();
        painel.add(txtPalavraChave);

        painel.add(new JLabel(""));
        btnEntrar = new JButton("Entrar");
        painel.add(btnEntrar);

        painel.add(new JLabel(""));
        JButton botaoAbrirInterface = new JButton("Abrir Interface Swing");
        botaoAbrirInterface.addActionListener((ActionEvent e) -> {
            controller.abrirInterfaceExemplo();
        });
        painel.add(botaoAbrirInterface);

        setContentPane(painel);
    }

    public Utilizador getDadosLogin() {
        return new Utilizador(txtUtilizador.getText(), new String(txtPalavraChave.getPassword()));
    }

    public JButton getBtnEntrar() {
        return btnEntrar;
    }
}
