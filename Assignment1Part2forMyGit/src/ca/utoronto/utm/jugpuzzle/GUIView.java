package ca.utoronto.utm.jugpuzzle;

import java.util.Observer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.geom.Dimension2D;
import java.util.Observable;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;






public class GUIView extends JPanel implements Observer  {

	
	
Dimension2D screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	
int height = (int) screenSize.getHeight();
int width = (int) screenSize.getWidth();
int x =0;


JLabel jl0 = new JLabel("",SwingConstants.CENTER);
JLabel jl1 = new JLabel("",SwingConstants.CENTER);
JLabel jl2 = new JLabel("",SwingConstants.CENTER);
JLabel jl3 = new JLabel("",SwingConstants.CENTER);
JButton bt1 = new JButton();

	 
	
	
	@Override
	public void update(Observable o, Object arg) {
		
		
		//this.setLayout(new GridBagLayout());
	    //GridBagConstraints c = new GridBagConstraints();
		
		//JugPuzzle jug_puzzle = new JugPuzzle();
		
		JugPuzzle jug_puzzle_old = (JugPuzzle)o;
		
		
		view_update(jl0,jl1,jl2,jl3,jug_puzzle_old);
		
		
		
		
	
		
		 
		
		
		
		 

		//GroupLayout layout = new GroupLayout(this);
		//this.setLayout(layout);
		

		//this.setLayout(null);
		 //this.setLayout(new GridLayout(1,3));
		
		
		
		
		 

		 
	}
	
	public void view_update(JLabel jl0, JLabel jl1, JLabel jl2, JLabel jl3, JugPuzzle jug_puzzle) {
		 
		jl0.setText(""+jug_puzzle.getJugs()[0].getAmount());
		 jl1.setText(""+jug_puzzle.getJugs()[1].getAmount());
		 jl2.setText(""+jug_puzzle.getJugs()[2].getAmount());
		  
		 
		 
		 
		 if (jug_puzzle.getIsPuzzleSolved()) {
		 jl3.setText("YOU WON WITH: "+jug_puzzle.getMoves()+" MOVES !!!");}
		 else { jl3.setText("Moves : "+jug_puzzle.getMoves());}
		 	 
	
		
		 jl0.setOpaque(true);
		 jl1.setOpaque(true);
		 jl2.setOpaque(true);
		 
		 
		 jl0.setFont(new Font("Serif", Font.PLAIN, 30));
		 jl0.setForeground(Color.WHITE);
		 jl0.setBackground(Color.BLUE); 
		 jl0.setPreferredSize(new Dimension(100,(jug_puzzle.getJugs()[0].getAmount()*50)+30));
		 
		 jl0.setLocation(100, 100);
		 
		 
		 jl1.setFont(new Font("Serif", Font.PLAIN, 30));
		 jl1.setForeground(Color.WHITE);
		 jl1.setBackground(Color.BLUE);
		 jl1.setPreferredSize(new Dimension(100,(jug_puzzle.getJugs()[1].getAmount()*50)+30));
		 
 
		 jl2.setFont(new Font("Serif", Font.PLAIN, 30));
		 jl2.setForeground(Color.WHITE);
		 jl2.setBackground(Color.BLUE);
		 jl2.setPreferredSize(new Dimension(100,(jug_puzzle.getJugs()[2].getAmount()*50)+30));
		 
		 
		 this.add(jl0);
		 this.add(jl1);
		 this.add(jl2);


		 this.setVisible(true);
	}	

	
	
}
