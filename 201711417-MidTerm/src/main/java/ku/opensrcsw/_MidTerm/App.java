package ku.opensrcsw._MidTerm;

import java.util.Scanner;
import java.io.*;
import java.text.ParseException;

import org.json.simple.*;
import org.json.simple.parser.*;
import midterm.problem2.RegularExpression;

/**
 * Hello world!
 *t
 */


public class App 
{
    public static void main ( String[] args ) throws FileNotFoundException, IOException, org.json.simple.parser.ParseException
    {
        System.out.print( "Enter the keyword you are looking for:" );
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        
        RegularExpression re = new RegularExpression();
     
    	JSONParser jsonParser = new JSONParser();
    	Object element = jsonParser.parse(new FileReader("midterm.json"));
    	JSONObject jsonObject = (JSONObject) element;
    	JSONArray infoArray = (JSONArray) jsonObject.get("poem");
    	
    	for(int i=0; i<infoArray.size(); i++) {
    		JSONObject itemObject = (JSONObject) infoArray.get(i);
    		
    		String str = itemObject.toJSONString();
    		//if(str.contains(input))	
    			//System.out.println("item"+i+ " :"+itemObject.get("item"));
    		if(re.check(str, input)) {
    			System.out.println("item"+i+ " :"+itemObject.get("item"));
    		}
    		
    	}
        
       
       
    }
}
