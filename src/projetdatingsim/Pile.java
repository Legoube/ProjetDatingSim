/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetdatingsim;

/**
 *
 * @author Antoine Legoube
 */
public interface Pile {
    /* 
    * méthodes abstraites de gestion d'une pile 
    * */
    public boolean estVide();
    public void empiler (Carte c);
    public Carte sommet();
    public void depiler();
    public void viderPile();
    public void remplirPile();
    
}
