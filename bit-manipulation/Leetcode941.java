public class Leetcode941 {
    // a valid mountain is defined as strictly increasing sequence of integers
    // and strictly decreasing sequence of integers

    // main
    public static void main(String[] args) {
        Leetcode941 leetcode941 = new Leetcode941();
        System.out.println(leetcode941.validMountainArray(new int[] {0,3,2,1}));
    }

    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        int i = 0;
        while(i<arr.length-1 && arr[i] < arr[i+1]) {
            i++;
        }
        if(i == 0 || i == arr.length -1 || arr[i] == arr[i+1]){
            return false;
        }
        while(i<arr.length-1 && arr[i] > arr[i+1]) {
            i++;
        }
        return i == arr.length - 1;
    }

}