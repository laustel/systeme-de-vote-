import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.awt.*;
import java.awt.event.*;


import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class InterfaceVote implements ActionListener{

	private static final long serialVersionUID = -9135182293073523397L;
	
	private String jdbcURL="jdbc:postgresql://localhost:5432/db_election";
	private String user = "postgres";
	private String pass = "toor";
	private int id1 ;
	private String pass1;
	private String [] candidat = new String [4];
	private int[] nbr ;
	private int nbrElec ;
	private int nbrVote = 0;
	private int can1,can2,can3,can4;
	
	
	JPanel contentPane;
	JPasswordField passwordField;
	JTextField textField;
	ButtonGroup group;
	JFrame frame;
	JButton btnvalider;
	JLabel candidat1,candidat2,candidat3,candidat4;
	JRadioButton btnradio1,btnradio2,btnradio3,btnradio4;
	
	
	
	 InterfaceVote() {
		 
		 try {
				Connection connection = DriverManager.getConnection(jdbcURL, user, pass);
				System.out.println("Connecter sur la bd");
				
				String sql = "SELECT nom_candidat FROM candidat";
				//String sqls = "SELECT id FROM personne";
				Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery(sql);
				//ResultSet results = statement.executeQuery(sqls);
				int i = 0;
				
				while(result.next()) {
					String nom = result.getString("nom_candidat");
					nom = nom.intern();
					candidat [i] = nom;
					i++;
				}
				/*int j = 0;
				while(results.next()) {
					int id = result.getInt("id");
					nbr [i] = id;
					j++;
				} */
				}catch (SQLException t) {
					System.out.println("Erreur de connection sur la bd");
					t.printStackTrace();
				}
	
		frame = new JFrame();
		frame.setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 1431, 875);
		frame.setVisible(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		frame.setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 255));
		panel.setForeground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 1413, 88);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("SYSTEME DE VOTE");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 47));
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		panel.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(33, 167, 56, 16);
		contentPane.add(label_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Main.class.getResource("/PHOTO/800px_COLOURBOX3691788.jpg")));
		lblNewLabel_1.setBounds(59, 124, 225, 189);
		contentPane.add(lblNewLabel_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Main.class.getResource("/PHOTO/94c9d59dcdcd3ec386fe2bde5b0da5ab.jpg")));
		label_2.setBounds(400, 124, 225, 189);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Main.class.getResource("/PHOTO/800px_COLOURBOX3691788.jpg")));
		label_3.setBounds(750, 124, 225, 189);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(Main.class.getResource("/PHOTO/94c9d59dcdcd3ec386fe2bde5b0da5ab.jpg")));
		label_4.setBounds(1080, 124, 225, 189);
		contentPane.add(label_4);
		
		//Label nom candidat de la base de donnnee
		candidat1 = new JLabel();
		candidat1.setText(candidat[0]);
		candidat1.setFont(new Font("Tahoma", Font.BOLD, 15));
		candidat1.setBounds(123, 326, 125, 30);
		contentPane.add(candidat1);
		
		candidat2 = new JLabel();
		candidat2.setText(candidat[1]);
		candidat2.setFont(new Font("Tahoma", Font.BOLD, 15));
		candidat2.setBounds(490, 326, 125, 30);
		contentPane.add(candidat2);
		
		candidat3 = new JLabel();
		candidat3.setText(candidat[2]);
		candidat3.setFont(new Font("Tahoma", Font.BOLD, 15));
		candidat3.setBounds(840, 326, 125, 30);
		contentPane.add(candidat3);
		
		candidat4 = new JLabel();
		candidat4.setText(candidat[3]);
		candidat4.setFont(new Font("Tahoma", Font.BOLD, 15));
		candidat4.setBounds(1170, 326, 125, 30);
		contentPane.add(candidat4);
		
		//bouton radio
		btnradio1 = new JRadioButton("");
		btnradio1.setBackground(Color.WHITE);
		btnradio1.setBounds(133, 365, 127, 25);
		btnradio1.setActionCommand("btnradio1");
		contentPane.add(btnradio1);
		
		btnradio2 = new JRadioButton("");
		btnradio2.setBackground(Color.WHITE);
		btnradio2.setBounds(495, 365, 127, 25);
		btnradio2.setActionCommand("btnradio2");
		contentPane.add(btnradio2);
		
		btnradio3 = new JRadioButton("");
		btnradio3.setBackground(Color.WHITE);
		btnradio3.setBounds(853, 365, 127, 25);
		btnradio3.setActionCommand("btnradio4");
		contentPane.add(btnradio3);
		
		btnradio4 = new JRadioButton("");
		btnradio4.setBackground(Color.WHITE);
		btnradio4.setBounds(1183, 365, 127, 25);
		btnradio4.setActionCommand("btnradio4");
		contentPane.add(btnradio4);
		
		
		group = new ButtonGroup();
		
		  group.add(btnradio1);
	      group.add(btnradio2);
	      group.add(btnradio3);
	      group.add(btnradio4);
	 
	 /*     add(btnradio1);
	      add(btnradio2);
	      add(btnradio3);
	      add(btnradio4); */ 
	      
		//Label id et password
		JLabel lblId = new JLabel("ID :");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblId.setBounds(450, 460, 93, 16);
		contentPane.add(lblId);
		
		JLabel lblPassword = new JLabel("PASSWORD :");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPassword.setBounds(450, 509, 141, 16);
		contentPane.add(lblPassword);
		
		//Texte field et password field
		passwordField = new JPasswordField();
		passwordField.setBounds(578, 500, 240, 30);
		contentPane.add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(578, 450, 240, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		//bouton validation
		btnvalider = new JButton("VALIDER");
		btnvalider.addActionListener(this);
		btnvalider.setBackground(Color.WHITE);
		btnvalider.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnvalider.setBounds(620, 600, 141, 53);
		contentPane.add(btnvalider);
		btnvalider.setFocusable(false);
		
	}
	 
	 public void actionPerformed (ActionEvent e) { 
		 if(e.getSource() == btnvalider ) {
			 boolean erreur = true;
			 id1 = Integer.parseInt(textField.getText());
			 pass1 = passwordField.getText().intern();
			
			try {
				Connection connection = DriverManager.getConnection(jdbcURL, user, pass);
				System.out.println("Connecter sur la bd");
				
				String sql = "SELECT id,mot_de_passe, statue FROM personne";
				
				Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery(sql);
				
				while(result.next()) {
					int id = result.getInt("id");
					String passw = result.getString("mot_de_passe");
					passw = passw.intern();
					int statue = result.getInt("statue");
					
					if(id == id1 && passw == pass1 ) {
						erreur = false;
						if(statue == 0 ) {
								if(group.getSelection().getActionCommand() == "btnradio1") {
									if(JOptionPane.showConfirmDialog(null,"Confirmer vous votre choix","Confirmation",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
										can1 +=1;
										nbrElec -=1; 
										nbrVote +=1;
										
										JOptionPane.showMessageDialog(null,"Vote enregistrer");
										textField.setText("");
										passwordField.setText("");
										frame.setVisible(false);
										ChoixLangue choix = new ChoixLangue();
									}			
									}
								else if(group.getSelection().getActionCommand() == "btnradio2") {
									if(JOptionPane.showConfirmDialog(null,"Confirmer vous votre choix","Confirmation",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
										
										can2 +=1;
										
										JOptionPane.showMessageDialog(null,"Merci");
										textField.setText("");
										passwordField.setText("");
						    
									}
								}else if(group.getSelection().getActionCommand() == "btnradio3") {
									if(JOptionPane.showConfirmDialog(null,"Confirmer vous votre choix","Confirmation",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
										can3 +=1;
										
										JOptionPane.showMessageDialog(null,"Merci");
										textField.setText("");
										passwordField.setText("");
									}
						         }else if(group.getSelection().getActionCommand() == "btnradio4") {
									if(JOptionPane.showConfirmDialog(null,"Confirmer vous votre choix","Confirmation",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
										can4 +=1;
										
										JOptionPane.showMessageDialog(null,"Merci");
										textField.setText("");
										passwordField.setText("");
									}
						        	 
						         }else{
						        	 JOptionPane.showMessageDialog(null,"Choississer un candidat");
						         }
						}else {
							JOptionPane.showMessageDialog(null,"Vous avez deja voter");
							frame.setVisible(false);
							ChoixLangue choix = new ChoixLangue();
						}
					}else if( passw == "") {
						JOptionPane.showMessageDialog(null,"Erreur un champ est vide ou les deux");
					}
					
					System.out.printf("id = %d- statue = %d", id,statue);
				}
				
				if(erreur == true) {
					JOptionPane.showMessageDialog(null,"ID ou Mot de passe incorect ou introuvable");
					frame.setVisible(false);
					ChoixLangue choix = new ChoixLangue();
				}
							
				connection.close();
			} catch (SQLException t) {
				System.out.println("Erreur de connection sur la bd");
				t.printStackTrace();
			}
		 }
	 }
}
			
