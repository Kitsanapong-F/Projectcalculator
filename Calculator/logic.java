package Calculator;

import java.util.ArrayList;
//ทำหน้าที่คิดเลขอย่างเดียว ไม่สนใจการรับค่า
//ต้องมี array
import java.util.List;

public class logic {
    private ArrayList<Double> num;
    private ArrayList<Character> op;

    public logic() {
        this.num = new ArrayList<>();
        this.op = new ArrayList<>();
    }

    public void addNum(double num) {
        this.num.add(num);
    }

    public void addop(char op) {
        this.op.add(op);
    }

    public List<Double> GetNum(){
        return num;
    }

    public List<Character> Getop(){
        return op;
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

    public void clear(){
        num.clear();
        op.clear();
    }
}
