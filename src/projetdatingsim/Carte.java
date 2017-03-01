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

public abstract class Carte {
    //Creation des attributs où l'on viendra stocker les différents paramètres d'une cartes.
    private final String m_actionGauche;
    private final String m_actionDroit;
    private final String m_periode;
    private final String m_activite;
    private final String m_message;
    private final String m_pretendant;
    private final String m_typePretendant;
    private final String m_carteSuivante;
    private final String m_nbPointsGauche;  //Nombre de points qu'apporte (positif ou negatif) l'action gauche.
    private final String m_nbPointsDroit;    //Nombre de points qu'apporte (positif ou negatif) l'action droite.
    
    /*String actionGauche, String actionDroit, String periode, String activite, String message, String pretendant,
            String carteSuivante, int nbPointsGauche, int nbPointsDroit*/
    Carte (String tableauCarte[]){
        m_actionGauche = tableauCarte[1];
        m_actionDroit = tableauCarte[2];
        m_periode = tableauCarte[3];
        m_activite = tableauCarte[4];
        m_message = tableauCarte[5];
        m_pretendant = tableauCarte[6];
        m_typePretendant = tableauCarte[7];
        m_carteSuivante = tableauCarte[8];
        m_nbPointsGauche = tableauCarte[9];
        m_nbPointsDroit = tableauCarte[10];
    } 

    public void afficheActionGauche(){
        System.out.println(m_actionGauche);
    }
    public String getPeriode(){
        return m_periode;
    }
    public String getPretendant(){
        return m_pretendant;
    }
    public String getActionGauche(){
        return m_actionGauche;
    }
    public String getActionDroit(){
        return m_actionDroit;
    }
    public String getActivite() {
        return m_activite;
    }
    public String getMessage() {
        return m_message;
    } 
    public String getTypePretendant() {
        return m_typePretendant;
    }
    public String getNbPointsGauche(){
        return m_nbPointsGauche;
    }
    public String getNbPointsDroit(){
        return m_nbPointsDroit;
    }
    public String getCarteSuivante() {
        return m_carteSuivante;
    }
    
    
    //Methode utilisé pour retirer, dans la pile, toute les cartes relatives à un prétendant précis.
    public boolean pretendant(String lePretendant){
        if(lePretendant.equals(m_pretendant)){
            return true;
        }
        else return false;
    }
    abstract void actionLancee(boolean actionChoisie, Pretendant monPret);    
}
