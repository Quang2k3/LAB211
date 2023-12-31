package validate;

import entity.Doctor;
import java.util.Scanner;

/**
 *
 * @author Quang
 */
public class Validate {

    private final static Scanner SCANNER = new Scanner(System.in);

    /**
     * Don't let anyone instantiate this class.
     */
    public Validate() {}
    
    /**
     * Returns the valid integer value scanner from the input
     *
     * @param messageInfo               the message to be printed instructing 
     *                                  the user to input
     * @param messageErrorOutOfRange    the message will be printed if the 
     *                                  String parse is out of range
     * @param messageErrorInvalidNumber the message will be printed if the 
     *                                  String does not contain a parable integer
     * @param                           min minimum limit value
     * @param                           max maximum limit value
     * @return the valid integer value scanner from the input
     */
    public static int getInt(
            String messageInfo,
            String messageErrorOutOfRange,
            String messageErrorInvalidNumber,
            int min, int max
    ) {
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print(messageInfo);
                int number = Integer.parseInt(sc.nextLine());
                if (number >= min && number <= max) {
                    return number;
                }
                System.out.println(messageErrorOutOfRange);
            } catch (NumberFormatException e) {
                System.out.println(messageErrorInvalidNumber);
            }
        } while (true);
    }

    /**
     *Prompt user for input, validate it using a regular expression, and return it.
     * 
     * @param messageInfo  Message displayed for user input.
     * @param messageError Message for invalid input.
     * @param REGEX        Regular expression for validation.
     * @return Validated input matching the specified regular expression.
     */
    public static String getString(
            String messageInfo,
            String messageError,
            final String REGEX
    ) {
        do {
            System.out.print(messageInfo);
            String str = SCANNER.nextLine();
            if (str.matches(REGEX)) {
                return str;
            }
            System.out.println(messageError);
        } while (true);
    }

    /**
     * Checks if a Doctor's information has changed.
     *
     * @param doctor         The Doctor object to compare with.
     * @param code           The new code to compare.
     * @param name           The new name to compare.
     * @param specialization The new specialization to compare.
     * @param availability   The new availability to compare.
     * @return true if the information has changed, false if it remains the same.
     */
    public static boolean checkChangeInfo(
            Doctor doctor,
            String code,
            String name,
            String specialization,
            int availability
    ) {
        if (doctor.getCode().equalsIgnoreCase(code)
                && doctor.getName().equalsIgnoreCase(name)
                && doctor.getSpecialization().equalsIgnoreCase(specialization)
                && doctor.getAvailability() == availability) {
            return false;
        }
        return true;
    }
}