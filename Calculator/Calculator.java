package Calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        logic logic = new logic();
        display display = new display();
        System.out.print("num: ");
        double num = input.nextDouble();
        logic.addNum(num);// ใส่ตัวเลข

        while (true) {
            input.nextLine();
            System.out.print("\nตัวดำเนินการ (+, -, *, /, %) หรือ '=' เพื่อดูคำตอบ: ");
            String op = input.nextLine();
            char sop = op.charAt(0);
            if (op.equals("=")) {
                break;
            }
            logic.addop(sop);
            System.out.print("num: ");
            num = input.nextDouble();
            logic.addNum(num);// ใส่ตัวเลข

            display.SetNum(logic);
            display.SetOp(logic);

            display.PrintProcess();

        }
        display.SetNum(logic);
        display.SetOp(logic);
        if (!logic.CalFirst(false)) {
            display.PrintProcess();
            System.out.print(" = " + logic.CalSum());
            
        }
        logic.clear();
        input.close();
    }
}
