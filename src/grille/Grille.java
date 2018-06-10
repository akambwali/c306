package grille;

/**
 * Interface d'une grille de sudoku.
 * @author KAM-WAL
 *
 */
public interface Grille {

    /**
     * Caractere de case vide.
     */
    char EMPTY = '@';

    /**
     * Caracteres possibles a mettre dans la grille.
     * pour une grille 9x9 : 1..9
     */
    char[] POSSIBLE_9 = new char[]{
        '1', '2', '3', '4', '5', '6', '7', '8', '9'
    };

    /**
     * Caracteres possibles a mettre dans la grille.
     * pour une grille 16x16 : 0..9-a..f
     */
    char[] POSSIBLE_16 = new char[]{
        '1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
        'a', 'b', 'c', 'd', 'e', 'f'
    };

    /**
     * Pour definir la grille sous forme de tableau a 2 dimensions.
     *
     * @param grilleTab char[9][9] contenant les valeurs
     *
     */
    void setGrille(char[][] grilleTab);

    /**
     * Permet d'avoir la dimension d'une grille Sudoku.
     *
     * @return Dimension de la grille.
     */
    int getDimension();

    /**
     * Affecte une valeur dans la grille.
     *
     *
     */
    void setValue(int x, int y, char value) throws IllegalArgumentException;

    /**
     * Recupere une valeur de la grille.
     *
     */
    char getValue(int x, int y) throws IllegalArgumentException;

    /**
     * Teste si une grille est terminee.
     *
     * @return true si la grille est complete
     *
     */
    boolean complete();

    /**
     * Teste si une valeur est possible dans la grille par rapport a ce qu'elle
     * contient deja.
     *
     *
     */
    boolean possible(int x, int y, char value) throws IllegalArgumentException;

}
