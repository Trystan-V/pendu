package co.trystan;

import java.util.*;
import java.util.Random;

public class Mot {
    String[] motADeviner = {"ninja", "shuriken"};
    String[] motCache;
    String[] pourComparer;
    int random = 0;

    //tirage au sort du mot
    public Mot() {
        
    }

    public String choixDuMot() {
        this.random = new Random().nextInt(motADeviner.length);
        return motADeviner[random];
    }  
    
    // 

    public void masquageDuMot() {
        motCache = this.choixDuMot().split("");
        System.out.println(Arrays.toString(motCache));

        System.out.println("Voici le mot mystère :");

        for (int i = 0; i < motCache.length; i++) {
            motCache[i] = "_";
        }
        System.out.println(Arrays.toString(motCache));
        
    }

    public void tableauPourComparer() {
        pourComparer = this.motADeviner[random].split("");
        System.out.println(Arrays.toString(pourComparer));
    }
}