class KarninghamAlgo{
    public static void main(String... args){
        int x = 4489,count = 0;
        System.out.println(Integer.toBinaryString(x));
        while(x!=0){
            int rsbm = x & -x;
            x = x-rsbm;
            count++;
        }
        System.out.println('a'&'b');
    }
}