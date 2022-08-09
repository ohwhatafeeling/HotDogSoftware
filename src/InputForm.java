import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class InputForm extends JFrame implements ActionListener {
	JPanel titlePanel;
	JPanel bunPanel;
	JPanel sausagePanel;
	JPanel toppingPanel;
	JPanel saucePanel;
	JPanel submitPanel;
	JPanel displayPanel;
	
	JLabel titleLabel;
	JLabel bunLabel;
	JLabel sausageLabel;
	JLabel toppingLabel;
	JLabel sauceLabel;
	
	JTextField nameTextField;
	JTextArea displayTextArea;
	
	JScrollPane displayScroll;
	
	JRadioButton[] bunButtons = new JRadioButton[3];
	JRadioButton noBun, plainBun, wholemealBun;
	String[] bunNames = {
			"No bun",
			"Plain bun",
			"Wholemeal bun"
	};
	
	JRadioButton[] sausageButtons = new JRadioButton[3];
	JRadioButton noSausage, standardSausage, chorizoSausage;
	String[] sausageNames = {
			"No sausage",
			"Standard sausage",
			"Chorizo sausage"
	};
	
	JCheckBox[] toppingBoxes = new JCheckBox[5];
	JCheckBox onion, cheese, bacon, jalapeno, egg;
	String[] toppingNames = {
			"Onion",
			"Cheese",
			"Bacon",
			"Jalapeno",
			"Egg"
	};
	
	JCheckBox[] sauceBoxes = new JCheckBox[5];
	JCheckBox tomatoSauce, mustard, bbqSauce, sourCream, chilliSauce;
	String[] sauceNames = {
			"Tomato Sauce",
			"Mustard",
			"BBQ Sauce",
			"Sour Cream",
			"Chilli Sauce"
	};
	
	ButtonGroup bunGroup;
	ButtonGroup sausageGroup;
	
	JButton submitButton;
	
	int orderNumber = 69;
	String name = "tomo";
	String bunSelected = "";
	String sausageSelected = "";
	ArrayList<String> toppingSelected = new ArrayList<String>();
	ArrayList<String> sauceSelected = new ArrayList<String>();
	String orderString = "";
	
	Hotdog hotdog;
	Order order;
	
	Queue<Order> orderQueue = new ArrayDeque<Order>();
	
	InputForm() {
		this.setSize(840, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Hot dog business software");
		this.setLayout(null);
		
		titlePanel = new JPanel();
		titlePanel.setBounds(0, 0, 420, 100);
		titlePanel.setBackground(Color.yellow);
		
		bunPanel = new JPanel();
		bunPanel.setBounds(0, 100, 420, 100);
		bunPanel.setBackground(Color.green);
		
		sausagePanel = new JPanel();
		sausagePanel.setBounds(0, 200, 420, 100);
		sausagePanel.setBackground(Color.yellow);
		
		toppingPanel = new JPanel();
		toppingPanel.setBounds(0, 300, 420, 100);
		toppingPanel.setBackground(Color.green);
		
		saucePanel = new JPanel();
		saucePanel.setBounds(0, 400, 420, 100);
		saucePanel.setBackground(Color.yellow);
		
		submitPanel = new JPanel();
		submitPanel.setBounds(0, 500, 420, 100);
		submitPanel.setBackground(Color.orange);
		
		displayPanel = new JPanel();
		displayPanel.setBounds(420, 0, 420, 600);
		displayPanel.setBackground(Color.blue);
		
		titleLabel = new JLabel("Enter customers name:");
		bunLabel = new JLabel("Select bun:");
		sausageLabel = new JLabel("Select sausage:");
		toppingLabel = new JLabel("Select topping(s):");
		sauceLabel = new JLabel("Select sauce(s):");
		
		titlePanel.add(titleLabel);
		bunPanel.add(bunLabel);
		sausagePanel.add(sausageLabel);
		toppingPanel.add(toppingLabel);
		saucePanel.add(sauceLabel);
		
		nameTextField = new JTextField();
		nameTextField.setPreferredSize(new Dimension(150, 40));
		titlePanel.add(nameTextField);
		
		bunGroup = new ButtonGroup();
		sausageGroup = new ButtonGroup();
		
		noBun = new JRadioButton("No bun");
		plainBun = new JRadioButton("Plain bun");
		wholemealBun = new JRadioButton("Wholemeal bun");
		
		noSausage = new JRadioButton("No sausage");
		standardSausage = new JRadioButton("Standard sausage");
		chorizoSausage = new JRadioButton("Chorizo sausage");
		
		onion = new JCheckBox("Onion");
		cheese = new JCheckBox("Cheese");
		bacon = new JCheckBox("Bacon");
		jalapeno = new JCheckBox("Jalapeno");
		egg = new JCheckBox("Egg");
		
		tomatoSauce = new JCheckBox("Tomato sauce");
		mustard = new JCheckBox("Mustard");
		bbqSauce = new JCheckBox("BBQ sauce");
		sourCream = new JCheckBox("Sour cream");
		chilliSauce = new JCheckBox("Chilli sauce");
		
		bunButtons[0] = noBun;
		bunButtons[1] = plainBun;
		bunButtons[2] = wholemealBun;
		
		sausageButtons[0] = noSausage;
		sausageButtons[1] = standardSausage;
		sausageButtons[2] = chorizoSausage;
		
		toppingBoxes[0] = onion;
		toppingBoxes[1] = cheese;
		toppingBoxes[2] = bacon;
		toppingBoxes[3] = jalapeno;
		toppingBoxes[4] = egg;
		
		sauceBoxes[0] = tomatoSauce;
		sauceBoxes[1] = mustard;
		sauceBoxes[2] = bbqSauce;
		sauceBoxes[3] = sourCream;
		sauceBoxes[4] = chilliSauce;
		
		
		for (int i = 0; i < bunButtons.length; i++) {
			bunGroup.add(bunButtons[i]);
			bunPanel.add(bunButtons[i]);
			bunButtons[i].setActionCommand(bunNames[i]);
		}
		
		for (int i = 0; i < sausageButtons.length; i++) {
			sausageGroup.add(sausageButtons[i]);
			sausagePanel.add(sausageButtons[i]);
			sausageButtons[i].setActionCommand(sausageNames[i]);
		}
		
		for (int i = 0; i < toppingBoxes.length; i++) {
			toppingPanel.add(toppingBoxes[i]);
			toppingBoxes[i].setActionCommand(toppingNames[i]);
		}
		
		for (int i = 0; i < sauceBoxes.length; i++) {
			saucePanel.add(sauceBoxes[i]);
			sauceBoxes[i].setActionCommand(sauceNames[i]);
		}
		
		displayTextArea = new JTextArea();
		
		displayScroll = new JScrollPane(displayTextArea);
		displayScroll.setPreferredSize(new Dimension(300, 500));
		
		displayPanel.add(displayScroll);
		
		plainBun.setSelected(true);
		standardSausage.setSelected(true);
		
		submitButton = new JButton("Submit");
		submitButton.addActionListener(this);
		submitPanel.add(submitButton);
		
		this.add(titlePanel);
		this.add(bunPanel);
		this.add(sausagePanel);
		this.add(toppingPanel);
		this.add(saucePanel);
		this.add(submitPanel);
		this.add(displayPanel);
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == submitButton) {
			name = nameTextField.getText();
			bunSelected = bunGroup.getSelection().getActionCommand();
			sausageSelected = sausageGroup.getSelection().getActionCommand();
			for (JCheckBox box : toppingBoxes) {
				if (box.isSelected()) {
					toppingSelected.add(box.getActionCommand());
				}
			}
			for (JCheckBox box : sauceBoxes) {
				if (box.isSelected()) {
					sauceSelected.add(box.getActionCommand());
				}
			}
			
			hotdog = new Hotdog(bunSelected, sausageSelected, toppingSelected, sauceSelected);
			order = new Order(orderNumber, name, hotdog);

			orderQueue.add(order);
//			for (Order order : orderQueue) {
//				System.out.println(order + "\n");
//			}
			
			System.out.println(order);
			
//			System.out.println(order.toString());
			displayTextArea.setText(displayTextArea.getText() + "\n" + order.toString());
			
			for (JCheckBox box: toppingBoxes) {
				box.setSelected(false);
			}
			for (JCheckBox box : sauceBoxes) {
				box.setSelected(false);;
			}
			toppingSelected.clear();
			sauceSelected.clear();
			name = "";
			nameTextField.setText("");
			orderNumber++;
		}
	}
	
}
