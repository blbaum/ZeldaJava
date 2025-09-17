// author: Bryant Baum
// date: 9/12/2025
// assignment: Map editor assignment

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.lang.Math;

public class Controller implements ActionListener, MouseListener, KeyListener, MouseMotionListener
{
	private boolean keepGoing;
	private View view;
	private Model model;
	private boolean keyLeft;
	private boolean keyRight;
	private boolean keyUp;
	private boolean keyDown;
	private static boolean isEditing;
	private static boolean isAdding;
	private boolean isRemoving;
	private String filename;

	public Controller(Model m)
	{
		model = m;
		keepGoing = true;
		filename = "map.json";
	}

	public void setView(View v)
	{
		view = v;
	}

	public void actionPerformed(ActionEvent e) { 	}

	public boolean update()
	{	
		// if(keyRight)
		// 	model.moveRight();			
		// if(keyLeft)
		// 	model.moveLeft();
		// if(keyUp)
		// 	model.moveUp();			
		// if(keyDown)
		// 	model.moveDown();

		//the Controller keeps track of whether or not we have quit the program and
		//returns this value to the Game engine of whether or not to continue the game loop
		return keepGoing;
	}

	public void mousePressed(MouseEvent e)
	{
		if(isEditing){
			int mouseX = (Math.floorDiv(e.getX(), 50) * 50) + view.getScrollPosX();
			int mouseY = (Math.floorDiv(e.getY(), 50) * 50) + view.getScrollPosY();
			if(isAdding){
					model.addTree(mouseX, mouseY);
			}
			if(!isAdding){
					model.removeTree(mouseX, mouseY);
			}
		}
	}

	public void mouseDragged(MouseEvent e)
	{
		if(isEditing){
			int mouseX = (Math.floorDiv(e.getX(), 50) * 50) + view.getScrollPosX();
			int mouseY = (Math.floorDiv(e.getY(), 50) * 50) + view.getScrollPosY();
			if(isAdding){
					model.addTree(mouseX, mouseY);
			}
			if(!isAdding){
					model.removeTree(mouseX, mouseY);
			}
		}
	}

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
			case KeyEvent.VK_Q:
				System.exit(0);
		}
		char c = Character.toLowerCase(e.getKeyChar());
		if(c == 'q') System.exit(0);
		if(c == 'e'){
			isEditing = !isEditing;	
			isAdding = true;
		}
		if(c == 'a') isAdding = true;
		if(c == 'r') isAdding = false;
		if(c == 'c' && isEditing)	model.clear();
		if(c == '4') view.setScrollPosX(-700); // left
		if(c == '6') view.setScrollPosX(700); // right
		if(c == '8') view.setScrollPosY(-500); // up
		if(c == '2') view.setScrollPosY(500); // down
		if(c == 'l') {
			Json loadObject = Json.load(filename);
			model.unmarshal(loadObject);
			System.out.println("File " + filename + " loaded!");
		}
		if(c == 's') {
			model.marshal().save(filename);
			System.out.println("Saved file: " + filename + "!");
		}
	}

	public static boolean isEditing(){
		return isEditing;
	}
	
	public static boolean isAdding(){
		return isAdding;
	}

	// need to be included
	public void keyTyped(KeyEvent e) { }
	public void mouseMoved(MouseEvent e){
		//  System.out.println(e.getX()+", "+e.getY());
	} 
	public void mouseReleased(MouseEvent e){ }
	public void mouseEntered(MouseEvent e){ }
	public void mouseExited(MouseEvent e){ }
	public void mouseClicked(MouseEvent e){ }
}
