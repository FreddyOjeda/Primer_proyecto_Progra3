package Vista;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPanel extends JPanel{

	private JTextField userName;
	private JPasswordField password;
	private JButton loginButton;
	
	public LoginPanel() {
		this.setOpaque(true);
		this.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(375, 170, 200, 230);
		panel.setBorder(BorderFactory.createTitledBorder("Login"));
		panel.setOpaque(true);
		
		addLabels();
		addButtons();
		addTextFields();
		this.add(panel);
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
	
	
}
