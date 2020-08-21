import java.util.Scanner;
public class ques1
{
	public static void main(String[] args)
	{
		String s1,s2;
		Scanner myobject= new Scanner(System.in);
		System.out.println("ENTER FIRST STRING OF YOUR CHOICE:");
		s1=myobject.nextLine();
		
		System.out.println("ENTER SECOND STRING OF YOUR CHOICE:");
		s2=myobject.next();
		int a1=s1.length();
		int a2=s2.length();
		int z=0,ans=0;
		if(a1<a2)
		System.out.println("0");
		else {
			int [] x;
			int [] y;
			x= new int[1000];
			y=new int[1000];
			for (int i=0;i<a2;i++)
				 y[(int)s2.charAt(i)]++;
			for(int i=0;i<a2;i++){

		          int a=(int)s1.charAt(i);
		          if(x[a]<y[a])
		            z++;
		          x[a]++;

		          if(z==a2)
		            ans++;}

		          for(int i=a2;i<a1;i++){

		          int a=(int)s1.charAt(i);
		        int p=(int)s1.charAt(i-a2);

		        if(x[p]<=y[p])
		        z--;

		        x[p]--;

		        if(x[a]<y[a])
		        z++;

		        x[a]++;

		        if(z==a2)
		        ans++;}

		        System.out.println(ans);		
		}
			
	}
}
