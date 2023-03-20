package week3.day1;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "We learn java basics as part of java basics sessions in java week1";
		int count=0;
		String[] textSplit = text.split(" ");
		System.out.println("Initial text before duplicates: ");
		for (int i = 0; i < textSplit.length; i++) {
			System.out.print(textSplit[i] + " ");
		}
		for (int i = 0; i < textSplit.length; i++) {
			for (int j = i+1; j < textSplit.length; j++) {
				if(textSplit[i].equalsIgnoreCase(textSplit[j]))
				{
						count=count+1;
				}
				
				if(count>0)
				{
					//textSplit[j] = textSplit[j].replaceAll("[^0-9]", "");
					textSplit[j] = textSplit[j].replaceAll(textSplit[j], "");
					count=0;
				}
	
				
			}
		
			
		}
		System.out.println("\nAfter Duplicates removed: ");
		for (int i = 0; i < textSplit.length; i++) {
			System.out.print(textSplit[i]+ " ");
		}
		

	}

}
