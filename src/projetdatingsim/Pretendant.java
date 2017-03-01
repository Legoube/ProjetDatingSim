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

public abstract class Pretendant {
    

    Pretendant() {
    }
    
    abstract void rendezVous();
    abstract void evolutionRelation(String nbPointsChaine);
}