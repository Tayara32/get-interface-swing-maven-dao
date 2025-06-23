package view;

import dao.EstadoDAO;
import model.Estado;
import model.Utilizador;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class InserirEquipamentoView extends JFrame {

    private final JTextField txtNome;
    private final JComboBox<Estado> cbEstado;
    private final JTextField txtSala;
    private final JComboBox<Utilizador> cbResponsavel;
    private final JButton btnInserir;
    private final JButton btnVoltar;
    private final JTextField numeroSerie;
    private final JTextField dataAquisicao;

    public InserirEquipamentoView() {
        setTitle("Inserir Equipamento");
        setSize(400, 350);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel painel = new JPanel(new GridLayout(7, 2, 10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        painel.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        painel.add(txtNome);

        painel.add(new JLabel("Estado:"));
        cbEstado = new JComboBox<>();
        painel.add(cbEstado);

        painel.add(new JLabel("Sala:"));
        txtSala = new JTextField();
        painel.add(txtSala);

        painel.add(new JLabel("Responsável:"));
        cbResponsavel = new JComboBox<>();
        painel.add(cbResponsavel);

        painel.add(new JLabel("Número de Série:"));
        numeroSerie = new JTextField(20);
        painel.add(numeroSerie);

        painel.add(new JLabel("Data de Aquisição:"));
        dataAquisicao = new JTextField(20);
        painel.add(dataAquisicao);

        btnVoltar = new JButton("Voltar");
        btnInserir = new JButton("Inserir");
        painel.add(btnVoltar);
        painel.add(btnInserir);

        setContentPane(painel);
    }

    // Getters
    public JTextField getTxtNome() {
        return txtNome;
    }

    public JComboBox<Estado> getCbEstado() {
        return cbEstado;
    }

    public JTextField getTxtSala() {
        return txtSala;
    }

    public JComboBox<Utilizador> getCbResponsavel() {
        return cbResponsavel;
    }

    public void adicionarAcaoInserir(ActionListener listener) {
        btnInserir.addActionListener(listener);
    }

    public void adicionarAcaoVoltar(ActionListener listener) {
        btnVoltar.addActionListener(listener);
    }
}
