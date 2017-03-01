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
public class CarteBuilder {
        
    CarteBuilder(String[] tableauCarte, PileCartes pile) { 
        if(tableauCarte[0].equals("Classique")) {
            pile.empiler(new CarteClassique(tableauCarte));
        }
        if(tableauCarte[0].equals("Oublie")) {
            pile.empiler(new CarteOublie(tableauCarte));
        }
        if(tableauCarte[0].equals("Suite")) {
            pile.empiler(new CarteSuite(tableauCarte));
        }
    } 
}
