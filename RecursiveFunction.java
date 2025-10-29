
/***********************************************

 This is a function to calculate the difference between x and y

 Function does not terminate when the value of x = 0 and y = negative number
 because it enters into a loop as y can never reach zero.

 ***********************************************/
import java.util.Random;
public class RecursiveFunction {
    public static int rec (int x , int y) {
        if(y==0){
            return x;
        }
        else if(y<0 && x<0 || y<0 && x>0){
            return rec(x+1, y+1);
        }
        else{
            return rec(x-1,y-1);
        }
    }

    public static int iter (int x, int y){
        while(y!=0){
            if( y<0 && x<0 || y<0 && x>0){
                x=x+1;
                y=y+1;
            }
            else{
                x=x-1;
                y=y-1;
            }
        }
        return x;
    }
    public static void main(String[] args){
        System.out.println(rec(0,-10));
        System.out.println(iter(11,22));
    }
}