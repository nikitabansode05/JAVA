class ScopeTrap {

    static int x = 5;

    static int compute(int x) {
        return compute(x, 1);
    }

    static int compute(int x, int y) {
        if (x <= 0) {
            return y;
        }
        return compute(x - 1, x * y);
    }

    static int compute(double x) {
        return (int) x + ScopeTrap.x;
    }

    public static void main(String[] args) {
        int result1 = compute(3);
        int result2 = compute(3.0);
        System.out.println(result1 + " " + result2);
    }
}
