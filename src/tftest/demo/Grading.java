package tftest.demo;

/**
 * @author RAYMARTPC Date: 2/11/2012
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Grading {

    private static final int NUM_STUDENT = 200;
    private static final int TEST_SCORE = 40;
    private static final int NUM_QUESTION = 20;
    private static final double PERCENTAGE = 100;
    private static final int MORE_THAN_20 = 20; // list the question numbers that more than 20% of the students got wrong.

    static char[] answer = new char[NUM_QUESTION];
    static int[] wrongAnswer = new int[NUM_QUESTION];

    static String[] id = new String[NUM_STUDENT];
    static String[] studentAnswer = new String[NUM_STUDENT];
    static int j = 0;
    
    // contents stored here
    public static Scanner inputFile;

    /*
     * read the file(test1.txt)
     */
    public static void readFile() {
        // j acts as an index 
        // id = number of students (200)
        
        while (inputFile.hasNext() && j < id.length) {
            
            // store all the content after the first line
            // reads line by line
            String line = inputFile.nextLine();
            
            // extract the ids from the content and store it
            id[j] = line.substring(0, 8);
            
            // extract the student answers from the content
            // and store
            studentAnswer[j] = line.substring(9, 29);
            
            // increment j untill reached end of file
            j++;
        }
        
    }

    /**
     * @return letterGrade return appropriate student test grade based on the
     * test result
     */
    public static char getGrade(int score) {
        double grade = score * 100.0 / TEST_SCORE;
        /*
         * the test grade (A-F).
         */
        char letterGrade;
        if (grade >= 90) {
            letterGrade = 'A';
        } else if (grade >= 80) {
            letterGrade = 'B';
        } else if (grade >= 70) {
            letterGrade = 'C';
        } else if (grade >= 60) {
            letterGrade = 'D';
        } else {
            letterGrade = 'F';
        }
        return letterGrade;
    }

    /**
     * Accumulate the total of points from
     * 
     * Important : 
     *  This is NESTED with/inside the printResult
     *  for loop.
     * 
     * each correct question
     * @param forEachStudAns
     * @return 
     */
    public static int studentPoints(int forEachStudAns) {
        // store the score
        int studentScore = 0;
        char noAnswer = ' ';
        
        // condition:
        // 1. 2 points for CORRECT
        // 2. -1 points for WRONG
        // 3. 0 for NO ANSWER
        // increment wrongAnswer when 2 and 3 are met
        
        // iterate through each question
        for (int i = 0; i < NUM_QUESTION; i++) {
            // for each student response
            // compare his/her answer with the correct one
            // notice: j
            if (studentAnswer[forEachStudAns].charAt(i) == answer[i]) {
                studentScore += 2;
            } else if (studentAnswer[forEachStudAns].charAt(i) == noAnswer) {
                
                // determine which question student get 
                // wrong answered
                wrongAnswer[i]++;
                
            } else {
                studentScore--;
                wrongAnswer[i]++;
            }
        }
        return studentScore;
    }

    public static void printResult() {
       // print the result for whe whole 200 students
        for (int i = 0; i < NUM_STUDENT; i++) {
            
            // student ids
            String studentID = id[i];
            
            // students response
            String studentRes = studentAnswer[i];
            
            // combine ids and response
            String idResponse = studentID.concat(" ").concat(studentRes);
            
            // returns the total points fot each
            // student 
            int totalPoints = studentPoints(i);
            String points = String.valueOf(totalPoints);
            
            // letter grade A B C D E F
            char letterGrade = getGrade(totalPoints);
            String grade = String.valueOf(letterGrade);
            
            // combine points and grade
            String pointsGrade = points.concat(" ").concat(grade);
            
            // combine all together
            String together = idResponse.concat(" ").concat(pointsGrade);
            
            System.out.println(together);
        }

        /**
         * Output the questions by which 20% of 
         * student got wrong.
         * Example:
         *  Q1 : 
         *      expected answer = T 
         *      number of students wrong = 45
         *      percent = 22.5
         */
        
        // percent of wrong answer per questions
        double percentWrongAnswer;
        for (int k = 0; k < NUM_QUESTION; k++) {
            
            // expected answer but got it wrong
            String expectedAnswer = new String(answer);
            
            // percent of wrong answer for each question
            percentWrongAnswer = wrongAnswer[k] * PERCENTAGE / NUM_STUDENT;
            
            // question number
            int questionNumber = k + 1;
            
            // number of students who got the question wrong
            int numStudentWrong = wrongAnswer[k];
            
            // percent of students who got the question wrong
            double percentStudentWrong = (Math.round(wrongAnswer[k]) / ((double) NUM_STUDENT) * PERCENTAGE);
            
            if (percentWrongAnswer > MORE_THAN_20) {
                String zero = "0";
                if(k<=9) {
                    System.out.println(zero 
                        + questionNumber + " : " 
                        + expectedAnswer.charAt(k) + " "
                        + numStudentWrong + " "
                        + percentStudentWrong);
                } else {
                    System.out.println(questionNumber + " : " 
                        + expectedAnswer.charAt(k) + " "
                        + numStudentWrong + " "
                        + percentStudentWrong);
                }
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        // file name
        String dataInput = "test1.txt";
        // validate
        processFile(dataInput);
        
        // read the first line and store
        answer = inputFile.nextLine().toCharArray();
        
        // get the desired inputs that are ids and
        // student answers
        readFile();
        
        // display output
        printResult();
    }

    public static String validateArgs(String[] args) {
        // Validate arguments here
        String dataInput = "test1.txt";
        if (args.length == 0) {
            System.out.println("No arguments found." + "\nEnter an argument and try again.");
            System.exit(0);
        } else {
            dataInput = args[0];
        }
        return dataInput;
    }

    /**
     * Validate the file for errors 
     * if file exists or not
     *
     * @param dataInput
     */
    public static void processFile(String dataInput) {
        try {
            inputFile = new Scanner(new File(dataInput));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
