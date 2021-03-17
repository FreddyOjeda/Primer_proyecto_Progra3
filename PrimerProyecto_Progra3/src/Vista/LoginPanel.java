package Vista;

import java.awt.Color;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPanel extends JPanel{

	private JTextField userName;
	private JPasswordField password;
	private JButton loginButton;
	private JButton home;
	
	public LoginPanel() {
		this.setOpaque(true);
		this.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(375, 170, 200, 230);
		panel.setBorder(BorderFactory.createTitledBorder("Login"));
		panel.setBackground(Color.WHITE);
		panel.setOpaque(true);
		
		
		addButtons();
		addTextFields();
		addLabels();
		this.add(panel);
		addFonts();
	}
	
	private void addFonts() {
		JLabel loge = new JLabel();
		loge.setBounds(620, 460, 300, 170);
		ImageIcon img = new ImageIcon("src\\Vista\\Images\\Logo.png");
		Icon icone = new ImageIcon(img.getImage().getScaledInstance(loge.getWidth(), loge.getHeight(), Image.SCALE_DEFAULT));
		loge.setIcon(icone);
		this.add(loge);
		
		JLabel font3 = new JLabel();
		font3.setBounds(0, 0, 950, 650);
		ImageIcon image = new ImageIcon("src\\Vista\\Images\\fondo.jpg");
		Icon icon = new ImageIcon(image.getImage().getScaledInstance(font3.getWidth(), font3.getHeight(), Image.SCALE_DEFAULT));
		font3.setIcon(icon);
		this.add(font3);
	}

	private void addLabels() {
		JLabel label1 = new JLabel();
		label1.setText("Usuario: ");
		label1.setBounds(400, 200, 150, 20);
		this.add(label1);
		
		JLabel label2 = new JLabel();
		label2.setText("Contraseña: ");
		label2.setBounds(400, 270, 150, 20);
		this.add(label2);
	}
	
	private void addTextFields() {
		userName = new JTextField();
		userName.setBounds(400, 230, 150, 20);
		this.add(userName);
		
		password = new JPasswordField();
		password.setBounds(400, 300, 150, 20);
		this.add(password);
	}
	
	private void addButtons() {
		loginButton = new JButton();
		loginButton.setText("Iniciar Sesion");
		loginButton.setBounds(400, 340, 150, 20);
		this.add(loginButton);
		
		home = new JButton();
		home.setText("Volver");
		home.setBounds(20, 20, 80, 20);
		this.add(home);
	}

	public JTextField getUserName() {
		return userName;
	}

	public JButton getLoginButton() {
		return loginButton;
	}

	public void setUserName(JTextField userName) {
		this.userName = userName;
	}

	public void setLoginButton(JButton loginButton) {
		this.loginButton = loginButton;
	}

	public JPasswordField getPassword() {
		return password;
	}

	public void setPassword(JPasswordField password) {
		this.password = password;
	}

	public JButton getHome() {
		return home;
	}

	public void setHome(JButton home) {
		this.home = home;
	}
	
	
}
