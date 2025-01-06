import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameInventory_Partie3_List {
    private JFrame frame;
    private JTextField nameField;
    private JTextField quantityField;
    private DefaultListModel<String> inventoryModel;
    private JList<String> inventoryList;

    public GameInventory_Partie3_List() {
        // Création de la fenêtre principale
        frame = new JFrame("Inventaire");
        // Taille de la fenêtre
        frame.setSize(550, 300);
        // Le bouton fermer
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Création des composants
        JPanel inputPanel = new JPanel(new FlowLayout());
        JLabel nameLabel = new JLabel("Nom:");
        nameField = new JTextField(10);
        JLabel quantityLabel = new JLabel("Quantité:");
        quantityField = new JTextField(5);
        JButton addButton = new JButton("Ajouter");
        JButton removeButton = new JButton("Supprimer");

        // Ajout des composants au panneau d'entrée
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(quantityLabel);
        inputPanel.add(quantityField);
        inputPanel.add(addButton);
        inputPanel.add(removeButton);

        // Liste d'inventaire
        inventoryModel = new DefaultListModel<>();
        inventoryList = new JList<>(inventoryModel);
        JScrollPane listScrollPane = new JScrollPane(inventoryList);

        // Ajout des panneaux à la fenêtre
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(listScrollPane, BorderLayout.CENTER);

        // Gestion des événements
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().trim();
                String quantity = quantityField.getText().trim();

                if (name.isEmpty() || quantity.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Veuillez remplir tous les champs.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    int qty = Integer.parseInt(quantity);
                    inventoryModel.addElement(name + " (Quantité: " + qty + ")");
                    nameField.setText("");
                    quantityField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "La quantité doit être un nombre valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = inventoryList.getSelectedIndex();
                if (selectedIndex != -1) {
                    inventoryModel.remove(selectedIndex);
                } else {
                    JOptionPane.showMessageDialog(frame, "Veuillez sélectionner un élément à supprimer.", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Rendre la fenêtre visible
        frame.setVisible(true);
    }
}
