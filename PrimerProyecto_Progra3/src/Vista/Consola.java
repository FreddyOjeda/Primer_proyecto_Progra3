package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Controlador.Management;

public class Consola extends JFrame{
	
	private Management management;
	
	private MainPanel mainPanel;
	private LoginPanel loginPanel;
	private AdministratorPanel administratorPanel;
	
	public Consola() {
		management = new Management();
		mainPanel = new MainPanel();
		loginPanel = new LoginPanel();
		administratorPanel = new AdministratorPanel();
		
		this.setSize(950, 680);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Diccionario (Felipe Dueñas - Freddy Ojeda)");
		this.setResizable(false);
		
		//addMainPanel();
		addLoginPanel();
		//addAdministratorPanel();
		events();
	}
	
	//Control del panel principal.
	public void addMainPanel() {
		this.add(mainPanel);
		mainPanel.setVisible(true);
	}
	public void removeMainPanel() {
		mainPanel.setVisible(false);
		this.remove(mainPanel);
	}
	
	//Control del panel de iniciar sesion.
	private void addLoginPanel() {
		this.add(loginPanel);
		loginPanel.setVisible(true);
	}
	private void removeLoginpanel() {
		loginPanel.setVisible(false);
		this.remove(loginPanel);
	}
	
	//Control del panel de administrador
	private void addAdministratorPanel() {
		this.add(administratorPanel);
		administratorPanel.setVisible(true);
	}
	private void removeAdministratorPanel() {
		administratorPanel.setVisible(false);
		this.remove(administratorPanel);
	}
	
	private void events() {
		ActionListener action = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//ACCIONES DEL PANEL INICIAR SESION
				if (loginPanel.getLoginButton().equals(e.getSource())) {
					if (management.singnUp(loginPanel.getUserName().getText(), loginPanel.getPassword().getText())) {
						loginPanel.getUserName().setText("");
						loginPanel.getPassword().setText("");
						removeLoginpanel();
						addAdministratorPanel();
					}else {
						JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta");
						loginPanel.getUserName().setText("");
						loginPanel.getPassword().setText("");
					}
				}
				
				//ACCIONES DEL PANEL DE ADMINISTRADOR
				if (administratorPanel.getAdd().equals(e.getSource())) {
					management.addWord(administratorPanel.getNameAdd().getText(), administratorPanel.getMeaningAdd().getText(), administratorPanel.getTranslationAdd().getText());
					administratorPanel.getNameAdd().setText("");
					administratorPanel.getMeaningAdd().setText("");
					administratorPanel.getTranslationAdd().setText("");
				}
			}
		};
		loginPanel.getLoginButton().addActionListener(action);
		mainPanel.getEdit().addActionListener(action);
		administratorPanel.getAdd().addActionListener(action);
		administratorPanel.getEdit().addActionListener(action);
		administratorPanel.getDelete().addActionListener(action);
	}

}
