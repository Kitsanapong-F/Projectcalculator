package Calculator1;

import java.util.ArrayList;
//แสดงการใส่เลข
//แสดงการเลือกเครื่องหมาย
//แสดง process ว่าเราทำอะไรไปแล้วบ้าง
import java.util.List;

public class display {
    private ArrayList<Double> number;
    private ArrayList<Character> oplist;

    public display() {
        this.number = new ArrayList<>();
        this.oplist = new ArrayList<>();
    }

    public void SetNum(logic log) {
        this.number.clear();
        this.number.addAll(log.GetNum());
    }

    public void SetOp(logic log) {
        this.oplist.clear();
        this.oplist.addAll(log.Getop());
    }

    public void PrintProcess() {
        System.out.print("Process:");
        for (int i = 0; i < oplist.size(); i++) {
            if (oplist.get(i)=='=') {
                break;
            }
            System.out.print(" " + number.get(i));
            System.out.print(" " + oplist.get(i));
        }

        System.out.print(" " + number.getLast() + "\n");

    }
}
