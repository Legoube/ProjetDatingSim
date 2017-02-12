/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetdatingsim;

import java.io.*;
/**
 *
 * @author etudiant
 */
public class lecteurCarte {
    
    //Instanciation d'un variable necessaire pour lire le fichier de carte ligne par ligne.
    private String m_line = null;
    //Instanciation d'un tableau qui va contenir les paramètres (9) d'une carte.
    private String tableauParametres[] = new String[9];

    //Création de l'objet carte. 
    private Carte maCarte;

    public void lecture(String nomFichier)
    {
    try {
        //Instanciation d'un compteur pour parcours et compléter le tableau [tableauParametres]
        int compteur = 0;
        
        //Instanction d'un buffer pour stocker provisoirement les lignes du fichier traité
        String bufLigne = "";
        
        //Instanciation de l'objet bic qui va lire les fichiers (qui correspondent à nos cartes).
        BufferedReader bic = new BufferedReader(new FileReader(nomFichier)); 
        
        //Tant que le lecteur peut lire du contenu, on stock, au fer et à mesure, les paramètres dans le tableau.
        while ((m_line = bic.readLine()) != null){
            bufLigne = m_line;
            tableauParametres[compteur] = bufLigne;
            compteur = compteur + 1;
        }
        
        // Appel de la fonction d'affichage test de l'object Carte.
        maCarte = new Carte(tableauParametres);
        
	}
	catch (Exception e){
            m_line = e.toString();
            System.out.println(e.toString());
	}
    }
    
    public Carte getCarte(){
        return maCarte;
    }
}