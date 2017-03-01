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

public class PretendantAmi extends Pretendant{
    
    private String numero;
    private String signe;
    private int m_nbPoints;

    public PretendantAmi() { }

    @Override
    void rendezVous() {
        System.out.println("Rendez-vous avec les amis");
        try {
            Moteur.chargerFinDeJeuxRdv();
        } catch (PileException ex) {
            Logger.getLogger(PretendantAmi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    void evolutionRelation(String nbPointsChaine) {
                
        //Si le nb de points du prétendant est supérieur ou égal à 100, alors : 
        if(m_nbPoints < 100) {
            //Initialisation du signe (+ ou -) et du nombre de points.
            signe = nbPointsChaine.substring(0, 1);
            numero = nbPointsChaine.substring(1, 3);
            int pointsAjouEnlev = Integer.parseInt(numero);
            
            //Si le signe est positif, alors on ajoute des points pour le prétendant.
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
