// author: Bryant Baum
// date: 8/26/2025
// assignment: Turtle Graphics, laying groundwork for Zelda game

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Controller implements ActionListener, MouseListener, KeyListener
{
	private boolean keepGoing;
	private View view;
	private Model model;
	private boolean keyLeft;
	private boolean keyRight;
	private boolean keyUp;
	private boolean keyDown;
	
	public Controller(Model m)
	{
		model = m;
		keepGoing = true;
	}

	public void actionPerformed(ActionEvent e)
	{
		view.removeButton();
 	}

	public boolean update()
	{	
		if(keyRight)
			model.moveRight();			
		if(keyLeft)
			model.moveLeft();
		if(keyUp)
			model.moveUp();			
		if(keyDown)
			model.moveDown();

		//the Controller keeps track of whether or not we have quit the program and
		//returns this value to the Game engine of whether or not to continue the game loop
		return keepGoing;
	}

	public void setView(View v)
	{
		view = v;
	}

	public void mousePressed(MouseEvent e)
	{
		model.setDestination(e.getX(), e.getY());
	}

	public void mouseReleased(MouseEvent e){ }
	public void mouseEntered(MouseEvent e){ }
	public void mouseExited(MouseEvent e){ }
	public void mouseClicked(MouseEvent e){ }

	public void keyPressed(KeyEvent e)
	{
		switch(e.getKeyCode()){
			case KeyEvent.VK_RIGHT:
				keyRight = true;
				break;
			case KeyEvent.VK_LEFT:
				keyLeft = true;
				break;
			case KeyEvent.VK_UP:
				keyUp = true;
				break;
			case KeyEvent.VK_DOWN:
				keyDown = true;
				break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(e.getKeyCode()){
			case KeyEvent.VK_RIGHT:
				keyRight = false;
				break;
			case KeyEvent.VK_LEFT:
				keyLeft = false;
				break;
			case KeyEvent.VK_UP:
				keyUp = false;
				break;
			case KeyEvent.VK_DOWN:
				keyDown = false;
				break;
			case KeyEvent.VK_ESCAPE:
				System.exit(0);
		}
		char c = Character.toLowerCase(e.getKeyChar());
		if(c == 'q') System.exit(0);
	}

	public void keyTyped(KeyEvent e) { }
}
