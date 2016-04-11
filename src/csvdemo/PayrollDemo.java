package csvdemo;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class PayrollDemo extends ProcessData {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        ProcessData pd = new ProcessData();
        pd.processPayroll("data.csv");
        pd.displayOuput();
    }
}
