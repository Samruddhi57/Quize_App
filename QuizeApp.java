import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

class QuizeApp extends JFrame implements ActionListener {

	JLabel label;
	JRadioButton radioButton[] = new JRadioButton[5];
	JButton btnNext, btnBookmark;
	ButtonGroup bg;
	int count = 0, question = 0, x = 1, y = 1, now = 0;
	int m[] = new int[10];


	QuizeApp(String s) {
		super(s);
		label = new JLabel();
		add(label);
		bg = new ButtonGroup();
		for (int i = 0; i < 5; i++) {
			radioButton[i] = new JRadioButton();
			add(radioButton[i]);
			bg.add(radioButton[i]);
		}
		btnNext = new JButton("Next");
		btnBookmark = new JButton("Save later");
		btnNext.addActionListener(this);
		btnBookmark.addActionListener(this);
		add(btnNext);
		add(btnBookmark);
		
		set();
		label.setBounds(30, 40, 550, 20);
        
		radioButton[0].setBounds(50, 80, 450, 20);
		radioButton[1].setBounds(50, 110, 300, 20);
		radioButton[2].setBounds(50, 140, 300, 20);
		radioButton[3].setBounds(50, 170, 300, 20);

		btnNext.setBounds(100, 240, 100, 30);
		btnBookmark.setBounds(270, 240, 200, 30);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250, 100);
		setVisible(true);
		setSize(800, 550);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNext) {
			if (check())
				count = count + 1;
			question++;
			set();
			if (question == 9) {
				btnNext.setEnabled(false);
				btnBookmark.setText("Result");
			}
		}
		if (e.getActionCommand().equals("Save later")) {
			JButton bk = new JButton("Save later" + x);
			bk.setBounds(580, 50 * x, 200, 30);
			add(bk);
			bk.addActionListener(this);
			m[x] = question;
			x++;
			question++;
			set();
			if (question == 9)
				btnBookmark.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for (int i = 0, y = 1; i < x; i++, y++) {
			if (e.getActionCommand().equals("Save later" + y)) {
				if (check())
					count = count + 1;
				now = question;
				question = m[y];
				set();
				((JButton) e.getSource()).setEnabled(false);
				question = now;
			}
		}

		if (e.getActionCommand().equals("Result")) {
			if (check())
				count = count + 1;
			question++;
			JOptionPane.showMessageDialog(this, "correct answers= " + count);
			System.exit(0);
		}

	}

	void set() {
		radioButton[4].setSelected(true);
		if (question == 0) {
			label.setText("Que1:  Which of the following is not introduced with Java 8?");
			radioButton[0].setText("Stream API");
			radioButton[1].setText("Serialization");
			radioButton[2].setText("Spliterator");
			radioButton[3].setText("Lambda Expression");
		}
		if (question == 1) {
			label.setText("Que2:  Which feature of java 7 allows to not explicitly close IO resource?");
			radioButton[0].setText("try catch finally");
			radioButton[1].setText("IOException");
			radioButton[2].setText("AutoCloseable");
			radioButton[3].setText("Streams");
		}
		if (question == 2) {
			label.setText("Que3: SessionFactory is a thread-safe object.");
			radioButton[0].setText("true");
			radioButton[1].setText("false");
			radioButton[2].setText("don't know");
			radioButton[3].setText("false");
		}
		if (question == 3) {
			label.setText("Que4: Which is the new method introduced in java 8 to iterate over a collection?");
			radioButton[0].setText("for (String i : StringList)");
			radioButton[1].setText("foreach (String i : StringList)");
			radioButton[2].setText("StringList.forEach()");
			radioButton[3].setText("List.for()");
		}
		if (question == 4) {
			label.setText("Que5:  What is the substitute of Rhino javascript engine in Java 8?");
			radioButton[0].setText(" Nashorn");
			radioButton[1].setText("V8");
			radioButton[2].setText("Inscript");
			radioButton[3].setText("Narcissus");
		}
		if (question == 5) {
			label.setText("Que6: How to read entire file in one line using java 8?");
			radioButton[0].setText("Files.readAllLines()");
			radioButton[1].setText("Files.read()");
			radioButton[2].setText("Files.readFile()");
			radioButton[3].setText("Files.lines()");
		}
		if (question == 6) {
			label.setText("Que7:  Which feature of java 7 allows to not explicitly close IO resource?");
			radioButton[0].setText("try catch finally");
			radioButton[1].setText("IOException");
			radioButton[2].setText("AutoCloseable");
			radioButton[3].setText("Streams");
		}
		if (question == 7) {
			label.setText("Que8:  Which of the following is not a Java features?");
			radioButton[0].setText("Dynamic");
			radioButton[1].setText("Architecture Neutral");
			radioButton[2].setText("Use of pointers");
			radioButton[3].setText("Object-oriented");
		}
		if (question == 8) {
			label.setText("Que9: SessionFactory is a thread-safe object.");
			radioButton[0].setText("true");
			radioButton[1].setText("false");
			radioButton[2].setText("don't know");
			radioButton[3].setText("false");
		}
		if (question == 9) {
			label.setText("Que10: Which of the following is not a state of object in Hibernate?");
			radioButton[0].setText("Attached()");
			radioButton[1].setText("Detached()");
			radioButton[2].setText("Persistent()");
			radioButton[3].setText("Transient()");
		}
		label.setBounds(30, 40, 800, 20);
	
	}

	boolean check() {
		if (question == 0)
			return (radioButton[1].isSelected());
		if (question == 1)
			return (radioButton[1].isSelected());
		if (question == 2)
			return (radioButton[0].isSelected());
		if (question == 3)
			return (radioButton[2].isSelected());
		if (question == 4)
			return (radioButton[0].isSelected());
		if (question == 5)
			return (radioButton[0].isSelected());
		if (question == 6)
			return (radioButton[1].isSelected());
		if (question == 7)
			return (radioButton[2].isSelected());
		if (question == 8)
			return (radioButton[0].isSelected());
		if (question == 9)
			return (radioButton[0].isSelected());
		return false;
	}

	public static void main(String s[]) {
		new QuizeApp("Java Quize App!");
	}

}