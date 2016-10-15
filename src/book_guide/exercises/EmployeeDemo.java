package book_guide.exercises;

import java.util.Arrays;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class EmployeeDemo {

    public static void main(String[] args) {
        // You can actually use an object as an array like the following
        Employee[] staffMembers = new Employee[3];

        // Then populate the objects like this:
        staffMembers[0] = new Employee();
        staffMembers[0].setName("Susan Meyers");
        staffMembers[0].setIdNumber(47899);
        staffMembers[0].setDepartment("Accounting");
        staffMembers[0].setPosition("Vice President");

        staffMembers[1] = new Employee();
        staffMembers[1].setName("Mark Jones");
        staffMembers[1].setIdNumber(39119);
        staffMembers[1].setDepartment("IT");
        staffMembers[1].setPosition("Programmer");

        staffMembers[2] = new Employee();
        staffMembers[2].setName("Joy Rogers");
        staffMembers[2].setIdNumber(81774);
        staffMembers[2].setDepartment("Manufacturing");
        staffMembers[2].setPosition("Engineer");

        System.out.println("Name" + "\t" + "ID Number" + "\t" + "Department" + "\t" + "Position");
        System.out.println("------------------------------------------------");
        for (int i = 0; i < staffMembers.length; i++) {
            System.out.println(staffMembers[i].getName() + "\t" + staffMembers[i].getIdNumber() + "\t" + staffMembers[i].getDepartment() + "\t\t" + staffMembers[i].getPosition());
        }
    }
}
