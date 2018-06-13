package grille;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * Classe de test d'une grille sudoku.
 *
 * @author KAM-WAL
 * @author AKALA Kouma
 */
public class GrilleTest {

    /**
     * Variable statique permettant de manipuler plus facilement les caracteres
     * vides.
     */
    static final char EMPTY = Grille.EMPTY;

    /**
     * Grille vide.
     */
    static final char[][] GRILLE_VIDE_9 = {
        {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
        {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
        {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
        {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
        {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
        {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
        {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
        {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
        {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY}};

    /**
     * Grille incomplete.
     */
    static final char[][] GRILLE_INCOMPLETE_9 = {
        {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, '6', EMPTY, '7', EMPTY},
        {EMPTY, '7', EMPTY, '9', EMPTY, '4', EMPTY, '3', EMPTY},
        {'4', EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, '1'},
        {'3', EMPTY, '6', EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
        {EMPTY, EMPTY, '2', '8', EMPTY, '1', '9', EMPTY, EMPTY},
        {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, '1', EMPTY, '5'},
        {'1', EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, '7'},
        {EMPTY, '3', EMPTY, '5', EMPTY, '8', EMPTY, '9', EMPTY},
        {EMPTY, '5', EMPTY, '4', EMPTY, EMPTY, EMPTY, EMPTY, EMPTY}};

    /**
     * Grille complete.
     */
    static final char[][] GRILLE_COMPLETE_9 = {
        {'8', '2', '7', '1', '5', '4', '3', '9', '6'},
        {'9', '6', '5', '3', '2', '7', '1', '4', '8'},
        {'3', '4', '1', '6', '8', '9', '7', '5', '2'},
        {'5', '9', '3', '4', '6', '8', '2', '7', '1'},
        {'4', '7', '2', '5', '1', '3', '6', '8', '9'},
        {'6', '1', '8', '9', '7', '2', '4', '3', '5'},
        {'7', '8', '6', '2', '3', '5', '9', '1', '4'},
        {'1', '5', '4', '7', '9', '6', '8', '2', '3'},
        {'2', '3', '9', '8', '4', '1', '5', '6', '7'}};

    /**
     * Test getDimension(). Dimension grille.
     */
    static final int TEST_GETDIMENSION_DIMENSION_GRILLE = 9;

    /**
     * Test getValue(). Valeur de y.
     */
    static final int TEST_GETVALUE_VAL_Y = 8;

    /**
     * Test getValue(). Index x négatif.
     */
    static final int TEST_GETVALUE_INDEX_X_NEGATIF = -2;

    /**
     * Test getValue(). Index x négatif valeur y.
     */
    static final int TEST_GETVALUE_INDEX_X_NEGATIF_Y = 5;
    
     /**
     * Test getValue(). Index y négatif
     */
    static final int TEST_GETVALUE_INDEX_Y_NEGATIF = 8;

    /**
     * Test getValue(). Index y négatif valeur x
     */
    static final int TEST_GETVALUE_INDEX_Y_NEGATIF_X = -5;

    /**
     * Test setValueLeveesDExceptions() pour x. Valeur de x.
     */
    static final int TEST_SETVALUE_LEVEE_EXCEPTION_X_VAL_X = 15;

    /**
     * Test setValueLeveesDExceptions() pour x. Valeur de y.
     */
    static final int TEST_SETVALUE_LEVEE_EXCEPTION_X_VAL_Y = 5;

    /**
     * Test setValueLeveesDExceptions() pour y. Valeur de x.
     */
    static final int TEST_SETVALUE_LEVEE_EXCEPTION_Y_VAL_X = 3;

    /**
     * Test setValueLeveesDExceptions() pour y. Valeur de y.
     */
    static final int TEST_SETVALUE_LEVEE_EXCEPTION_Y_VAL_Y = 20;


    /**
     * Méthode principale.
     * @param args arguments de la méthode main
     */
    public static void main(final String[] args) {
        GrilleTest grilleTest = new GrilleTest();
        grilleTest.testGetDimension();
        grilleTest.testSetValue();
        grilleTest.testGetValue();
        grilleTest.testSetValueLeveesDExceptions();
        grilleTest.testGetValueLeveesDExceptions();
        grilleTest.testComplete();
        grilleTest.testPossibleLeveesDExceptions();
        grilleTest.testPossible();
    }

    /**
     * Permet de tester la methode getDimension().
     */
    @Test
    public final void testGetDimension() {
       System.out.println("Test de la methode getDimension() ...");
        Grille sudoku = new GrilleImpl(GRILLE_VIDE_9);
        sudoku.setGrille(GRILLE_INCOMPLETE_9);
        assertEquals("Test dimension sur grille vide.",
                TEST_GETDIMENSION_DIMENSION_GRILLE, sudoku.getDimension());
    }

    /**
     * Permet de tester la methode setValue().
     */
    @Test
    public final void testSetValue() {
         System.out.println("Test de la methode setValue() ...");
        Grille sudoku = new GrilleImpl(GRILLE_INCOMPLETE_9);
        sudoku.setValue(1, 1, '2');
        char recup = sudoku.getValue(1, 1);
        assertEquals('2', recup);
    }

    /**
     * Permet de tester la methode getValue().
     */
    @Test
    public final void testGetValue() {
        System.out.println("Test de la methode getValue() ...");
        Grille sudoku = new GrilleImpl(GRILLE_INCOMPLETE_9);
        char recup = sudoku.getValue(2, TEST_GETVALUE_VAL_Y);
        assertEquals('3', recup);
        try {
            char recupIndexXNegatif = sudoku.getValue(
                    TEST_GETVALUE_INDEX_X_NEGATIF, 
                    TEST_GETVALUE_INDEX_X_NEGATIF_Y);
            fail("Une IllegalArgumentException aurait "
                    + "du etre levee pour l'index x");
        } catch (IllegalArgumentException e) {

        }
        try {
            char recupIndexYNegatif = sudoku.getValue(
                    TEST_GETVALUE_INDEX_Y_NEGATIF_X,
                    TEST_GETVALUE_INDEX_Y_NEGATIF);
            fail("Une IllegalArgumentException "
                    + "aurait du etre levee pour l'index y");
        } catch (IllegalArgumentException e) {

        }
    }

    /**
     * Permet de tester la levee d'exceptions pour la methode setValue().
     */
    @Test
    public final void testSetValueLeveesDExceptions() {
        System.out.println("Test levees d'exceptions (valeurs incorrectes pour"
                + " x, y et la valeur) pour la methode setValue() ...");
        Grille sudoku = new GrilleImpl(GRILLE_COMPLETE_9);

        try {
            sudoku.setValue(TEST_SETVALUE_LEVEE_EXCEPTION_X_VAL_X, 
                    TEST_SETVALUE_LEVEE_EXCEPTION_X_VAL_Y, '6');
            fail("Une IllegalArgumentException aurait du etre levee pour x");
        } catch (IllegalArgumentException e) {

        }

        try {
            sudoku.setValue(TEST_SETVALUE_LEVEE_EXCEPTION_Y_VAL_X, 
                    TEST_SETVALUE_LEVEE_EXCEPTION_Y_VAL_Y, '6');
            fail("Une IllegalArgumentException aurait du etre levee pour y");
        } catch (IllegalArgumentException e) {

        }

        // Valeur interdite
        try {
            sudoku.setValue(3, 5, 'z');
            fail("Une IllegalArgumentException aurait "
                    + "du etre levee pour la valeur");
        } catch (IllegalArgumentException e) {

        }
    }

    /**
     * Permet de tester la levee d'exceptions pour la methode getValue().
     */
    @Test
    public final void testGetValueLeveesDExceptions() {
        System.out.println("Test levees d'exceptions (s, y) "
                + "pour la methode getValue() ...");
        Grille sudoku = new GrilleImpl(GRILLE_COMPLETE_9);
        try {
            char valeur = sudoku.getValue(15, 2);
            fail("Une IllegalArgumentException aurait du etre levee pour x");
        } catch (IllegalArgumentException e) {

        }
        try {
            char valeur = sudoku.getValue(4, 12);
            fail("Une IllegalArgumentException aurait du etre levee pour y");
        } catch (IllegalArgumentException e) {

        }
    }

    /**
     * Permet de tester la methode complete().
     */
    @Test
    public final void testComplete() {
         System.out.println("Test de la methode complete() ...");
        Grille sudoku = new GrilleImpl(GRILLE_COMPLETE_9);
        assertEquals("Test de completude de la grille.", true,
                sudoku.complete());
        Grille sudokuIncomplet = new GrilleImpl(GRILLE_INCOMPLETE_9);
        assertEquals("Test de completude de la grille.", false,
                sudokuIncomplet.complete());
    }

    /**
     * Permet de tester la levee d'exceptions pour la methode possible().
     */
    @Test
    public final void testPossibleLeveesDExceptions() {
        //TODO

    }

    /**
     * Permet de tester la methode possible().
     */
    @Test
    public final void testPossible() {
        //TODO
    }
}
