package view;

// Importa todas as classes do pacote javax.swing, utilizadas para construir interfaces gráficas em Java
// Inclui componentes como JFrame, JPanel, JButton, JLabel, JTextField, JTable, JScrollPane, etc.
import javax.swing.*;

// Importa a classe DefaultTableModel, usada para gerir os dados que aparecem numa JTable
// Permite adicionar, remover ou modificar linhas e colunas dinamicamente
import javax.swing.table.DefaultTableModel;

// Importa todas as classes do pacote java.awt, responsáveis pela gestão visual da janela
// Inclui layouts (BorderLayout, GridLayout), fontes, cores, e elementos gráficos gerais
import java.awt.*;

// Importa a classe ActionListener, que permite reagir a eventos gerados por botões (cliques)
// Essencial para associar comportamentos aos botões da interface
import java.awt.event.ActionListener;

// Declaração da classe ListarEquipamentosView, que representa uma janela gráfica para listar os equipamentos
// A classe estende (herda) JFrame, permitindo criar uma janela completa com tabela, botões e layout personalizado
// Esta view será utilizada para apresentar os dados de forma tabular e interagir com ações como Editar, Remover ou Filtrar
public class ListarEquipamentosView extends JFrame {

    // Componentes da interface
    private final JTable tabela;           // Tabela para mostrar os equipamentos
    private final JButton btnEditar;       // Botão para editar o equipamento selecionado
    private final JButton btnRemover;      // Botão para remover o equipamento selecionado
    private final JButton btnFiltrar;      // Botão para aplicar filtros na lista
    private final JButton btnVoltar;       // Botão para voltar à janela anterior

    // Construtor da janela
    public ListarEquipamentosView() {
        setTitle("Lista de Equipamentos");                  // Define o título da janela
        setSize(700, 400);                                  // Define o tamanho da janela
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);         // Fecha apenas esta janela ao clicar em X
        setLocationRelativeTo(null);                        // Centraliza a janela no ecrã
        setResizable(false);                                // Impede redimensionamento

        // Criação da tabela com colunas definidas
        tabela = new JTable(new DefaultTableModel(
                new Object[]{"Nome", "Estado", "Número de Série", "Data de Aquisição", "Sala", "Responsável"}, 0));
        JScrollPane scroll = new JScrollPane(tabela);       // Adiciona scroll à tabela

        // Painel inferior com os botões de ação
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // Instanciação dos botões
        btnEditar = new JButton("Editar");
        btnRemover = new JButton("Remover");
        btnFiltrar = new JButton("Filtrar");
        btnVoltar = new JButton("Voltar");

        // Adiciona os botões ao painel
        painelBotoes.add(btnVoltar);
        painelBotoes.add(btnFiltrar);
        painelBotoes.add(btnEditar);
        painelBotoes.add(btnRemover);

        // Adiciona a tabela e os botões ao layout da janela
        getContentPane().add(scroll, BorderLayout.CENTER);     // Tabela ocupa a área central
        getContentPane().add(painelBotoes, BorderLayout.SOUTH); // Botões ficam na parte inferior
    }

    // Getter para aceder à tabela
    public JTable getTabela() {
        return tabela;
    }

    // Método para associar ação ao botão "Editar"
    public void adicionarAcaoEditar(ActionListener listener) {
        btnEditar.addActionListener(listener);
    }

    // Método para associar ação ao botão "Remover"
    public void adicionarAcaoRemover(ActionListener listener) {
        btnRemover.addActionListener(listener);
    }

    // Método para associar ação ao botão "Filtrar"
    public void adicionarAcaoFiltrar(ActionListener listener) {
        btnFiltrar.addActionListener(listener);
    }

    // Método para associar ação ao botão "Voltar"
    public void adicionarAcaoVoltar(ActionListener listener) {
        btnVoltar.addActionListener(listener);
    }

    // Permite aceder ao modelo da tabela (para adicionar/remover linhas)
    public DefaultTableModel getModeloTabela() {
        return (DefaultTableModel) tabela.getModel();
    }
}
