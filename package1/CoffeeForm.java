package package1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CoffeeForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtId;
	private JTextField txtName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoffeeForm frame = new CoffeeForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CoffeeForm() {
		setTitle("CoffeeForm");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID: ");
		lblId.setBounds(10, 29, 46, 14);
		contentPane.add(lblId);
		
		textField = new JTextField();
		textField.setBounds(66, 26, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(66, 79, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 82, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblType = new JLabel("Type: ");
		lblType.setBounds(10, 141, 46, 14);
		contentPane.add(lblType);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(66, 137, 86, 22);
		contentPane.add(comboBox);
		MainForm.selections.forEach(s -> comboBox.addItem(s.title));
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Coffee cfe = new Coffee();
				cfe.id = Integer.parseInt(txtId.getText());
				cfe.name = txtName.getText();
				cfe.selection = new Selection();
				
				for(Selection s: MainForm.selections) {
					if(s.title.equals(comboBox.getSelectedItem().toString())) {
						cfe.selection = s;
					}
				}
				MainForm.coffees.add(cfe);
				txtId.setText("");
				txtName.setText("");
				comboBox.setSelectedIndex(0);
			}
		});
		btnSave.setBounds(10, 188, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBack.setBounds(10, 222, 89, 23);
		contentPane.add(btnBack);
	}
}
