package view;

import model.Estado;


import javax.swing.*;
import java.awt.*;

import model.Utilizador;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import java.util.Properties;


public class InserirEquipamentoView extends JFrame {

    private final JTextField txtNome;
    private final JComboBox<Estado> comboEstado;
    private final JTextField txtSala;
//    private final JComboBox<Utilizador> cbResponsavel;
    private final JButton btnInserir;
    private final JButton btnVoltar;
    private final JTextField numeroSerie;
    private final JDatePickerImpl dataAquisicao;

    public InserirEquipamentoView(Utilizador utilizador) {
        setTitle("Inserir Equipamento");
        setSize(450, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel painel = new JPanel(new GridLayout(8, 2, 12, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        painel.add(new JLabel("Utilizador: " + utilizador.getUtilizador()));
        painel.add(new JLabel("Perfil: " + utilizador.getPerfil_id()));


        painel.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        painel.add(txtNome);

        painel.add(new JLabel("Estado:"));
        comboEstado = new JComboBox<>();
        painel.add(comboEstado);

        painel.add(new JLabel("Sala:"));
        txtSala = new JTextField();
        painel.add(txtSala);

//        painel.add(new JLabel("Responsável:"));
//        cbResponsavel = new JComboBox<>();
//        painel.add(cbResponsavel);

        painel.add(new JLabel("Número de Série:"));
        numeroSerie = new JTextField(20);
        painel.add(numeroSerie);

        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Hoje");
        p.put("text.month", "Mês");
        p.put("text.year", "Ano");

        painel.add(new JLabel("Data de Aquisição:"));
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        dataAquisicao = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        painel.add(dataAquisicao);


        btnVoltar = new JButton("Voltar");
        btnInserir = new JButton("Inserir");
        painel.add(btnVoltar);
        painel.add(btnInserir);

        add(painel);
    }

    // Getters
    public JTextField getTxtNome() {
        return txtNome;
    }

    public JComboBox<Estado> getComboEstado() {
        return comboEstado;
    }

    public JTextField getTxtSala() {
        return txtSala;
    }
    public JTextField getNumeroSerie() {
        return numeroSerie;
    }

    public JDatePickerImpl getDataAquisicao() {
        return dataAquisicao;
    }

//    public JComboBox<Utilizador> getCbResponsavel() {
//        return cbResponsavel;
//    }


    public JButton getBtnInserir() {
        return btnInserir;
    }

    public JButton getBtnVoltar() {
        return btnVoltar;
    }

}
