package ca.utoronto.utm.jugpuzzle;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;

public class MoveActionListener implements ActionListener{

	
private JugPuzzle jug_puzzle;
private JButton[] buttons;
private int jug_pressed_before = 0;
private int num_button_pressed = 0;
private int current_jug_pressed= 0 ;

	
	MoveActionListener(JugPuzzle jug_puzzle, JButton[] buttons) {
		this.jug_puzzle = jug_puzzle;
		this.buttons = buttons;
		
	}
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		
		JButton source = (JButton)e.getSource();	
		
		
		num_button_pressed++;
		
		
		current_jug_pressed = Arrays.asList(buttons).indexOf(source);
		if (num_button_pressed==2) {
			
			
			System.out.println("was pressed "+jug_pressed_before+"just pressed "+current_jug_pressed );
			
			jug_puzzle.move(jug_pressed_before, current_jug_pressed);

			System.out.println(jug_puzzle);
			
			num_button_pressed = 0;
			
			
		}

		jug_pressed_before = Arrays.asList(buttons).indexOf(source);
		
		if (jug_puzzle.getIsPuzzleSolved()) {
			buttons[0].setEnabled(false);
			buttons[1].setEnabled(false);
			buttons[2].setEnabled(false);
		}
	
		
		}}
	




	
		
			
	

		
	
	
	
	
