/*
 * C'est dans cette classe que l'on va remplir une pile de cartes.
 */
package projetdatingsim;

import java.util.Vector;
import java.io.*;

/**
 *
 * @author Antoine Legoubé
 */
public class PileCartes implements Pile
{
    //Création d'un vecteurs qui va contenir nos objets Carte.
    Vector m_conteneur;
    //Création d'un objet lecteurCarte necessaire au lancement de sa méthode lecture.
    lecteurCarte monLecteur;
	
    public PileCartes() {
        Vector vect = new Vector();
        m_conteneur = vect;
    }

    @Override
    public boolean estVide() {
        return m_conteneur.isEmpty();
    }

    @Override
    public void empiler(Carte c) {
        m_conteneur.addElement(c);
    }
	
    @Override
    public Carte sommet() {
        if(m_conteneur.isEmpty() == false)
	return (Carte) m_conteneur.lastElement();
        else
            return null;
    }

    @Override
    public void depiler(){
        m_conteneur.remove(m_conteneur.lastElement());
    }

    @Override
    public void viderPile() {
        m_conteneur.removeAllElements();
    }
    
    @Override
    public void remplirPile() {
        //C'est ici que l'on va appeler le lecteur de cartes.
        //On va parcourir le repertoire contenant les fichiers cartes à l'aide de l'objet File.
        //On va lire chaque fichier et empiler en fonction de la période.
        
        
        //Instanciation de l'objet lecteurCarte.
        monLecteur = new lecteurCarte();
        //Création d'un objet Carte necessaire à l'appel des fonctions Cartes (notamment getPeriode).
        Carte maCarte;
        //Création d'un objet File pour stocker le nom du rep et le parcourir.
        File fichier = new File("cartes");
        //Tableau de File pour stocker les noms des cartes.
        File[] fichiers = fichier.listFiles();
        
        //Instanciation des trois String de periode necessaire à la comparaison
        //avec getPeriodeCarte.
        String matin = "Matin";
        String soir = "Soir";
        String apresmidi = "Apres-midi";
        
        //Tant que l'on trouve des fichier dans le repertoire, on lit les noms de fichiers.
        //On appel le lecteur qui va initialiser les cartes. 
        //Appel à la méthode getPeriodeCarte pour empiler selon la période.
        
        //Algorithmiquement :
        //On parcours 3 fois le repertoire, pour remplir chaque periode (matin, midi, soir)
        //Debut boucle
        //  1ere fois debut boucle : si periode = Matin, on empile, sinon, on continue. --> Sortie de boucle.
        //  2ieme fois debut boucle : Si periode = Apres-midi, on empile, sinon on continue --> Sortie de boucle.
        //  3ieme fois debut boucle : Si periode = Soir, on empile, sinon on continue --> sortie de boucle.
        //Sortie de boucle.
        for(int i = 0; i<3; i++){
            //Remplissage période = Matin.
            if(fichiers !=  null) {
                for(int compteurFichier = 0; compteurFichier < fichiers.length; compteurFichier++) {
                    String nomFichier = fichiers[compteurFichier].getPath();    //C'est sale ...
                    monLecteur.lecture(nomFichier);
                    maCarte = monLecteur.getCarte();
                    
                    if(matin.equals(maCarte.getPeriode())){
                        empiler(monLecteur.getCarte());
                    }
                    else
                        continue;
                    }
            }
            //Remplissage période = apres-midi
            if(fichiers !=  null) {
                for(int compteurFichier = 0; compteurFichier < fichiers.length; compteurFichier++) {
                    String nomFichier = fichiers[compteurFichier].getPath();    //C'est sale ...
                    monLecteur.lecture(nomFichier);
                    maCarte = monLecteur.getCarte();
                    
                    if(apresmidi.equals(maCarte.getPeriode())){
                        empiler(monLecteur.getCarte());
                    }
                    else
                        continue;
                    }
            }
            //Remplissage période = soir
            if(fichiers !=  null) {
                for(int compteurFichier = 0; compteurFichier < fichiers.length; compteurFichier++) {
                    String nomFichier = fichiers[compteurFichier].getPath();    //C'est sale ...
                    monLecteur.lecture(nomFichier);
                    maCarte = monLecteur.getCarte();
                    
                    if(soir.equals(maCarte.getPeriode())){
                        empiler(monLecteur.getCarte());
                    }
                    else
                        continue;
                    }
            }
            
        }
        
    }

}
