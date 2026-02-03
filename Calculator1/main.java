package Calculator1;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        logic calculatorLogic = new logic();
        display calculatorDisplay = new display();

        System.out.println("=== Group Calculator Project ===");
        
        // รับตัวเลขตัวแรก
        System.out.print("ป้อนตัวเลขเริ่มต้น: ");
        while (!input.hasNextDouble()) {
            System.out.print("กรุณาป้อนเฉพาะตัวเลข: ");
            input.next();
        }
        calculatorLogic.addNum(input.nextDouble());

        while (true) {
            System.out.print("ตัวดำเนินการ (+, -, *, /, %) หรือ '=' เพื่อคำนวณ: ");
            String opInput = input.next();
            char op = opInput.charAt(0);

            if (op == '=') break;

            calculatorLogic.addOp(op);

            System.out.print("ป้อนตัวเลขถัดไป: ");
            while (!input.hasNextDouble()) {
                System.out.print("กรุณาป้อนเฉพาะตัวเลข: ");
                input.next();
            }
            calculatorLogic.addNum(input.nextDouble());

            // แสดง process ปัจจุบันให้ผู้ใช้เห็น
            calculatorDisplay.printProcess(calculatorLogic);
        }

        // เริ่มคำนวณ
        boolean error = calculatorLogic.calFirst();
        if (error) {
            System.out.println("!!! Error: มีการหารด้วยศูนย์เกิดขึ้นในระบบ !!!");
        } else {
            double finalAnswer = calculatorLogic.calSum();
            calculatorDisplay.showResult(finalAnswer);
        }

        calculatorLogic.clear();
        input.close();
    }
}