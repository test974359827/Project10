package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import dart.Tactics;
/**
 * 
 * @author Mohammadrahim Masoumi
 *
 */
public class TacticsTest {
	

		Tactics Mo = new Tactics(2);
		
	 @Test
	 public void GameStarting(){
		 
	
		 

		assertEquals(2,Mo.getPlayerCount());
		assertEquals("Tactics",Mo.getGamemode());
	
		 Mo.throwDart(1, 2);
		 Mo.throwDart(11, 3);
		 Mo.throwDart(12, 2);
		 Mo.throwDart(20, 2);
		 Mo.throwDart(17, 2);
		 Mo.throwDart(14, 3);
		 Mo.throwDart(9, 2);
		 Mo.throwDart(18, 2);
		 Mo.throwDart(19, 2);
		 Mo.throwDart(25, 2);
		 Mo.throwDart(10, 2);
		 Mo.throwDart(16, 3);
		 Mo.throwDart(12, 1);
		 Mo.throwDart(10, 1);
		 Mo.throwDart(25, 2);
		 Mo.throwDart(17, 1);
		 Mo.throwDart(19, 1);
		 Mo.throwDart(20, 2);
		 Mo.throwDart(18, 1);
		 Mo.throwDart(13, 3);
		 Mo.throwDart(15, 1);
		 Mo.throwDart(15, 2);
		 
		 Mo.Point();
		 
		 assertEquals(true,Mo.gewonnen());
	 }
	 

		
	}


