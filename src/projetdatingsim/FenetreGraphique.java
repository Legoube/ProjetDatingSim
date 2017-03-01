/*
 * Antoine Legoubé
 * Licence professionnel Logiciels Libres
 * PROJET Dating Sim pour M. Traverson
 * Merci au site d'apprentissage https://www.openclassrooms.com, et aux cours de M. Traverson
 * Ainsi qu'aux nombreux forums apportant des réponses sur internet.
 */
package projetdatingsim;

/**
 * @author Antoine LEGOUBE
 */

import javax.swing.*; //Bibliothéque graphique Swing
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.AncestorListener;

public class FenetreGraphique extends JFrame {
    
    @SuppressWarnings("empty-statement")
    
    //Initialisation des images de période.
    Icon soir = new ImageIcon("img/moon.png");
    Icon matin = new ImageIcon("img/sunrise.png");
    Icon aprem = new ImageIcon("img/lights.png");
    Icon fin = new ImageIcon("img/folder.png");
    
    Icon totoro = new ImageIcon("img/totoro.png");
    Icon pecheur = new ImageIcon("img/pecheur.png");
    Icon inconnu = new ImageIcon("img/inconnu.png");

    //Création du panel principale, qui contiendra nos JBoutons / JLabel
    JPanel pan = new JPanel();
    
    JPanel panRendVous = new JPanel();

    //Instanciation / initialisation des couleurs, police, taille de police.
    Color couleurMessage = new Color(0, 153, 204);
    Color couleurPeriodeMatin = new Color(255, 255, 102);
    Color couleurPeriodeApresMidi = new Color(102, 255, 250);
    Color couleurPeriodeSoir = new Color(51, 0, 102);
    Color couleurActivite = new Color(0,0,50);
    Color couleurFinRendezVous = new Color(207, 188, 93);
    
    
    Font policeMessage = new Font("Georgia", Font.BOLD, 27);
    Font policeActivite = new Font("Purisa", Font.BOLD, 32);
    Font policeBoutons = new Font("Trabuchet", Font.PLAIN, 20);
    Font policeNbPoints = new Font("Impact", Font.BOLD, 30);
    Font policePretendant = new Font("Georgia", Font.BOLD, 20);
    Font policeDebutDeJeux = new Font("Georgia", Font.BOLD, 50);
    Font policeFinDeJeux = new Font("Georgia", Font.BOLD, 25);
    Font policeFinRendezVous = new Font("Georgia", Font.BOLD, 33);

    
    //Création des label / boutons / panels / menu 
    JLabel labelPeriode = new JLabel();
    JLabel labelActivite = new JLabel();
    JLabel labelnbPoints = new JLabel();
    JLabel labelPretendant = new JLabel();
    JLabel labelFinDeJeux = new JLabel();
    JLabel labelMessageDeFin = new JLabel();
    JLabel labelImageCentrale = new JLabel();
    
    JTextArea textMessage = new JTextArea();
    JTextArea textMessageFin = new JTextArea();
    
    JButton btDroit = new JButton();
    JButton btGauche = new JButton();
    JButton btStart = new JButton();
    
    
        
    JPanel panPeriActi = new JPanel();
    JPanel panZoneBut = new JPanel();
    JPanel panMessage = new JPanel();
    JPanel panDebut = new JPanel();
    JPanel panFin = new JPanel();
    
    
    //Instanciation du menu.
    JMenuBar monMenu = new JMenuBar();
    JMenu menu = new JMenu("");
    
    //Message de fin si plus de carte dans la pile : 
    String messageFinPile = "Hum, dommage pour vous, il semblerait que vous n'appreciez pas les autres, ou pas assez pour avoir d'Amis... Il n'y a plus de carte dans la Pile. Dommage. Relancer (en haut, à gauche) si vous le souhaitez :) ";
    //Message de fin pour un rendezVous...
    String messageFinRdv = "Waoo ! Vous avez réussi à vous faire inviter à un rendez vous par : ";
    
