package co.trystan;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Jeu {

    String[] motADeviner = {"ninja", "shuriken", "ninjustsu"};
    String[] motCache;
    String[] pourComparer;
    String entrerUneLettre;
    Scanner scan = new Scanner(System.in);
    int random = 0;
    int pVRestant = 8;
    
    public void debut() {
        System.out.println("Vous allez maintenant prendre part au jeu du pendu !!");
        System.out.println("Trouve les lettres manquantes avant la fin sinon ...");
    }

    public void leNomDuJoueur() {
        System.out.println("Quel est ton nom ?");
    
        Scanner scan = new Scanner(System.in);
        String entreeScan = scan.nextLine();

        Joueur joueur1 = new Joueur();
        joueur1.creationNom(entreeScan);

        System.out.println("Bienvenue à vous " + joueur1.nom + " !");
    }

    public String choixDuMot() {
        this.random = new Random().nextInt(motADeviner.length);
        return motADeviner[random];
    }  
    
    // 

    public void masquageDuMot() {
        motCache = this.choixDuMot().split("");
        //System.out.println(Arrays.toString(motCache));

        System.out.println("Voici le mot mystère :");

        for (int i = 0; i < motCache.length; i++) {
            motCache[i] = "_";
        }
        System.out.println(Arrays.toString(motCache));
        
    }

    public void tableauPourComparer() {
        pourComparer = this.motADeviner[random].split("");
        //System.out.println(Arrays.toString(pourComparer));
    }

    public String choisirUneLettre(){
        entrerUneLettre = scan.next(); 
        return entrerUneLettre;  
    }

    public void jouerUneLettre() {
        boolean bonneReponse = false;

        for (int i = 0; i < motADeviner.length; i++) {
            try {
                if (entrerUneLettre.equals(motADeviner[i])) {
                    bonneReponse = true;
                    this.motCache[i] = this.pourComparer[i];
                    System.out.println("bien joué ! continuons");
                    System.out.println(Arrays.toString(motCache));
                    return;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                
            }
            
        }
        if( bonneReponse == false) {
            System.out.println("C'est raté !");
            this.pVRestant--;
                if(pVRestant == 0){
                    System.out.println("PENDU");
                    System.out.println("");
                    System.out.println("|  DEAD  |");
                    System.out.println("|  X  X  |");
                    System.out.println("|  ----  |");
                    
                }else{
                    System.out.println("plus que " + this.pVRestant + " pv. Choisissez une autre lettre :");
                }
        }
    }

    public void recommencer() {
        
        while (this.motCache != this.pourComparer) {
            victoire();
            choisirUneLettre();
            jouerUneLettre();

        }
    }

    public void victoire() {
        
        if (Arrays.equals(this.motCache, this.pourComparer)) {
            try {
                System.out.println("Félicitation ! vous avez gagné !");
                scan.close();
            } catch (IllegalStateException e) {
                System.out.println("Je sais que ce fut un moment intense, mais voulez-vous rejouer ?");
            }
        }
    }
}