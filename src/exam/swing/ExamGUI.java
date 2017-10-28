package exam.swing;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;


public class ExamGUI extends JFrame {
	GetConnection gc = new GetConnection();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTextField textField;
	public JPasswordField passwordField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable table;
		/*
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExamGUI frame = new ExamGUI();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			});
		}		
	


	
	/**
	 * Create the frame.
	 * @return 
	 */

	public ExamGUI() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 934, 616);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		JPanel LoginScreen = new JPanel();
		contentPane.add(LoginScreen, "name_178480656964087");
		LoginScreen.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(317, 300, 89, 17);
		LoginScreen.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(317, 404, 65, 14);
		LoginScreen.add(lblNewLabel_2);

		textField = new JTextField();
		textField.setBounds(500, 297, 140, 20);
		LoginScreen.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(500, 403, 140, 20);
		LoginScreen.add(passwordField);

		JButton btnNewButton = new JButton("Submit");

		btnNewButton.setBounds(409, 508, 89, 23);
		LoginScreen.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ExamGUI.class.getResource("/images/bias logo.png")));
		lblNewLabel.setBounds(275, 87, 476, 175);
		LoginScreen.add(lblNewLabel);

		JPanel ChooseTest = new JPanel();
		contentPane.add(ChooseTest, "name_178480776256829");
		ChooseTest.setLayout(null);

		JLabel lblPleaseChooseOne = new JLabel("Please choose one of the following.");
		lblPleaseChooseOne.setBounds(303, 91, 302, 35);
		lblPleaseChooseOne.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
		lblPleaseChooseOne.setHorizontalAlignment(SwingConstants.CENTER);
		ChooseTest.add(lblPleaseChooseOne);

		JButton btnNewButton_1 = new JButton("English");
		btnNewButton_1.setBounds(419, 222, 100, 28);
		ChooseTest.add(btnNewButton_1);

		JPanel MathTest = new JPanel();
		MathTest.setAutoscrolls(true);
		contentPane.add(MathTest, "name_178480893654333");
		MathTest.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("Math");
		lblNewLabel_4.setBounds(419, 0, 70, 35);
		lblNewLabel_4.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		MathTest.add(lblNewLabel_4);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(6, 38, 896, 456);
		MathTest.add(scrollPane_1);

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setWrapStyleWord(true);
		textArea_1.setLocation(9, 0);
		scrollPane_1.setViewportView(textArea_1);
		textArea_1.setEditable(false);
		
		JButton btnNewButton_3 = new JButton("Submit");
		
		btnNewButton_3.setBounds(409, 513, 90, 28);
		MathTest.add(btnNewButton_3);

		JPanel ReadingTest = new JPanel();
		contentPane.add(ReadingTest, "name_178481009002998");
		ReadingTest.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("Reading");
		lblNewLabel_5.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(401, 10, 105, 40);
		ReadingTest.add(lblNewLabel_5);

		JButton button_1 = new JButton("Submit");

		button_1.setBounds(409, 531, 89, 23);
		ReadingTest.add(button_1);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(6, 60, 896, 461);
		ReadingTest.add(scrollPane_2);

		JTextArea textArea_2 = new JTextArea();
		textArea_2.setEditable(false);
		scrollPane_2.setViewportView(textArea_2);

		JPanel EnglishTest = new JPanel();
		contentPane.add(EnglishTest, "name_178481082461777");
		EnglishTest.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("English");
		lblNewLabel_3.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(427, 10, 54, 35);
		EnglishTest.add(lblNewLabel_3);

		JButton button_2 = new JButton("Submit");

		button_2.setBounds(409, 531, 89, 23);
		EnglishTest.add(button_2);

		JTextArea textArea_3 = new JTextArea();
		textArea_3.setEditable(false);
		textArea_3.setBounds(6, 55, 896, 466);
		EnglishTest.add(textArea_3);

		JPanel Results = new JPanel();
		contentPane.add(Results, "name_178481150670163");
		Results.setLayout(null);

		JLabel lblResults = new JLabel("Results");
		lblResults.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 18));
		lblResults.setHorizontalAlignment(SwingConstants.CENTER);
		lblResults.setBounds(338, 67, 231, 82);
		Results.add(lblResults);
		
		JTextArea textArea = new JTextArea();
		textArea.setForeground(Color.BLACK);
		textArea.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 19));
		textArea.setEditable(false);
		textArea.setBounds(6, 199, 896, 104);
		
		Results.add(textArea);

		JPanel LoginFail = new JPanel();
		contentPane.add(LoginFail, "name_178481228780857");
		LoginFail.setLayout(null);

		JButton btnNewButton_2 = new JButton("OK");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CardLayout cardLayout = (CardLayout)contentPane.getLayout();
				cardLayout.first(contentPane);
			}
		});
				
		btnNewButton_2.setBounds(389, 367, 130, 50);
		LoginFail.add(btnNewButton_2);

		JLabel lblNewLabel_6 = new JLabel("Error! Authentication Failed.");
		lblNewLabel_6.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(341, 147, 296, 71);
		LoginFail.add(lblNewLabel_6);

		JButton btnMath = new JButton("Math");
		btnMath.setBounds(419, 346, 100, 28);
		ChooseTest.add(btnMath);

		JButton btnReading = new JButton("Reading");
		btnReading.setBounds(419, 470, 100, 28);
		ChooseTest.add(btnReading);
		
		JPanel Root = new JPanel();
		contentPane.add(Root, "name_78230353664963");
		Root.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Welcome!");
		lblNewLabel_7.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
		lblNewLabel_7.setBounds(412, 44, 83, 60);
		Root.add(lblNewLabel_7);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(296, 292, 336, 26);
		Root.add(comboBox);
		
		JLabel lblSearchByName = new JLabel("Please choose one of the following filters:");
		lblSearchByName.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 14));
		lblSearchByName.setBounds(324, 116, 257, 60);
		Root.add(lblSearchByName);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Name");
		
		
		buttonGroup.add(chckbxNewCheckBox);
		chckbxNewCheckBox.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 14));
		chckbxNewCheckBox.setBounds(296, 208, 104, 18);
		Root.add(chckbxNewCheckBox);
		
		JCheckBox chckbxUserid_1 = new JCheckBox("UserID");
		buttonGroup.add(chckbxUserid_1);
		chckbxUserid_1.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 14));
		chckbxUserid_1.setBounds(412, 208, 104, 18);
		Root.add(chckbxUserid_1);
		
		JCheckBox chckbxExamType_1 = new JCheckBox("Exam Type");
		buttonGroup.add(chckbxExamType_1);
		chckbxExamType_1.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 14));
		chckbxExamType_1.setBounds(528, 208, 104, 18);
		Root.add(chckbxExamType_1);
		
		JButton btnNewButton_4 = new JButton("Go!");
		
		btnNewButton_4.setBounds(409, 475, 90, 28);
		Root.add(btnNewButton_4);
		
		JPanel Display = new JPanel();
		contentPane.add(Display, "name_319718558691756");
		Display.setLayout(new BorderLayout());
		
		
		table = new JTable();
		table.setEnabled(false);
		table.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 14));
		table.setRowSelectionAllowed(false);
		table.setBorder(null);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setShowVerticalLines(true);
		table.setShowHorizontalLines(true);
		table.setBounds(6, 443, 896, -370);
		JScrollPane scrollPane_3 = new JScrollPane();
		Display.add(scrollPane_3);
		scrollPane_3.setViewportView(table);
		
		JLabel lblResults_1 = new JLabel("Results:");
		lblResults_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblResults_1.setBounds(422, 30, 64, 24);
		lblResults_1.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
		Display.add(lblResults_1, BorderLayout.NORTH);
		
		JButton btnNewButton_5 = new JButton("Back to search:");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cardLayout = (CardLayout)contentPane.getLayout();
				cardLayout.previous(contentPane);
			}
		});
		
		
		
		btnNewButton_5.setBounds(385, 496, 138, 28);
		Display.add(btnNewButton_5, BorderLayout.SOUTH);
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
			
				char[] temppass = passwordField.getPassword();
				String tempuse=textField.getText();
				String password = null;
				password = String.copyValueOf(temppass);
				
				
				if (Test.checkLogin(tempuse, password)) {
					CardLayout cardLayout = (CardLayout)contentPane.getLayout();
					cardLayout.next(contentPane);
					Test.UserID(tempuse, password);
				}
				else if (Test.adminLogin(tempuse, password)){
					CardLayout cardLayout = (CardLayout)contentPane.getLayout();
					cardLayout.show(contentPane,"name_78230353664963");
					Test.adminSearch();
					String [][] comboBoxItems = Test.userdata;
					chckbxNewCheckBox.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent arg0){
							if (chckbxNewCheckBox.isSelected()){
								comboBox.removeAllItems();
								for (int z = 0; z < comboBoxItems.length;z++) {
									System.out.println(comboBoxItems[z][0]);
									comboBox.addItem(comboBoxItems[z][0]);
								}
							}
						}
					});
					chckbxUserid_1.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent arg0){
								if (chckbxUserid_1.isSelected()){
									comboBox.removeAllItems();
									for (int z = 0; z < comboBoxItems.length;z++) {
										System.out.println(comboBoxItems[z][1]);
										comboBox.addItem(comboBoxItems[z][1]);
										
									
									}
								}
								
							}
						
					});
					
					chckbxExamType_1.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent arg0){
								if (chckbxExamType_1.isSelected()){
									comboBox.removeAllItems();
									for (int z = 0; z < comboBoxItems.length;z++) {
										System.out.println(comboBoxItems[z][2]);
										comboBox.addItem(comboBoxItems[z][2]);
										
									}
								}
						}
					});
					
				}
						
				else {
					passwordField.setText(null);
					textField.setText(null);
					CardLayout cardLayout = (CardLayout)contentPane.getLayout();
					cardLayout.show(contentPane,"name_178481228780857");
				}
			}
		});
		
		DefaultTableModel model = null;
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				DefaultTableModel model = null;
				
				 if (chckbxNewCheckBox.isSelected()) {
						System.out.println("I selected " + comboBox.getSelectedItem() +  " from " + chckbxNewCheckBox.getText()); 
						try {
							 model = Test.FillTable(Test.nametable(comboBox.getSelectedItem()));
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				 }
				 if (chckbxUserid_1.isSelected()){
					 System.out.println("I selected " + comboBox.getSelectedItem() +  " from " + chckbxUserid_1.getText());
					 try {
						 model = Test.FillTable(Test.useridtable(comboBox.getSelectedItem()));
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				  }
				 if (chckbxExamType_1.isSelected()){
						System.out.println("I selected " + comboBox.getSelectedItem() +  " from " + chckbxExamType_1.getText());
						try {
							 model = Test.FillExamTypeTable(Test.examtypetable(comboBox.getSelectedItem()));
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						}
				 DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
				 centerRenderer.setHorizontalAlignment( SwingConstants.CENTER );
				 centerRenderer.setVerticalAlignment(SwingConstants.CENTER);
				 table.setDefaultRenderer(String.class, centerRenderer);
				table.setModel(model);
				for (int x =0;x < table.getColumnCount(); x ++) {
					table.getColumnModel().getColumn(x).setCellRenderer(centerRenderer);
				}
				
				CardLayout cardLayout= (CardLayout)contentPane.getLayout();
				cardLayout.last(contentPane);
				
				
				
		
				
			}
		});
		
		String [][] questions = Test.questionlist;
		String [] questionarray = new String [25];
		JRadioButton [][] answers = new JRadioButton [25][5];
		String [] selectedanswers = new String [25];
		
		btnMath.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cardLayout = (CardLayout)contentPane.getLayout();
				cardLayout.show(contentPane, "name_178480893654333");
				Test.TimeStarted();
				String queries ="";
				Test.ImportTestQuestions("Math");
				for (int j = 0; j < questions.length; j++) {
					if (questions[j][0] != null) {
						questionarray[j] = questions[j][0];
						queries = queries + questions[j][0] + "\n\n\n";
					}
				}
				int a = 6;
				int b = 25;
				
				ButtonGroup options = new ButtonGroup ();
				for (int row = 0; row < 25; row++) {
					for (int col = 1; col < 6; col ++) {
						if (questions[row][col - 1] != null){
							answers [row][col - 1] = new JRadioButton (questions [row][col]); 
							answers[row][col-1].setBounds(a ,b, 178, 18);
							answers[row][col-1].setBackground(Color.WHITE);
							a += 180;
							textArea_1.add(answers[row][col-1]);
							}
						else {
							answers[row][col -1] = new JRadioButton();
							answers[row][col-1].setBounds(a ,b, 170, 18);
							answers[row][col-1].setBackground(Color.WHITE);
							a += 172;
						}
					}
					options = new ButtonGroup();
					options.add(answers[row][0]);
					options.add(answers[row][1]);
					options.add(answers[row][2]);
					options.add(answers[row][3]);
					options.add(answers[row][4]);

					b+=48;
					a=6;

				}
				Test.ExamType("Math");
				textArea_1.setText(queries);	
			
			}
		});

		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cardLayout = (CardLayout)contentPane.getLayout();
				cardLayout.show(contentPane, "name_178481082461777");
				Test.TimeStarted();
				String queries ="";
				Test.ImportTestQuestions("English");
				for (int j = 0; j < questions.length; j++) {
					if (questions[j][0] != null) {
						questionarray[j] = questions[j][0];
						queries = queries + questions[j][0] + "\n\n\n";
					}
				}

				int a = 10;
				int b = 25;
				ButtonGroup options = new ButtonGroup ();

				for (int row = 0; row < 25; row++) {
					for (int col = 1; col < 5; col ++) {
						if (questions[row][col - 1] != null){
							answers [row][col - 1] = new JRadioButton (questions [row][col]); 
							answers[row][col-1].setBounds(a ,b, 210, 18);
							answers[row][col-1].setBackground(Color.WHITE);
							a += 212;
							textArea_3.add(answers[row][col-1]);
						}
						else {
							answers[row][col -1] = new JRadioButton();
							answers[row][col-1].setBounds(a ,b, 170, 18);
							answers[row][col-1].setBackground(Color.WHITE);
							a += 172;
						}
					}
					options = new ButtonGroup();
					options.add(answers[row][0]);
					options.add(answers[row][1]);
					options.add(answers[row][2]);
					options.add(answers[row][3]);
					b+=48;
					a=10;

				}
				Test.ExamType("English");
				textArea_3.setText(queries);	
			
			}
		});
		btnReading.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cardLayout = (CardLayout)contentPane.getLayout();
				cardLayout.show(contentPane, "name_178481009002998");
				Test.TimeStarted();
				String queries ="";

				Test.ImportTestQuestions("Reading");

				for (int j = 0; j < questions.length; j++) {
					if (questions[j][0] != null) {
						questionarray[j] = questions[j][0];
						queries = queries + questions[j][0] + "\n\n\n";
					}
				}

				int a = 10;
				int b = 25;
				ButtonGroup options = new ButtonGroup ();

				for (int row = 0; row < 25; row++) {
					for (int col = 1; col < 5; col ++) {
						if (questions[row][col - 1] != null){
							answers [row][col - 1] = new JRadioButton (questions [row][col]); 
							answers[row][col-1].setBounds(a ,b, 210, 18);
							answers[row][col-1].setBackground(Color.WHITE);
							a += 212;
							textArea_2.add(answers[row][col-1]);
						}
						else {
							answers[row][col -1] = new JRadioButton();
							answers[row][col-1].setBounds(a ,b, 170, 18);
							answers[row][col-1].setBackground(Color.WHITE);
							a += 172;
						}
					}
					options = new ButtonGroup();
					options.add(answers[row][0]);
					options.add(answers[row][1]);
					options.add(answers[row][2]);
					options.add(answers[row][3]);
					b+=48;
					a=10;
					Test.ExamType("Reading");
					textArea_2.setText(queries);	
				}
			}
		});	
		
	

		
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for (int row = 0; row<25;row++) {
					for (int col = 1; col < 6; col ++) {
						if (answers[row][col-1] != null){
							if (answers[row][col - 1].isSelected()) {
								selectedanswers[row] = answers[row][col -1].getText();
							}
						}
					}
				}
				String [] usableanswers = Test.RemoveNull(selectedanswers);
				String [] usablequestions = Test.RemoveNull(questionarray);
				if (usableanswers.length == usablequestions.length) {	
					Test.TimeStopped();
					for (int j = 0; j<25; j++) {
						if (questions[j][0] != null) {
							Test.ExportResults(questions[j][0]);
						}
					}
					Test.UpdateUserInfo();
					Test.WindowClosed();
					Test.storeResults(usableanswers);
					Test.Score(usableanswers);
					CardLayout cardLayout = (CardLayout)contentPane.getLayout();
					cardLayout.show(contentPane, "name_178481150670163");
					String [] statistics = Test.resultspage();
					String display = "";
					for (int x = 0; x < 2; x++) {
						display += statistics[x] +"\n";						
					}
					textArea.setText(display);
				}
				else {
					return;					
				}
			}
		});

		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				for (int row = 0; row<25;row++) {
					for (int col = 1; col < 6; col ++) {
						if (answers[row][col-1] != null){
							System.out.println("Row "+row+" "+(col - 1));
							System.out.println("English "+answers[row][col - 1].isSelected());
							if (answers[row][col - 1].isSelected()) {
								selectedanswers[row] = answers[row][col -1].getText();
							}
						}
					}
				}
				String [] usableanswers = Test.RemoveNull(selectedanswers);
				String [] usablequestions = Test.RemoveNull(questionarray);
				if (usableanswers.length == usablequestions.length) {	
					Test.TimeStopped();
					for (int j = 0; j<25; j++) {
						if (questions[j][0] != null) {
							Test.ExportResults(questions[j][0]);
						}
					}
					Test.UpdateUserInfo();
					Test.WindowClosed();
					Test.storeResults(usableanswers);
					Test.Score(usableanswers);
					CardLayout cardLayout = (CardLayout)contentPane.getLayout();
					cardLayout.show(contentPane, "name_178481150670163");
					String [] statistics = Test.resultspage();
					String display = "";
					for (int x = 0; x < 2; x++) {
						display += statistics[x] +"\n";						
					}
					textArea.setText(display);
				}
				else {
					return;					
				}
			}
			
		});
		
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (int row = 0; row<25;row++) {
					for (int col = 1; col < 6; col ++) {
						if (answers[row][col-1] != null){
							System.out.println("Row "+row+" "+(col - 1));
							System.out.println("Math "+answers[row][col - 1].isSelected());
							if (answers[row][col - 1].isSelected()) {
								selectedanswers[row] = answers[row][col -1].getText();
							}
						}
					}
				}
				String [] usableanswers = Test.RemoveNull(selectedanswers);
				String [] usablequestions = Test.RemoveNull(questionarray);
				if (usableanswers.length == usablequestions.length) {	
					Test.TimeStopped();
					for (int j = 0; j<25; j++) {
						if (questions[j][0] != null) {
							Test.ExportResults(questions[j][0]);
						}
					}
					Test.UpdateUserInfo();
					Test.WindowClosed();
					Test.storeResults(usableanswers);
					Test.Score(usableanswers);
					CardLayout cardLayout = (CardLayout)contentPane.getLayout();
					cardLayout.show(contentPane, "name_178481150670163");
					String [] statistics = Test.resultspage();
					String display = "";
					for (int x = 0; x < 2; x++) {
						display += statistics[x] +"\n";						
					}
					textArea.setText(display);
				}
				else {
					return;					
				}
				
			}
		});
	
	
	}
	}
		
			
	
		

	











