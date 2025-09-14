// author: Bryant Baum
// date: 9/12/2025
// assignment: Map editor assignment

import java.lang.Math;
import java.util.ArrayList;

public class Model
{
	private ArrayList<Tree> trees;
	private Tree tree;

	public Model()
	{
		this.trees = new ArrayList<Tree>();
	}	

	public Tree getTreesAt(int i)
	{
		return this.trees.get(i);
	}

	public int getTreesLength()
	{
		return this.trees.size();
	}

	public void addTree(int x, int y)
	{
		this.trees.add(new Tree(x, y));
	}
	
	// public void update()
	// {
	// 	// Move the model
	// 	if(this.ModelX < this.destX) 
	// 		this.ModelX += Math.min(modelSpeed, this.destX - this.ModelX); // right movement
	// 	else if(this.ModelX > this.destX)
	// 		this.ModelX -= modelSpeed; // left movement
	// 	if(this.modelY < this.destY) 
	// 		this.modelY += Math.min(modelSpeed, this.destY - this.modelY); // down movement
	// 	else if(this.modelY > this.destY) 
	// 		this.modelY -= modelSpeed; // up movement
	// }
	
	// public int getModelX()
	// {
	// 	return this.ModelX;
	// }
	
	// public int getModelY()
	// {
	// 	return this.modelY;
	// }

  // public void moveRight(){
  //   this.destX += modelSpeed;
  // }

  // public void moveLeft(){
  //   // this.destX = Math.max(0, getModelX() - modelSpeed);
	// 	this.destX -= modelSpeed;
  // }

  // public void moveUp(){
  //   this.destY -= modelSpeed;
  // }

  // public void moveDown(){
  //   this.destY += modelSpeed; 
  // }
}