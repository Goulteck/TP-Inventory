import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GameInventory_Partie3_Block {
    private JFrame frame;
    private JTextField nameField;
    private JPanel inventoryPanel;
    private ArrayList<JButton> itemButtons;
    public GameInventory_Partie3_Block() {
        // Création de la fenêtre principale
        frame = new JFrame("Inventaire");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Liste des boutons des items
        itemButtons = new ArrayList<>();

        // Création des composants d'entrée
        JPanel inputPanel = new JPanel(new FlowLayout());
        JLabel nameLabel = new JLabel("Nom de l'item:");
        nameField = new JTextField(15);
        JButton addButton = new JButton("Ajouter");

        // Ajout des composants d'entrée au panneau supérieur
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(addButton);

        // Panneau pour afficher les items
        inventoryPanel = new JPanel();
        inventoryPanel.setLayout(new GridLayout(0, 4, 10, 10)); // Grille avec 4 colonnes
        JScrollPane scrollPane = new JScrollPane(inventoryPanel);

        // Bouton pour tout supprimer
        JButton clearButton = new JButton("X");
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
        inventoryPanel.add(clearButton);

        // Gestion de l'ajout d'items
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().trim();

                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Veuillez entrer un nom d'item.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Création d'un bouton pour l'item
                JButton itemButton = new JButton(name);
                itemButton.setBackground(Color.CYAN);
                itemButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        inventoryPanel.remove(itemButton);
                        itemButtons.remove(itemButton);
                        inventoryPanel.revalidate();
                        inventoryPanel.repaint();
                    }
                });

                // Ajout du bouton au panneau et à la liste
                itemButtons.add(itemButton);
                inventoryPanel.add(itemButton);

                // Réinitialisation du champ de texte
                nameField.setText("");

                // Mise à jour de l'affichage
                inventoryPanel.revalidate();
                inventoryPanel.repaint();
            }
        });

        // Ajout des panneaux à la fenêtre principale
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Rendre la fenêtre visible
        frame.setVisible(true);
    }
}
