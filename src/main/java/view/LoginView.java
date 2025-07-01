package view;

import model.Utilizador;
import controller.LoginController;
import util.IconeUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginView extends JFrame {

    private final JTextField txtUtilizador;
    private final JPasswordField txtPalavraChave;
    private final JButton btnEntrar;

    public LoginView(LoginController controller) {
        setTitle("Login - JavaTech");
        setSize(350, 270);
        IconeUtil.aplicarIcone(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel titulo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel tituloLabel = new JLabel("JavaTech Equipamentos");
        tituloLabel.setFont(new Font(tituloLabel.getFont().getFontName(), Font.BOLD, 18));
        titulo.add(tituloLabel);
        titulo.setBackground(new Color(100, 169, 220, 255));
        tituloLabel.setForeground(new Color(255,100,50));



        JPanel painel = new JPanel(new GridLayout(4,2, 10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
        painel.setOpaque(false); // torna o painel transparente para mostrar o fundo do painel principal



        painel.add(new JLabel("Utilizador (Email):"));
        txtUtilizador = new JTextField();
        painel.add(txtUtilizador);

        painel.add(new JLabel("Palavra-chave:"));
        txtPalavraChave = new JPasswordField();
        painel.add(txtPalavraChave);

        painel.add(new JLabel(""));
        btnEntrar = new JButton("Entrar");
        painel.add(btnEntrar);

//        Caso seja preciso utilizar calendário e aceder outro tipo de interface
//        //painel.add(new JLabel(""));
//        JButton botaoAbrirInterface = new JButton("Abrir Interface Swing");
//        botaoAbrirInterface.addActionListener((ActionEvent e) -> {
//            controller.abrirInterfaceExemplo();
//        });
//        painel.add(botaoAbrirInterface);
//
//        JButton btnCalendario = new JButton("Calendário");
//        btnCalendario.addActionListener(e -> {
//            new CalendarioView();
//        });
//        painel.add(btnCalendario);

        JPanel painelPrincipal = new JPanel(new BorderLayout());
        painelPrincipal.add(titulo, BorderLayout.NORTH);
        painelPrincipal.add(painel, BorderLayout.CENTER);
        painelPrincipal.setBackground(new Color(100, 169, 220, 255));

        setContentPane(painelPrincipal);
    }

    public Utilizador getDadosLogin() {
        return new Utilizador(txtUtilizador.getText(), new String(txtPalavraChave.getPassword()));
    }

    public JButton getBtnEntrar() {
        return btnEntrar;
    }
}
