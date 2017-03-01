/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetdatingsim;

import java.io.IOException;

/**
 *
 * @author etudiant
 */
public class Main { 
    
    public static void main(String[] args) throws IOException {
        //Mise en place interface graphique
        FenetreGraphique fG = new FenetreGraphique();
        //Création d'un moteur
        Moteur moteur;
        moteur = new Moteur(fG);
        //Setting de l'interface 
        Moteur.setInterfaceDebutJeux();
    }
}
