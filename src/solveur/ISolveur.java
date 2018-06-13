package solveur;

/**
 *
 * Interface pour l'implementation d'un solveur.
 * @author KAM-WAL
 * @author AKALA Kouma
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
     * @throws IllegalArgumentException si la grille à résoudre n'est pas
     * valable ou si aucune solution n'a pu être calculée
     * @return true si une solution est disponible, false sinon
     */
    boolean resoudre();

    /**
     * Verifie si la grille est resolue.
     *
     * @throws IllegalArgumentException si la grille non valide
     * @return true si la grille est resolue, false sinon
     */
    boolean resolu();

    /**
     * Affiche la solution trouvee a la grille.
     */
    void afficherSolution();
}