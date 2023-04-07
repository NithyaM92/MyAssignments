package week3.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class FindSecondLargest {

	public static void main(String[] args) {
		
		int[] data = {3,2,11,4,6,7,2,3,3,6,7};
		Set<Integer> dataSet = new TreeSet<Integer>();
		for (int i = 0; i < data.length; i++) {
			dataSet.add(data[i]);
		}
		List<Integer> dataList = new ArrayList<Integer>(dataSet);
		System.out.println("Unique elements inside List ordered in ASCII order ");
		for (Integer integer : dataList) {
			System.out.println(integer);
		}
	    int size = dataList.size();
	    System.out.println("Total elements : "+size);
		System.out.println("second last element from List is : " + dataList.get(size-2));

	}

}
