package phone_manager;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class PhoneItemUtil {

    public PhoneItemUtil() {
    }
    /**
     * format the phone number as (514) 802-8660
     * @param str
     * @return 
     */
    public String formatPhone(String str) {
        String formatPhone = "(" + str.substring(0, 3) + ") ";
        formatPhone += str.substring(3, 6) + "-";
        formatPhone += str.substring(6);
        return formatPhone;
    }
    
    /**
     * Removes unnecessary chars
     * gets only the first char
     * and makes it lowercase
     * @param str the string to format 
     * @return 
     */
    public String formatStr(String str) {
        return str.substring(0, 1).toLowerCase();
    }
    
    /**
     * phone number must be a 10-digit and
     * must be an integer
     * @param phNumber phone number to validate
     * @return returns true if phone number is valid
     */
    public  boolean validatePhNum(String phNumber) { 
        if(!(phNumber.length()==10 && phNumber.matches(".*\\d"))) {
             System.out.println("Enter a valid 10 digit phone number.");
             return false;
        }
        return true;
    }
    
}
