package Calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        logic logic = new logic();
        logic.addNum(0);// ใส่ตัวเลข

        while (true) {

            System.out.print("ตัวดำเนินการ (+, -, *, /, %) หรือ '=' เพื่อดูคำตอบ: ");
            String op = input.next();
            char sop = op.charAt(0);
            logic.addop(sop);

            if (op.equals("=")) {
                break;
            }

            logic.addNum(0);// ใส่ตัวเลข

            display asd = new display();

        }
        if (!logic.CalFirst(false)) {
            logic.CalSum();// แสดงคำตอบ
        }
        logic.clear();
        input.close();
    }
}