    public FenetreGraphique() throws IOException {  

//--------> DEFINITION de la fenetre graphique avec Taille, Titre, positionnement.
    //Définit un titre pour notre fenêtre
    this.setTitle("Dating Sim - L'Aventure extraordinaire");
    //Définit sa taille d'apparition: 800 pixels de large et 600 pixels de haut
    this.setSize(1600, 700);
    //Nous demandons maintenant à notre objet de se positionner au centre
    this.setLocationRelativeTo(null);
    //Termine le processus lorsqu'on clique sur la croix rouge
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
    
//--------> GESTION DU MENU
    //Ajout de la bar de manu dans la fenetre.
    this.setJMenuBar(monMenu);
    JMenuItem relancer = new JMenuItem("C'est reparti");
    //Ajout d'items pour le menu
    monMenu.add(menu);
    relancer.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Moteur.viderLaPile();
                Moteur.setInterfaceDebutJeux();
            } catch (PileException | IOException ex) {
                Logger.getLogger(FenetreGraphique.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    });
    monMenu.add(relancer);
    
//---------> GESTION de l'affichage de la carte et de son JLabel  
    this.setVisible(true);
    }
    
    //Methode d'initialisation des label / button / menu
    public void setLabelPeriode(String periode){
        labelPeriode.setHorizontalAlignment(SwingConstants.CENTER);
        labelPeriode.setOpaque(true);
        if(periode.equals("Matin")) {
            labelPeriode.setIcon(matin);
            labelPeriode.setBackground(couleurPeriodeMatin);
        }
        if(periode.equals("Apres-midi")) {
            labelPeriode.setIcon(aprem);
            labelPeriode.setBackground(couleurPeriodeApresMidi);
        }
        if(periode.equals("Soir")) {
            labelPeriode.setIcon(soir);
            labelPeriode.setBackground(couleurPeriodeSoir);
        }
    }
    public void setLabelImage(String pretendant) {
        labelImageCentrale.setHorizontalAlignment(SwingConstants.CENTER);
        if(pretendant.equals("Totoro")) {
            labelImageCentrale.setIcon(totoro);
        }
        if(pretendant.equals("Pecheur")) {
            labelImageCentrale.setIcon(pecheur);
        }
        if(pretendant.equals("Inconnu")) {
            labelImageCentrale.setIcon(inconnu);
        }
    }
    public void setLabelActivite(String activite) {
        labelActivite.setText(activite);
        labelActivite.setFont(policeActivite);
        labelActivite.setForeground(Color.WHITE);
        labelActivite.setHorizontalAlignment(SwingConstants.CENTER);
        labelActivite.setOpaque(true);
        labelActivite.setBackground(couleurActivite);
        
        
    }
    public void setLabelnbPoints(int nbPoints) {
        labelnbPoints.setText(String.valueOf(nbPoints));
        labelnbPoints.setFont(policeNbPoints);
        labelnbPoints.setForeground(Color.BLACK);
        labelnbPoints.setHorizontalAlignment(SwingConstants.CENTER);
        labelnbPoints.setOpaque(true);
        labelnbPoints.setBackground(Color.WHITE);
        
    }
    public void setLabelPretendant(String pretendant) {
        labelPretendant.setText(pretendant);
        labelPretendant.setFont(policePretendant);
        labelPretendant.setForeground(Color.BLACK);
        labelPretendant.setHorizontalAlignment(SwingConstants.CENTER);
        labelPretendant.setOpaque(true);
        labelPretendant.setBackground(Color.WHITE);
        
    }
    public void setLabelMessage(String message) {
        
        textMessage.setText(message);
        textMessage.setFont(policeMessage);
        textMessage.setLineWrap(true);
        textMessage.setWrapStyleWord(true);
        textMessage.setPreferredSize(new Dimension(0, 100));
        textMessage.setOpaque(true);
        textMessage.setBackground(couleurMessage);
        textMessage.setAlignmentX(CENTER_ALIGNMENT);
        textMessage.setAlignmentY(CENTER_ALIGNMENT);
        
    }
    public void setLabelFinalImgPile() {
        labelFinDeJeux.setIcon(fin);
        labelFinDeJeux.setHorizontalAlignment(SwingConstants.CENTER);
        labelFinDeJeux.setVerticalAlignment(SwingConstants.CENTER);
    }
    public void setLabelFinalMessPile() {
        labelMessageDeFin.setText(messageFinPile);
    }
    //Initialisation des boutons
    public void setButDroit(String nameDroit) {
        btDroit.setText(nameDroit);
        btDroit.setFont(policeBoutons);
        
    }
    public void setButGauche(String nameGauche) {
        btGauche.setText(nameGauche);
        btGauche.setFont(policeBoutons);
    
    }
    public void ajouterBoutonListener() {
        btDroit.addActionListener(new BoutonListenerDroit());
        btGauche.addActionListener(new BoutonListenerGauche());
    }
    
    
    public void setPanelFinal() {
        panFin.setLayout(new BorderLayout());
        panFin.add(labelFinDeJeux, BorderLayout.CENTER);
        panFin.add(labelMessageDeFin, BorderLayout.SOUTH);
        
    }
    public void setPanel(){
        
        //---------> GESTION des zones Periode et Activité
        //Utilisation d'un gridLayout, proposant plus de liberté que le borderLayout.

        panPeriActi.setLayout(new GridLayout(1,4));
        panPeriActi.add(labelPeriode);
        panPeriActi.add(labelActivite);
        panPeriActi.add(labelPretendant);
        panPeriActi.add(labelnbPoints);
        panPeriActi.setPreferredSize(new Dimension(0, 80));
                
        panZoneBut.setLayout(new BorderLayout());
        panZoneBut.add(btDroit, BorderLayout.EAST);
        panZoneBut.add(labelImageCentrale, BorderLayout.CENTER);
        panZoneBut.add(btGauche, BorderLayout.WEST);
        
        panZoneBut.repaint();
        panZoneBut.revalidate();

        pan.setLayout(new BorderLayout());
        pan.add(panPeriActi, BorderLayout.NORTH);
        pan.add(panZoneBut, BorderLayout.CENTER);
        pan.add(textMessage, BorderLayout.SOUTH);

        this.setContentPane(pan);
        
    }
    public void setPanelDebutDeJeux() {
        btStart = new JButton("Salut à toi compagnon. On ne pert pas de temps, allons-y !");
        btStart.setFont(policeDebutDeJeux);
        btStart.addActionListener(new BoutonListenerDebut());
        
        panDebut.setLayout(new BorderLayout());
        panDebut.add(btStart, BorderLayout.CENTER);
        
        this.setContentPane(this.panDebut);
        
    }
    public void setPanelFinDeJeux() {
        
        panFin.setLayout(new BorderLayout());
        panFin.add(labelFinDeJeux, BorderLayout.CENTER);
        panFin.add(labelMessageDeFin,BorderLayout.SOUTH);
        
    }
    public void setPanelFinRendVous(String pretendant) {
        
        String message = this.messageFinRdv+pretendant;
        JLabel labelMessageRendezVous = new JLabel(message);
        labelMessageRendezVous.setBackground(couleurFinRendezVous);
        labelMessageRendezVous.setOpaque(true);
        labelMessageRendezVous.setFont(policeBoutons);
        labelMessageRendezVous.setPreferredSize(new Dimension(0, 250));
        
        labelImageCentrale.setHorizontalAlignment(SwingConstants.CENTER);
        if(pretendant.equals("Totoro")) {
            labelImageCentrale.setIcon(totoro);
        }
        if(pretendant.equals("Pecheur")) {
            labelImageCentrale.setIcon(pecheur);
        }
        if(pretendant.equals("Inconnu")) {
            labelImageCentrale.setIcon(inconnu);
        }
        
        panRendVous.setLayout(new BorderLayout());
        panRendVous.add(labelImageCentrale, BorderLayout.CENTER);
        panRendVous.add(labelMessageRendezVous, BorderLayout.SOUTH);
                
    }
    public void changerPanelDebut() {
        this.setContentPane(this.pan);
        this.pan.revalidate();
                
    }
    public void changerPanelFinPile() {
        this.setContentPane(this.panFin);
        this.revalidate();
    }
    public void changerPanelFinRdv() {
        this.setContentPane(this.panRendVous);
        this.revalidate();
    }
}