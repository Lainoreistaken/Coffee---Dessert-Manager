package package1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pack1.Department;
import pack1.Student;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class MainForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	static ArrayList<Selection> selections = new ArrayList<Selection>();
	static ArrayList<Coffee> coffees = new ArrayList<Coffee>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm frame = new MainForm();
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
	public MainForm() {
		setTitle("MainForm");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCoffeeForm = new JButton("CoffeeForm");
		btnCoffeeForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CoffeeForm cfForm = new CoffeeForm();
				cfForm.setVisible(true);
			}
		});
		btnCoffeeForm.setBounds(120, 29, 158, 62);
		contentPane.add(btnCoffeeForm);
		
		JButton btnSelectionform = new JButton("SelectionForm");
		btnSelectionform.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectionForm slcForm = new SelectionForm();
				slcForm.setVisible(true);
			}
		});
		btnSelectionform.setBounds(120, 131, 158, 62);
		contentPane.add(btnSelectionform);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(316, 227, 89, 23);
		contentPane.add(btnExit);
	}
}
