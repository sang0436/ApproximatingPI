import java.awt.*;
import javax.swing.*;

public class Piday {

	public static void main(String[] args) {
		Dimension dim = new Dimension(400,400);
		JFrame frame = new JFrame("Dart");
		frame.setLocation(50,50);
		frame.setPreferredSize(dim);
		
		DrawPanel drawpanel = new DrawPanel();
		
		frame.add(drawpanel);
		frame.pack();
		frame.setVisible(true);
		
	}
}

class DrawPanel extends JPanel {
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawRect(50, 30, 300, 300);
		g.drawOval(50, 30, 300, 300);
		
		int r = 150;
		int total = 0;
		int circle = 0;
		double recordPI = 0;
		
		for (int i=0;i<10000;i++) {
			double rValue = Math.random();
			int x = (int) (50 + (rValue * 300));
			double rValue2 = Math.random();
			int y = (int) (30 + (rValue2 * 300));
			g.drawLine(x, y, x, y);
			total++;
			
			int a = Math.abs(r-x+50);
			int b = Math.abs(r-y+30);
			int d = (a*a) + (b*b);
			
			if (d < r * r) {
				circle++;
			}
	
			double pi = 4.0 * ((double)circle / (double)total);
			double recordDiff = Math.abs(Math.PI - recordPI);
		    	double diff = Math.abs(Math.PI - pi);
		    	if (diff < recordDiff) {
		      		recordDiff = diff;
		      		recordPI = pi;
		    	}
			System.out.println(recordPI);
		}
	}
}
