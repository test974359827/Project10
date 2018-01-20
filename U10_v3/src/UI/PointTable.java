package UI;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import dart.*;


public class PointTable extends JFrame{
	
	/**
	 * Hier wird die Tabelle erstellt, in der alle Ergebnisse und Eingaben angezeigt werden. 
	 */
	private static final long serialVersionUID = 1L;
	private Object[][] data = null;
	private String[] columns;
	DefaultTableModel mod ;
	JTable table ;
	
	/**
	 * Eigenschaften der Tabelle werden hier festgestellt und die Tabelle wird erstellt.
	 * @param player
	 * 		Der Spieler.
	 */
	public PointTable(Player[] player) {

		//headers for the table
		columns = new String[player.length]; // 
		for(int i = 0 ; i < player.length ; i++)
			columns[i]=player[i].getName();
		
		mod = new DefaultTableModel(data, columns);
		table = new JTable(mod);
		
		Dimension Framesize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = Framesize.width / 4, y = Framesize.height / 4 ;
         this.setBounds(x, y, 1000, 458);
        //add the table to the frame
        getContentPane().add(new JScrollPane(table));
        this.setTitle("Table Example");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        this.pack();
        this.setVisible(true);
		
	}
		
	/**
	 * Diese Methode fügt die Punkte der jeweiligen Spieler zur Tabelle hinzu. 
	 * @param ActivePlayerNumber 
	 * 		Der Spieler, der gerade am Spielen ist.
	 * @param Point
	 * 		Die erreichten Punktzahl
	 * @param DartNumber
	 * 		Wurfnummer
	 */
	public void addPoint(int ActivePlayerNumber, String Point , int DartNumber){
		if(data != null){
			if(data.length < DartNumber){
				Object[][] a = new Object[DartNumber][columns.length];
				for(int i = 0 ; i < data.length ; i++){
					for(int j = 0 ; j < columns.length ; j++)
						a[i][j] = data[i][j];
				}
				a[data.length ][ActivePlayerNumber] = Point;
				data = a ;
				mod.addRow(data[DartNumber - 1]);
			}
			else{
				data[DartNumber - 1][ActivePlayerNumber] = Point;
				mod.setValueAt(Point, DartNumber - 1, ActivePlayerNumber);
			}
		}
		else
		{
			Object[][] a = new Object[DartNumber][columns.length];
			a[ 0 ][ActivePlayerNumber] = Point;
			data = a ;
			mod.addRow(data[DartNumber - 1]);
		}
	}
}
