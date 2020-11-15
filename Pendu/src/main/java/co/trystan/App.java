package co.trystan;


/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        //System.out.println("Hello World!");
    Jeu jeu = new Jeu();
    jeu.leNomDuJoueur();
    jeu.debut();
    jeu.choixDuMot();
    jeu.masquageDuMot();
    jeu.tableauPourComparer();
    jeu.choisirUneLettre(); 
    jeu.jouerUneLettre();
    jeu.recommencer();
    jeu.victoire();

    }


}
