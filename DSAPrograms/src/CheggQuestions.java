/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
public class CheggQuestions {
    
    public static void main(String[] args) {
//        System.out.println(Math.round(-7.5));
//        System.out.println(Math.abs(-7.5));
//        System.out.println(Math.ceil(-7.5));
//        System.out.println(Math.floor(-7.5));
        System.out.println(res(5126));
    }
    
    public static int res(int n) {
        if (n <= 10) {
            return n;
        } else {
            int a = n % 10;
            int b = n / 10;
            return a + res(a + b);
        }
    }
}
