package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Controlador.Management;

public class Consola extends JFrame{

	private Management management;

	private MainPanel mainPanel;

	private UserPanel userPanel;
	private LoginPanel loginPanel;
	private AdministratorPanel administratorPanel;

	public Consola() {
		management = new Management();
		mainPanel = new MainPanel();
		userPanel = new UserPanel();
		loginPanel = new LoginPanel();
		administratorPanel = new AdministratorPanel();

		this.setSize(950, 680);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Diccionario (Felipe Dueñas - Freddy Ojeda)");
		this.setResizable(false);

		//addUserPanel();
		//addLoginPanel();
		addMainPanel();
		events();
	}

	//Control del panel del usuario.
	private void addUserPanel() {
		this.add(userPanel);
		userPanel.setVisible(true);
	}
	private void removeUserPanel() {
		userPanel.setVisible(false);
		this.remove(userPanel);
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

	//Control del panel principal
	private void addMainPanel() {
		this.add(mainPanel);
		mainPanel.setVisible(true);
	}
	private void removeMainPanel() {
		mainPanel.setVisible(false);
		this.remove(mainPanel);
	}

	private void events() {
		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//ACCIONES DEL PANEL PRINCIPAL
				if (mainPanel.getUsers().equals(e.getSource())) {
					removeMainPanel();
					addUserPanel();
				}
				if (mainPanel.getAdministrator().equals(e.getSource())) {
					removeMainPanel();
					addLoginPanel();
				}

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
				if (loginPanel.getHome().equals(e.getSource())) {
					removeLoginpanel();
					addMainPanel();
				}

				//ACCIONES DEL PANEL DE USUARIO
				if (userPanel.getHome().equals(e.getSource())) {
					removeUserPanel();
					addMainPanel();
				}


				if (userPanel.getButton().equals(e.getSource())) {

				}

				// MOSTRAR PALABRAS EN LA TABLA
				if(userPanel.getBox().equals(e.getSource())){

					cleanTableWords();
					
					String [][] vectorTwo = null;
					String comboContent = userPanel.getBox().getSelectedItem().toString();

					if(comboContent.equals("Todo")) {
						vectorTwo = management.listedWords();
					}else {
						vectorTwo = management.listedByCharacter(comboContent.charAt(0));
					}

					for(int i=0; i<vectorTwo.length; i++) {		
						userPanel.getDefaultTableModel().addRow(vectorTwo[i]);
					}
					
				}


				//ACCIONES DEL PANEL DE ADMINISTRADOR
				//ACCIONES DEL PANEL DE ADMINISTRADOR - AGREGAR PALABRA
				
				if (administratorPanel.getAdd().equals(e.getSource())){

					if(administratorPanel.getNameAdd().getText().equals("") ||
							administratorPanel.getMeaningAdd().getText().equals("") ||
							administratorPanel.getTranslationAdd().getText().equals("")){

						JOptionPane.showMessageDialog(null,"Por favor complete todos los campos");
					}
					else{
						try {

							String nameAdd = administratorPanel.getNameAdd().getText();
							String meaningAdd = administratorPanel.getMeaningAdd().getText();
							String translationAdd = administratorPanel.getTranslationAdd().getText();

							if(management.addWord(nameAdd, meaningAdd, translationAdd) == true){
								JOptionPane.showMessageDialog(null, "Palabra agregada correctamente");
							}else {
								JOptionPane.showMessageDialog(null, "No se pudo agregar la palabra");
							}
						}
						catch (Exception exception){
							JOptionPane.showMessageDialog(null, "No se pudo agregar la palabra");
						}
					}
					administratorPanel.getNameAdd().setText("");
					administratorPanel.getMeaningAdd().setText("");
					administratorPanel.getTranslationAdd().setText("");
				}


				// ACCIONES DEL PANEL DE ADMINISTRADOR - EDITAR PALABRA - BUSCAR
				if(administratorPanel.getSearchEdit().equals(e.getSource())){

					if(administratorPanel.getNameEdit().getText().equals("")) {
						JOptionPane.showMessageDialog(null,"Por favor ingrese la palabra que quiere buscar");

					}else{
						try {

							String nameEdit = administratorPanel.getNameEdit().getText();

							if(management.searchWord(nameEdit) != null) {

								String[] vector = management.searchWord(nameEdit);

								administratorPanel.getMeaningEdit().setText(vector[1]);
								administratorPanel.getTranslationEdit().setText(vector[2]);

								administratorPanel.getMeaningEdit().setEnabled(true);
								administratorPanel.getTranslationEdit().setEnabled(true);
								administratorPanel.getNameEdit().setEnabled(false);
							}else {
								JOptionPane.showMessageDialog(null, "No se encontro la palabra");
								administratorPanel.getNameEdit().setText("");
								administratorPanel.getMeaningEdit().setText("");
								administratorPanel.getTranslationEdit().setText("");
								administratorPanel.getMeaningEdit().setEnabled(false);
								administratorPanel.getTranslationEdit().setEnabled(false);
							}
						}catch (Exception exception) {
							administratorPanel.getNameEdit().setText("");
							administratorPanel.getMeaningEdit().setText("");
							administratorPanel.getTranslationEdit().setText("");
							administratorPanel.getMeaningEdit().setEnabled(false);
							administratorPanel.getTranslationEdit().setEnabled(false);
							JOptionPane.showMessageDialog(null, "Por favor ingrese una palabra valida");
						}
					}
				}

				//ACCIONES PANEL DEL ADMINISTRADOR - EDITAR PALABRA - GUARDAR CAMBIOS
				if(administratorPanel.getEdit().equals(e.getSource())){

					try {

						if(administratorPanel.getNameEdit().getText().equals("") ||
								administratorPanel.getMeaningEdit().getText().equals("") ||
								administratorPanel.getTranslationEdit().getText().equals("")){
							JOptionPane.showMessageDialog(null,"No fue posible editar la palabra, por favor complete todos los campos");
						}else {

							String nameEdit = administratorPanel.getNameEdit().getText();
							String meaningEdit = administratorPanel.getMeaningEdit().getText();
							String translationEdit = administratorPanel.getTranslationEdit().getText();

							if(management.updateWork(nameEdit, meaningEdit, translationEdit)== true) {
								JOptionPane.showMessageDialog(null, "Palabra actualizada correctamente");
							}else {
								JOptionPane.showMessageDialog(null, "No fue posible actualizar la palabra");
							}
						}
					} catch (Exception exception) {
						JOptionPane.showMessageDialog(null, "No fue posible actualizar la palabra");
					}

					administratorPanel.getNameEdit().setText("");
					administratorPanel.getMeaningEdit().setText("");
					administratorPanel.getTranslationEdit().setText("");
					administratorPanel.getNameEdit().setEnabled(true);
					administratorPanel.getMeaningEdit().setEnabled(false);
					administratorPanel.getTranslationEdit().setEnabled(false);
				}


				// ACCIONES DEL PANEL DE ADMINISTRADOR - ELIMINAR - BUSCAR
				if(administratorPanel.getSearchDelete().equals(e.getSource())){
					//
					if(administratorPanel.getNameDelete().getText().equals("")) {
						JOptionPane.showMessageDialog(null,"Por favor ingrese todos los campos");

					}else{
						try {
							String nameDelete = administratorPanel.getNameDelete().getText();

							if(management.searchWord(nameDelete) != null) {

								String[] vector = management.searchWord(nameDelete);

								administratorPanel.getMeaningDelete().setText(vector[1]);
								administratorPanel.getTranslationDelete().setText(vector[2]);

							}else {
								JOptionPane.showMessageDialog(null, "No se encontro la palabra");
								administratorPanel.getNameDelete().setText("");
								administratorPanel.getMeaningDelete().setText("");
								administratorPanel.getTranslationDelete().setText("");
							}
						}catch (Exception exception) {
							administratorPanel.getNameDelete().setText("");
							administratorPanel.getMeaningDelete().setText("");
							administratorPanel.getTranslationDelete().setText("");
							JOptionPane.showMessageDialog(null, "Por favor ingrese una palabra valida");
						}
					}	
				}

				// ACCIONES DEL PANEL DE ADMINISTRADOR - ELIMINAR
				if(administratorPanel.getDelete().equals(e.getSource())){

					try {
						if(administratorPanel.getNameDelete().getText().equals("") || 
								administratorPanel.getMeaningDelete().getText().equals("") ||
								administratorPanel.getTranslationDelete().getText().equals("")){

							JOptionPane.showMessageDialog(null, "No fue posible eliminar la palabra, por favor complete todos los campos");
						}else {
							String nameDelete = administratorPanel.getNameDelete().getText();

							if( management.deleteWord(nameDelete) == true) {

								JOptionPane.showMessageDialog(null, "Palabra eliminada correctamente");
							}else {
								JOptionPane.showMessageDialog(null, "No se pudo eliminar la palabra");
							}
						}
					}catch (Exception exception) {
						JOptionPane.showMessageDialog(null, "No se pudo eliminar la palabra");
					}
					administratorPanel.getNameDelete().setText("");
					administratorPanel.getMeaningDelete().setText("");
					administratorPanel.getTranslationDelete().setText("");
				}

				// CERRAR SESIÓN ADMINISTRADOR

				if (administratorPanel.getSignOut().equals(e.getSource())) {
					removeAdministratorPanel();
					addMainPanel();
				}
			}
		};

		mainPanel.getUsers().addActionListener(action);
		mainPanel.getAdministrator().addActionListener(action);
		loginPanel.getLoginButton().addActionListener(action);
		loginPanel.getHome().addActionListener(action);

		userPanel.getHome().addActionListener(action);
		userPanel.getButton().addActionListener(action);
		userPanel.getBox().addActionListener(action);

		administratorPanel.getAdd().addActionListener(action);
		administratorPanel.getEdit().addActionListener(action);
		administratorPanel.getSearchEdit().addActionListener(action);
		administratorPanel.getDelete().addActionListener(action);
		administratorPanel.getSearchDelete().addActionListener(action);
		administratorPanel.getSignOut().addActionListener(action);


	}

	public void cleanTableWords() {
		for (int i = 0; i < userPanel.getDefaultTableModel().getRowCount(); i++) {
			userPanel.getDefaultTableModel().removeRow(i);
			i--;
		}
	}

}
