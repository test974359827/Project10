package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import dart.DoubleOut;

/**
 * 
 * @author shayan davarifard
 *
 */
public class DoubleOutTest {

	
 @Test

 public void GameStarting(){
	 DoubleOut Shayan = new DoubleOut(2);
	 assertEquals(2,Shayan.getPlayerCount());
 }
	
}
