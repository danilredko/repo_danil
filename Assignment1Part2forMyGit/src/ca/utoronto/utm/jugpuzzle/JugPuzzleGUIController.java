package ca.utoronto.utm.jugpuzzle;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.geom.Dimension2D;


public class JugPuzzleGUIController {

	
	

	
	
	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
	
	public void paintComponent(Graphics2D g) {
		   g.setColor(Color.GREEN);
		   g.fillRect(0, 0, 10, 10);
		}

	public static void createAndShowGUI() {
		// Create and hook up the Model, View and the controller
		
		// View
		GUIView guiView1 = new GUIView();
		
		
		// Model
		JugPuzzle model_jug1 = new JugPuzzle();
		
		// Hook the model to the view.
		model_jug1.addObserver(guiView1);
		
		
		
		// Create the GUI controller to control the Model
		JFrame frame = new JFrame("JugPuzzle"); 
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		Dimension2D screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		
		int height = (int) screenSize.getHeight()/2;
		int width = (int) screenSize.getWidth()/3;

		
		
		
		
		
		frame.setLocation(300, 100);
		
		//JPanel panel = new JPanel();
		JButton b1, b2, b3, cancel; 
		
		
		GridLayout experimentLayout = new GridLayout(1,3);
		
		JPanel buttons_panel = new JPanel();
		buttons_panel.setLayout(experimentLayout);
        
        //JPanel view_panel = new JPanel();
        //view_panel.setLayout(new GridLayout(1,0));

       
        

		// Create the buttons
		b1 = new JButton(""+model_jug1.getJugs()[0].getCapacity());
		b2 = new JButton(""+model_jug1.getJugs()[1].getCapacity());
		b3 = new JButton(""+model_jug1.getJugs()[2].getCapacity());
		
		
		
		
		cancel = new JButton("START OVER");
		
		JButton[] buttons = {b1,b2,b3,cancel};
		
		
		
		buttons_panel.add(b1);
		buttons_panel.add(b2);
		buttons_panel.add(b3);
		buttons_panel.add(cancel);
        
		//view_panel.add(guiView1);
		
        frame.getContentPane().add(buttons_panel, BorderLayout.NORTH);
        frame.getContentPane().add(guiView1, BorderLayout.SOUTH);

		MoveActionListener mb1 = new MoveActionListener(model_jug1, buttons);
		StartOverActionListener start_over_action = new StartOverActionListener(model_jug1);
		
		
		b1.addActionListener(mb1);
		b2.addActionListener(mb1);
		b3.addActionListener(mb1);
		cancel.addActionListener(start_over_action);
		
		frame.setSize(500, 500);
		//frame.pack();
		frame.setVisible(true);
		
	}
	
	
	
	
}
