// author: Bryant Baum
// date: 8/26/2025
// assignment: Turtle Graphics, laying groundwork for Zelda game

import javax.swing.JFrame;
import java.awt.Toolkit;

public class Game extends JFrame
{
	private boolean keepGoing;

	private Model model;
	private Controller controller;
	private View view;

	public Game()
	{
		keepGoing = true;
		
		model = new Model();
		controller = new Controller(model);
		view = new View(controller, model);
		
		this.setTitle("Turtle Wars!");
		this.setSize(500, 500);
		this.setFocusable(true);
		this.getContentPane().add(view);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.addKeyListener(controller);

		view.addMouseListener(controller);
	}

	public void run()
	{
		do
		{
			keepGoing = controller.update();
			model.update(); 
			view.repaint(); // calls View.paintComponent indirectly
			Toolkit.getDefaultToolkit().sync();	// updates the screen

			// Go to sleep for 50 milliseconds
			try
			{
				Thread.sleep(50);
			}	
			catch(Exception e)
			{
				e.printStackTrace();
				System.exit(1);
			}
		} while(keepGoing == true);
	}

	public static void main(String[] args)
	{
		Game g = new Game();
		g.run();
	}
}
