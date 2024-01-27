import java.util.*;

public class RunLengthEncode{
  public static void main(String[] args){ //main function that asks to enter a string, calls the encode, and prints the response
    Scanner input = new Scanner(System.in);
    System.out.print("Please enter a string: ");
    String str = input.nextLine();
    String encoded = Encode(str);
    System.out.println(encoded);

  }

  public static String Encode(String str){
    String encoded = ""; //empty string, number of characters set to 1, and the string converted to char array
    int numofchar = 1;
    char[] strexpand = str.toCharArray();
    for (int i = 0; i < strexpand.length; i++){ //iterate over array
      if((i+1)==strexpand.length || strexpand[i] != strexpand[i+1]){ //if the index is at last letter or if current letter does not equal the next one
        encoded+=strexpand[i]; //add it to the string encoded
      }else{
        for(int j = (i+1); j<strexpand.length; j++){ //iterate over str at next index
        int p = j+1; //one more over
        if(p==strexpand.length || strexpand[j] != strexpand[p]){ //if the next character from j is the last character, or it does not equal with the character at j
            numofchar++; //number of characters is increased
            if (numofchar <= 4){ //if its less than or equal to 4, add those characters to the encoded string, reset the number of characters to 1, i is set to the last reviewed place in array, and break
              for (int q = 0; q<numofchar; q++){
                encoded+=strexpand[i];
              }
              numofchar = 1;
              i=j;
              break;
            }else{
              if(numofchar>9){ //if number of characters is greater than 9, encode it with a /, the number, and one of the characters
                encoded += "/" + Integer.toString(numofchar) + strexpand[i];
                i = j;
                numofchar = 1;
                break;
              }else{ //if it is 9 or less, code with /0, the number, and the character
                encoded += "/0" + Integer.toString(numofchar) + strexpand[i];
                i = j;
                numofchar = 1;
                break;
              }
            }
          }else if(strexpand[j] == strexpand[p]){ //if the current character at j equals the next one, increase the number of characters
              numofchar++;
            }
        }
      }
    }
    return encoded; //return the new message
  }
}
