package solveur;

import static org.junit.Assert.*;

import org.junit.Test;

import grille.GrilleImpl;

/**
 *
 * Classe de test du solveur de grille.
 *
 * @author KAM-WAL
 * @author AKALA Kouma
 *
 */
public final class SolveurTest {

    /**
     * Grille correcte.
     */
    private static final char[][] GRILLE_CORRECTE
            = {{'5', '3', '4', '6', '7', '8', '9', '1', '2'},
            {'6', '7', '2', '1', '9', '5', '3', '4', '8'},
            {'1', '9', '8', '3', '4', '2', '5', '6', '7'},
            {'8', '5', '9', '7', '6', '1', '4', '2', '3'},
            {'4', '2', '6', '8', '5', '3', '7', '9', '1'},
            {'7', '1', '3', '9', '2', '4', '8', '5', '6'},
            {'9', '6', '1', '5', '3', '7', '2', '8', '4'},
            {'2', '8', '7', '4', '1', '9', '6', '3', '5'},
            {'3', '4', '5', '2', '8', '6', '1', '7', '9'}};

    /**
     * Grille incorrecte. 5 est présent 2 fois sur la première colonne.
     */
    private static final char[][] GRILLE_INCORRECTE
            = {{'5', '3', '4', '6', '7', '8', '9', '1', '2'},
            {'6', '7', '2', '1', '9', '5', '3', '4', '8'},
            {'5', '9', '8', '3', '4', '2', '5', '2', '7'},
            {'8', '5', '9', '7', '6', '1', '4', '2', '3'},
            {'4', '2', '6', '8', '5', '3', '7', '9', '1'},
            {'7', '1', '3', '9', '2', '4', '8', '5', '6'},
            {'9', '6', '1', '5', '3', '7', '2', '8', '4'},
            {'2', '8', '7', '4', '1', '9', '6', '3', '5'},
            {'3', '4', '5', '2', '8', '6', '1', '7', '9'}};

    /**
     * Grille incorrecte.
     * 2 est présent 2 fois sur la troisième ligne.
     * Des caractères non autorisés sont présents dans la grille (x, g).
     */
    private static final char[][] GRILLE_INCORRECTE_2
            = {{'5', '3', '4', '6', '7', '8', '9', '1', '2', 'x'},
            {'6', '7', '2', '1', '9', '5', '3', '4', '8', '1'},
            {'5', '9', '8', '3', '4', '2', '5', '2', '7', 't'},
            {'8', '5', '9', '7', '6', '1', '4', '2', '3', '5'},
            {'4', '2', '6', '8', '5', '3', '7', '9', '1', '5'},
            {'7', '1', '3', '9', '2', '4', '8', '5', '6', 'g'},
            {'9', '6', '1', '5', '3', '7', '2', '8', '4', '1'},
            {'2', '8', '7', '4', '1', '9', '6', '3', '5', '2'},
            {'3', '4', '5', '2', '8', '6', '1', '7', '9', '9'}};

    /**
     * Grille incorrecte. T et X présents dans la grille.
     */
    private static final char[][] GRILLE_INCORRECTE_3
            = {{'X', 'T', '4', '6', '7', '8', '9', '1', '2'},
            {'X', '7', '@', '1', '9', '5', '3', '4', '8'},
            {'1', '9', '8', '3', '@', '2', '5', '6', '7'},
            {'8', '5', '9', '7', '6', '1', '4', '2', '3'},
            {'4', '2', '@', '8', '5', '3', '7', '9', '1'},
            {'7', '1', '3', '9', '2', '4', '@', '5', '6'},
            {'9', '6', '1', '5', '@', '7', '2', '8', '4'},
            {'@', '8', '7', '4', '1', '9', '6', '@', '5'},
            {'3', '4', '5', '2', 't', '6', '1', '7', '9'}};

    /**
     * Test du constructeur de GrillImpl.
     */
    @Test
    public void testConstructeurGrilleImpl() {
        SolveurImpl solveur =
                new SolveurImpl(new GrilleImpl(GRILLE_CORRECTE));
    }

    /**
     * Test de la méthode verifierGrille().
     *
     */
    @Test
    public void testVerifierGrille() {
        SolveurImpl solveur =
                new SolveurImpl(new GrilleImpl(GRILLE_INCORRECTE));
        assertEquals(false, solveur.verifierGrille());
    }

    /**
     * Test de la méthode resoudre().
     */
    @Test
    public void testResoudre() {
        SolveurImpl solveurGrilleCorrecteResolue =
                new SolveurImpl(new GrilleImpl(GRILLE_CORRECTE));
        assertEquals("Test de la méthode resoudre().",
                      true,
                      solveurGrilleCorrecteResolue.resoudre());
    }

    /**
     * Test de la méthode resolu() pour une grille complète.
     */
    @Test
    public void testResolu() {
        SolveurImpl solveur
                = new SolveurImpl(new GrilleImpl(GRILLE_CORRECTE));
        boolean solution = solveur.resolu();
        assertEquals(true, solution);
    }

    /**
     * Test de la méthode resolu()avec exception pour une grille incorrecte.
     */
    @Test
    public void testResoluAvecException() {
        try {
            SolveurImpl solveur
                    = new SolveurImpl(new GrilleImpl(GRILLE_INCORRECTE));
            solveur.resolu();
            fail("L'exception aurait du être levé pour grille non valide");
        } catch (IllegalArgumentException e) {
            //rien a faire, c'est normal qu'on ait l'exception
        }
    }

    /**
     * Test de la méthode afficherSolution().
     */
    @Test
    public void testafficherSolution() {
        //TODO
    }

}
