package solveur;

/**
 *
 * Interface pour l'implementation d'un solveur.
 * @author KAM-WAL
 *
 */
public interface ISolveur {

    /**
     * Teste la validite de la grille.
     *
     * @return true si la grille est valide, false sinon
     */
    boolean verifierGrille();

    /**
     * Resoud la grille passee en parametre.
     *
     */
    boolean resoudre();

    /**
     * Verifie si la grille est resolue.
     *
     */
    boolean resolu();

    /**
     * Affiche la solution trouvee a la grille.
     */
    void afficherSolution();
}
