// author: Bryant Baum
// date: 9/12/2025
// assignment: Map editor assignment

import java.lang.Math;
import java.util.ArrayList;

public class Model
{
	public ArrayList<Tree> trees;

	public Model()
	{
		trees = new ArrayList<Tree>();
	}	

	public Tree getTreeAt(int index){
		return trees.get(index);
	}

	public int getTreesLength()
	{
		return this.trees.size();
	}

	public void addTree(int mouseX, int mouseY)
	{
		for(int i = 0; i < trees.size(); i++)
		{
			if(trees.get(i).treeClicked(mouseX, mouseY)){
				return;
			}
		}
		this.trees.add(new Tree(mouseX, mouseY));
	}

	public void removeTree(int mouseX, int mouseY)
	{
		for(int i = 0; i < trees.size(); i++)
		{
			if(trees.get(i).treeClicked(mouseX, mouseY)){
				trees.remove(i);
				return;
			}
		}
	}

	public void clear(){
		this.trees.clear();
	}
	
	public Json marshal(){
		Json ob = Json.newObject();
		Json treeList = Json.newList();
		ob.add("trees", treeList);
		for(int i = 0; i < trees.size(); i++){
			treeList.add(trees.get(i).marshal());
		}
		return ob;
	}

	public void unmarshal(Json ob){
		clear();
		Json treeList = ob.get("trees");
		for(int i = 0; i < treeList.size(); i++){
			trees.add(new Tree(treeList.get(i)));
		}
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