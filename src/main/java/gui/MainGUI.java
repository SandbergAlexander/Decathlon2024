package gui;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

import common.Competitor;
import decathlon.*;
import excel.ExcelPrinter;
import heptathlon.*;


public class MainGUI {

    private JTextField nameField;
    private JTextField resultField;
    private JComboBox<String> disciplineBox;
    private JTextArea outputArea;
    private JTable competitorTable;
    private DefaultTableModel tableModel;
    private ArrayList<Competitor> competitors = new ArrayList<>();
    public static void main(String[] args) {
        new MainGUI().createAndShowGUI();
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Track and Field Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(6, 1));

        // Input for competitor's name
        nameField = new JTextField(20);
        panel.add(new JLabel("Enter Competitor's Name:"));
        panel.add(nameField);

        // Dropdown for selecting discipline
        String[] disciplines = {
                "100m", "400m", "1500m", "110m Hurdles",
                "Long Jump", "High Jump", "Pole Vault",
                "Discus Throw", "Javelin Throw", "Shot Put",
                "Hep 100m Hurdles", "Hep 200m", "Hep 800m",
                "Hep High Jump", "Hep Javelin Throw",
                "Hep Long Jump", "Hep Shot Put"
        };
        disciplineBox = new JComboBox<>(disciplines);
        panel.add(new JLabel("Select Discipline:"));
        panel.add(disciplineBox);

        // Input for result
        resultField = new JTextField(10);
        panel.add(new JLabel("Enter Result:"));
        panel.add(resultField);

        // Button to calculate and display result
        JButton calculateButton = new JButton("Calculate Score");
        calculateButton.addActionListener(new CalculateButtonListener());
        panel.add(calculateButton);

        JButton exportButton = new JButton("Export to Excel");
        exportButton.addActionListener(new ExportButtonListener());  // New export button listener
        panel.add(exportButton);  // Add export button to the panel

        // Tooltips for input fields and buttons
        nameField.setToolTipText("Enter a valid name for the competitor");
        resultField.setToolTipText("Enter a valid result in numbers for the selected discipline");

        // Output area
        outputArea = new JTextArea(5, 40);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        panel.add(scrollPane);

