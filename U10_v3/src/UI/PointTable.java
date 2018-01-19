package UI;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dart.*;


public class PointTable extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Object[][] data = null;
	private String[] columns;
	DefaultTableModel mod ;
	JTable table ;
	public PointTable(Player[] player) {
//		setOpacity(10.0f);
		 //headers for the table
		columns = new String[player.length];
		for(int i = 0 ; i < player.length ; i++)
			columns[i]=player[i].getName();
         
        
		
		
		 mod = new DefaultTableModel(data, columns);
		
		table = new JTable(mod);
         
        //add the table to the frame
        getContentPane().add(new JScrollPane(table));
         
        this.setTitle("Table Example");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        this.pack();
        this.setVisible(true);
		
	}
	
	public void addPoint(int ActivePlayerNumber, int Point , int DartNumber){
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
//		d
		
		
	}
	
	
	
	
	
}
