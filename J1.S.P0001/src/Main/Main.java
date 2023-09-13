package Main;

import Validate.BubbleSort;
import java.util.Scanner;

/**
 *
 * @author Quang
 */
public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);
    
    /**
     * Returns the valid integer value scanner from the input
     * 
     * @param messageInfo               the message to be printed instructing
     *                                  the user to input
     * @param messageErrorOutOfRange    the message will be printed if the String
     *                                  parse is out of range
     * @param messageErrorInvalidNumber the message will be printed if the String
     *                                  does not contain a parable integer
     * @param min                       minimum limit value
     * @param max                       maximum limit value
     * @return the valid integer value scanner from the input
     */
    
    public static int getInt(
            String messageInfo,
            String messageErrorOutOfRange,
            String messageErrorInvalidNumber,
            int min, int max
    ) {
        do {            
            try {
                System.out.print(messageInfo);
                int number = Integer.parseInt(SCANNER.nextLine());
                if (number >= min && number <= max) {
                    return number;
                }
                System.out.println(messageErrorOutOfRange);
            } catch (NumberFormatException e) {
                System.out.println(messageErrorInvalidNumber);
            }
        } while (true);
    }
    
    public static void main(String[] args) {
        
        int numberOfArray = getInt("Enter number of array: ", 
                "Number must be integer", "Number of array", 0, Integer.MAX_VALUE);
        BubbleSort sort = new BubbleSort(numberOfArray);
        
        sort.generateRandomIntegerOfArray();
        System.out.println("Unsorted:");
        sort.displayArray();
        System.out.println("Sorted:");
        sort.bubbleSort();
        sort.displayArray();
    }
}