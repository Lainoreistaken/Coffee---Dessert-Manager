package package1;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class SelectionForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtId;
	private JTextField txtType;
	public DefaultListModel<String> listModel;
	public JList list;
	public JComboBox cb_Slc;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectionForm frame = new SelectionForm();
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
	public SelectionForm() {
		setTitle("SelectionForm");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(10, 35, 42, 14);
		contentPane.add(lblId);
		
		textField = new JTextField();
		textField.setBounds(62, 32, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(62, 81, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblType = new JLabel("Type: ");
		lblType.setBounds(10, 84, 52, 14);
		contentPane.add(lblType);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Selection slc = new Selection();
				slc.id = Integer.parseInt( txtId.getText() );
				slc.type = txtType.getText();
				MainForm.selections.add(slc);
				txtId.setText("");
				txtType.setText("");
			}
		});
		btnSave.setBounds(10, 142, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(10, 189, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblTypes = new JLabel("Types");
		lblTypes.setBounds(338, 11, 63, 14);
		contentPane.add(lblTypes);
		
		listModel = new DefaultListModel<String>();
		
		list = new JList(listModel);
		list.setBackground(Color.LIGHT_GRAY);
		list.setBounds(326, 64, 89, 155);
		contentPane.add(list);
		
		DefaultComboBoxModel<String> cbModel = new DefaultComboBoxModel<String>();
		cb_Slc = new JComboBox(cbModel);
		cb_Slc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				filltheList();
				
			}
		});
		
		cb_Slc.setBounds(312, 28, 112, 22);
		contentPane.add(cb_Slc);
		
		MainForm.selections.forEach(s -> cbModel.addElement(s.title));
		
		
		
		JButton btnDelCoffee = new JButton("Delete Coffee");
		btnDelCoffee.setBounds(167, 155, 114, 23);
		contentPane.add(btnDelCoffee);
		
		JButton btnDelType = new JButton("Delete Type");
		btnDelType.setBounds(167, 189, 114, 23);
		contentPane.add(btnDelType);
	}

}
