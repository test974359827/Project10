package UI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import dart.*;

public class MyFrame {

	private JFrame frmDart;
	private JTextField txtAnzahl;
	JRadioButton rdbtnDoubleOut = new JRadioButton("Double Out");
	JRadioButton rdbtnTaptic = new JRadioButton("Tactics");
	JRadioButton rdbtnShanghai = new JRadioButton("Shanghai");
	JLabel label = new JLabel("");
	private final JLabel lblError = new JLabel("");
	public static MyFrame Win ;



	/**
	 * Launch the application.
	 * @wbp.parser.entryPoint
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					 Win = new MyFrame();
//					Win.frmDart.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public MyFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDart = new JFrame();
		frmDart.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Anzahl : ");
		lblNewLabel.setBounds(40, 35, 69, 20);
		frmDart.getContentPane().add(lblNewLabel);
		
		JLabel lblMode = new JLabel("Mode : ");
		lblMode.setBounds(50, 71, 69, 20);
		frmDart.getContentPane().add(lblMode);
		
		txtAnzahl = new JTextField();
		txtAnzahl.setBounds(124, 32, 315, 26);
		frmDart.getContentPane().add(txtAnzahl);
		txtAnzahl.setColumns(10);
		txtAnzahl.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) start();
			}
		});
		
		rdbtnDoubleOut.setBounds(124, 67, 113, 29);
		rdbtnDoubleOut.setSelected(true);
		frmDart.getContentPane().add(rdbtnDoubleOut);
		
		rdbtnTaptic.setBounds(247, 67, 81, 29);
		frmDart.getContentPane().add(rdbtnTaptic);
		
		rdbtnShanghai.setBounds(335, 67, 104, 29);
		frmDart.getContentPane().add(rdbtnShanghai);
		
		ButtonGroup BTG = new ButtonGroup();
		BTG.add(rdbtnShanghai);
		BTG.add(rdbtnTaptic);
		BTG.add(rdbtnDoubleOut);
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				start();
			}
		});
		btnNewButton.setBounds(454, 35, 115, 60);
		frmDart.getContentPane().add(btnNewButton);
		
		label.setBounds(124, 5, 315, 20);
		label.setForeground(Color.red);;
		
		Dimension Framesize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = Framesize.width / 3, y = Framesize.height / 3 ;
		frmDart.getContentPane().add(label);
		lblError.setForeground(Color.RED);
		lblError.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblError.setBounds(40, 110, 529, 39);
		
		frmDart.getContentPane().add(lblError);
		frmDart.setTitle("Dart");
		frmDart.setBounds(x, y, 630, 647);
		frmDart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public void start(){
		if(lblError.getText() != null) lblError.setText("");
			int PlayerCount;
			try {
				PlayerCount = Integer.parseInt(txtAnzahl.getText());
	             if(label.getText() != null) label.setText("");
	            } catch (Exception z) { 
	            	label.setText("Please use only numbers");
	                return;
	       }
			if(rdbtnDoubleOut.isSelected())
				 new DoubleOut(PlayerCount);
			 if(rdbtnTaptic.isSelected())
				 new Tactics(PlayerCount);
			 if(rdbtnShanghai.isSelected())
				 new Shanghai(PlayerCount);
		}

	
	
	public void error(String a){
		frmDart.setVisible(true);
		lblError.setText(a);
	}
}
