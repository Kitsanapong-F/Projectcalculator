package Calculator;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        
         while (true) {
            System.out.print("ตัวดำเนินการ (+, -, *, /, %) หรือ '=' เพื่อดูคำตอบ: ");
            String op = input.next();

            if (op.equals("=")) {
                break;
            }

        display asd = new display();
        logic wewe = new logic();

        
        }
    }   
}
