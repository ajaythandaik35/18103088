import java.util.Scanner;
public class count_sort{
    public static void main(String[] args){
        
	Scanner obj = new Scanner(System.in);
        System.out.print("ENTER SIZE OF THE ARRAY: ");
        
	int n = obj.nextInt();
        int[] arr = new int[n];
	

        System.out.println("ENTER ARRAY ELEMENTS BETWEEN RANGE (0-20) : ");
        int[] val = new int[21];
        for(int i=0;i<n;i++){
            arr[i] = obj.nextInt();
            if(arr[i]<0 || arr[i]>20){
                val[0]++;
            }
            else{
                val[arr[i]]++;
            }
        }
        int j=0;
        for(int i=0;i<21;i++){
            for(int k=0;k<val[i];k++){
                arr[j] = i;
                j++;
            }
        }
        System.out.print("SORTED ARRAY: ");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}