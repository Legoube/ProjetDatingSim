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

public class PretendantFourbe extends Pretendant{
    
    private int m_nbPoints;
    private String signe;
    private String numero;
    
    public PretendantFourbe() { }

    @Override
    void rendezVous() {
        System.out.println("Bien joué ! Rendez-vous avec les Fourbes.");
        try {
            Moteur.chargerFinDeJeuxRdv();
        } catch (PileException ex) {
            Logger.getLogger(PretendantFourbe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    void evolutionRelation(String nbPointsChaine) {
        
        //Si le nb de points du prétendant est supérieur ou égal à 100 alors :
        if(m_nbPoints < 100) {
            //Initialisation du signe (+ ou -) et du nombre de points.
            signe = nbPointsChaine.substring(0, 1);
            numero = nbPointsChaine.substring(1, 3);
            int pointsAjouEnlev = Integer.parseInt(numero);
            
            switch(signe) {
                case "+" :
                    m_nbPoints = m_nbPoints + pointsAjouEnlev;
                    break;
                case "-" :
                    m_nbPoints = m_nbPoints - pointsAjouEnlev;
                    break;
            }
            
        }
        //Sinon, on appel la méthode rendez-vous.
        else {
            this.rendezVous();
        }
    }
    public int getNbPoints() {
        return m_nbPoints;
    }
}
