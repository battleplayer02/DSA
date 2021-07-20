package pep_test;

public class q5 {
    int a[] = new int[5];

    public void len() {
        System.out.println(a.length);
    }

    public void inc() {
        a = new int[a.length * 2];
    }

    public static void main(String[] args) {
        q5 q = new q5();
        q.len();
        q.inc();
        q.len();
        q.inc();
        q.len();
    }
}
