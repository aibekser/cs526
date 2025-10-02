package cs526.week1.problem3;

public class Problem3 {
    public static int dolt(int n) {
        if (n == 0) return 1;
        else if (n == 1) return 1;
        else if (n == 2) return 2;
        else return dolt(n - 1) + dolt(n - 2) - dolt(n - 3);
    }

    public static void main(String[] args) {
        System.out.println("dolt(1) = " + dolt(1));
        System.out.println("dolt(3) = " + dolt(3));
        System.out.println("dolt(6) = " + dolt(6));
    }
}