        // Table for displaying competitors and their results
        String[] columnNames = {"Name", "100m", "400m", "1500m", "110m Hurdles",
                "Long Jump", "High Jump", "Pole Vault",
                "Discus Throw", "Javelin Throw", "Shot Put",
                "Hep 100M Hurdles", "Hep 200M", "Hep 800M", "Hep High Jump",
                "Hep Javelin Throw", "Hep Long Jump", "Hep Shot Put", "Total Score"};
        tableModel = new DefaultTableModel(columnNames, 0);
        competitorTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(competitorTable);
        tableScrollPane.setPreferredSize(new Dimension(750, 200));



        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.CENTER);  // Top panel with inputs
        frame.add(tableScrollPane, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            String discipline = (String) disciplineBox.getSelectedItem();
            String resultText = resultField.getText();

            try {
                double result = Double.parseDouble(resultText);

                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid name for the competitor", "Invalid Name", JOptionPane.ERROR_MESSAGE);
                    return; // Exit the method if name is empty or doesn't start with an uppercase letter
                }

                // Check if all characters are letters
                for (int i = 0; i < name.length(); i++) {
                    if (!Character.isLetter(name.charAt(i))) {
                        JOptionPane.showMessageDialog(null, "Name must only contain letters", "Invalid Name", JOptionPane.ERROR_MESSAGE);
                        return; // Exit the method if name contains non-letter characters
                    }
                }

                int score = 0;
                switch (discipline) {
                    case "100m":
                        Deca100M deca100M = new Deca100M();
                        score = deca100M.calculateResult(result);
                        break;
                    case "400m":
                        Deca400M deca400M = new Deca400M();
                        score = deca400M.calculateResult(result);
                        break;
                    case "1500m":
                        Deca1500M deca1500M = new Deca1500M();
                        score = deca1500M.calculateResult(result);
                        break;
                    case "110m Hurdles":
                        Deca110MHurdles deca110MHurdles = new Deca110MHurdles();
                        score = deca110MHurdles.calculateResult(result);
                        break;
                    case "Long Jump":
                        DecaLongJump decaLongJump = new DecaLongJump();
                        score = decaLongJump.calculateResult(result);
                        break;
                    case "High Jump":
                        DecaHighJump decaHighJump = new DecaHighJump();
                        score = decaHighJump.calculateResult(result);
                        break;
                    case "Pole Vault":
                        DecaPoleVault decaPoleVault = new DecaPoleVault();
                        score = decaPoleVault.calculateResult(result);
                        break;
                    case "Discus Throw":
                        DecaDiscusThrow decaDiscusThrow = new DecaDiscusThrow();
                        score = decaDiscusThrow.calculateResult(result);
                        break;
                    case "Javelin Throw":
                        DecaJavelinThrow decaJavelinThrow = new DecaJavelinThrow();
                        score = decaJavelinThrow.calculateResult(result);
                        break;
                    case "Shot Put":
                        DecaShotPut decaShotPut = new DecaShotPut();
                        score = decaShotPut.calculateResult(result);
                        break;
                    case "Hep 100m Hurdles":
                        Hep100MHurdles hep100mHurdles = new Hep100MHurdles();
                        score = hep100mHurdles.calculateResult(result);
                        break;
                    case "Hep 200m":
                        Hep200M hep200M = new Hep200M();
                        score = hep200M.calculateResult(result);
                        break;
                    case "Hep 800m":
                        Hep800M hep800M = new Hep800M();
                        score = hep800M.calculateResult(result);
                        break;
                    case "Hep High Jump":
                        HeptHightJump hepHighJump = new HeptHightJump();
                        score = hepHighJump.calculateResult(result);
                        break;
                    case "Hep Javelin Throw":
                        HeptJavelinThrow hepJavelinThrow = new HeptJavelinThrow();
                        score = hepJavelinThrow.calculateResult(result);
                        break;
                    case "Hep Long Jump":
                        HeptLongJump hepLongJump = new HeptLongJump();
                        score = hepLongJump.calculateResult(result);
                        break;
                    case "Hep Shot Put":
                        HeptShotPut hepShotPut = new HeptShotPut();
                        score = hepShotPut.calculateResult(result);
                        break;
                }
                Competitor competitor = new Competitor(name);
                if (!competitors.contains(competitor)) {
                    competitors.add(competitor);
                } else {
                    competitor = competitors.get(competitors.indexOf(competitor));
                }


                // Update the competitor's score for the selected discipline
                competitor.setScore(discipline, score);
                outputArea.append("Competitor: " + name + "\n");
                outputArea.append("Discipline: " + discipline + "\n");
                outputArea.append("Result: " + result + "\n");
                outputArea.append("Score: " + score + "\n\n");
                tableModel.addRow(competitor.getRowData());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number for the result.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class ExportButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                exportToExcel();
                JOptionPane.showMessageDialog(null, "Results exported successfully!", "Export Successful", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Failed to export results to Excel.", "Export Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void exportToExcel() throws IOException {
        String[][] data = new String[competitors.size()][];
        int i = 0;
        for (Competitor competitor : competitors) {
            Object[] rowData = competitor.getRowData(); // Get the competitor's row data

            // Ensure the array size matches the number of columns in rowData
            data[i] = new String[rowData.length];

            // Safely copy rowData to data array
            for (int j = 0; j < rowData.length; j++) {
                data[i][j] = (rowData[j] != null) ? rowData[j].toString() : "";  // Handle null values
            }
            i++;
        }

        ExcelPrinter printer = new ExcelPrinter("TrackAndFieldResults");
        printer.add(data, "Results");
        printer.write();
    }

}
