package Vista;

import javax.swing.JFrame;

public class Consola extends JFrame{
	
	private MainPanel mainPanel;
	
	
	public Consola() {
		
		mainPanel = new MainPanel();
		
		this.setSize(950, 680);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Diccionario (Felipe Dueñas - Freddy Ojeda)");
		this.setResizable(false);
		
		addMainPanel();
	}
	
	//agrega el panel a la ventana
	public void addMainPanel() {
		this.add(mainPanel);
		mainPanel.setVisible(true);
	}
	public void removeMainPanel() {
		mainPanel.setVisible(false);
		this.remove(mainPanel);
	}

}
