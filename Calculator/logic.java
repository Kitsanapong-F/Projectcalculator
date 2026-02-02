package Calculator;

import java.util.ArrayList;
import java.util.List;

public class logic {
    private ArrayList<Double> num;
    private ArrayList<Character> op;

    public logic() {
        this.num = new ArrayList<>();
        this.op = new ArrayList<>();
    }

    public void addNum(double n) {
        this.num.add(n);
    }

    public void addOp(char o) {
        this.op.add(o);
    }

    public List<Double> getNum() { return num; }
    public List<Character> getOp() { return op; }

    // รอบที่ 1: จัดการ *, /, %
    public boolean calFirst() {
        boolean hasError = false;
        for (int i = 0; i < op.size(); i++) {
            char currentOp = op.get(i);
            if (currentOp == '%' || currentOp == '/' || currentOp == '*') {
                double left = num.get(i);
                double right = num.get(i + 1);
                double result = 0;

                if (currentOp == '*') {
                    result = left * right;
                } else {
                    if (right == 0) {
                        hasError = true;
                        break;
                    }
                    result = (currentOp == '/') ? left / right : left % right;
                }

                num.set(i, result);
                num.remove(i + 1);
                op.remove(i);
                i--; // ถอยดัชนีกลับมาเช็คตำแหน่งเดิมที่เพิ่งเลื่อนมา
            }
        }
        return hasError;
    }

    // รอบที่ 2: จัดการ +, -
    public double calSum() {
        double sum = num.get(0);
        for (int i = 0; i < op.size(); i++) {
            if (op.get(i) == '+') sum += num.get(i + 1);
            else if (op.get(i) == '-') sum -= num.get(i + 1);
        }
        return sum;
    }

    public void clear() {
        num.clear();
        op.clear();
    }
}