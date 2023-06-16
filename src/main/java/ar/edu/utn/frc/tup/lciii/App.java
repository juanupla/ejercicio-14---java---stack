package ar.edu.utn.frc.tup.lciii;

import java.util.Scanner;
import java.util.Stack;

/**
 * Hello Stack!
 *
 */
public class App 
{

    /**
     * This is the main program
     * 
     */
    public static void main( String[] args ) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. */
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            String cadena = scan.nextLine();
            boolean flag = false;
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < cadena.length(); i++) {
                char c = cadena.charAt(i);
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') { //peek() se usa para validar el orden. {{(())}} ok. {({)}} no.
                    stack.pop();
                } else {
                    flag = true; //si solo se ingresan ))]]}} nunca se agrega nada a la pila, entonces sigue vacia. sirve para validar
                    break;
                }
            }
            if (stack.isEmpty() && !flag){
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }
    }
}
