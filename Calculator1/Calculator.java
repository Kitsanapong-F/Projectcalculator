package Calculator1;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        logic logic = new logic();
        display display = new display();
        
        boolean running = true;

        while (running) { // ลูปหลักสำหรับเริ่มการคำนวณใหม่
            System.out.println("\n---Calculator---");
            System.out.print("num: ");
            
            // ดักจับกรณีผู้ใช้ไม่ป้อนตัวเลข
            while (!input.hasNextDouble()) {
                System.out.println("กรุณาป้อนตัวเลขเท่านั้น!");
                System.out.print("num: ");
                input.next();
            }
            
            double num = input.nextDouble();
            logic.addNum(num);

            while (true) { // ลูปสำหรับป้อนตัวดำเนินการไปเรื่อยๆ
                input.nextLine(); // clear buffer
                System.out.print("\nตัวดำเนินการ (+, -, *, /, %) หรือ '=' เพื่อดูคำตอบ: ");
                String op = input.nextLine();
                
                if (op.equals("=")) {
                    break;
                }
                
                char sop = op.charAt(0);
                logic.addop(sop);
                
                System.out.print("num: ");
                while (!input.hasNextDouble()) {
                    System.out.println("กรุณาป้อนตัวเลขเท่านั้น!");
                    System.out.print("num: ");
                    input.next();
                }
                num = input.nextDouble();
                logic.addNum(num);

                display.SetNum(logic);
                display.SetOp(logic);
                display.PrintProcess();
            }

            // คำนวณและแสดงผล
            display.SetNum(logic);
            display.SetOp(logic);
            
            if (!logic.CalFirst(false)) {
                display.PrintProcess();
                System.out.println("Result: " + logic.CalSum());
            } else {
                System.out.println("!!! เกิดข้อผิดพลาดในการคำนวณ (เช่น หารด้วย 0) !!!");
            }

            // --- ฟีเจอร์ถามว่าจะใช้ต่อไหม ---
            System.out.print("\nWould you like to continue to use calculator or not (y/n): ");
            String choice = input.next().toLowerCase();
            
            if (choice.equals("n")) {
                running = false;
                System.out.println("ขอบคุณที่ใช้งาน!");
            } else {
                logic.clear(); // ล้างข้อมูลเก่าเพื่อเริ่มการคำนวณใหม่
            }
        }
        
        input.close();
    }
}