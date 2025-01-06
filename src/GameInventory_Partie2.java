import javax.swing.*;
import java.awt.*;

    public class GameInventory_Partie2 {
        private JFrame frame;
        private JTextField nameField;
        private JTextField quantityField;
        private DefaultListModel<String> inventoryModel;
        private JList<String> inventoryList;

        public GameInventory_Partie2() {
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

            // Ajout des composants au panneau
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

            // Rendre la fenêtre visible
            frame.setVisible(true);
        }
    }

