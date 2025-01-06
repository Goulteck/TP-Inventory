import javax.swing.*;

    public class GameInventory_Partie1 {
        private JFrame frame;

        public GameInventory_Partie1() {
            // Création de la fenêtre principale
            frame = new JFrame("Inventaire");
            // Taille de la fenêtre
            frame.setSize(400, 300);
            // Le bouton fermer
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Rendre la fenêtre visible
            frame.setVisible(true);
        }
    }
