package view;

import javax.swing.*;
import java.awt.*;
import java.util.Properties;
import java.util.Calendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import javax.swing.JFormattedTextField.AbstractFormatter;

public class CalendarioView {

    public CalendarioView() {
        criarJanela();
    }

    private void criarJanela() {
        JFrame frame = new JFrame("Selecionar Data - Calendário");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // Configuração do modelo
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Hoje");
        p.put("text.month", "Mês");
        p.put("text.year", "Ano");

        // Criar o DatePicker
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

        // Adiciona ao painel
        panel.add(datePicker);

        // Botão para demonstrar recolha da data
        JButton btnObterData = new JButton("Obter Data");
        btnObterData.addActionListener(e -> {
            Object selectedDate = datePicker.getModel().getValue();
            if (selectedDate != null) {
                JOptionPane.showMessageDialog(frame, "Data selecionada: " + selectedDate.toString());
            } else {
                JOptionPane.showMessageDialog(frame, "Nenhuma data selecionada.");
            }
        });
        panel.add(btnObterData);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}

// Formatter para o DatePicker
class DateLabelFormatter extends AbstractFormatter {
    private final String datePattern = "yyyy-MM-dd";
    private final SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

    @Override
    public Object stringToValue(String text) throws ParseException {
        return dateFormatter.parse(text);
    }

    @Override
    public String valueToString(Object value) {
        if (value != null) {
            Calendar cal = (Calendar) value;
            return dateFormatter.format(cal.getTime());
        }
        return "";
    }
}
