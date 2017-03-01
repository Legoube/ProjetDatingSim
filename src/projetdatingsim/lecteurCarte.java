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

import java.io.*;

public class lecteurCarte {
    
    //Instanciation d'un variable necessaire pour lire le fichier de carte ligne par ligne.
    private String m_line = null;
    //Instanciation d'un tableau qui va contenir les paramètres (11) d'une carte.
    private final String tableauParametres[] = new String[11];

    public String[] lecture(String nomFichier)
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
	}
	catch (Exception e){
            m_line = e.toString();
            System.out.println(e.toString());
	}
    return tableauParametres;
    }
}