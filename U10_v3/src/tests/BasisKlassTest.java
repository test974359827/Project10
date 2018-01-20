package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import dart.*;

public class BasisKlassTest {
	
	DoubleOut Basis = new DoubleOut(3);
	
	 @Test
	 public void PlayerTest(){

		 Basis.throwDart(10, 1);
		 assertEquals(10,Basis.getPlayerByIndex(0).getThrowDartValueByIndex(0, 0));
		 assertEquals(1,Basis.getPlayerByIndex(0).getThrowDartValueByIndex(0, 1));
		 assertEquals("Spieler 1",Basis.getPlayerByIndex(0).getName());
		 assertEquals("Spieler 2",Basis.getPlayerByIndex(1).getName());
		 
	 }

	 @Test
	 public void DartsTestThrowDart(){
		 
		 assertEquals(3,Basis.getPlayerCount());
		 assertEquals("Double Out",Basis.getGamemode());

		 Basis.throwDart(10, 1);
		 assertEquals(10,Basis.getPlayerByIndex(0).getThrowDartValueByIndex(0, 0));
		 System.out.println(Basis.getActivePlayerNumber());
	 }
	 
	 @Test
	 public void DartsTestAddplayerNextPlayer(){
		 
		 Basis.start();
		 
	 }
	 
	 
	 @Test
	 public void DartsTestNextPlayer(){
		 
		 assertEquals(3,Basis.getPlayerCount());
		 assertEquals("Double Out",Basis.getGamemode());

		 Basis.throwDart(10, 1);
		 assertEquals(10,Basis.getPlayerByIndex(0).getThrowDartValueByIndex(0, 0));
		 System.out.println(Basis.getActivePlayerNumber());
	 }
}
