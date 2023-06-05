package leverger.test;


import org.junit.Assert;
import org.junit.jupiter.api.Test;

import leverger.modele.Puzzle;

public class TestsPuzzle {
	
	@Test
    public void la3emeCaseDoitContenirUnePiece() {
        Puzzle puzzle = new Puzzle();
        int numeroPiece = 3;
        puzzle.mettrePiece(numeroPiece);
        boolean contientUnePiece = puzzle.contientUnePiece(numeroPiece);
        Assert.assertTrue(contientUnePiece);
    }
	
	@Test
    public void la6emeCaseNeDoitPasContenirDePiece() {
        Puzzle puzzle = new Puzzle();
        
        puzzle.mettrePiece(5);
        puzzle.mettrePiece(7);
        
        Assert.assertFalse(puzzle.contientUnePiece(6));
    }	
	
}


