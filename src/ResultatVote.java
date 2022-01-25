import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

public class ResultatVote extends JFrame {

	private JPanel contentPane;
	private String jdbcURL="jdbc:postgresql://localhost:5432/db_election";
	private String user = "postgres";
	private String pass = "toor";
	String nomgagnant;
	String chemingagnant;
	private int ids;
	double pourcentagegagnant,pourcentage,pourcent;
	
	JLabel lphoto = new JLabel("");;
	private JLabel lnom;
	private JLabel lpourcent;
	private JLabel lblGagnant;
	private JLabel lblPourcentageVictoire;
	private JLabel lblVainqueur;
	private ArrayList <String> electeur = new ArrayList <> ();
	private double nbr_votant,restepour =100;
	private JLabel label_2;
	private JLabel label_1;
	private JLabel label_3;
	private JLabel lblNomCandidat;
	private JLabel lblPourcentage;
	private JLabel lblPerdant;
	private JLabel lblNewLabel_1;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResultatVote frame = new ResultatVote();
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
	public ResultatVote() {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1350, 870);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 255));
		panel.setForeground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 1370, 88);
		contentPane.add(panel); 
		
		JLabel lblSystemeDeVote = new JLabel("SYSTEME DE VOTE");
		lblSystemeDeVote.setForeground(new Color(255, 255, 255));
		lblSystemeDeVote.setBackground(new Color(255, 255, 255));
		lblSystemeDeVote.setFont(new Font("Serif", Font.BOLD, 34));
		panel.add(lblSystemeDeVote); 
		

		
		lnom = new JLabel("");
		lnom.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lnom.setBounds(648, 480, 260, 43);
		contentPane.add(lnom);
		
		lpourcent = new JLabel("");
		lpourcent.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lpourcent.setBounds(656, 566, 98, 18);
		contentPane.add(lpourcent);
		
		lblGagnant = new JLabel("GAGNANT :");
		lblGagnant.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblGagnant.setBounds(527, 480, 142, 43);
		contentPane.add(lblGagnant);
		
		lblPourcentageVictoire = new JLabel("POURCENTAGE VICTOIRE :");
		lblPourcentageVictoire.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPourcentageVictoire.setBounds(398, 550, 248, 34);
		contentPane.add(lblPourcentageVictoire);
		

		lblVainqueur = new JLabel("VAINQUEUR");
		lblVainqueur.setForeground(Color.BLUE);
		lblVainqueur.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblVainqueur.setBounds(596, 184, 240, 61);
		contentPane.add(lblVainqueur);
		
		label_2 = new JLabel("%");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_2.setBounds(779, 562, 46, 24);
		contentPane.add(label_2);
		
		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, user, pass);
			String sqls = "SELECT id,nom_candidat,nbr_vote,img FROM candidat";
			String sqle = "SELECT nom_personne FROM personne";
			Statement statement = connection.createStatement();
			Statement statemente = connection.createStatement();
			ResultSet result = statement.executeQuery(sqls);
			ResultSet resulte = statemente.executeQuery(sqle);
			int i=0;
			while(resulte.next()) {
				String nom = resulte.getString("nom_personne");
				nom = nom.intern();
				electeur.add(nom);
				i++;
			}
			nbr_votant = electeur.size();
			while(result.next()) {
				String nom = result.getString("nom_candidat");
				int nbr_vote = result.getInt("nbr_vote");
				int id = result.getInt("id");
				nom = nom.intern();
				double nbr_voted = (double) nbr_vote;
				pourcentage =  (nbr_voted*100)/nbr_votant;
				String requete = "UPDATE candidat SET pourcentage = "+ pourcentage +"WHERE id = "+ id +" ";
				try {
					PreparedStatement changevote = connection.prepareStatement(requete);
					changevote.execute();
				}catch(SQLException ex) {
					System.out.println(ex);	
				}
				
			}
			
			String sql = "SELECT id, nom_candidat,pourcentage,img FROM candidat";
			Statement statements = connection.createStatement();
			ResultSet results = statements.executeQuery(sql);
			double max = 0;
			while(results.next()) {
				int id = results.getInt("id");
				String nom = results.getString("nom_candidat");
				pourcent = results.getDouble("pourcentage");
				String chemin = results.getString("img");
				nom = nom.intern();
				chemin = chemin.intern();
				
				if(pourcent > max ) {
					
					nomgagnant = nom;
					chemingagnant = chemin;
					pourcentagegagnant = pourcent;
					ids=id;
					max = pourcent;
				}
				
			}
			
			String pg = String.valueOf(pourcentagegagnant);
			lnom.setText(nomgagnant);
			lpourcent.setText(pg);
			
			lphoto.setIcon(new ImageIcon(chemingagnant));
			lphoto.setBounds(585, 229, 320, 249);
			contentPane.add(lphoto);
			
			String afficher = "SELECT id,nom_candidat,pourcentage FROM candidat";
			Statement statementa = connection.createStatement();
			ResultSet resulta = statementa.executeQuery(afficher);
			
			int tai=309;
			while(resulta.next()) {
				String nom = resulta.getString("nom_candidat");
				double pourcentage = resulta.getDouble("pourcentage");
				int id = resulta.getInt("id");
				nom = nom.intern();
				if(ids != id) {
					
					JLabel lblNom = new JLabel("NOM");
					lblNom.setFont(new Font("Tahoma", Font.PLAIN, 19));
					lblNom.setBounds(963, tai, 152, 34);
					contentPane.add(lblNom);
					
					JLabel lblNewLabel = new JLabel();
					lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
					lblNewLabel.setBounds(1100, tai, 100, 34);
					contentPane.add(lblNewLabel);
					
					JLabel label = new JLabel("%");
					label.setFont(new Font("Tahoma", Font.PLAIN, 19));
					label.setBounds(1244, tai, 46, 34);
					contentPane.add(label);
					
					lblNom.setText(nom);
					String pc = String.valueOf(pourcentage);
					lblNewLabel.setText(pc);
					
					tai +=59;
					
				}
				
			}
			
			lblNomCandidat = new JLabel("NOM CANDIDAT");
			lblNomCandidat.setForeground(Color.BLUE);
			lblNomCandidat.setFont(new Font("Tahoma", Font.PLAIN, 19));
			lblNomCandidat.setBounds(889, 216, 140, 43);
			contentPane.add(lblNomCandidat);
			
			lblPourcentage = new JLabel("POURCENTAGE");
			lblPourcentage.setForeground(Color.BLUE);
			lblPourcentage.setFont(new Font("Tahoma", Font.PLAIN, 19));
			lblPourcentage.setBounds(1062, 229, 128, 16);
			contentPane.add(lblPourcentage);
			
			lblPerdant = new JLabel("PERDANT");
			lblPerdant.setForeground(Color.BLUE);
			lblPerdant.setFont(new Font("Tahoma", Font.PLAIN, 19));
			lblPerdant.setBounds(1004, 181, 140, 24);
			contentPane.add(lblPerdant);
			
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\aicha\\eclipse-workspace\\SystemeVote\\media\\feu.png"));
			lblNewLabel_1.setBounds(-154, 76, 1314, 639);
			contentPane.add(lblNewLabel_1);
			connection.close();
			}catch (SQLException t) {
				t.printStackTrace();
			}
		
		
	}
}
