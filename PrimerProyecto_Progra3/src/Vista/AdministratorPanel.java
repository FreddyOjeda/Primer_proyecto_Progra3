package Vista;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AdministratorPanel extends JPanel{
	
	private JButton add;
	private JButton edit;
	private JButton delete;
	private JButton searchEdit;
	private JButton searchDelete;
	
	private JTextField nameAdd;
	private JTextField translationAdd;
	private JTextField nameEdit;
	private JTextField translationEdit;
	private JTextField nameDelete;
	private JTextField translationDelete;
	
	private JTextArea meaningAdd;
	private JTextArea meaningEdit;
	private JTextArea meaningDelete;
	
	
	public AdministratorPanel() {
		this.setOpaque(true);
		this.setLayout(null);
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(75, 70, 200, 500);
		panel1.setBorder(BorderFactory.createTitledBorder("Agregar"));
		panel1.setOpaque(true);
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(375, 70, 200, 500);
		panel2.setBorder(BorderFactory.createTitledBorder("Editar"));
		panel2.setOpaque(true);
		
		JPanel panel3 = new JPanel();
		panel3.setBounds(675, 70, 200, 500);
		panel3.setBorder(BorderFactory.createTitledBorder("Eliminar"));
		panel3.setOpaque(true);
		
		addButtons();
		addTextFields();
		addTextAreas();
		addLabels();
		
		this.add(panel1);
		this.add(panel2);
		this.add(panel3);
	}
	
	private void addButtons() {
		add = new JButton();
		add.setText("Agregar");
		add.setBounds(100, 500, 150, 20);
		this.add(add);
		
		edit = new JButton();
		edit.setText("Guardar Cambios");
		edit.setBounds(400, 500, 150, 20);
		this.add(edit);
		
		delete = new JButton();
		delete.setText("Eliminar");
		delete.setBounds(700, 500, 150, 20);
		this.add(delete);
		
		searchEdit = new JButton();
		searchEdit.setText("Buscar");
		searchEdit.setBounds(400, 170,150,20);
		this.add(searchEdit);
		
		searchDelete = new JButton();
		searchDelete.setText("Buscar");
		searchDelete.setBounds(700, 170,150,20);
		this.add(searchDelete);
	}
	
	private void addTextFields() {
		nameAdd = new JTextField();
		nameAdd.setBounds(100, 140, 150, 20);
		this.add(nameAdd);
		
		nameEdit = new JTextField();
		nameEdit.setBounds(400, 140, 150, 20);
		this.add(nameEdit);
		
		nameDelete = new JTextField();
		nameDelete.setBounds(700, 140, 150, 20);
		this.add(nameDelete);
		
		translationAdd = new JTextField();
		translationAdd.setBounds(100, 430, 150, 20);
		this.add(translationAdd);
		
		translationEdit = new JTextField();
		translationEdit.setBounds(400, 430, 150, 20);
		this.add(translationEdit);
		
		translationDelete = new JTextField();
		translationDelete.setBounds(700, 430, 150, 20);
		this.add(translationDelete);
	}
	
	private void addTextAreas() {
		meaningAdd = new JTextArea();
		meaningAdd.setBounds(100, 240, 150, 110);
		meaningAdd.setBorder(BorderFactory.createTitledBorder(""));
		meaningAdd.setLineWrap(true);
		this.add(meaningAdd);
		
		meaningEdit = new JTextArea();
		meaningEdit.setBounds(400, 240, 150, 110);
		meaningEdit.setBorder(BorderFactory.createTitledBorder(""));
		meaningEdit.setLineWrap(true);
		this.add(meaningEdit);
		
		meaningDelete = new JTextArea();
		meaningDelete.setBounds(700, 240, 150, 110);
		meaningDelete.setBorder(BorderFactory.createTitledBorder(""));
		meaningDelete.setLineWrap(true);
		this.add(meaningDelete);
		
	}

	private void addLabels() {
		JLabel label1 = new JLabel();
		label1.setText("Palabra: ");
		label1.setHorizontalAlignment(JLabel.CENTER);
		label1.setBounds(100, 100, 150, 20);
		this.add(label1);
		
		JLabel label2 = new JLabel();
		label2.setText("Palabra: ");
		label2.setHorizontalAlignment(JLabel.CENTER);
		label2.setBounds(400, 100, 150, 20);
		this.add(label2);
		
		JLabel label3 = new JLabel();
		label3.setText("Palabra: ");
		label3.setHorizontalAlignment(JLabel.CENTER);
		label3.setBounds(700, 100, 150, 20);
		this.add(label3);
		
		JLabel label4 = new JLabel();
		label4.setText("Significado: ");
		label4.setHorizontalAlignment(JLabel.CENTER);
		label4.setBounds(100, 200, 150, 20);
		this.add(label4);
		
		JLabel label5 = new JLabel();
		label5.setText("Significado: ");
		label5.setHorizontalAlignment(JLabel.CENTER);
		label5.setBounds(400, 200, 150, 20);
		this.add(label5);
		
		JLabel label6 = new JLabel();
		label6.setText("Significado: ");
		label6.setHorizontalAlignment(JLabel.CENTER);
		label6.setBounds(700, 200, 150, 20);
		this.add(label6);
		
		JLabel label7 = new JLabel();
		label7.setText("Traduccion (ingles): ");
		label7.setHorizontalAlignment(JLabel.CENTER);
		label7.setBounds(100, 390, 150, 20);
		this.add(label7);
		
		JLabel label8 = new JLabel();
		label8.setText("Traduccion (ingles): ");
		label8.setHorizontalAlignment(JLabel.CENTER);
		label8.setBounds(400, 390, 150, 20);
		this.add(label8);
		
		JLabel label9 = new JLabel();
		label9.setText("Traduccion (ingles): ");
		label9.setHorizontalAlignment(JLabel.CENTER);
		label9.setBounds(700, 390, 150, 20);
		this.add(label9);
	}

	public JButton getAdd() {
		return add;
	}

	public JButton getEdit() {
		return edit;
	}

	public JButton getDelete() {
		return delete;
	}

	public JTextField getNameAdd() {
		return nameAdd;
	}

	public JTextField getTranslationAdd() {
		return translationAdd;
	}

	public JTextField getNameEdit() {
		return nameEdit;
	}

	public JTextField getTranslationEdit() {
		return translationEdit;
	}

	public JTextField getNameDelete() {
		return nameDelete;
	}
	public JTextField getTranslationDelete() {
		return translationDelete;
	}

	public void setAdd(JButton add) {
		this.add = add;
	}

	public void setEdit(JButton edit) {
		this.edit = edit;
	}

	public void setDelete(JButton delete) {
		this.delete = delete;
	}

	public void setNameAdd(JTextField nameAdd) {
		this.nameAdd = nameAdd;
	}

	public void setTranslationAdd(JTextField translationAdd) {
		this.translationAdd = translationAdd;
	}

	public void setNameEdit(JTextField nameEdit) {
		this.nameEdit = nameEdit;
	}

	public void setTranslationEdit(JTextField translationEdit) {
		this.translationEdit = translationEdit;
	}

	public void setNameDelete(JTextField nameDelete) {
		this.nameDelete = nameDelete;
	}

	public void setTranslationDelete(JTextField translationDelete) {
		this.translationDelete = translationDelete;
	}

	public JButton getSearchEdit() {
		return searchEdit;
	}

	public JButton getSearchDelete() {
		return searchDelete;
	}

	public JTextArea getMeaningAdd() {
		return meaningAdd;
	}

	public JTextArea getMeaningEdit() {
		return meaningEdit;
	}

	public JTextArea getMeaningDelete() {
		return meaningDelete;
	}

	public void setSearchEdit(JButton searchEdit) {
		this.searchEdit = searchEdit;
	}

	public void setSearchDelete(JButton searchDelete) {
		this.searchDelete = searchDelete;
	}

	public void setMeaningAdd(JTextArea meaningAdd) {
		this.meaningAdd = meaningAdd;
	}

	public void setMeaningEdit(JTextArea meaningEdit) {
		this.meaningEdit = meaningEdit;
	}

	public void setMeaningDelete(JTextArea meaningDelete) {
		this.meaningDelete = meaningDelete;
	}
	
	

}
