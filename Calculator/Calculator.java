package Calculator;

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
                System.out.print("ตัวดำเนินการ (+, -, *, /, %) หรือ '=' เพื่อดูคำตอบ: ");
                while (!input.hasNext("[+*/%=-]")) {
                    //[...] หมายถึงเลือกแค่ตัวเดียวจากด้านในนี้
                    System.out.println("กรุณาป้อนตัวดำเนินการเท่านั้น!");
                    System.out.print("ตัวดำเนินการ (+, -, *, /, %) หรือ '=' เพื่อดูคำตอบ: ");
                    input.nextLine();
                }
                String op = input.nextLine();
                op = op.trim();//ตัดช่องว่าง

                if (op.equals("=")) {
                    break;
                }
                
                char sop = op.charAt(0);
                logic.addOp(sop);

                System.out.print("num: ");
                while (!input.hasNextDouble()) {
                    System.out.println("กรุณาป้อนตัวเลขเท่านั้น!");
                    System.out.print("num: ");
                    input.next();
                }
                num = input.nextDouble();
                logic.addNum(num);

                display.printProcess(logic);
            }

            if (!logic.calFirst()) {
                display.printProcess(logic);
                System.out.println("Result: " + logic.calSum());
            } else {
                System.out.println("!!! เกิดข้อผิดพลาดในการคำนวณ (เช่น หารด้วย 0) !!!");
            }
            // ทำให้การต้องตอบ Y / N เท่านั้นถึงจะทำงานต่อไปได้
            // --- ฟีเจอร์ถามว่าจะใช้ต่อไหม ---
            while (true) {
                System.out.print("\nWould you like to continue to use calculator or not (y/n): ");
                String choice = input.next().toLowerCase();

                if (choice.equalsIgnoreCase("N")) {
                    running = false;
                    System.out.println("ขอบคุณที่ใช้งาน!");
                    break;
                } else {
                    if(choice.equalsIgnoreCase("Y")){
                        logic.clear(); // ล้างข้อมูลเก่าเพื่อเริ่มการคำนวณใหม่
                        break;
                    }
                }
            }
        }

        input.close();
    }
}