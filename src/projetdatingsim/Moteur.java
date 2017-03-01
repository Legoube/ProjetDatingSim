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
import java.io.IOException;

public class Moteur {

    private static PileCartes m_maPileCartes;
    public static FenetreGraphique m_fG;
    private static PretendantAmi m_mesAmis;
    private static PretendantFourbe m_mesFourbes;
    private static PretendantInconnu m_mesInconnu;
    
    Moteur(FenetreGraphique fG) throws IOException{
        m_fG = fG;
    }

//-->Méthodes de gestions d'interfaces
    public static void setInterface() throws IOException, PileException {
        //Appel à toute les méthode necessaire pour la mise en place d'une fenetre.
        //période - activite - message - message du boutongauche - message du bouton droit
        m_fG.setLabelPeriode(m_maPileCartes.sommet().getPeriode());
        m_fG.setLabelActivite(m_maPileCartes.sommet().getActivite());
        m_fG.setLabelPretendant(m_maPileCartes.sommet().getPretendant());
        if(m_maPileCartes.sommet().getTypePretendant().equals("Ami")) {
            m_fG.setLabelnbPoints(m_mesAmis.getNbPoints());
        }
        if(m_maPileCartes.sommet().getTypePretendant().equals("Fourbe")) {
            m_fG.setLabelnbPoints(m_mesFourbes.getNbPoints());
        }
        if(m_maPileCartes.sommet().getTypePretendant().equals("Inconnu")) {
            m_fG.setLabelnbPoints(m_mesInconnu.getNbPoints());
        }
        m_fG.setLabelImage(m_maPileCartes.sommet().getPretendant());
        m_fG.setLabelMessage(m_maPileCartes.sommet().getMessage());
        m_fG.setButDroit(m_maPileCartes.sommet().getActionDroit());
        m_fG.setButGauche(m_maPileCartes.sommet().getActionGauche());
    }
    public static void setPanelPrincipal() {
        m_fG.setPanel();
    }
    public static void setInterfaceDebutJeux() throws IOException {
        //Setting de l'interface de début de jeux...
        //Remplissage de la pile.
        //Instanciation d'objets mesAmi / mesFourbe / mesInconnu
        m_fG.setPanelDebutDeJeux();
        m_fG.ajouterBoutonListener();

        m_mesAmis = new PretendantAmi();
        m_mesFourbes = new PretendantFourbe();
        m_mesInconnu = new PretendantInconnu();

        m_maPileCartes = new PileCartes();
        m_maPileCartes.remplirPile();
        
        
    }
    public static void chargerInterfaceJeux() {
        m_fG.changerPanelDebut();
    }
    public static void chargerFinDeJeuxPile() {
        m_fG.setLabelFinalImgPile();
        m_fG.setLabelFinalMessPile();
        m_fG.setPanelFinDeJeux();
        m_fG.changerPanelFinPile();
    }
    public static void chargerFinDeJeuxRdv() throws PileException {
        m_maPileCartes.depiler();
        m_fG.setPanelFinRendVous(m_maPileCartes.sommet().getPretendant());
        m_fG.changerPanelFinRdv();
    }
    
//-->Methodes de gestion de la pile
    public static void depilerPile() throws PileException {
        m_maPileCartes.depiler();
    }
    public static boolean pileVide() {
        return m_maPileCartes.estVide();
    }
    public PileCartes getMaPileCartes() {
        return m_maPileCartes;
    }
    public static String getNbPointsGauche() throws PileException {
        return m_maPileCartes.sommet().getNbPointsGauche();
    }
    public static String getNbPointsDroit() throws PileException {
        return m_maPileCartes.sommet().getNbPointsDroit();
    }
    public static void empilerCarteSuivante() throws PileException {
        m_maPileCartes.empilerCarteSuivante(m_maPileCartes.sommet().getCarteSuivante());
    }
    public static void viderLaPile() throws PileException {
        m_maPileCartes.viderPile();
    }
    
//-->Methode d'action pour le bouton droit et gauche.
    //Si le prétendant est un ami, alors on lance la méthode 'actionLancee' de notre objet 'm_mesAmis'.
    //Si le prétendant est un Fourbe, on lance la méthode 'actionLancee' de notre 'm_mesFourbes'.
    //Si le prétendant est un Inconnu, on lance la méthode 'actionLancee' de notre 'm_mesInconnu'.
    public static void lancerActionDroite() throws PileException {
        switch(m_maPileCartes.sommet().getTypePretendant()) {
            case "Ami" :
                m_maPileCartes.sommet().actionLancee(false, m_mesAmis);
                break;
            case "Fourbe" :
                m_maPileCartes.sommet().actionLancee(false, m_mesFourbes);
                break;
            case "Inconnu" :
                m_maPileCartes.sommet().actionLancee(false, m_mesInconnu);
                break;
        }
    }
    public static void lancerActionGauche() throws PileException {
        switch(m_maPileCartes.sommet().getTypePretendant()) {
            case "Ami" :
                m_maPileCartes.sommet().actionLancee(true, m_mesAmis);
                break;
            case "Fourbe" :
                m_maPileCartes.sommet().actionLancee(true, m_mesFourbes);
                break;
            case "Inconnu" :
                m_maPileCartes.sommet().actionLancee(true, m_mesInconnu);
                break;
        }
    }
}