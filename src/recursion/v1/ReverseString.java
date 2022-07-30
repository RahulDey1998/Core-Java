package recursion.v1;

/**
 * @author rahul_dey
 */
public class ReverseString {

    public static void main(String[] args) {
        String s = "rahul";
//        System.out.println(s.substring(1));
        System.out.println(reverse("umbrella"));

    }

    public static String reverse(String s){
       if(s.length() == 1){
           return s;
       }
       else{
          return reverse(s.substring(1)) + s.charAt(0);
       }
    }

}
