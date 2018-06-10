package solveur;

import grille.Grille;
import grille.GrilleImpl;

/**
 *
 * Classe d'implementation de l'interface solveur.
 * @author KAM-WAL
 *
 */
public final class SolveurImpl implements ISolveur {

    /**
     * Grille de Sudoku.
     */
    private GrilleImpl grille;

    /**
     * Constructeur de la classe.
     *
     * @param newgrille GrilleImpl
     */
    public SolveurImpl(final GrilleImpl newgrille) {
        this.grille = newgrille;
    }

    /**
     * Verifier la validite de la grille.
     *
     */
    public boolean verifierGrille() {
        char[][] grillecontent = grille.getGrille().clone();
        int dimension;
        dimension = grille.getDimension();
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (grillecontent[i][j] != Grille.EMPTY) {
                    char tmp = grillecontent[i][j];
                    grillecontent[i][j] = Grille.EMPTY;
                    try {
                        if (!grille.possible(i, j, tmp)) {
                            return false;
                        }
                    } catch (IllegalArgumentException e) {
                        return false;
                    }
                    grillecontent[i][j] = tmp;
                }
            }
        }
        return true;
    }

    /**
     * Resolution de la grille de Sudoku.
     *
     */
    public boolean resoudre() {
        int dimension;
        dimension = grille.getDimension();
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (grille.getGrille()[i][j] == GrilleImpl.EMPTY) {
                for (int k = 0; k < dimension; k = k + 1) {
                    char val = Grille.POSSIBLE_9[k];
                        try {
                            grille.setValue(i + 1, j + 1, val);
                            if (resoudre()) {
                                return true;
                            }
                        } catch (IllegalArgumentException ex) {
                            System.out.println("Erreur. Valeur non valide.");
                        }
                }
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Verification de la resolution de la grille.
     *
     */
    public boolean resolu() {
        if (!verifierGrille()) {
            throw new IllegalArgumentException("Grille non valide.");
        }
        return true;
    }

    /**
     * Affichage de la grille complete apres reolution.
     */
    public void afficherSolution() {
        int part = 3;
        int dimension;
        dimension = grille.getDimension();
        for (int i = 0; i < dimension; ++i) {
            if (i % part == 0) {
                System.out.println(" -----------------------");
            }
            for (int j = 0; j < dimension; ++j) {
                if (j % part == 0) {
                    System.out.print("| ");
                }
                System.out.print(grille.getGrille()[i][j]);
                System.out.print(' ');
            }
            System.out.println("|");
        }
        System.out.println(" -----------------------");
    }

}
