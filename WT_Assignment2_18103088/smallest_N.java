public class smallest_N{
    public static void main(String[] args){
        int n=1;
        int sum = 1;
        while(n<Integer.MAX_VALUE){
            if(sum==n*n){
                System.out.println("ANS :- "+n);
            }
            n+=1;
            sum+=n;
        }
        System.out.println("FINAL LOOP, SUM: "+sum+" n: "+n);
    }
}