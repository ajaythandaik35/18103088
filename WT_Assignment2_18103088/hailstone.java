import java.util.Scanner;
public class hailstone{
    public static void main(String[] args){
        Scanner obj = new Scanner(System.in);
        System.out.print("ENTER A NUMBER OF YOUR CHOICE : ");
        int n = obj.nextInt();

        System.out.println("HAILSTONE SEQUENCE : " + n);
        int a = 0;
        while(n!=1 && a<Integer.MAX_VALUE && n<Integer.MAX_VALUE && n>0){
            if(n%2!=0){
                n*=3;
                n++;
            }
            else{
                n/=2;
            }
            System.out.println(n);
            a++;
        }
        if(n==1){
            System.out.println("NUMBER OF STEPS : "+a);
        }
        else if(n==Integer.MAX_VALUE || n<0){
            System.out.println("INTEGER OVERFLOW REACHED");
        }
        else{
            System.out.println("NUMBER OF STEPS MAXED OUT.");
        }
    }
}