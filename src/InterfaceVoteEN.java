import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class InterfaceVoteEN implements ActionListener{
	
	
	
private static final long serialVersionUID = -9135182293073523397L;
	
	private String jdbcURL="jdbc:postgresql://localhost:5432/db_election";
	private String user = "postgres";
	private String pass = "toor";
	private int id1 ;
	private String pass1;
	private ArrayList <String> candidat = new ArrayList <> ();
	private ArrayList <String> electeur = new ArrayList <> ();
	private String chemin,ressource,selectnom;
	private int nbr_vote,nbr_votan;
	
	 JFrame frame;
	 JPanel contentPane;
	 JTextField textid;
	 JPasswordField textpass;
	 JButton btnVoter,btnQuitter;
	 JLabel lphoto = new JLabel("");; 
	 
	
	 InterfaceVoteEN() {
		 
		 try {
				Connection connection = DriverManager.getConnection(jdbcURL, user, pass);
				String sql = "SELECT nom_candidat FROM candidat";
				String sqls = "SELECT nom_personne FROM personne";
				Statement statement = connection.createStatement();
				Statement statements = connection.createStatement();
				ResultSet result = statement.executeQuery(sql);
				ResultSet results = statements.executeQuery(sqls);
				int i = 0;
				
				while(result.next()) {
					String nom = result.getString("nom_candidat");
					nom = nom.intern();
					candidat.add(nom);
					i++;
				}
				
				while(results.next()) {
					String nom = results.getString("nom_personne");
					nom = nom.intern();
					electeur.add(nom);
					i++;
				}
				connection.close();
				}catch (SQLException t) {
					System.out.println("Erreur de connection sur la bd");
					t.printStackTrace();
				}
		 	
		    frame = new JFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setBounds(0, 0, 1350, 870);
			contentPane = new JPanel();
			contentPane.setBackground(new Color(240, 255, 255));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			frame.setContentPane(contentPane);
			contentPane.setLayout(null);
			frame.setVisible(true);
			
			JPanel panel = new JPanel();
			panel.setBackground(new Color(0, 153, 255));
			panel.setForeground(new Color(0, 0, 0));
			panel.setBounds(0, 0, 1370, 88);
			contentPane.add(panel);
			
			JLabel lblSystemeDeVote = new JLabel("VOTING SYSTEM");
			lblSystemeDeVote.setForeground(new Color(255, 255, 255));
			lblSystemeDeVote.setBackground(new Color(255, 255, 255));
			lblSystemeDeVote.setFont(new Font("Serif", Font.BOLD, 34));
			panel.add(lblSystemeDeVote);
			
			JList list = new JList();
			list.setBounds(310, 202, 364, 347);
			
			contentPane.add(list);
			
			DefaultListModel model = new DefaultListModel();
			for(int i = 0;i<candidat.size();i++) {
				model.addElement(candidat.get(i));
			}
			list.setModel(model);
			
			JSplitPane splitpane = new JSplitPane();
			
			list.setModel(model);
			
			JLabel lblListeCandidat = new JLabel("LIST OF CANDIDATES");
			lblListeCandidat.setFont(new Font("Tahoma", Font.PLAIN, 22));
			lblListeCandidat.setBounds(379, 139, 260, 62);
			contentPane.add(lblListeCandidat);
			
			textid = new JTextField();
			textid.setBounds(1034, 480, 268, 27);
			contentPane.add(textid);
			textid.setColumns(10);
			
			JLabel lblId = new JLabel("ID:");
			lblId.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblId.setBounds(969, 474, 102, 34);
			contentPane.add(lblId);
			
			JLabel lblMotDePasse = new JLabel("PASSWORD :");
			lblMotDePasse.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblMotDePasse.setBounds(877, 537, 147, 34);
			contentPane.add(lblMotDePasse);
			
			textpass = new JPasswordField();
			textpass.setBounds(1034, 542, 268, 27);
			contentPane.add(textpass);
		
			
			JLabel nomselect = new JLabel("");
			nomselect.setFont(new Font("Tahoma", Font.PLAIN, 20));
			nomselect.setBounds(950, 76, 268, 62);
			contentPane.add(nomselect);
			
			JLabel lblNomDuCandidat = new JLabel("NAME OF CANDIDATE TO SELECT:");
			lblNomDuCandidat.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNomDuCandidat.setBounds(700, 88, 253, 43);
			contentPane.add(lblNomDuCandidat);
			
			JLabel lblNomDuPartie = new JLabel("PART NAME:");
			lblNomDuPartie.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNomDuPartie.setBounds(742, 263, 143, 27);
			contentPane.add(lblNomDuPartie);
			
			JLabel lblNomDuCandidat_1 = new JLabel("CANDIDATE NAME :");
			lblNomDuCandidat_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNomDuCandidat_1.setBounds(724, 316, 161, 34);
			contentPane.add(lblNomDuCandidat_1);
			
			JLabel lblAge = new JLabel("AGE :");
			lblAge.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblAge.setBounds(843, 412, 42, 27);
			contentPane.add(lblAge);
			
			JLabel lpartie = new JLabel("");
			lpartie.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lpartie.setBounds(984, 265, 132, 22);
			contentPane.add(lpartie);
			
			JLabel lnomcan = new JLabel("");
			lnomcan.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lnomcan.setBounds(984, 314, 290, 39);
			contentPane.add(lnomcan);
			
			JLabel lblPrenomDuCandidat = new JLabel("LAST NAME OF CANDIDATE:");
			lblPrenomDuCandidat.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblPrenomDuCandidat.setBounds(698, 369, 187, 32);
			contentPane.add(lblPrenomDuCandidat);
			
			JLabel lprenom = new JLabel("");
			lprenom.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lprenom.setBounds(984, 368, 318, 34);
			contentPane.add(lprenom);
			
			JLabel lage = new JLabel("");
			lage.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lage.setBounds(984, 420, 46, 14);
			contentPane.add(lage);
			
			
			JLabel lblAns = new JLabel("YEAR");
			lblAns.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblAns.setBounds(1041, 420, 46, 14);
			contentPane.add(lblAns);
			
			btnVoter = new JButton("Vote");
			btnVoter.setBounds(1007, 619, 132, 39);
			contentPane.add(btnVoter);
			btnVoter.addActionListener(this);
			
			btnQuitter = new JButton("Leave");
			btnQuitter.setBounds(1149, 619, 132, 39);
			contentPane.add(btnQuitter);
			btnQuitter.addActionListener(this);
			
			JLabel lblNewLabel1 = new JLabel("");
			lblNewLabel1.setIcon(new ImageIcon("C:\\Users\\aicha\\eclipse-workspace\\SystemeVote\\media\\img2.png"));
			lblNewLabel1.setBounds(-155, 76, 1334, 662);
			contentPane.add(lblNewLabel1);
							
			list.addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent e) {
					selectnom = (String) list.getSelectedValue();
					nomselect.setText(selectnom);
					
					try {
						Connection connection = DriverManager.getConnection(jdbcURL, user, pass);
						String sqls = "SELECT partie, nom_candidat,prenom_candidat, age, img FROM candidat";
						Statement statement = connection.createStatement();
						ResultSet result = statement.executeQuery(sqls);
						int i = 0;
						
						while(result.next()) {
							String partie = result.getString("partie");
							String nom = result.getString("nom_candidat");
							String prenom = result.getString("prenom_candidat");
							int age = result.getInt("age");
							chemin = result.getString("img");
							partie = partie.intern();
							nom = nom.intern();
							chemin = chemin.intern();
							String age1 = String.valueOf(age);
							if(nom == selectnom) {
								
								lpartie.setText(partie);
								lnomcan.setText(nom);
								lprenom.setText(prenom);
								lage.setText(age1);
								
								lphoto.setIcon(new ImageIcon(chemin));
								lphoto.setBounds(1158, 100, 187, 166);
								contentPane.add(lphoto); 
							}
						}
						connection.close();
						}catch (SQLException t) {
							t.printStackTrace();
						}
			
				}
						
			});
	 }



	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnVoter ) {
			 boolean erreur = true;
			 id1 = Integer.parseInt(textid.getText());
			 pass1 = textpass.getText().intern();
			
			try {
				Connection connection = DriverManager.getConnection(jdbcURL, user, pass);
				
				String sql = "SELECT id, mot_de_passe, statue FROM personne";
				String sqls = "SELECT id ,nom_candidat,nbr_vote,pourcentage FROM candidat";
				Statement statement = connection.createStatement();
				Statement statements = connection.createStatement();
				
				ResultSet result = statement.executeQuery(sql);
				ResultSet results = statements.executeQuery(sqls);
				
				while(result.next()) {
					int ide = result.getInt("id");
					String passw = result.getString("mot_de_passe");
					passw = passw.intern();
					int statue = result.getInt("statue");
					
					if(ide == id1 && passw == pass1 ) {
						erreur = false;
						if(statue == 0 ) {	
							boolean veri = false;
							while(results.next()) {
								int idc = results.getInt("id");
								String nom = results.getString("nom_candidat");
								nbr_vote = results.getInt("nbr_vote");
								nom = nom.intern();
									if(nom == selectnom) {
										if(JOptionPane.showConfirmDialog(null,"Confirm your choice","Confirmation",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
												nbr_vote +=1;
												nbr_votan -= 1;
												String requeteca = "UPDATE candidat SET nbr_vote = "+ nbr_vote +"WHERE id = "+ idc +" ";
												try {
													PreparedStatement changevote = connection.prepareStatement(requeteca);
													changevote.execute();
												}catch(SQLException ex) {
													System.out.println(ex);	
												}
												JOptionPane.showMessageDialog(null,"Vote Register");
												frame.setVisible(false);
												ChoixLangue choix = new ChoixLangue();
												
												String requeteel = "UPDATE personne SET statue = "+ 1 +"WHERE id = "+ ide +" ";	
												try {
													PreparedStatement changestatut = connection.prepareStatement(requeteel);
													changestatut.execute();
												}catch(SQLException ex) {
													System.out.println(ex);
												}
											}
										veri = true;	
									}
							}
							if(veri == false){
								JOptionPane.showMessageDialog(null,"Choose a candidate");
							}
						}else {
							JOptionPane.showMessageDialog(null,"You have already voted");
							frame.setVisible(false);
							ChoixLangue choix = new ChoixLangue();
						}
					}
				}
				if(erreur == true) {
					JOptionPane.showMessageDialog(null,"Incorrect or not found ID or Password");
				}
				
			connection.close();
			}catch (SQLException t) {
				t.printStackTrace();
			}
}
		if(e.getSource() == btnQuitter) {
			frame.setVisible(false);
			ChoixLangue choix = new ChoixLangue();
		}
		
	} 
	public void close() {
		frame.setVisible(false);
	}
}
