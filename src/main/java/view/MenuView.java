package view;

import javax.swing.*;
import java.awt.*;

public class MenuView extends JFrame {

    private final JButton btnInserir;
    private final JButton btnListar;
    private final JButton btnLogout;

    public MenuView() {
        setTitle("Menu Principal - GET");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Painel com os botões
        JPanel painel = new JPanel(new GridLayout(3, 1, 10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        btnInserir = new JButton("Inserir Equipamento");
        btnListar = new JButton("Listar Equipamentos");
        btnLogout = new JButton("Logout");

        painel.add(btnInserir);
        painel.add(btnListar);
        painel.add(btnLogout);

        setContentPane(painel);
    }

    public JButton getBtnInserir() {
        return btnInserir;
    }

    public JButton getBtnListar() {
        return btnListar;
    }

    public JButton getBtnLogout() {
        return btnLogout;
    }
}
