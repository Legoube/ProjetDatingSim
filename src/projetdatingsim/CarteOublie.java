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

public class CarteOublie extends Carte{
    
    private final String m_typeCarte;
    
    public CarteOublie(String[] tableauCarte) {
        super(tableauCarte);
        m_typeCarte = tableauCarte[0];
    }

    //Methode d'appel à aux méthode 'evolutionRelation' des prétendants concernés.
    //Pour ce type de carte 'Oublie', si l'action choisi est l'action de gauche (soit le boolean true)
    //Alors on dépile la prochaine carte, car on considère que l'on ne se souvient plus de notre prochaine action,
    //du à un état second...
    @Override
    void actionLancee(boolean actionChoisie, Pretendant monPret) {
        if(actionChoisie == true){
            try {
                monPret.evolutionRelation(Moteur.getNbPointsGauche());
                Moteur.depilerPile();
            } catch (PileException ex) {
                Logger.getLogger(CarteOublie.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        if(actionChoisie == false) {
            try {
                monPret.evolutionRelation(Moteur.getNbPointsDroit());
            } catch (PileException ex) {
                Logger.getLogger(CarteOublie.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
