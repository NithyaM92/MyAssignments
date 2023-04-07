package week3.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MissingNumber {

	public static void main(String[] args) {
		int data[] = {1,2,4,5,6,7,2,3,4,5,6,8,7,10};
		Set<Integer> dataSet = new TreeSet<Integer>();
		for (int i = 0; i < data.length; i++) {
			dataSet.add(data[i]);
		}
		System.out.println("Final unique number set is :");
		List<Integer> dataList = new ArrayList<Integer>(dataSet);
		for (Integer integer : dataList) {
			System.out.println(integer);
		}
		
		for (int i = 0; i < dataList.size(); i++) {
			if(i+1<dataList.size())
			{
			if(dataList.get(i)+1==dataList.get(i+1))
			{
				
			}
			else
			{
				System.out.println("Missing number is : " + (dataList.get(i)+1));
			}
		}
		}
	}

}
