package Vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class UserPanel extends JPanel{

	JComboBox box;
	JButton home;
	private JButton button;
	DefaultTableModel defaultTableModel;
	
	public UserPanel() {
		this.setOpaque(true);
		this.setLayout(null);
		
		addComponents();
		addComboBox();
		addTable();
		addLabels();
	}
	
	private void addLabels() {
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

	private void addComponents() {
		JPanel panel = new JPanel();
		panel.setBounds(400, 50, 450, 250);
		panel.setBorder(BorderFactory.createTitledBorder("Datos: ")); 
		this.add(panel);
		
		home = new JButton();
		home.setText("Volver");
		home.setBounds(20, 20, 80, 20);
		this.add(home);
		
		button = new JButton();
		button.setText("<html><p>Ver</p><p>Detalles</p></html>");
		button.setBounds(320, 180, 65, 50);
		button.setPreferredSize(null);
		this.add(button);
	}
	
	private void addComboBox() {
		String [] filters = {"Todo","A","B","C","D","E","F","G","H","J","K","L","M","N","Ñ","O","P","Q","R","S","T","U","V","W","X","Y","Z"}; 
		box = new JComboBox(filters);
		box.setBounds(130,57,120,20);
		this.add(box);
	}
	
	private void addTable() {
		JPanel contenedor = new JPanel();
		contenedor.setBorder(BorderFactory.createTitledBorder("Palabras")); 
		contenedor.setBackground(new Color(0,0,0,0));
		contenedor.setBounds(70,97,240,509);
		this.add(contenedor);
		
		String [] ColumnNames = {"Palabra","Definicion","Traduccion"};
		
		defaultTableModel = new DefaultTableModel();
		//DefaultTableModel defaultTableModel = new DefaultTableModel();
		defaultTableModel.setColumnIdentifiers(ColumnNames);
		
		JTable jTable = new JTable(defaultTableModel) {
			@Override
			public Dimension getPreferredScrollableViewportSize() {
				return new Dimension(225, 455);
			}
		};
		
		jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		JScrollPane jScrollPane = new JScrollPane(jTable);
		contenedor.add(jScrollPane);
	}	

	
	public DefaultTableModel getDefaultTableModel() {
		return defaultTableModel;
	}
	
	public JComboBox getBox() {
		return box;
	}

	public void setBox(JComboBox box) {
		this.box = box;
	}

	public JButton getHome() {
		return home;
	}

	public void setHome(JButton home) {
		this.home = home;
	}

	public JButton getButton() {
		return button;
	}

	public void setButton(JButton button) {
		this.button = button;
	}
	
	
	
	
}
