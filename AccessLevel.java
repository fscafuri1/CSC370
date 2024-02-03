import java.util.*;

public class AccessLevel{
  public static void main(String[] args){
    Scanner inputarray = new Scanner(System.in);
    System.out.print("Please enter an array of rights: ");
    String[] strRights = inputarray.nextLine().replaceAll("\\{", "").replaceAll("}", "").split(",");
    Scanner inputint = new Scanner(System.in);
    System.out.print("Please enter a minimum permission: ");
    int minPer = Integer.valueOf(inputint.nextLine());
    String encoded = Permissions(strRights, minPer);
    System.out.println(encoded);
  }

  private static String Permissions(String[] rights, int minPermission){
    String permissions = "";
    for(int i = 0; i<rights.length; i++){
        int number = Integer.valueOf(rights[i]);
        if(number < minPermission){
          permissions+="D";
        }else{
          permissions+="A";
        }
    }
    return permissions;
  }
}
