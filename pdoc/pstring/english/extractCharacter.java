/**
 * 
 */
package pdoc.pstring.english;

/**
 * @author white
 *
 */
public class extractCharacter {
	String str = "";
	
	public static String SqltoVeracode(String s){
		char[] cs = s.toCharArray();
        for(int i=0 ; i<s.length() ; i++){ 
      	  if(Character.isDigit(s.charAt(i)))
      	  {
      		  cs[i] = '?';
      	  }
      	  if(Character.isLetter(s.charAt(i)))
      	  {
      		  cs[i] = '?';
      	  }
        }		
		return cs.toString();		
	}
}
