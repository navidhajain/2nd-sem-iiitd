import java.util.*;

class PairStack {
    int first;
    int second;

    PairStack() {
        first = 0;
        second = 0;
    }
}

public class StackSecBLab {
    public static void main(String[] args) {
        Random sc = new Random();
        int n = sc.nextInt(100000);
        int m = sc.nextInt(1000000000);

        PairStack[] p = new PairStack[m];

        for (int i = 0; i < p.length; i++) {
            p[i] = new PairStack();
            p[i].first = i;
        }

        PairStack current = null;

        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            p[temp - 1].second++;
            if (current == null) {
                current = p[temp - 1];
            } else {
                PairStack check = current;
                if (check.second < p[temp - 1].second) {
                    current = p[temp - 1];

                } else {
                    if (check.second == p[temp - 1].second) {
                        if (check.first < p[temp - 1].first) {
                            current = p[temp - 1];
                        }
                    }
                }
            }

            System.out.println((current.first + 1) + " " + current.second);
        }

    }
}
