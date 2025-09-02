// author: Bryant Baum
// date: 8/26/2025
// assignment: Turtle Graphics, laying groundwork for Zelda game

import java.lang.Math;

public class Model
{
	private int turtleX;
	private int turtleY;
	private int destX;
	private int destY;
	private int turtleSpeed;

	public Model()
	{
		turtleSpeed = 4;
	}

	public void update()
	{
		// Move the turtle
		if(this.turtleX < this.destX) 
			this.turtleX += Math.min(turtleSpeed, this.destX - this.turtleX); // right movement
		else if(this.turtleX > this.destX)
			this.turtleX -= turtleSpeed; // left movement
		if(this.turtleY < this.destY) 
			this.turtleY += Math.min(turtleSpeed, this.destY - this.turtleY); // down movement
		else if(this.turtleY > this.destY) 
			this.turtleY -= turtleSpeed; // up movement
	}

	public void setDestination(int x, int y)
	{
		this.destX = x;
		this.destY = y;
	}
	
	public int getTurtleX()
	{
		return turtleX;
	}
	
	public int getTurtleY()
	{
		return turtleY;
	}

  public void moveRight(){
    this.destX += turtleSpeed;
  }

  public void moveLeft(){
    // this.destX = Math.max(0, getTurtleX() - turtleSpeed);
		this.destX -= turtleSpeed;
  }

  public void moveUp(){
    this.destY -= turtleSpeed;
  }

  public void moveDown(){
    this.destY += turtleSpeed; 
  }
}