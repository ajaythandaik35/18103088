import java.util.Scanner;
public class ques2{
	public static void main(String[] args) {
		
		String t;
		Scanner myobj=new Scanner(System.in);
		System.out.println("ENTER THE STRING OF YOUR CHOICE:");
		
		
		t=myobj.nextLine();
		System.out.println("ENTER THE SIZE OF THE REPLACEMENT VECTOR :");
		int n=myobj.nextInt();
		int x=0;
		String[] s=new String[1000];
		String[] s1=new String[n];
		String[] s2=new String[n];
		String var="";
		java.util.HashMap<String, Integer> mark = new java.util.HashMap<String, Integer>();
		for(int i=0;i<n;i++){
	        System.out.println("ENTER THE WORD TO BE REPLACED : ");
	        s1[i]=myobj.next();
	        s2[i]=String.valueOf(s1[i].charAt(0)); 
	        for(int r=0;r<s1[i].length()-1; r++) {
	        	s2[i]=s2[i]+'*';
	        }
	        mark.put(s1[i],i+1);}

	        int k=t.length();

	        for(int i=0;i<k;i++){
	        int j=i;
	        var="";

	        while((j<k)&&(t.charAt(j)!=' ')){
	        var=var+t.charAt(j);
	        j++;}

	        if(var!=" ")
	        i=j;

	        s[x]=var;
	        x++;}

	        for(int i=0;i<x;i++){

	        if(mark.containsKey(s[i])){
	        int z=mark.get(s[i]);
	        s[i]=s2[z-1];}}

	        for(int i=0;i<x;i++)
	        System.out.print(s[i]+" ");

	        System.out.print("\n");
		
		
	}
}