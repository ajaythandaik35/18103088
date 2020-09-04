import java.util.*;
public class STO{
    public static void main(String[] args){
        Scanner obj = new Scanner(System.in);
        System.out.print("ENTER THE MAXIMUM LIMIT FOR THE UNIVERSE: ");
        int univ_var = obj.nextInt();

        System.out.print("ENTER THE NUMBER OF ELEMENTS IN SET A AND B : ");
        int a = obj.nextInt(), b = obj.nextInt();

        ArrayList<Integer> arr1 = new ArrayList<Integer>(), arr2 = new ArrayList<Integer>();

        System.out.println("GIVEN ELEMENTS TO BE ADDED TO THE SET (Anything outside universe will be replaced by 0): ");
        ArrayList<Integer> universe = new ArrayList<Integer>();
        for(int i=0;i<=univ_var;i++){
            System.out.print(i+" ");
            universe.add(i);
        }
        System.out.println();

        System.out.print("ENTER ELEMENTS OF SET A : ");
        int temp;
        boolean value;
        for(int i=0;i<a;i++){
            temp = obj.nextInt();
            if(temp<0 || temp>univ_var){
                temp = 0;
            }
            value = false;
            for(int j=0;j<arr1.size();j++){
                if(arr1.get(j)==temp){
                    value = true;
                }
            }
            if(!value){
                arr1.add(temp);
            }
        }

        System.out.print("ENTER THE ELEMENTS OF SET B : ");
        for(int i=0;i<b;i++){
            temp = obj.nextInt();
            if(temp<0 || temp>univ_var){
                temp = 0;
            }
            value = false;
            for(int j=0;j<arr2.size();j++){
                if(arr2.get(j)==temp){
                    value = true;
                }
            }
            if(!value){
                arr2.add(temp);
            }
        }

        // Using Arrays
        System.out.println("\nUSING ARRAYS");

        // Union
        long startTime = System.nanoTime();
        ArrayList<Integer> union = new ArrayList<Integer>();
        for(int i=0;i<arr1.size(); i++){
            value = false;
            for(int j=0;j<union.size();j++){
                if(arr1.get(i)==union.get(j)){
                    value = true;
                    break;
                }
            }
            if(!value){
                union.add(arr1.get(i));
            }
        }
        for(int i=0;i<arr2.size(); i++){
            value = false;
            for(int j=0;j<union.size();j++){
                if(arr2.get(i)==union.get(j)){
                    value = true;
                    break;
                }
            }
            if(!value){
                union.add(arr2.get(i));
            }
        }
        System.out.print("UNION OF A AND B : ");
        for(int i=0;i<union.size();i++){
            System.out.print(union.get(i)+" ");
        }
        System.out.println("");
        long duration = System.nanoTime() - startTime;
        System.out.println("TIME FOR UNION WITH ARRAYS : " + duration);

        // Intersection
        startTime = System.nanoTime();
        ArrayList<Integer> intersection = new ArrayList<Integer>();
        for(int i=0;i<arr1.size(); i++){
            value = false;
            for(int j=0;j<arr2.size();j++){
                if(arr1.get(i)==arr2.get(j)){
                    value = true;
                    break;
                }
            }
            if(value){
                intersection.add(arr1.get(i));
            }
        }
        System.out.print("\nINTERSECTION OF A AND B: ");
        for(int i=0;i<intersection.size();i++){
            System.out.print(intersection.get(i)+" ");
        }
        System.out.println("");
        duration = System.nanoTime() - startTime;
        System.out.println("TIME FOR INTERSECTION WITH ARRAYS : " + duration);

        // Set Difference
        startTime = System.nanoTime();
        ArrayList<Integer> diff1 = new ArrayList<Integer>();
        for(int i=0;i<universe.size(); i++){
            value = false;
            for(int j=0;j<arr1.size();j++){
                if(arr1.get(j)==universe.get(i)){
                    value = true;
                    break;
                }
            }
            if(!value){
                diff1.add(universe.get(i));
            }
        }
        System.out.print("\nSET DIFFERENCE OF A : ");
        for(int i=0;i<diff1.size();i++){
            System.out.print(diff1.get(i)+" ");
        }
        System.out.println("");

        ArrayList<Integer> diff2 = new ArrayList<Integer>();
        for(int i=0;i<universe.size(); i++){
            value = false;
            for(int j=0;j<arr2.size();j++){
                if(arr2.get(j)==universe.get(i)){
                    value = true;
                    break;
                }
            }
            if(!value){
                diff2.add(universe.get(i));
            }
        }
        System.out.print("SET DIFFERENCE OF A : ");
        for(int i=0;i<diff2.size();i++){
            System.out.print(diff2.get(i)+" ");
        }
        System.out.println("");
        duration = System.nanoTime() - startTime;
        System.out.println("TIME FOR UNION WITH ARRAYS : " + duration);


        // Using sets
        System.out.println("\n\nUSING SETS");
        Set<Integer> universe_s = new HashSet<Integer>(), s1 = new HashSet<Integer>(), s2 = new HashSet<Integer>();
        universe_s.addAll(universe);
        s1.addAll(arr1);
        s2.addAll(arr2);

        // Union
        startTime = System.nanoTime();
        Set<Integer> union_s = new HashSet<Integer>(a);
        union_s.addAll(s2);
        System.out.print("\nUNION OF A AND B : ");
        System.out.println(union);
        duration = System.nanoTime() - startTime;
        System.out.println("TIME FOR UNION WITH SETS : " + duration);

        // Intersection
        startTime = System.nanoTime();
        Set<Integer> intersection_s = new HashSet<Integer>(a);
        union_s.retainAll(s2);
        System.out.print("\nINTERSECTION OF A AND B : ");
        System.out.println(intersection);
        duration = System.nanoTime() - startTime;
        System.out.println("TIME FOR INTERSECTION WITH SETS : " + duration);

        // Set Difference
        startTime = System.nanoTime();
        Set<Integer> diff1_s = new HashSet<Integer>(universe_s), diff2_s = new HashSet<Integer>(universe_s);
        diff1_s.removeAll(s1);
        System.out.print("\nSET DIFFERENCE OF A");
        System.out.println(diff1_s);

        diff2_s.removeAll(s2);
        System.out.print("SET DIFFERENCE OF B");
        System.out.println(diff2_s);
        duration = System.nanoTime() - startTime;
        System.out.println("TIME FOR SET DIFFERENCE WITH SETS : " + duration);

        // Conclusion
        System.out.println("TIME COMPLEXITY OF SETS < ARRAYS");
    }
}