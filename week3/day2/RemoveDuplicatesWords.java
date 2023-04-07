package week3.day2;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicatesWords {

	public static void main(String[] args) {
		
		String text = "We learn java basics as part of java sessions in java week1";
		System.out.println("Initial text : " );
		System.out.println(text);
		String[] splitText = text.split(" ");
		Set<String> textSet = new LinkedHashSet<String>();
		for (int i = 0; i < splitText.length; i++) {
			textSet.add(splitText[i]);
		}
		System.out.println("After removing duplicates text is : ");
		for (String string : textSet) {
			System.out.print(string+ " " );
		}
	}

}
