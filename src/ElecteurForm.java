

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class ElecteurForm extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8875439032220656422L;
	private JPanel contentPane;
	 static JTextField textField;
	 static JTextField textField_1;
	 static JTextField textField_2;
	 static JTextField textField_3;
	 static JPasswordField passwordField;
	 JButton btnEnregistrer,btnNouveau;
	 
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ElecteurForm frame = new ElecteurForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
		}
	}); 
		
	}

	/**
	 * Create the frame.
	 */
	public ElecteurForm() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1102, 835);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBounds(0, 0, 1084, 88);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblSystemDeVote = new JLabel("SYSTEM DE VOTE");
		lblSystemDeVote.setForeground(Color.WHITE);
		lblSystemDeVote.setFont(new Font("Tahoma", Font.BOLD, 47));
		lblSystemDeVote.setBounds(265, 13, 419, 48);
		panel.add(lblSystemDeVote);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(Color.BLUE);
		panel_1.setBounds(159, 147, 715, 595);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("NOM :");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(93, 75, 74, 16);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblPrenom = new JLabel("PRENOM :");
		lblPrenom.setForeground(Color.WHITE);
		lblPrenom.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPrenom.setBounds(93, 168, 108, 16);
		panel_1.add(lblPrenom);
		
		JLabel lblAge = new JLabel("AGE :");
		lblAge.setForeground(Color.WHITE);
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAge.setBounds(93, 260, 74, 16);
		panel_1.add(lblAge);
		
		JLabel lblNumeroDeCni = new JLabel("NUMERO DE CNI :");
		lblNumeroDeCni.setForeground(Color.WHITE);
		lblNumeroDeCni.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNumeroDeCni.setBounds(93, 442, 188, 16);
		panel_1.add(lblNumeroDeCni);
		
		textField = new JTextField();
		textField.setBounds(324, 56, 319, 35);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(324, 149, 319, 35);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(324, 247, 319, 35);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(324, 436, 319, 35);
		panel_1.add(textField_3);
		
		panel_1.add(btnEnregistrer = new JButton("ENREGISTRER") );
		btnEnregistrer.addActionListener(this);
		
		btnEnregistrer.setBackground(Color.WHITE);
		btnEnregistrer.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnEnregistrer.setBounds(306, 527, 179, 41);
		
		
		panel_1.add(btnNouveau = new JButton("NOUVEAU "));
		btnNouveau.addActionListener(this);
		btnNouveau.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnNouveau.setBackground(Color.WHITE);
		btnNouveau.setBounds(524, 527, 179, 41);
		panel_1.add(btnNouveau);
		
		JLabel lblMotDePasse = new JLabel("MOT DE PASSE :");
		lblMotDePasse.setForeground(Color.WHITE);
		lblMotDePasse.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMotDePasse.setBounds(108, 353, 162, 16);
		panel_1.add(lblMotDePasse);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(324, 247, 319, 35);
		panel_1.add(passwordField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(324, 346, 319, 35);
		panel_1.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("VEUILLER VOUS ENREGISTRER ELECTEUR");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setBounds(271, 101, 419, 21);
		contentPane.add(lblNewLabel);
	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnEnregistrer){
			
			String nom = textField.getText();
			String prenom = textField_1.getText();
			int age = Integer.parseInt (textField_2.getText());
			String mot_de_passe = passwordField.getText();
			String cni = textField_3.getText();
			
			
			InsertionElecteur connexion  = new  InsertionElecteur(nom,prenom,age,mot_de_passe,cni);
			connexion.connection();
			
		    }
		
        if(e.getSource()==btnNouveau){
        	
        	 textField.setText("");
        	 textField_1.setText("");
        	 textField_2.setText("");
        	 passwordField.setText("");
        	 textField_3.setText("");
		  }
       
		
	
		
		}
		
}
