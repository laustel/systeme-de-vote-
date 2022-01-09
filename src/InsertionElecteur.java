

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JOptionPane;

public class InsertionElecteur {
	
	private String nom = "";
	private String prenom = "";
	private int age ;
	private String pass = "";
	private String cni = "";
	private int  statue ;
	
	
	InsertionElecteur(String nom,String prenom,int age,String pass,String cni) {
		
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.pass = pass;
		this.cni = cni;
		this.statue = 0;
		
	}
	
	public void connection() {
		String jdbcURL="jdbc:postgresql://localhost:5432/db_election";
		String user = "postgres";
		String pass = "root";
		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, user, pass);
			System.out.println("Connecter sur la bd");
			
			String sql = "INSERT INTO personne (nom_personne, prenom_personne,age,mot_de_passe, num_cni, statue) VALUES(?, ?, ?, ?, ?, ?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
						
			statement.setString(1, this.nom);
			statement.setString(2, this.prenom);
			statement.setInt(3, this.age);
			statement.setString(4, this.pass);
			statement.setString(5, this.cni);
			statement.setInt(6, this.statue);
			
			int rows = statement.executeUpdate();
			if(rows > 0) {
				System.out.println("insertion valider");
			}
			connection.close();
		} catch (SQLException e) {
			System.out.println("Erreur de connection sur la bd");
			e.printStackTrace();
		}
	}
	
	

}
