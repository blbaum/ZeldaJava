// author: Bryant Baum
// date: 8/26/2025
// assignment: Turtle Graphics, laying groundwork for Zelda game

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;
import javax.swing.JButton;
import java.awt.Color;

public class View extends JPanel
{
	private JButton b1;
	private BufferedImage turtle_image;
	private Model model;

	public View(Controller c, Model m)
	{
		model = m;

		b1 = new JButton("click to remove.");
		b1.addActionListener(c);
		this.add(b1);

		c.setView(this); // sets object that view references

		try
		{
			this.turtle_image = ImageIO.read(new File("images/turtle.png"));
		}
		catch(Exception e)
		{
			e.printStackTrace(System.err);
			System.exit(1);
		}
	}

	public void paintComponent(Graphics g)
	{
		g.setColor(new Color(51,115,87));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.drawImage(this.turtle_image, model.getTurtleX(), model.getTurtleY(), null);
	}

	public void removeButton()
	{
		this.remove(b1);
		this.repaint();
	}
}
