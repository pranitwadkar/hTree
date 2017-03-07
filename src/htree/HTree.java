package htree;
import java.awt.Color;
import joyce.*;

public class HTree 
{
     
    public static void main(String[] args) 
    {
        int level=5;
        Graph world= new Graph("h_Tree", 1000,1000);
        JLine line= new JLine(-5,0,5,0);
        world.draw(line);
        HTree ob= new HTree();
        ob.makeH(line, level, world,true);
    }
    
    
   public void makeH(JLine line, int level, Graph world, boolean count)
    {
       if(level==0)
           return;
       if(count==true)
       {
           JPoint left= line.getStart();
           JPoint right= line.getEnd();
           double length= (right.getX()-left.getX())*0.8;
           JLine leftLine= new JLine(left.getX(), (left.getY()+length/2), left.getX(), (left.getY()-length/2));
           leftLine.setBorderColor(Color.magenta);
           JLine rightLine = new JLine(right.getX(), (right.getY()+length/2), right.getX(), (right.getY()-length/2));
           rightLine.setBorderColor(Color.red);
           world.draw(leftLine);
           world.draw(rightLine);
           makeH(leftLine, level-1, world, false);
           makeH(rightLine, level-1, world, false);
       }
       else
       {
           JPoint top= line.getStart();
           JPoint bottom= line.getEnd();
           double length= (top.getY()-bottom.getY());
           double shortLength= (length*0.66)/2;
           JLine topLine= new JLine((top.getX()+shortLength), top.getY(), (top.getX()-shortLength), top.getY());
           JLine bottomLine= new JLine((bottom.getX()+shortLength), bottom.getY(), (bottom.getX()-shortLength), bottom.getY());
           topLine.setBorderColor(Color.green);
           bottomLine.setBorderColor(Color.blue);
           world.draw(topLine);
           world.draw(bottomLine);
           makeH(topLine, level-1, world, true);
           makeH(bottomLine, level-1, world, true);
       }
       
    }
}