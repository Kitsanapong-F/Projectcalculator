package Calculator;

import java.util.ArrayList;
//ทำหน้าที่คิดเลขอย่างเดียว ไม่สนใจการรับค่า
//ต้องใส่เลขกับเครื่องหมายก่อนค่อยกด "="
//ต้องมี array

//     import java.util.Scanner;

// public class calculator {
//     public static void main(String[] args) {
//         Scanner input = new Scanner(System.in);

//         System.out.println("=== เครื่องคิดเลขแบบสะสมค่า (กด '=' เพื่อสรุปผล) ===");

//         System.out.print("เริ่มด้วยตัวเลข: ");
//         double total = input.nextDouble();
//         String process = "" + total;

//         while (true) {
//             System.out.print("ตัวดำเนินการ (+, -, *, /, %) หรือ '=' เพื่อดูคำตอบ: ");
//             String op = input.next();

//             if (op.equals("=")) {
//                 break;
//             }

//             System.out.print("ตัวเลขถัดไป: ");
//             double nextNum = input.nextDouble();

//             switch (op) { //method คำนวน
//                 case "+": total += nextNum; break;
//                 case "-": total -= nextNum; break;
//                 case "*": total *= nextNum; break;
//                 case "/": 
//                     if (nextNum != 0) total /= nextNum; 
//                     else System.out.println("Error: หารด้วย 0 ไม่ได้ (ข้ามการคำนวณนี้)");
//                     break;
//                 case "%": total %= nextNum; break;
//                 default:
//                     System.out.println("ตัวดำเนินการไม่ถูกต้อง ลองใหม่ครับ");
//                     continue;
//             }

//             process += " " + op + " " + nextNum;
//             System.out.println("ขณะนี้: " + process + " = " + total);
//         }

//         System.out.println("\n-----------------------------");
//         System.out.println("กระบวนการทั้งหมด: " + process);
//         System.out.println("คำตอบสุดท้าย: " + total);
//         System.out.println("-----------------------------");

//         input.close();
//     }
// }
public class logic {
    private ArrayList<Double> num;
    private ArrayList<Character> op;

    public logic() {
        num = new ArrayList<>();
        op = new ArrayList<>();
    }

    public void addNum(double num) {
        this.num.add(num);
    }

    public void addop(char op) {
        this.op.add(op);
    }

    public boolean CalFirst(boolean chack) {
        for (int i = 0; i < op.size(); i++) {
            if (op.get(i) == '%' || op.get(i) == '/' || op.get(i) == '*') {

                switch (op.get(i)) {
                    case '%':
                        if (num.get(i + 1) == 0) {
                            chack = true;
                        } else {
                            num.set(i, num.get(i) % num.get(i + 1));
                        }
                        break;
                    case '/':
                        if (num.get(i + 1) == 0) {
                            chack = true;
                        } else {
                            num.set(i, num.get(i) / num.get(i + 1));
                        }
                        break;
                    case '*':
                            num.set(i, num.get(i) * num.get(i + 1));
                        break;
                }
                if (!chack) {
                    num.remove(i+1);
                    op.remove(i);
                    i--;
                }
            }
        }
        return chack;
    }
    public double CalSum() {
        double sum = num.get(0);
        for(int i = 0; i < op.size() ; i++){
            switch (op.get(i)) {
                case '+':
                    sum += num.get(i+1); 
                    break;
                case '-':
                    sum -= num.get(i+1); 
                    break;
            }
        }
        return sum ;
    }
}
