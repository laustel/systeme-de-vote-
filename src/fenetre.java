import java.awt.Color;
import java.awt.Font;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
public class fenetre extends JFrame {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7956996240526284315L;
	JPanel contentPane;
	JFrame frame;
	JTextField textField;
	JTextField textField_1;
	JTextField textField_2;
	JTextField textField_4;

	
	fenetre() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 1431, 875);
		frame.setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBounds(0, 0, 1413, 88);
		panel.setBackground(Color.BLUE);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SYSTEM DE VOTE");
		lblNewLabel.setBounds(356, 13, 439, 48);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 47));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.BLACK);
		panel_1.setBackground(Color.BLUE);
		panel_1.setBorder(null);
		panel_1.setBounds(175, 160, 813, 668);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("NOM :");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(94, 87, 66, 25);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblPrenom = new JLabel("PRENOM :");
		lblPrenom.setForeground(Color.WHITE);
		lblPrenom.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPrenom.setBounds(94, 184, 101, 25);
		panel_1.add(lblPrenom);
		
		JLabel lblAge = new JLabel("AGE :");
		lblAge.setForeground(Color.WHITE);
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAge.setBounds(92, 300, 54, 25);
		panel_1.add(lblAge);
		
		JLabel lblPartis = new JLabel("PARTIS :");
		lblPartis.setForeground(Color.WHITE);
		lblPartis.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPartis.setBounds(94, 430, 102, 25);
		panel_1.add(lblPartis);
		
		textField = new JTextField();
		textField.setBounds(322, 76, 380, 37);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(322, 181, 380, 37);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(322, 297, 380, 37);
		panel_1.add(textField_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(322, 418, 380, 37);
		panel_1.add(textField_4);
		
		JButton btnNewButton = new JButton("M'ENREGISTRER");
		btnNewButton.setSelectedIcon(null);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(264, 582, 226, 37);
		panel_1.add(btnNewButton);
		
		JButton btnNouveau = new JButton("NOUVEAU");
		btnNouveau.setForeground(Color.BLACK);
		btnNouveau.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnNouveau.setBackground(Color.WHITE);
		btnNouveau.setBounds(50,250 ,141, 54);
		panel_1.add(btnNouveau);
		
		JLabel lblNewLabel_1 = new JLabel("VEUILLEZ VOUS ENREGISTRER CANDIDAT");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_1.setBounds(366, 97, 425, 32);
		contentPane.add(lblNewLabel_1);
		
		frame.setLocationRelativeTo(null);
	}
}
