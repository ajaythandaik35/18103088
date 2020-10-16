class A4_q2
{
    public static void main(String[] args)
    {
        int num = -1;
        byte b = (byte)num;
        int n = b;
        char c = (char)b, c1 = (char)n;
        int final_num = c;
        System.out.println("Current integer: "+ num); 
        System.out.println("Byte: "+ b + " " + n + " " + c1); 
        System.out.println("Character: "+ c);
        System.out.println("Final integer: "+ final_num);
    }
}