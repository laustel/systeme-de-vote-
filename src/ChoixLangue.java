import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ChoixLangue implements ActionListener{
	
	JPanel contentPane;
	JFrame frame;
	JLabel label,label2;
	JButton btnfrancais,btnanglais;
	InterfaceVoteFR frameFR;
	InterfaceVoteEN frameEN;
	
	ChoixLangue(){
		
	frame = new JFrame();
	frame.setBackground(Color.WHITE);
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.setBounds(0, 0, 1350, 870);
	frame.setVisible(true);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(240, 255, 255));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	frame.setContentPane(contentPane);
	frame.setLocationRelativeTo(null);
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
	
	label = new JLabel();
	label.setText("CHOISSISSEZ VOTRE LANGUE");
	label.setFont(new Font("Tahoma", Font.BOLD, 33));
	label.setBounds(450, 182, 525, 30);
	contentPane.add(label);
	
	label2 = new JLabel();
	label2.setText("CHOOSE YOUR LANGUAGE");
	label2.setFont(new Font("Tahoma", Font.BOLD, 33));
	label2.setBounds(472, 233, 525, 30);
	contentPane.add(label2);
	
	btnfrancais = new JButton("FRANCAIS");
	btnfrancais.addActionListener(this);
	btnfrancais.setBackground(Color.WHITE);
	btnfrancais.setFont(new Font("Tahoma", Font.BOLD, 19));
	btnfrancais.setBounds(182, 373, 195, 88);
	contentPane.add(btnfrancais);
	btnfrancais.setFocusable(false);
	
	btnanglais = new JButton("ENGLISH");
	btnanglais.addActionListener(this);
	btnanglais.setBackground(new Color(255, 255, 255));
	btnanglais.setFont(new Font("Tahoma", Font.BOLD, 19));
	btnanglais.setBounds(1041, 373, 195, 88);
	contentPane.add(btnanglais);
	btnanglais.setFocusable(false);
	
	JLabel lblNewLabel1 = new JLabel("");
	lblNewLabel1.setIcon(new ImageIcon("C:\\Users\\aicha\\eclipse-workspace\\SystemeVote\\media\\img1.png"));
	lblNewLabel1.setBounds(10, 76, 1334, 662);
	contentPane.add(lblNewLabel1);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnfrancais) {
			frame.setVisible(false);
			frameFR = new InterfaceVoteFR(); 
		}
		
		if(e.getSource() == btnanglais) {
			frame.setVisible(false);
			frameEN = new InterfaceVoteEN(); 
		}
		
	}
	
	public void close() {
		frame.setVisible(false);
	}

}
