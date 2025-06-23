package controller;

import dao.EstadoDAO;
import model.Estado;
import view.InserirEquipamentoView;

import javax.swing.*;
import java.util.List;

public class EstadoController {

    private InserirEquipamentoView view;
    private EstadoDAO estadoDAO;

    public EstadoController() {
        view = new InserirEquipamentoView();
        estadoDAO = new EstadoDAO();
        carregarEstados();
        view.setVisible(true);
    }


    private void carregarEstados() {
        List<Estado> estados = estadoDAO.listarEstados();
        JComboBox<Estado> combo = view.getCbEstado();

        combo.removeAllItems(); // Limpa antes, por segurança
        for (Estado estado : estados) {
            combo.addItem(estado);
        }
    }
}
