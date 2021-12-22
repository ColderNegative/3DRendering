package Rendering;

import javax.swing.*;
import java.awt.event.*;

class App extends JFrame {
	JFrame frame;
	App() {
		JButton button = new JButton("clickHere");
		button.setBounds(130,100,100,40);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (button.getText().equals("clickHere")) {
					button.setText("Clicked");
				} else {
					button.setText("clickHere");
				}
			}
		});

		add(button);
		setSize(400, 500);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new App();
	}
}