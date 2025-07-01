package controller;

import dao.EstadoDAO;
import dao.EquipamentoDAO;
import org.jdatepicker.impl.JDatePickerImpl;
import view.InserirEquipamentoView;
import model.Estado;
import model.Equipamento;
import model.Utilizador;

import javax.swing.*;
import java.time.LocalDate;
import java.util.List;

public class InserirController {


    private InserirEquipamentoView view; //
    private int idResponsavel; // ID do utilizador que criou o registo
    private Utilizador utilizador;


    public InserirController(Utilizador utilizador) {
       // this.view = view;
       // this.idResponsavel = idResponsavel;
        this.utilizador = utilizador;
        this.view = new InserirEquipamentoView(utilizador);

        carregarEstados();
        configurarBotaoInserir();
        configurarBotaoVoltar();

        view.setVisible(true);

    }

    /**
     * Carrega a lista de estados a partir da base de dados.
     */
    private void carregarEstados() {
        EstadoDAO estadoDAO = new EstadoDAO();
        List<Estado> estados = estadoDAO.listarEstados();
        JComboBox<Estado> combo = view.getComboEstado();
        combo.removeAllItems();
        for (Estado e : estados) {
            combo.addItem(e);
        }
    }

    /**
     * Configura o botão Inserir para validar os campos e inserir o equipamento.
     */
    private void configurarBotaoInserir() {
        view.getBtnInserir().addActionListener(_ -> {
            // Validação dos campos
            String nome = view.getTxtNome().getText().trim();
            Estado estadoSelecionado = (Estado) view.getComboEstado().getSelectedItem();
            String sala = view.getTxtSala().getText().trim();
            String numeroDeSerie = view.getNumeroSerie().getText().trim();
            JDatePickerImpl datePicker = view.getDataAquisicao();

            if (nome.isEmpty() || estadoSelecionado == null || sala.isEmpty() || numeroDeSerie.isEmpty()) {
                JOptionPane.showMessageDialog(view,
                        "Por favor, preencha todos os campos antes de inserir.",
                        "Campos obrigatórios",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            //Calendário para inserir a data de aquisição
            java.util.Date selectedDate = (java.util.Date) datePicker.getModel().getValue();
            if(selectedDate == null) {
                JOptionPane.showMessageDialog(view,
                        "Por favor, selecione uma data de aquisição válida.",
                        "Data obrigatória",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            LocalDate dataAquisicao = selectedDate.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();

            // Criar o objeto Equipamento
            Equipamento eq = new Equipamento();
            eq.setNome(nome);
            eq.setEstado(estadoSelecionado);
            eq.setSala(sala);
            eq.setNumeroSerie(numeroDeSerie);
            eq.setDataAquisicao(dataAquisicao);

            // Responsável atual
//            Utilizador resp = new Utilizador();
//            resp.setId(idResponsavel);
//            eq.setResponsavel(resp);

            // Inserir na base de dados
            boolean sucesso = new EquipamentoDAO().inserirEquipamento(eq);
            if (sucesso) {
                JOptionPane.showMessageDialog(view,
                        "Equipamento inserido com sucesso!",
                        "Sucesso",
                        JOptionPane.INFORMATION_MESSAGE);

                view.dispose();
                new MenuController(utilizador); // voltar ao menu
            } else {
                JOptionPane.showMessageDialog(view,
                        "Erro ao inserir equipamento.",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    /**
     * Configura o botão Voltar para fechar a view e voltar ao menu.
     */
    private void configurarBotaoVoltar() {
        view.getBtnVoltar().addActionListener(_ -> {
            view.dispose();
            new MenuController(utilizador); // volta ao menu
        });
    }
}
