package week3.day2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortingUsingCollection {

	public static void main(String[] args) {
		String textArray[] = {"Google" , "Microsoft" , "TestLeaf" ,"Maverick"};
		int length = textArray.length;
		Set<String> textArrayset = new TreeSet<String>();
		for (int i = 0; i < textArray.length; i++) {
			textArrayset.add(textArray[i]);
		}
		List<String> textArrayList = new ArrayList<String>(textArrayset);
		for (int i = textArrayList.size()-1; i >= 0; i--) {
			
			System.out.println(textArrayList.get(i));
		}
		

	}

}
