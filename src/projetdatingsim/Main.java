package projetdatingsim;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
    System.out.println("hello");
    
    PileCartes maPileCartes = new PileCartes();
    
    maPileCartes.remplirPile();
    
    System.out.println(maPileCartes.sommet().getPeriode());
    maPileCartes.sommet().afficheActionGauche();
    maPileCartes.depiler();
    System.out.println(maPileCartes.sommet().getPeriode());
    maPileCartes.sommet().afficheActionGauche();

    }
}