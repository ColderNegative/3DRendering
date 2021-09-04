import java.awt.*;

import java.awt.event.*;
import javax.swing.*;

public class MyPanel extends JPanel implements ActionListener{

	final int PANEL_WIDTH = 500;
	final int PANEL_HEIGHT = 500;
	double angle;
	
	MyPanel(){
		this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
		this.setBackground(Color.black);
		Timer timer;
		timer = new Timer(5, this);
		timer.start();
	}

	public void paint(Graphics g) {
		
		super.paint(g); // paint background
		
		Graphics2D g2D = (Graphics2D) g;
		
		double[][] cube = VectorObjects.createCube(20, 10, angle, angle, 0, 0);
		
		g2D.setColor(Color.white);
		
		g2D.drawLine( (int) cube[0][0], (int) cube[0][1], (int) cube[1][0], (int) cube[1][1]);
		g2D.drawLine( (int) cube[1][0], (int) cube[1][1], (int) cube[2][0], (int) cube[2][1]);
		g2D.drawLine( (int) cube[2][0], (int) cube[2][1], (int) cube[3][0], (int) cube[3][1]);
		g2D.drawLine( (int) cube[3][0], (int) cube[3][1], (int) cube[0][0], (int) cube[0][1]);
		
		g2D.drawLine( (int) cube[4][0], (int) cube[4][1], (int) cube[5][0], (int) cube[5][1]);
		g2D.drawLine( (int) cube[5][0], (int) cube[5][1], (int) cube[6][0], (int) cube[6][1]);
		g2D.drawLine( (int) cube[6][0], (int) cube[6][1], (int) cube[7][0], (int) cube[7][1]);
		g2D.drawLine( (int) cube[7][0], (int) cube[7][1], (int) cube[4][0], (int) cube[4][1]);
		
		g2D.drawLine( (int) cube[4][0], (int) cube[4][1], (int) cube[0][0], (int) cube[0][1]);
		g2D.drawLine( (int) cube[5][0], (int) cube[5][1], (int) cube[1][0], (int) cube[1][1]);
		g2D.drawLine( (int) cube[6][0], (int) cube[6][1], (int) cube[2][0], (int) cube[2][1]);
		g2D.drawLine( (int) cube[7][0], (int) cube[7][1], (int) cube[3][0], (int) cube[3][1]);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		angle += 0.01;
		repaint();
		
	}
}