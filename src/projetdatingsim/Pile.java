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

public interface Pile {
    /* 
    * méthodes abstraites de gestion d'une pile 
    * */
    public boolean estVide();
    public void empiler (Carte c);
    public Carte sommet() throws PileException;
    public void depiler() throws PileException;
    public void viderPile() throws PileException;
    public void remplirPile();
    public void depilerPretendant(String monPretendant) throws PileException;
    public void empilerCarteSuivante(String carteSuivante);
}
