/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetdatingsim;
/**
 *
 * @author Antoine LEGOUBE
 */
public class Carte {
    //Creation des attributs où l'on viendra stocker les différents paramètres d'une cartes.
    private String m_actionGauche;
    private String m_actionDroit;
    private String m_periode;
    private String m_activite;
    private String m_message;
    private String m_pretendant;
    private String m_carteSuivante;
    private String m_nbPointsGauche;  //Nombre de points qu'apporte (positif ou negatif) l'action gauche.
    private String m_nbPointsDroit;    //Nombre de points qu'apporte (positif ou negatif) l'action droite.
    
    /*String actionGauche, String actionDroit, String periode, String activite, String message, String pretendant,
            String carteSuivante, int nbPointsGauche, int nbPointsDroit*/
    Carte (String tableauCarte[]){
        m_actionGauche = tableauCarte[0];
        m_actionDroit = tableauCarte[1];
        m_periode = tableauCarte[2];
        m_activite = tableauCarte[3];
        m_message = tableauCarte[4];
        m_pretendant = tableauCarte[5];
        m_carteSuivante = tableauCarte[6];
        m_nbPointsGauche = tableauCarte[7];
        m_nbPointsDroit = tableauCarte[8];
    } 

    public void afficheActionGauche(){
        System.out.println(m_actionGauche);
    }
    
    public String getPeriode(){
        return m_periode;
    }
    
    /*public void actionLancee(int selectAction){
        if(selectAction == 1)
        {
            
        }
    }*/
    
    //abstract void rendezVous();
    //abstract void evolutionRelation(); 
}
