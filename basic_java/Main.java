import java.util.Scanner;
// import java.util.Arrays;

public class Main {
	private static String[][] arr;
	private static Scanner in;

	public static void showTable(){
		for (String[] column : arr){
			System.out.print("|");
			for (String row : column){
				System.out.print(row + "\t|");
			}
			System.out.println();
		}
	}

	public static void populateArray(int index1, int index2){
		RandomStringGenerator gen = new RandomStringGenerator();
		arr = new String[index1][index2];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
    			arr[i][j] = gen.generateRandomString();
			}
		}
	}

	public static void searchArray(String keyword){
		int numberOfOccurrence = 0;
		for (int i = 0; i < arr.length; i++){
			for (int j = 0; j < arr[i].length; j++){
    			int lastIndex = 0;
    			int count = 0;

          while(lastIndex != -1){

            lastIndex = arr[i][j].indexOf(keyword,lastIndex);

            if(lastIndex != -1){
              count ++;
              lastIndex ++;
            }
          }
    			if (count > 0){
    				numberOfOccurrence++;
    				System.out.println(count + " occurrence/s at index " + i + ", " + j);
    			}
			}
		}
		if (numberOfOccurrence == 0){
			System.out.println("No occurrence found");
		}
	}

  public static void editTable(){
    int index1;
    int index2;
    String newVal;
              
    do {
      System.out.print("Index at y axis... ");
      while (!in.hasNextInt()) {
        in.next();
        System.out.print("That's not a number... ");
      }
      index1 = in.nextInt();
    } while (index1 < 0 || index1 >= arr[0].length);

    do {
      System.out.print("Index at x axis... ");
        while (!in.hasNextInt()) {
            in.next();
            System.out.print("That's not a number... ");
        }
        index2 = in.nextInt();
    } while (index2 < 0 || index2 >= arr.length);

    do {
      System.out.println("5 characters only...");
      newVal = in.next();
    } while (newVal.length() > 5);

    arr[index1][index2] = newVal;
    System.out.println();
    showMenu();
  }

  public static void searchTable(){
    System.out.print("Search... ");
    String keyword = in.next();
    searchArray(keyword);
    System.out.print("Press enter to continue...");
    Scanner keyboard = new Scanner(System.in);
    keyboard.nextLine();
    System.out.println();
    showMenu();
  }

	public static void select(){
		int selection;
		boolean cont = true;
      	while(cont){
      		do {
				System.out.print("Enter number from the selection... ");
        		while (!in.hasNextInt()) {
            		in.next();
            		System.out.print("That's not a number... ");
        		}
        		selection = in.nextInt();
			} while (selection <= 0 || selection > 4);
      		switch(selection){
      			case 1: editTable();
      				break;
      			case 2: searchTable();
      				break;
      			case 3:
      				init();
      				showMenu();
      				break;
      			case 4: 
      				cont = false;
      				break;	
      			default:
      				System.out.println("Invalid selection");			
      		}	
      	}
	}

	public static void showMenu(){
		showTable();
		System.out.println();
		System.out.println("1. Edit");
    System.out.println("2. Search");
    System.out.println("3. New table");
    System.out.println("4. Exit");
	}

	public static void init(){
		in = new Scanner(System.in);
		System.out.println("Number of rows... ");
		int firstVal;
		do {
			System.out.print("Enter a positive number... ");
        	while (!in.hasNextInt()) {
            	in.next();
            	System.out.print("That's not a number... ");
        	}
        	firstVal = in.nextInt();
    	} while (firstVal <= 0);
		System.out.println("Number of columns... ");
		int secondVal;
		do {
			System.out.print("Enter a positive number... ");
        	while (!in.hasNextInt()) {
            	in.next();
            	System.out.print("That's not a number... ");
        	}
        	secondVal = in.nextInt();
    	} while (secondVal <= 0);
      	System.out.println();
      	populateArray(firstVal, secondVal);
	}


	public static void main(String args[]) {
		init();
		showMenu();
		select();
	}

}