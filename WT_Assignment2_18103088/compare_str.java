import java.util.Scanner;
public class compare_str{
    public static void main(String args[]){
        
	
	Scanner obj = new Scanner(System.in);
	System.out.print(" ENTER TWO STRINGS OF YOUR CHOICE : ");
        String s1, s2;
	s1 = obj.nextLine();
        s2 = obj.nextLine();

       
       	boolean value = true;
        int a1 = s1.length(),a2 = s2.length(), n;
        if(a1<a2){
            n = a1;
        }
        else{
            n = a2;
        }

        int i = 0;
        while(i<n){

            int first = s1.charAt(i), second = s2.charAt(i);

            if(first<second){
                value = false;
                System.out.println("SMALLER STRING: "+s1);
                System.out.println("LARGER STRING: "+s2);
                break;
            }

            else if(second<first){
                value = false;
                System.out.println("SMALLER STRING: "+s2);
                System.out.println("LARGER STRING: "+s1);
                break;
            }
            i+=1;
        }

        if(value){
            if(a1>n){
                System.out.println("SMALLER STRING: "+s2);
                System.out.println("LARGER STRING: "+s1);
            }
            else if(a2>n){
                System.out.println("SMALLER STRING: "+s1);
                System.out.println("LARGER STRING: "+s2);
            }
            else{
                System.out.println(s1 +" and "+ s2 +" ARE EQUAL");
            }
        }

    }
}