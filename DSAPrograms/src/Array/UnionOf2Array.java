/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Array;

import com.sun.org.apache.xml.internal.resolver.Catalog;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Administrator
 */
public class UnionOf2Array {
    public static void main(String[] args) 
    {
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        int n = s.nextInt();
        Set<Integer> set = new HashSet<Integer>();
        int arr1[] = new int[m];
        int arr2[] = new int[n];
        for (int i = 0; i < m; i++) {
            arr1[i] = s.nextInt();
            set.add(arr1[i]);
        }
        for (int i = 0; i < n; i++) {
            arr2[i] = s.nextInt();
            set.add(arr2[i]);
        }
        System.out.print(set);
    }
}
