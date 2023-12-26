import java.util.*;
import java.io.*;

public class Test {
	
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
	//we assume the users input is valid
		
		
		System.out.println("Enter the File name");
		
		WordAnalysis_ADT WordAnalysis_ADT = new WordAnalysis_ADT(input.next());

		System.out.println("Enter the No. of the opreation you want : ");
		System.out.println("1. An operation to determine the total No. of words in a text file ");
		System.out.println("2. An operation to determine the total No. of unique words in a text file ");
		System.out.println("3. An operation to determine the total number of occurrences of a particular word ");
		System.out.println("4. An operation to determine the total number of words with a particular length ");
		System.out.println("5. An operation to display the Sorted unique words");
		System.out.println("6. An operation to display the locations of the occurrences of a particular word ");
		System.out.println("7. An operation to examine if two words are occurring adjacent to each othe ");
		System.out.println("x. Exit");
		
		char ch;
		do {
			
			System.out.println("Enter your choice : ");
			ch = input.next().charAt(0);
			
			switch(ch) {
			
			case '1' :
			System.out.println("The total No. of words in the text file : " + WordAnalysis_ADT.documentLength());
			break;
			
			case '2' :
		    System.out.println("The total No. of unique words in the text file : " + WordAnalysis_ADT.uniqueWords() );
			break;
			
			case '3' :
			System.out.println("Enter a word : ");	
			String w = input.next();
			System.out.println("The Total No. of occurrences of " + w + " "+ WordAnalysis_ADT.totalWord(w));
			break;
			
			case '4' :
			System.out.println("Enter a length : ");
			int l = input.nextInt();
			System.out.println("The Total No. of words with length "+ l + "  are "+ WordAnalysis_ADT.totalWordsForLength(l));
			break;
			
		    case '5' :
		    System.out.println("Sorted unique words : ");
		    WordAnalysis_ADT.displayUniqueWords();	
		    break;
			
		    case '6' :
		    System.out.println("Enter a word : ");
		    String W = input.next();
		    System.out.println("The locations of the occurrences of "+ W );
		    
		    LinkedList <WordOccurrence> list = WordAnalysis_ADT.occurrences(W);
	        if (!list.empty())
	        {
	            list.findFirst();
	            while ( ! list.last())
	            {
	                System.out.print(list.retrieve().toString() + "  ");
	                list.findNext();
	            }
	            System.out.print(list.retrieve().toString() + "  ");
	        }
	        System.out.println("");
	        break;
	        
		    case '7' :
		    System.out.println("Enter two word : ");
		    String w1 = input.next();
		    String w2 = input.next();
		    System.out.print(w1 +" and "+ w2 + " are ");
		    if( WordAnalysis_ADT.checkAdjacent(w1, w2) == true )
		    	System.out.println("Adjacent");
		    else
		    	System.out.println("Not Adjacent");
		    break;
		    
		    case 'x' :
		    	System.out.println("BYE");
		   	
			}
		}while(ch!= 'x');
        
        
  }
    


}
