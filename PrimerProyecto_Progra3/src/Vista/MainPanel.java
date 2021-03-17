package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPanel extends JPanel{

	private JButton users;
	private JButton administrator;
	
	public MainPanel() {
		this.setOpaque(true);
		this.setLayout(null);
		
		addButtons();
		addLabels();
		addPanels();
	}

	private void addPanels() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 950, 150);
		this.add(panel);
	}

	private void addLabels() {
		JLabel title = new JLabel("DICCIONARIO");
		title.setBounds(225, 10, 500, 120);
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setVerticalAlignment(JLabel.CENTER);
		title.setFont(new Font("Agency FB", Font.BOLD, 80));
		this.add(title);
		
		JLabel subTitle = new JLabel("(Español - English)");
		subTitle.setBounds(490, 90, 200, 50);
		subTitle.setHorizontalAlignment(JLabel.CENTER);
		subTitle.setVerticalAlignment(JLabel.CENTER);
		subTitle.setFont(new Font("Agency FB", Font.BOLD, 20));
		this.add(subTitle);
		
		JLabel font1 = new JLabel();
		font1.setBounds(0, 0, 950, 150);
		font1.setIcon(new ImageIcon("src\\Vista\\Images\\barra-amarilla.png"));
		this.add(font1);
		
		JLabel font2 = new JLabel();
		font2.setBounds(400, 150, 950, 100);
		font2.setIcon(new ImageIcon("src\\Vista\\Images\\barra2.jpg"));
		this.add(font2);
		
		JLabel loge = new JLabel();
		loge.setBounds(620, 460, 300, 170);
		ImageIcon img = new ImageIcon("src\\Vista\\Images\\Logo.png");
		Icon icone = new ImageIcon(img.getImage().getScaledInstance(loge.getWidth(), loge.getHeight(), Image.SCALE_DEFAULT));
		loge.setIcon(icone);
		this.add(loge);
		
		JLabel font3 = new JLabel();
		font3.setBounds(0, 241, 950, 400);
		ImageIcon image = new ImageIcon("src\\Vista\\Images\\fondo.jpg");
		Icon icon = new ImageIcon(image.getImage().getScaledInstance(font3.getWidth(), font3.getHeight(), Image.SCALE_DEFAULT));
		font3.setIcon(icon);
		this.add(font3);
	}

	private void addButtons() {
		users = new JButton();
		users.setText("Usuario");
		users.setBounds(0, 150, 200, 100);
		this.add(users);
		
		administrator = new JButton();
		administrator.setText("Administrador");
		administrator.setBounds(200, 150, 200, 100);
		this.add(administrator);
	}

	public JButton getUsers() {
		return users;
	}

	public void setUsers(JButton users) {
		this.users = users;
	}

	public JButton getAdministrator() {
		return administrator;
	}

	public void setAdministrator(JButton administrator) {
		this.administrator = administrator;
	}
	
	
}
