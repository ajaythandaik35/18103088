import java.util.Scanner;
class ques4{
	static boolean areAnagram(String s1, String s2) {
		if (s1.length()!=s2.length()) {
			return false;
		}
		int value=0;
		for (int i=0;i<s1.length();i++) {
			value=value^(int)s1.charAt(i);
			value=value^(int)s2.charAt(i);
			}
		return value==0;	
	}
	public static void main(String[] args) {
		
		String t1,t2;
		Scanner myobj=new Scanner(System.in);

		System.out.println("Enter string 1:");
		t1=myobj.nextLine();

		System.out.println("Enter string 2:");
		t2=myobj.nextLine();

		boolean answer=areAnagram(t1,t2);
		if(answer==true)
			System.out.println("Strings are anagrams");
		else
			System.out.println("Strings are not anagrams");
	}
}
