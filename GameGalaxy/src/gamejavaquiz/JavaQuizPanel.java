package gamejavaquiz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class JavaQuizPanel extends JPanel implements ActionListener{
	
	String[] questions = 	{
			"which company created java ?",
			"In which year java was created ?",
			"what was java originally called ?",
			"What is Java?",
            "Explain the main features of Java.",
            "What are the primitive data types in Java?",
            "What is the default value of the boolean variable in Java?",
            "Which keyword is used to declare a constant in Java?",
            
            "What is the purpose of the 'static' keyword in Java?",
            "Which class is the superclass for all classes in Java?",
            "What is the main purpose of the 'StringBuilder' class in Java?",
            "What is the difference between '=='' and '.equals()' when comparing strings in Java?",
            "What is the output of the following code?  int x = 5; System.out.println(x++);",
            "Which Java keyword is used to implement multiple inheritance?",
            "What is the purpose of the 'super' keyword in Java?",
            "How can you handle exceptions in Java?",
            "What is the significance of the 'final' keyword in Java?",
            "What is the difference between 'ArrayList' and 'LinkedList' in Java?"
            
		};

	String[][] options =	{
				{"A. Sun MicroSystems","B. Oracle","C. Microsoft","D. Alphabet"},
				{"A. 1989","B. 1995","C. 1972","D. 1980"},
				{"A. Apple","B. Oak","C. COBOL","D. Kotlin"},
				{"A. Java is a programming language.", "B. Java is a type of coffee.", "C. Java is an island in Indonesia.", "D. Java is a database management system."},
	            {"A. Object-oriented programming", "B. Platform independence", "C. Memory management", "D. All of the above"},
	            {"A. int", "B. float", "C. boolean", "D. All of the above"},
	            {"A. true", "B. false", "C. 0", "D. 1"},
	            {"A. const", "B. final", "C. static", "D. constant"},
	            
	            {"A. To create an instance of a class", "B. To indicate that a method or variable belongs to the class rather than an instance", "C. To make a class non-instantiable", "D. To indicate a constant variable"},
	            {"A. Object", "B. Main", "C. JavaLang", "D. None of the above"},
	            {"A. To create mutable sequences of characters", "B. To represent a fixed-size, immutable sequence of characters", "C. To format strings", "D. To parse XML documents"},
	            {"A. '==' compares object references, while '.equals()' compares the content of the objects", "B. '==' compares the content of the objects, while '.equals()' compares object references", "C. Both '==' and '.equals()' are used interchangeably", "D. '==' and '.equals()' are only applicable to primitive data types"},
	            {"A. 6", "B. 5", "C. 4", "D. 6 (with a space)"},
	            {"A. extends", "B. implements", "C. inheritance", "D. super"},
	            {"A. It refers to the superclass of the current class", "B. It is used to call the constructor of the superclass", "C. It is used to access the superclass's fields and methods", "D. It is used to create an instance of the superclass"},
	            {"A. By using try-catch blocks", "B. By declaring exceptions in the method signature", "C. By using the 'finally' block", "D. All of the above"},
	            {"A. It indicates that a class cannot be extended", "B. It indicates that a method cannot be overridden", "C. It indicates that a variable cannot be modified after initialization", "D. All of the above"},
	            {"A. 'ArrayList' is based on an array, while 'LinkedList' is based on a linked list", "B. 'ArrayList' allows faster random access, while 'LinkedList' is efficient for insertions and deletions", "C. 'ArrayList' is thread-safe, while 'LinkedList' is not", "D. There is no significant difference between 'ArrayList' and 'LinkedList'"}
	            
			};
	
	char[] answers =		{
				'A',
				'B',
				'B',
				'A', 
	            'D', 
	            'D', 
	            'B', 
	            'B',
	            'B', 'A', 'A', 'A', 'B', 'B', 'B', 'D', 'D', 'B'
			};
	
	char guess;
	char answer;
	int index;
	int correct_guesses = 0;
	int total_questions = questions.length;
	int result;
	int seconds = 30;
	
	JTextField textfield = new JTextField();
	JTextArea textarea = new JTextArea();	//to hold the current questions 
	JButton buttonA = new JButton();
	JButton buttonB = new JButton();
	JButton buttonC = new JButton();
	JButton buttonD = new JButton();
	
	JButton saveAndExitButton = new JButton("SAVE AND EXIT");
	JButton exitButton = new JButton("Exit");
	JButton quitquizButton = new JButton("Quit Quiz");
	
	
	JLabel answer_labelA = new JLabel();
	JLabel answer_labelB = new JLabel();
	JLabel answer_labelC = new JLabel();
	JLabel answer_labelD = new JLabel();
	JLabel time_label = new JLabel();
	JLabel seconds_left = new JLabel();
	JTextField number_right = new JTextField();
	JTextField percentage = new JTextField();
	
	private boolean button_clicked = false;
	
	Set<Integer> usedNumbers = new HashSet<>();
    Random random = new Random();
    static int qus_no = 0;
	
	Timer timer = new Timer(1000, new ActionListener() {
	
		@Override
		public void actionPerformed(ActionEvent e) {
			seconds--;
			seconds_left.setText(String.valueOf(seconds));
			if(seconds <= 0) {
				displayAnswer();
			}
		
		}
	});
	
	public JavaQuizPanel() {
		
		
		
		textfield.setBounds(0,0,1500,50);
		textfield.setBackground(new Color(25,25,25));
		textfield.setForeground(new Color(25,255,0));
		textfield.setFont(new Font("Ink Free",Font.BOLD,30));
		textfield.setBorder(BorderFactory.createBevelBorder(1));
		textfield.setHorizontalAlignment(JTextField.CENTER);
		textfield.setEditable(false); 
		//textfield.setText("greeen text on top");
		
		textarea.setBounds(0,50,1500,50);
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		textarea.setBackground(new Color(25,25,25));
		textarea.setForeground(new Color(25,255,0));
		textarea.setFont(new Font("MV Boli",Font.BOLD,30));
		textarea.setBorder(BorderFactory.createBevelBorder(1));
		textarea.setEditable(false); 
		//textarea.setText("question");
		
		buttonA.setBounds(0,100,200,100);
		buttonA.setFont(new Font("MV Boli",Font.BOLD,35));
		buttonA.setFocusable(false);
		buttonA.addActionListener(this);
		buttonA.setText("A");
		
		buttonB.setBounds(0,200,200,100);
		buttonB.setFont(new Font("MV Boli",Font.BOLD,35));
		buttonB.setFocusable(false);
		buttonB.addActionListener(this);
		buttonB.setText("B");
		
		buttonC.setBounds(0,300,200,100);
		buttonC.setFont(new Font("MV Boli",Font.BOLD,35));
		buttonC.setFocusable(false);
		buttonC.addActionListener(this);
		buttonC.setText("C");
		
		buttonD.setBounds(0,400,200,100);
		buttonD.setFont(new Font("MV Boli",Font.BOLD,35));
		buttonD.setFocusable(false);
		buttonD.addActionListener(this);
		buttonD.setText("D");
		
		answer_labelA.setBounds(225,100,1500,100);
		answer_labelA.setBackground(new Color(50,50,50));
		answer_labelA.setForeground(new Color(25,255,0));
		answer_labelA.setFont(new Font("MV Boli",Font.PLAIN,30));
		//answer_labelA.setText("testing label");
		
		answer_labelB.setBounds(225,200,1500,100);
		answer_labelB.setBackground(new Color(50,50,50));
		answer_labelB.setForeground(new Color(25,255,0));
		answer_labelB.setFont(new Font("MV Boli",Font.PLAIN,30));
		//answer_labelB.setText("testing label");
		
		answer_labelC.setBounds(225,300,1500,100);
		answer_labelC.setBackground(new Color(50,50,50));
		answer_labelC.setForeground(new Color(25,255,0));
		answer_labelC.setFont(new Font("MV Boli",Font.PLAIN,30));
		//answer_labelC.setText("testing label");
		
		answer_labelD.setBounds(225,400,1500,100);
		answer_labelD.setBackground(new Color(50,50,50));
		answer_labelD.setForeground(new Color(25,255,0));
		answer_labelD.setFont(new Font("MV Boli",Font.PLAIN,30));
		//answer_labelD.setText("testing label");
		
		seconds_left.setBounds(1400,600,100,100);
		seconds_left.setBackground(new Color(25,25,25));
		seconds_left.setForeground(new Color(255,0,0));
		seconds_left.setFont(new Font("Ink Free",Font.BOLD,60));
		seconds_left.setBorder(BorderFactory.createBevelBorder(1));
		seconds_left.setOpaque(true);
		seconds_left.setHorizontalAlignment(JTextField.CENTER);
		seconds_left.setText(String.valueOf(seconds));
		
		time_label.setBounds(1400,575,100,20);
		time_label.setBackground(new Color(50,50,50));
		time_label.setForeground(new Color(255,0,0));
		time_label.setFont(new Font("MV Boli",Font.PLAIN,20));
		time_label.setHorizontalAlignment(JTextField.CENTER);
		time_label.setText("timer >:D");
		
		number_right.setBounds(695,125,110,75);
		number_right.setBackground(new Color(25,25,25));
		number_right.setForeground(new Color(25,255,0));
		number_right.setFont(new Font("Ink Free",Font.BOLD,30));
		number_right.setHorizontalAlignment(JTextField.CENTER);
		number_right.setEditable(false);
		
		percentage.setBounds(695,200,110,75);
		percentage.setBackground(new Color(25,25,25));
		percentage.setForeground(new Color(25,255,0));
		percentage.setFont(new Font("Ink Free",Font.BOLD,30));
		percentage.setBorder(BorderFactory.createBevelBorder(1));
		percentage.setHorizontalAlignment(JTextField.CENTER);
		percentage.setEditable(false);
		
		saveAndExitButton.setBounds(625, 325, 250, 100);
		saveAndExitButton.setFont(new Font("Arial", Font.BOLD, 25));
		saveAndExitButton.setBackground(new Color(25,255,0));
		saveAndExitButton.setForeground(Color.white);
		saveAndExitButton.setFocusable(false);
		
		exitButton.setBounds(625, 435, 250, 100);
		exitButton.setFont(new Font("Arial", Font.BOLD, 25));
		exitButton.setBackground(new Color(25,255,0));
		exitButton.setForeground(Color.white);
		exitButton.setFocusable(false);
		
		quitquizButton.setBounds(625, 600, 250, 100);
		quitquizButton.setFont(new Font("Arial", Font.BOLD, 25));
		quitquizButton.setBackground(new Color(25,255,0));
		quitquizButton.setForeground(Color.white);
		quitquizButton.setFocusable(false);
		
		quitquizButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				result = -1;
				button_clicked = true;
				SwingUtilities.getWindowAncestor(quitquizButton).dispose();
			}
			
		});
		
		this.add(quitquizButton);
		this.add(time_label);
		this.add(seconds_left);
		this.add(answer_labelA);
		this.add(answer_labelB);
		this.add(answer_labelC);
		this.add(answer_labelD);
		this.add(buttonA);
		this.add(buttonB);
		this.add(buttonC);
		this.add(buttonD);
		this.add(textarea);
		this.add(textfield);
		
		this.setPreferredSize(new Dimension(1500,700));	//note border applies to the frame when we use setPreferredsize
		this.setBackground(new Color(50,50,50));
		this.setFocusable(true);
		
		this.setLayout(null);
	
		index = getIndex();
		nextQuestion();
		
	}
	
	public int getIndex() {
		
		int randomIndex;
		 while(usedNumbers.size() < total_questions) {
			 randomIndex = random.nextInt((total_questions - 1) - 0 + 1) + 0;
			 if(!usedNumbers.contains(randomIndex)) {
				 usedNumbers.add(randomIndex);
				 return randomIndex;
			 }
		 }
		 return total_questions;
	}
	
	public void nextQuestion() {	//method for displaying next question 
		
		
		
		if(index>=total_questions) {
			results();
		}
		else {
			textfield.setText("Question "+(qus_no += 1));
			textarea.setText(questions[index]);
			answer_labelA.setText(options[index][0]);
			answer_labelB.setText(options[index][1]);
			answer_labelC.setText(options[index][2]);
			answer_labelD.setText(options[index][3]);
			timer.start();
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {	//method for action performed 
		// TODO Auto-generated method stub
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		if(e.getSource() == buttonA) {
			answer = 'A';
			if(answer == answers[index]) {
				correct_guesses++;
			}
		}
		
		if(e.getSource() == buttonB) {
			answer = 'B';
			if(answer == answers[index]) {
				correct_guesses++;
			}
		}
		
		if(e.getSource() == buttonC) {
			answer = 'C';
			if(answer == answers[index]) {
				correct_guesses++;
			}
		}
		
		if(e.getSource() == buttonD) {
			answer = 'D';
			if(answer == answers[index]) {
				correct_guesses++;
			}
		}
		
		displayAnswer();
	}
	
	public void displayAnswer() {		//for displaying the answer
		
		timer.stop();
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		if(answers[index] != 'A') {
			answer_labelA.setForeground(new Color(255,0,0));
		}
		if(answers[index] != 'B') {
			answer_labelB.setForeground(new Color(255,0,0));
		}
		if(answers[index] != 'C') {
			answer_labelC.setForeground(new Color(255,0,0));
		}
		if(answers[index] != 'D') {
			answer_labelD.setForeground(new Color(255,0,0));
		}
		
		Timer pause = new Timer(2000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				answer_labelA.setForeground(new Color(25,255,0));
				answer_labelB.setForeground(new Color(25,255,0));
				answer_labelC.setForeground(new Color(25,255,0));
				answer_labelD.setForeground(new Color(25,255,0));
				
				answer = ' ';
				seconds = 30;
				seconds_left.setText(String.valueOf(seconds));
				buttonA.setEnabled(true);
				buttonB.setEnabled(true);
				buttonC.setEnabled(true);
				buttonD.setEnabled(true);
				index = getIndex();
				nextQuestion();
			
			}
		});	//to add a pause after displaying teh o/p
		
		pause.setRepeats(false);
		pause.start();
		
	}
	
	public void results() {		//for showing the result 
		
		this.remove(quitquizButton);
		
		this.revalidate();
		this.repaint();
		result = (int) (((double)correct_guesses / total_questions)*100);

		saveAndExitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				button_clicked = true;
				SwingUtilities.getWindowAncestor(saveAndExitButton).dispose();
			}
			
		});
		
		exitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				result = -1;
				button_clicked = true;
				SwingUtilities.getWindowAncestor(exitButton).dispose();
			}
			
		});
		
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		//result = (int)(correct_guesses /(double)total_questions)*100;
		
		textfield.setText("RESULTS!");
		textarea.setText("");
		answer_labelA.setText("");
		answer_labelB.setText("");
		answer_labelC.setText("");
		answer_labelD.setText("");
		
		number_right.setText("("+correct_guesses+"/"+total_questions+")");
		percentage.setText(result+"%");
		
		this.add(percentage);
		this.add(number_right);
		this.add(saveAndExitButton);
		this.add(exitButton);
	}
	
	public int getScore() {
		return result;
	}
	
	public boolean isButtonClicked() {
		return button_clicked;
	}
	
}
