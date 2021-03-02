import java.awt.Dimension;

import javax.swing.JFrame;

public class Window {
	
	public Window(int w, int h) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame();
		
		frame.pack();
		
		frame.setVisible(true);
		frame.setPreferredSize(new Dimension(w, h));
		frame.setMaximumSize(new Dimension(w, h));
		frame.setMinimumSize(new Dimension(w, h));
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		
		
		
	}
	
	
	
		
}
