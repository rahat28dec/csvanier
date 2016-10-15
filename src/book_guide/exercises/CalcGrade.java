package book_guide.exercises;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class CalcGrade {

    public static void main(String[] args) {
        double avg = calcAverage(59, 59, 59, 59, 59);
        char letterGrade = determineGrade(avg);
        System.out.println(letterGrade);
    }

    public static double calcAverage(
            int score1, int score2,
            int score3, int score4,
            int score5) {
        return (score1 + score2 + score3 + score4 + score5) / 5;
    }

    public static char determineGrade(double avg) {
        char letterGrade = 'F';
        if (avg > 89 && avg < 101) {
            letterGrade = 'A';
        }
        if (avg > 79 && avg < 90) {
            letterGrade = 'B';
        }
        if (avg > 69 && avg < 80) {
            letterGrade = 'C';
        }
        if (avg > 59 && avg < 70) {
            letterGrade = 'D';
        }
        if (avg <= 59) {
            letterGrade = 'F';
        }
        return letterGrade;
    }
}
