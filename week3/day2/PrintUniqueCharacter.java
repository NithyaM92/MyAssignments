package week3.day2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.graphbuilder.struc.LinkedList;

public class PrintUniqueCharacter {

	public static void main(String[] args) {
		String text = "subisan";
		System.out.println("Text is " + text);
		char[] charText = text.toCharArray();
		Set<Character> charSet = new HashSet<Character>();
		for (int i = 0; i < charText.length; i++) {
			
			charSet.add(charText[i]);
		}
		
		System.out.println("Unique characters for the text : ");
		for (Character character : charSet) {
			System.out.print(character+ " ");
		}
		System.out.println("\n After removing duplicate letters");
		List<Character> charList = new ArrayList<Character>(charSet);
		
		for(int i=0; i<charList.size();i++)
		{
			int c=0;
			for(int j=0; j<charText.length;j++)
			{
				if(charList.get(i)==charText[j])
				{
					c++;
					
				}
			}
			if(c==1)
			{
				System.out.print(charList.get(i) + " ");
			}
			
		}
		

	}

}
