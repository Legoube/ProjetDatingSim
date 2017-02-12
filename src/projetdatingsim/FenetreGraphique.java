/*
 * Antoine Legoubé
 * Licence professionnel Logiciels Libres
 * PROJET Dating Sim pour M. Traverson
 * Merci au site d'apprentissage https://www.openclassrooms.com, et aux cours de M. Traverson
 */
package projetdatingsim;

import javax.swing.*; //Bibliothéque graphique Swing
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.applet.Applet;
/**
 *
 * @author AntoineL
 */
public class FenetreGraphique extends JFrame {

    @SuppressWarnings("empty-statement")
    public FenetreGraphique() throws IOException {            
    //Définit un titre pour notre fenêtre
    this.setTitle("Dating Traverson v0.1");
    //Définit sa taille : 400 pixels de large et 100 pixels de haut
    this.setSize(400, 100);
    //Nous demandons maintenant à notre objet de se positionner au centre
    this.setLocationRelativeTo(null);
    //Termine le processus lorsqu'on clique sur la croix rouge
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
    
    
//--------> GESTION de notre panel qui va accueillir les bouton / Label
    //Instanciation d'un objet JPanel
    JPanel pan = new JPanel();
    //Définition de sa couleur de fond
    pan.setBackground(Color.ORANGE);  
    //On prévient notre JFrame que notre JPanel sera son content pane
    this.setContentPane(pan);
    
//--------> GESTION DU MENU
    //Instanciation d'une barre de menu
    JMenuBar monMenu = new JMenuBar();
    this.setJMenuBar(monMenu);
    //Instancation d'items pour le menu
    JMenu menu = new JMenu("RELANCER");
    monMenu.add(menu);
    
//---------> GESTION des boutons
    //Instanciation des boutons Droit et gauche
    JButton btDroit = new JButton("choix droit");
    JButton btGauche = new JButton("choix gauche");
    //Déclaration de "grille" d'élements (type layout)    
        setLayout(new BorderLayout());
        add("West", btGauche);
        add("East", btDroit);
        
//---------> GESTION de l'affichage de la carte et de son JLabel
   
    ImageIcon maCarte = new ImageIcon("moi.png");
    Graphics g = null;
    JLabel zoneCarte = new JLabel(maCarte);
    pan.add("Center",zoneCarte);
    
    this.setVisible(true);
    }
    
}

/*
  //Méthode appelée lors du clic de souris

  public void mouseClicked(MouseEvent event) { }


  //Méthode appelée lors du survol de la souris

  public void mouseEntered(MouseEvent event) { }


  //Méthode appelée lorsque la souris sort de la zone du bouton

  public void mouseExited(MouseEvent event) { }


  //Méthode appelée lorsque l'on presse le bouton gauche de la souris

  public void mousePressed(MouseEvent event) { }


  //Méthode appelée lorsque l'on relâche le clic de souris

  public void mouseReleased(MouseEvent event) { }       

}
*/
