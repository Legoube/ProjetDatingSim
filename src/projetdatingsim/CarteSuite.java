/*
 * Antoine Legoubé
 * Licence professionnel Logiciels Libres
 * PROJET Dating Sim pour M. Traverson
 * Merci au site d'apprentissage https://www.openclassrooms.com, et aux cours de M. Traverson
 * Ainsi qu'aux nombreux forums apportant des réponses sur internet.
 */
package projetdatingsim;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Antoine LEGOUBE
 */

public class CarteSuite extends Carte{
    
    private final String m_typeCarte;
    
    public CarteSuite(String[] tableauCarte) {
        super(tableauCarte);
        m_typeCarte = tableauCarte[0];
    }

    //Methode d'appel à aux méthode 'evolutionRelation' des prétendants concernés.
    //Pour ce type de carte 'Suite', on ajoute, après l'action, en haut de la pile, la carte suivante.
    //Ce type de carte correspond en fait à une discussion, ou une série d'evenements liés.
    @Override
    void actionLancee(boolean actionChoisie, Pretendant monPret) {
        if(actionChoisie == true){
            try {
                monPret.evolutionRelation(Moteur.getNbPointsGauche());
                Moteur.empilerCarteSuivante();
            } catch (PileException ex) {
                Logger.getLogger(CarteSuite.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
        if(actionChoisie == false) {
            try {
                monPret.evolutionRelation(Moteur.getNbPointsDroit());
            } catch (PileException ex) {
                Logger.getLogger(CarteSuite.class.getName()).log(Level.SEVERE, null, ex);
            }
        }           
    }
    
}
