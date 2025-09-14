// author: Bryant Baum
// date: 9/12/2025
// assignment: Map editor assignment

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
	private BufferedImage tree_image;
	private Model model;

	public View(Controller c, Model m)
	{
		model = m;

		c.setView(this); // sets object that view references

		try
		{
			this.tree_image = ImageIO.read(new File("images/tree.png"));
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

		for(int i = 0; i < model.getTreesLength(); i++){
			Tree tree = model.getTreesAt(i);
			g.drawImage(this.tree_image, tree.getX()-tree.getWidth()/2, tree.getY()-tree.getHeight()/2, tree.getWidth(), tree.getHeight(), null);
		}
	}
}
