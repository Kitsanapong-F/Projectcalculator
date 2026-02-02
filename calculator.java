import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== เครื่องคิดเลขแบบสะสมค่า (กด '=' เพื่อสรุปผล) ===");

        System.out.print("เริ่มด้วยตัวเลข: ");
        double total = input.nextDouble();
        String process = "" + total;

        while (true) {
            System.out.print("ตัวดำเนินการ (+, -, *, /, %) หรือ '=' เพื่อดูคำตอบ: ");
            String op = input.next();

            if (op.equals("=")) {
                break;
            }

            System.out.print("ตัวเลขถัดไป: ");
            double nextNum = input.nextDouble();

            switch (op) { // method คำนวน
                case "+":
                    total += nextNum;
                    break;
                case "-":
                    total -= nextNum;
                    break;
                case "*":
                    total *= nextNum;
                    break;
                case "/":
                    if (nextNum != 0)
                        total /= nextNum;
                    else
                        System.out.println("Error: หารด้วย 0 ไม่ได้ (ข้ามการคำนวณนี้)");
                    break;
                case "%":
                    total %= nextNum;
                    break;
                default:
                    System.out.println("ตัวดำเนินการไม่ถูกต้อง ลองใหม่ครับ");
                    continue;
            }

            process += " " + op + " " + nextNum;
            System.out.println("ขณะนี้: " + process + " = " + total);
        }

        System.out.println("\n-----------------------------");
        System.out.println("กระบวนการทั้งหมด: " + process);
        System.out.println("คำตอบสุดท้าย: " + total);
        System.out.println("-----------------------------");

        input.close();
    }
}
