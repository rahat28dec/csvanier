package phonemanager;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class PhoneItem {
    // empty constructor
    public PhoneItem(){};
    
    // constructor
    public PhoneItem(String name, String phone) {
        this.name = name.trim();
        this.phone = phone.trim();
    }

//    @Override
//    public String toString() {
//        return "PhoneItem{" + "name=" + name + ", phone=" + phone + '}';
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone.trim();
    }
    
    public void setItem(PhoneItem phoneItem) {
        this.name = phoneItem.name;
        this.phone = phoneItem.phone;
    }
    
    private String name;
    private String phone;
    
    @Override
    public String toString() {
        return String.format("%-15s%s", name, this.formatPhone(phone));
    }
    
    public String formatPhone(String str) {
        String formatPhone = "(" + str.substring(0, 3) + ") ";
        formatPhone += str.substring(3, 6) + "-";
        formatPhone += str.substring(6);
        return formatPhone;
    }
}
