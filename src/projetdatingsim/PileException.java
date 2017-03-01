/*
 * Antoine Legoubé
 * Licence professionnel Logiciels Libres
 * PROJET Dating Sim pour M. Traverson
 * Merci au site d'apprentissage https://www.openclassrooms.com, et aux cours de M. Traverson
 * Ainsi qu'aux nombreux forums apportant des réponses sur internet.
 */
package projetdatingsim;

/**
 *
 * @author Antoine Legoubé
 */
public class PileException extends Exception{
    
    //Déclaration d'exception basique pour la pile vide...
    public PileException() {
        super("ERREUR : pile vide ...");
    }
}
