import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class GameInventory_Partie3_Block {
    private JFrame frame;
    private JTextField nameField;
    private JTextField quantityField;
    private JPanel inventoryPanel;
    private HashMap<String, JButton> itemButtons;

    public GameInventory_Partie3_Block() {
        // Création de la fenêtre principale
        frame = new JFrame("Inventaire");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Liste des boutons des items (nom -> bouton)
        itemButtons = new HashMap<>();

        // Création des composants d'entrée
        JPanel inputPanel = new JPanel(new FlowLayout());
        JLabel nameLabel = new JLabel("Nom de l'item:");
        nameField = new JTextField(15);
        JLabel quantityLabel = new JLabel("Quantité:");
        quantityField = new JTextField(5);
        JButton addButton = new JButton("Ajouter");

        // Ajout des composants d'entrée au panneau supérieur
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(quantityLabel);
        inputPanel.add(quantityField);
        inputPanel.add(addButton);

        // Panneau pour afficher les items
        inventoryPanel = new JPanel();
        inventoryPanel.setLayout(new GridLayout(0, 4, 10, 10)); // Grille avec 4 colonnes
        JScrollPane scrollPane = new JScrollPane(inventoryPanel);

        // Bouton pour tout supprimer
        JButton clearButton = new JButton("Vider tout");
        clearButton.setBackground(Color.RED);
        clearButton.setForeground(Color.WHITE);
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inventoryPanel.removeAll();
                itemButtons.clear();
                inventoryPanel.revalidate();
                inventoryPanel.repaint();
            }
        });

        // Gestion de l'ajout ou mise à jour des items
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().trim();
                String quantity = quantityField.getText().trim();

                if (name.isEmpty() || quantity.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Veuillez entrer un nom et une quantité.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    int qty = Integer.parseInt(quantity);
                    if (qty <= 0) {
                        JOptionPane.showMessageDialog(frame, "La quantité doit être un nombre positif.", "Erreur", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (itemButtons.containsKey(name)) {
                        // Mise à jour de la quantité d'un item existant
                        JButton existingButton = itemButtons.get(name);
                        existingButton.setText(name + " (Quantité: " + qty + ")");
                    } else {
                        // Création d'un nouveau bouton pour l'item
                        JButton itemButton = new JButton(name + " (Quantité: " + qty + ")");
                        itemButton.setBackground(Color.CYAN);
                        itemButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // Supprimer l'item lorsqu'on clique dessus
                                inventoryPanel.remove(itemButton);
                                itemButtons.remove(name);
                                inventoryPanel.revalidate();
                                inventoryPanel.repaint();
                            }
                        });

                        // Ajout du bouton au panneau et à la liste
                        itemButtons.put(name, itemButton);
                        inventoryPanel.add(itemButton);
                    }

                    // Réinitialisation des champs de texte
                    nameField.setText("");
                    quantityField.setText("");

                    // Mise à jour de l'affichage
                    inventoryPanel.revalidate();
                    inventoryPanel.repaint();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "La quantité doit être un nombre valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Ajout des panneaux à la fenêtre principale
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(clearButton, BorderLayout.SOUTH);

        // Rendre la fenêtre visible
        frame.setVisible(true);
    }
}