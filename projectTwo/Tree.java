public class Tree 
{
  private int x, y, width, height;

  public Tree(int x, int y)
  {
    this.x = x;
    this.y = y;
    this.width = 50;
    this.height = 50;
  }

  public Tree(Json ob){
    this.x = (int)ob.getLong(x);
    this.y = (int)ob.getLong(y);
    this.width = 50;
    this.height = 50;
  } 

  public Json marshal(){
    Json ob = Json.newObject();
    ob.add("x", x);
    ob.add("y", y);
    return ob;
  }

  public int getX(){
    return this.x;
  }
  
  public int getY(){
    return this.y;
  }

  public int getWidth(){
    return this.width;
  }
  
  public int getHeight(){
    return this.height;
  }

  public boolean treeClicked(int mouseX, int mouseY){
    if((mouseX >= x && mouseX < x+width) && (mouseY >= y && mouseY < y+height)) return true;
    return false;
  }
}