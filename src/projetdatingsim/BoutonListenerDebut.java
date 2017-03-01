/*
 * Antoine Legoubé
 * Licence professionnel Logiciels Libres
 * PROJET Dating Sim pour M. Traverson
 * Merci au site d'apprentissage https://www.openclassrooms.com, et aux cours de M. Traverson
 * Ainsi qu'aux nombreux forums apportant des réponses sur internet.
 */
package projetdatingsim;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Antoine Legoubé
 */
public class BoutonListenerDebut implements ActionListener{
    
    @Override
    public void actionPerformed(ActionEvent actionBt) {
        try {
            Moteur.setInterface();
            Moteur.setPanelPrincipal();
            Moteur.chargerInterfaceJeux();
            
        } catch (IOException ex) {
            Logger.getLogger(BoutonListenerDroit.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PileException ex) {
            Logger.getLogger(BoutonListenerDebut.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
