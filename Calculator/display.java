package Calculator;

import java.util.List;

public class display {
    public void printProcess(logic log) {
        List<Double> number = log.getNum(); 
        List<Character> oplist = log.getOp();
        
        if (number.isEmpty()) return;

        System.out.print("[Process]: ");
        for (int i = 0; i < oplist.size(); i++) {
            System.out.print(number.get(i) + " " + oplist.get(i) + " ");
        }
        // พิมพ์ตัวเลขตัวสุดท้ายที่ไม่มีตัวดำเนินการต่อท้าย
        System.out.println(number.get(number.size() - 1));
    }

    public void showResult(double result) {
        System.out.println("================================");
        System.out.println("ANSWER: " + result);
        System.out.println("================================");
    }
}
