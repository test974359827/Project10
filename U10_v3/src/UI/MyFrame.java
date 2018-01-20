package UI;

import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
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

	/**
	 * Alle Spielmodi werden angezeigt und durch die Rardiobuttons kann man den gewünschten Speilmodus auswählen. 
	 */
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
	public static void main(String[] args) {
		run();
	}
	
	public static void run() {
		Win = null;
		try {
			 Win = new MyFrame();
			Win.frmDart.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	
	/** 
	 * MyFrame wird inistaliziert.
	 */
	
	public MyFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDart = new JFrame();
		frmDart.getContentPane().addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
			}
		});
		frmDart.setResizable(false);
		frmDart.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Anzahl : "); // Anzahl der Spieler wird hier eingegeben. 
		lblNewLabel.setBounds(40, 35, 69, 20);
		frmDart.getContentPane().add(lblNewLabel);
		
		JLabel lblMode = new JLabel("Mode : "); // Der Spielmodus wird ausgewählt. 
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
		frmDart.getContentPane().add(rdbtnDoubleOut); // Spielmodus DoubleOut
		
		rdbtnTaptic.setBounds(247, 67, 81, 29);
		frmDart.getContentPane().add(rdbtnTaptic); // Spielmodus Tactics
		
		rdbtnShanghai.setBounds(335, 67, 104, 29);
		frmDart.getContentPane().add(rdbtnShanghai); // Spielmodus Shanghai
		
		/**
		 * Radiobuttons der verschiedenen Spielmodi
		 */
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
		frmDart.setBounds(x + 100, y + 100, 630, 209);
		frmDart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/** 
	 * Start wird aufgerufen und anschließend wird das Spiel gestartet. 
	 */
	public void start(){
		if(lblError.getText() != null) lblError.setText("");
			int PlayerCount;
			try {
				PlayerCount = Integer.parseInt(txtAnzahl.getText());
	             if(label.getText() != null) label.setText("");
	            } catch (Exception z) { 
	            	label.setText("Please use only numbers"); // Wenn keine Nummer oder Buchstaben für die Anzahl der Spieler eingegeben wird taucht dieser Fehler auf. 
	                return;
	       }
			
			frmDart.setVisible(false);
			/** 
			 * Hier wird der ausgewählte Spielmodus aufgerufen und gestartet. 
			 */
			if(rdbtnDoubleOut.isSelected())
				 new DoubleOut(PlayerCount);
			 if(rdbtnTaptic.isSelected())
				 new Tactics(PlayerCount);
			 if(rdbtnShanghai.isSelected())
				 new Shanghai(PlayerCount);
		}

	
	// Wenn ein Fehler aufzutauchen ist, dann wird diese Methode aufgerufen.
	public void error(String a){
		frmDart.setVisible(true);
		lblError.setText(a);
	}
}
