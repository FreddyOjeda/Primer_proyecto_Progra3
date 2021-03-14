package Vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MainPanel extends JPanel{

	JButton add;
	JButton edit;
	JButton delete;
	JPanel panel_;
	JPanel editPanel;
	
	public MainPanel() {
		this.setOpaque(true);
		this.setLayout(null);
		
		addComponents();
		addComboBox();
		addButtons();
		addTable();
	}
	
	private void addComponents() {
		JPanel panel = new JPanel();
		//panel.add(new JLabel("foo"));
		panel.setBounds(400, 50, 450, 250);
		panel.setBorder(BorderFactory.createTitledBorder("Datos: ")); 
		this.add(panel);
		
		panel_ = new JPanel();
		//panel.add(new JLabel("foo"));
		panel_.setBounds(400, 355, 450, 250);
		panel_.setBorder(BorderFactory.createTitledBorder("")); 
		this.add(panel_);
	}
	
	private void addComboBox() {
		String [] filters = {"Todo","A","B","C","D","E","F","G","H","J","K","L","M","N","Ñ","O","P","Q","R","S","T","U","V","W","X","Y","Z"}; 
		JComboBox box = new JComboBox(filters);
		box.setBounds(130,57,120,20);
		this.add(box);
	}
	
	private void addButtons() {
		add = new JButton();
		add.setBounds(400, 330, 100, 25);
		add.setText("Agregar");
		this.add(add);
		
		edit = new JButton();
		edit.setBounds(500, 330, 100, 25);
		edit.setText("Editar");
		this.add(edit);
		
		delete = new JButton();
		delete.setBounds(600, 330, 100, 25);
		delete.setText("Eliminar");
		this.add(delete);
	}
	
	private void addTable() {
		JPanel contenedor = new JPanel();
		contenedor.setBorder(BorderFactory.createTitledBorder("Palabras")); 
		contenedor.setBackground(new Color(0,0,0,0));
		contenedor.setBounds(70,97,240,509);
		this.add(contenedor);
		
		String [] ColumnNames = {"Palabra","Definicion","Traduccion"};
		DefaultTableModel defaultTableModel = new DefaultTableModel();
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

	public JButton getAdd() {
		return add;
	}

	public void setAdd(JButton add) {
		this.add = add;
	}

	public JButton getEdit() {
		return edit;
	}

	public void setEdit(JButton edit) {
		this.edit = edit;
	}

	public JButton getDelete() {
		return delete;
	}

	public void setDelete(JButton delete) {
		this.delete = delete;
	}

	public JPanel getPanel_() {
		return panel_;
	}

	public void setPanel_(JPanel panel_) {
		this.panel_ = panel_;
	}
	
	
}
