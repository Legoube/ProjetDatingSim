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

import java.util.Vector;
import java.io.*;
import java.util.Random;
import java.util.function.Predicate;

public class PileCartes implements Pile
{
    //Création d'un vecteurs qui va contenir nos objets Carte.
    Vector m_conteneur;
    //Création d'un objet lecteurCarte necessaire au lancement de sa méthode lecture.
    lecteurCarte monLecteur;
    //Création d'un objet carte pour l'insertion dans la pile.
    Carte m_carte;
    //création d'un builder de carte pour l'insertion de carte Typées.
    CarteBuilder m_monBuilder;
	
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
        m_carte = c;
        m_conteneur.addElement(c);
    }
    @Override
    public void empilerCarteSuivante(String carteSuivante) {
        //Instanciation de l'objet lecteurCarte.
        monLecteur = new lecteurCarte();
        //Création d'un objet File pour stocker le nom du rep et le parcourir.
        File fichier = new File("cartes");
        //Tableau de File pour stocker les noms des cartes.
        File[] fichiers = fichier.listFiles();
        
        if(fichiers !=  null) {
            int i = 0;
            while(!fichiers[i].getName().equals(carteSuivante)){
                i = i + 1;
                }
            m_monBuilder = new CarteBuilder(monLecteur.lecture(fichiers[i].getPath()), this);
        }
    }
    

    @Override
    public void depilerPretendant(final String monPretendant) throws PileException {
        
    //GESTION de dépilage d'un pretendant : 
    //Si le prétendant passé en param correspond au prétendant de la carte.
    //Alors, on supprime toutes les cartes correpondant à ce pretendant.
        m_conteneur.removeIf(new Predicate<Carte>() {
                @Override
                public boolean test(Carte c) {
                    return c.pretendant(monPretendant);
                }
            } );
        }

    @Override
    public Carte sommet() throws PileException {
        if(m_conteneur.isEmpty() == false)
	return (Carte) m_conteneur.lastElement();
        else
            return null;
    }
    public Carte carteA( int i ) {
        if(m_conteneur.isEmpty()==false)
            return(Carte) m_conteneur.elementAt(i);
        else
            return null;
    }

    @Override
    public void depiler() throws PileException {
        m_conteneur.remove(m_conteneur.lastElement());
    }

    @Override
    public void viderPile() throws PileException {
        m_conteneur.removeAllElements();
    }
    public boolean carteExist(String activite) {
        
        boolean carteExiste = false;
        
        for(int i = 0; i < m_conteneur.size(); i++) {
            if(activite.equals(this.carteA(i).getActivite()))
                carteExiste = true;
        }
        return carteExiste;
    }

    @Override
    public void remplirPile() {
        
        //Instanciation de l'objet lecteurCarte.
        monLecteur = new lecteurCarte();
        
        //Création d'objets File pour stocker le nom des repertoires.
        File dossierMatin = new File("cartes/carteMatin");
        File dossierApres = new File("cartes/carteApres");
        File dossierSoir = new File("cartes/carteSoir");
        
        //Tableau de File pour stocker les noms des fichiers.
        File[] fichiersMat = dossierMatin.listFiles();
        File[] fichierApre = dossierApres.listFiles();
        File[] fichierSoir = dossierSoir.listFiles();
        
        
        //INFO : 
        //Tant que l'on trouve des fichier dans le repertoire, on lit les noms de fichiers.
        //On appel le lecteur qui va initialiser les cartes. 
        
        //GENERATION ALEATOIRE :
        //Génération d'un nombre aléatoire, entre 0 et le nombre de fichiers présents dans le dossier.
        //On passe se nombre à la liste de fichier (un tableau en fait).
        //Cela selectionne le nom d'un fichiers aléatoire présent dans le dossier de carte.
        
        //ALGORiTHMIQUE :
        //Tant que le répertoire n'est pas entièrement analysé :
        //Génération d'un nombre alétoire (sert d'indice à la liste des fichiers du rep exemple : fichierSoir[]).
        //  --> Si la carte à insérer n'existe pas dans la PileCarte
        //      --> On insère.
       
        int compteurFichier1 = 0;
            //Remplissage période = soir
            if(fichierSoir !=  null) {
                
                while(compteurFichier1 != fichierSoir.length){
                    //Generation de nombre aleatoire
                    Random randGen = new Random();
                    int valMax = fichierSoir.length;
                    int valRand = randGen.nextInt(valMax);
                    
                    String nomFichier = fichierSoir[valRand].getPath();
                    String[] paramCarte = monLecteur.lecture(nomFichier);
                    
                    if(this.carteExist(paramCarte[4]) == false) {
                        m_monBuilder = new CarteBuilder(monLecteur.lecture(nomFichier), this);
                        compteurFichier1 = compteurFichier1 + 1;
                    }
                }
            }
            compteurFichier1 = 0;
            //Remplissage période = Apres-midi
            if(fichierApre !=  null) {

                while(compteurFichier1 != fichierApre.length){
                    //Generation de nombre aleatoire
                    Random randGen = new Random();
                    int valMax = fichierApre.length;
                    int valRand = randGen.nextInt(valMax);

                    String nomFichier = fichierApre[valRand].getPath();
                    String[] paramCarte = monLecteur.lecture(nomFichier);
                    
                    if(this.carteExist(paramCarte[4]) == false) {
                        m_monBuilder = new CarteBuilder(monLecteur.lecture(nomFichier), this);
                        compteurFichier1 = compteurFichier1 + 1;
                    }
                }
            }
            compteurFichier1 = 0;
            //Remplissage période = Matin
            if(fichiersMat !=  null) {

                while(compteurFichier1 != fichiersMat.length){
                    //Generation de nombre aleatoire
                    Random randGen = new Random();
                    int valMax = fichiersMat.length;
                    int valRand = randGen.nextInt(valMax);

                    String nomFichier = fichiersMat[valRand].getPath();
                    String[] paramCarte = monLecteur.lecture(nomFichier);
                    
                    if(this.carteExist(paramCarte[4]) == false) {
                        m_monBuilder = new CarteBuilder(monLecteur.lecture(nomFichier), this);
                        compteurFichier1 = compteurFichier1 + 1;
                    }
                }
            }
    }
}
