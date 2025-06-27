package view;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class InterfaceWidgetsView {

    private final LoginView loginView;

    public InterfaceWidgetsView(LoginView loginView) {
        this.loginView = loginView;
        criarJanela();
    }

    public void criarJanela() {
        JFrame frame = new JFrame("Interface de Exemplo - Componentes Visuais");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 800);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // layout vertical

        Font fontePadrao = new Font("SansSerif", Font.PLAIN, 14);

        // ✅ Etiqueta
        JLabel label = new JLabel("Etiqueta:");
        label.setFont(fontePadrao);
        panel.add(label);
        panel.add(Box.createVerticalStrut(8)); // espaço

        // ✅ Campo de texto
        JTextField textField = new JTextField("Campo de texto");
        textField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        textField.setFont(fontePadrao);
        panel.add(textField);
        panel.add(Box.createVerticalStrut(8));

        // ✅ Campo de password
        JPasswordField passwordField = new JPasswordField("senha123");
        passwordField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        passwordField.setFont(fontePadrao);
        panel.add(passwordField);
        panel.add(Box.createVerticalStrut(8));

        // ✅ Área de texto
        JTextArea textArea = new JTextArea("Área de texto...");
        textArea.setFont(fontePadrao);
        textArea.setRows(4);
        JScrollPane scrollArea = new JScrollPane(textArea);
        scrollArea.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));
        panel.add(scrollArea);
        panel.add(Box.createVerticalStrut(8));

        // ✅ Checkbox
        JCheckBox checkBox = new JCheckBox("Concordo com os termos");
        checkBox.setFont(fontePadrao);
        panel.add(checkBox);
        panel.add(Box.createVerticalStrut(8));

        // ✅ Radio buttons
        JRadioButton opcao1 = new JRadioButton("Opção A");
        JRadioButton opcao2 = new JRadioButton("Opção B");
        opcao1.setFont(fontePadrao);
        opcao2.setFont(fontePadrao);
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(opcao1);
        grupo.add(opcao2);
        panel.add(opcao1);
        panel.add(opcao2);
        panel.add(Box.createVerticalStrut(8));

        // ✅ Combobox
        JComboBox<String> comboBox = new JComboBox<>(new String[]{"Item 1", "Item 2", "Item 3"});
        comboBox.setFont(fontePadrao);
        comboBox.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        panel.add(comboBox);
        panel.add(Box.createVerticalStrut(8));

        // ✅ Lista
        JList<String> lista = new JList<>(new String[]{"Linha 1", "Linha 2", "Linha 3"});
        lista.setFont(fontePadrao);
        lista.setVisibleRowCount(3);
        JScrollPane scrollLista = new JScrollPane(lista);
        scrollLista.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80));
        panel.add(scrollLista);
        panel.add(Box.createVerticalStrut(8));

        // ✅ Botão Submeter
        JButton botaoSubmeter = new JButton("Submeter");
        botaoSubmeter.setFont(fontePadrao);
        botaoSubmeter.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        panel.add(botaoSubmeter);
        panel.add(Box.createVerticalStrut(8));

        // ✅ Slider
        JSlider slider = new JSlider();
        slider.setFont(fontePadrao);
        slider.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        panel.add(slider);
        panel.add(Box.createVerticalStrut(8));

        // ✅ Barra de progresso
        JProgressBar progressBar = new JProgressBar();
        progressBar.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        panel.add(progressBar);
        panel.add(Box.createVerticalStrut(8));

        // ✅ Spinner
        JSpinner spinner = new JSpinner();
        spinner.setFont(fontePadrao);
        spinner.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        panel.add(spinner);
        panel.add(Box.createVerticalStrut(8));

        // ✅ Abas
        JTabbedPane abas = new JTabbedPane();
        abas.setFont(fontePadrao);
        abas.addTab("Aba 1", new JLabel("Conteúdo da Aba 1"));
        abas.addTab("Aba 2", new JLabel("Conteúdo da Aba 2"));
        panel.add(abas);
        panel.add(Box.createVerticalStrut(8));

        // ✅ Texto extra com scroll
        JTextArea textoScroll = new JTextArea("Texto com scroll extra...");
        textoScroll.setFont(fontePadrao);
        textoScroll.setRows(4);
        JScrollPane scrollExtra = new JScrollPane(textoScroll);
        scrollExtra.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));
        panel.add(scrollExtra);
        panel.add(Box.createVerticalStrut(8));

        // ✅ ToggleButton
        JToggleButton toggleButton = new JToggleButton("Ativar / Desativar");
        toggleButton.setFont(fontePadrao);
        toggleButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        panel.add(toggleButton);
        panel.add(Box.createVerticalStrut(8));

        // ✅ Spinner com lista de valores
        JLabel labelSpinner = new JLabel("Spinner com valores fixos:");
        labelSpinner.setFont(fontePadrao);
        panel.add(labelSpinner);
        panel.add(Box.createVerticalStrut(4));
        String[] opcoesSpinner = {"Pequeno", "Médio", "Grande"};
        JSpinner spinnerLista = new JSpinner(new SpinnerListModel(opcoesSpinner));
        spinnerLista.setFont(fontePadrao);
        spinnerLista.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        panel.add(spinnerLista);
        panel.add(Box.createVerticalStrut(8));

        // ✅ Separador
        panel.add(new JSeparator(SwingConstants.HORIZONTAL));
        panel.add(Box.createVerticalStrut(8));

        // ✅ Tabela
        String[][] dadosTabela = {
                {"1", "João", "Estudante"},
                {"2", "Maria", "Professora"}
        };
        String[] colunasTabela = {"ID", "Nome", "Função"};
        JTable tabela = new JTable(dadosTabela, colunasTabela);
        tabela.setFont(fontePadrao);
        tabela.setRowHeight(25);
        JScrollPane scrollTabela = new JScrollPane(tabela);
        scrollTabela.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80));
        panel.add(scrollTabela);
        panel.add(Box.createVerticalStrut(8));

        // ✅ Botão de seleção de ficheiro
        JButton botaoFicheiro = new JButton("Abrir Ficheiro");
        botaoFicheiro.setFont(fontePadrao);
        botaoFicheiro.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        botaoFicheiro.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            int resultado = chooser.showOpenDialog(frame);
            if (resultado == JFileChooser.APPROVE_OPTION) {
                File ficheiro = chooser.getSelectedFile();
                JOptionPane.showMessageDialog(frame, "Ficheiro escolhido: " + ficheiro.getAbsolutePath());
            }
        });
        panel.add(botaoFicheiro);
        panel.add(Box.createVerticalStrut(8));

        // ✅ Botão Voltar
        JButton botaoVoltar = new JButton("Voltar ao Login");
        botaoVoltar.setFont(fontePadrao);
        botaoVoltar.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        botaoVoltar.addActionListener(e -> {
            frame.dispose();
            loginView.setVisible(true);
        });
        panel.add(botaoVoltar);
        panel.add(Box.createVerticalStrut(8));

        // ✅ ScrollPane que contém o painel
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        wrapper.add(scrollPane, BorderLayout.CENTER);

        frame.add(wrapper);
        frame.setVisible(true);
    }
}