package structure;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

/**
 * Created by dh on 2018/12/12.
 */
public class Evaluate {

    public static void main(String[] args) {
        // (1+((2+3)*(4*5)))
        Stack<String> ops = new Stack<>() ;
        Stack<Double> vals = new Stack<>() ;
        String str = StdIn.readString() ;
        for(int i = 0 ; i < str.length() ; i ++){
            String s = String.valueOf(str.charAt(i)) ;
            if(s.equals("(")) ;
            else if(s.equals("+")) ops.push(s) ;
            else if(s.equals("-")) ops.push(s) ;
            else if(s.equals("*")) ops.push(s) ;
            else if(s.equals("/")) ops.push(s) ;
            else if(s.equals(")")){
                String op = ops.pop() ;
                double v = vals.pop() ;
                if(op.equals("+")) v = vals.pop() + v ;
                else if(op.equals("-")) v = vals.pop() - v ;
                else if(op.equals("*")) v = vals.pop() * v ;
                else if(op.equals("/")) v = vals.pop() / v ;
                vals.push(v) ;
            }else{
                vals.push(Double.parseDouble(s)) ;
            }
        }
        StdOut.println(vals.pop());
    }
}
