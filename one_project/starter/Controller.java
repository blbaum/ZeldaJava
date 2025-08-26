import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Controller implements ActionListener
{
	private boolean keepGoing;
	
	public Controller()
	{
		keepGoing = true;
	}

	public void actionPerformed(ActionEvent e)
	{
		System.out.println("Hey! I said not to push that button!");
	}

	public boolean update()
	{	
		//the Controller keeps track of whether or not we have quit the program and
		//returns this value to the Game engine of whether or not to continue the game loop
		return keepGoing;
	}
}
