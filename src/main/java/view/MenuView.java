package view;

import model.Utilizador;
import util.IconeUtil;

import javax.swing.*;
import java.awt.*;

public class MenuView extends JFrame {

    private JButton btnInserir;
    private final JButton btnListar;
    private final JButton btnLogout;

    public MenuView(Utilizador utilizador) {
        setTitle("Menu Principal - JavaTech");
        setSize(300, 200);
        IconeUtil.aplicarIcone(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Painel com os botões
        JPanel painel = new JPanel(new GridLayout(0, 1, 10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        painel.setBackground(new Color(100, 169, 220, 255));

        if (utilizador.getPerfil_id() == 1){

            btnInserir = new JButton("Inserir Equipamento");
            painel.add(btnInserir);

        }

        btnListar = new JButton("Listar Equipamentos");
        btnLogout = new JButton("Logout");

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
