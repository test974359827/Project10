package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import dart.*;

public class BasisKlassTest {
	
	
	
	 @Test
	 public void PlayerTest(){
		 DoubleOut Basis = new DoubleOut(5);
		 Basis.throwDart(10, 1);
		 assertEquals(10,Basis.getPlayerByIndex(0).getThrowDartValueByIndex(0, 0));
		 assertEquals(1,Basis.getPlayerByIndex(0).getThrowDartValueByIndex(0, 1));
		 assertEquals("Spieler 1",Basis.getPlayerByIndex(0).getName());
		 assertEquals("Spieler 2",Basis.getPlayerByIndex(1).getName());
		 assertEquals("Spieler 3",Basis.getPlayerByIndex(2).getName());
	 }
	 
	 @Test
	 public void DartsTestThrowDart(){
		 Tactics Basis = new Tactics(3);
		 assertEquals(3,Basis.getPlayerCount());

		 Basis.throwDart(10, 1);
		 assertEquals(10,Basis.getPlayerByIndex(0).getThrowDartValueByIndex(0, 0));
	 }
	 
	 @Test
	 public void DartsTestAddplayerNextPlayer(){
		 
		 DoubleOut Basis = new DoubleOut(4);
		 assertEquals(false,Basis.addPlayer(new Player("Spieler 1")));
		 assertEquals(true,Basis.addPlayer(new Player("Spieler 11")));
		 
	 }
	 
	 
	 @Test
	 public void DartsTestNextPlayer(){
	 }
}
