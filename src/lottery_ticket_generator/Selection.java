package lottery_ticket_generator;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author RAYMARTHINKPAD
 */
public final class Selection {

    private final int num_elems;
    private final int low;
    private final int high;
    private ArrayList<Integer> al;

    /**
     * Default constructor, with assigned default values
     */
    public Selection() {
        this(6, 1, 49);
    }

    /**
     *
     * @param n: number of elements
     * @param low: lowest integer in the elements
     * @param high: highest integer in the elements
     */
    public Selection(int n, int low, int high) {
        /**
         * Example usage: Selection(6, 1, 49) This generates random integers of
         * 6 elements with 1 as the lowest integer and 49 as the highest
         * integer.
         */
        this.num_elems = n;
        this.low = low;
        this.high = high;
        al = new ArrayList(this.num_elems);
        for (int i = 0; i < (this.num_elems); i++) {
            int rand = this.pickRandomNumber();
            /**
             * Check if the random number already exists.
             * If it exists go step backward.
             * example:
             *      26(0), 26(1) -> the initial element
             *      and the next element is equivalent
             *      therefore go back to 
             *      the initial index that is (0) and
             *      generate new element
             */
            if (this.exists(rand)) {
                i--;
            } else {
                /**
                 * Store the random integers generated in the array list.
                 */
                this.al.add(rand);
            }
        }
        this.sort();
    }

    /**
     * We cannot have duplicate values in our 
     * random integers. Return false if
     * we have duplicates.
     * Since the array is already populated
     * we can check equalities.
     * @param n
     * @return
     */
    public boolean exists(int n) {
        for (int j = 0; j < this.al.size(); j++) {
            if (this.al.get(j).equals(n)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return a random integers between low 
     * and high inclusive (including low
     * and high).
     * @return
     */
    public int pickRandomNumber() {
        int rnums = (int) (Math.random() * (this.high - this.low + 1) + this.low);
        return rnums;
    }

    /**
     * Sort the random integers 
     * by ascending order.
     */
    public void sort() {
        Collections.sort(this.al);
    }

    /**
     * Returns a string representation 
     * of a winning draw.
     * @return
     */
    @Override
    public String toString() {
        return this.strRepresentation();
    }

    /**
     * Returns beautify output
     * @return 
     */
    public String strRepresentation() {
        String strResult = "";
        for (int i = 0; i < this.al.size(); i++) {
            Object obj = this.al.get(i);
            /**
             * Add the delimeter between elements 
             * but not the last elements
             * (size - 1)
             */
            String delim = "";
            if (i >= 0 && i < this.al.size() - 1) {
                delim = "-";
            }
            /**
             * Add zero for integer less
             * than 10 to make output 
             * bit pretty.
             */
            String zero = "";
            if(this.al.get(i)<10) {
                zero = "0";
            }
            strResult += zero + String.valueOf(obj) + delim;

        }
        return strResult;
    }
    /**
     * Returns the number of matches 
     * between the winning draw 
     * and the user picks.
     * @param winningDraw
     * @return 
     */
    public int match(Selection winningDraw) {
        int count = 0;
        for(int i = 0; i < winningDraw.al.size(); i++) {
            for(int j = 0; j < this.al.size(); j++) {
                /**
                 * w:6-9-24-34-42-43
                 * s:12-13-15-24-38-41
                 * Compare s[0]->12 to w[6,9,24,34,42,43]
                 * s[0]==w[i] -> count = 0;
                 * s index = 1
                 * s[1]->13
                 * s[1]==w[i] -> count = 0
                 * s[2]->15
                 * s[2]==w[i] -> count = 0
                 * s[3]->24
                 * s[3]==w[2] -> count = 1
                 */
                if(winningDraw.al.get(i).equals(this.al.get(j))) {
                    count++;
                }
            }
        }
        return count;
    }

}
