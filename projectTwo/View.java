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
	private Controller c;
	private int scrollPosX;
	private int scrollPosY;

	public View(Controller c, Model m)
	{
		model = m;

		c.setView(this); // sets object that view references

		this.scrollPosX = 0;
		this.scrollPosY = 0;

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

	public int getScrollPosX(){
		return this.scrollPosX;
	}
	
	public int getScrollPosY(){
		return this.scrollPosY;
	}

	public void setScrollPosX(int pos){
		int preCalculatedDistance = this.scrollPosX + pos;
		if(preCalculatedDistance <= 701 && preCalculatedDistance >= 0)
			this.scrollPosX += pos;
	}
	
	public void setScrollPosY(int pos){
		int preCalculatedDistance = this.scrollPosY + pos;
		if(preCalculatedDistance <= 501 && preCalculatedDistance >= 0)
			this.scrollPosY += pos;
	}
	
	public void paintComponent(Graphics g)
	{
		if(Controller.isEditing() == false){
			g.setColor(new Color(77, 155, 84));
		}
		else{
			g.setColor(new Color(132, 194, 137));
		}
		g.fillRect(0, 0, this.getWidth()+this.scrollPosX, this.getHeight()+this.scrollPosY);

		for(int i = 0; i < model.getTreesLength(); i++){
			Tree tree = model.getTreeAt(i);
			g.drawImage(this.tree_image, tree.getX()-this.scrollPosX, tree.getY()-this.scrollPosY, tree.getWidth(), tree.getHeight(), null);
		}

		if(Controller.isEditing() == true){
			if(Controller.isAdding() == true){
				g.setColor(new Color(159, 208, 163));
				g.fillRect(0, 0, 100, 100);
				g.drawString("EDIT MODE: ADD", 550, 25);
			}
			else{
				g.setColor(new Color(255, 31, 64));
				g.fillRect(0, 0, 100, 100);
				g.drawString("EDIT MODE: REMOVE", 550, 25);
			}
			g.drawImage(this.tree_image, 25, 25, 50, 50, null);
		}

	}
}
