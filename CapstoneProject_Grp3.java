package Projects;
import java.util.Random;
import java.util.Scanner;
import java.lang.String;

// Interface for evaluating scores
interface Evaluator {
    void evaluate(char[][] studentAnswers, char[] correctAnswers);
}

// Score analysis
class QuizScorer implements Evaluator {
    public void evaluate(char[][] a, char[] correctAnswers) {
        int students = a.length;
        System.out.println("\n\n-------");
        System.out.println("SCORES");
        System.out.println("------");
        
        for(int i = 0; i < students; i++) {
            int score = 0;
            for(int j = 0; j < 5; j++) {
            	if(a[i][j] == correctAnswers[j]) {
            		score += 4;
                } else if(a[i][j] != 'a' || a[i][j] != 'b' ||a[i][j] != 'c' ||a[i][j] != 'd') {
                	score += 0;
                } else {
                    score -= 1;
                }
            }
            System.out.println("Student " + (i + 1) + " Score: " + score);
        }
        System.out.println("\n-----------------");
        System.out.println("QUESTION ANALYSIS");
        System.out.println("-----------------");

        for(int j = 0; j < 5; j++) {
            int correctCount = 0;
            for(int i = 0; i < students; i++) {
                if (a[i][j] == correctAnswers[j]) {
                    correctCount++;
                }
            }
            int percentage = (int) ((correctCount * 100.0) / students);
            
            String difficulty;
            if(percentage > 75) difficulty = "Easy";
            else if (percentage > 40) difficulty = "Medium";
            else difficulty = "Hard";
            System.out.println("Q" + (j+1) + " Correct: " + percentage + "% (" + difficulty + ")");
        }
    }
}

// Exception class 
class OptionException extends Exception {
	OptionException(String msg){
		super(msg);
	}
}

// abstract class to create a quiz
abstract class answerQuiz{
	
	//throw message for wrong option chosen 
	public static void Option(char c) throws OptionException{
		if(c != 'a' || c != 'b' || c != 'c' ||c != 'd')
			throw new OptionException("Invalid option entered");
	}
	
    // Added rowIndex to fix bug where students overwrote each other
	answerQuiz(char[][] a, Scanner sc, int rowIndex) {
		System.out.println("Question 1"); // ans = b
		System.out.println("----------");
		System.out.println("What is the smallest integer data type in Java?");
		System.out.println("A. int		B. byte		C. short	D. long");
		System.out.print("Enter Response : ");
		a[rowIndex][0] = sc.next().charAt(0);
		try {
			Option(a[rowIndex][0]);
		}
		catch(OptionException e) {
			System.out.println(e.getMessage());
		}
		a[rowIndex][0] = Character.toLowerCase(a[rowIndex][0]);
		System.out.println();
		System.out.println("Question 2"); // ans b
		System.out.println("----------");
		System.out.println("Which keyword is used to include a package in your Java class?");
		System.out.println("A. package		B. import		C. include		D. use");
		System.out.print("Enter Response : ");
		a[rowIndex][1] = sc.next().charAt(0);
		try {
			Option(a[rowIndex][1]);
		}
		catch(OptionException e) {
			System.out.println(e.getMessage());
		}
		a[rowIndex][1] = Character.toLowerCase(a[rowIndex][1]);
		System.out.println();
		System.out.println("Question 3"); // ans c
		System.out.println("----------");
		System.out.println("In Java, what must all code be contained within?");
		System.out.println("A. Method		B. Object		C. Class 	D. Variable");
		System.out.print("Enter Response : ");
		a[rowIndex][2] = sc.next().charAt(0);
		try {
			Option(a[rowIndex][2]);
		}
		catch(OptionException e) {
			System.out.println(e.getMessage());
		}
		a[rowIndex][2] = Character.toLowerCase(a[rowIndex][2]);
		System.out.println();
		System.out.println("Question 4"); // ans d
		System.out.println("----------");
		System.out.println("Which object-oriented concept in Java allows one name to have multiple forms?");
		System.out.println("A. Inheritance		B. Encapsulation		C. Abstraction		D. Polymorphism");
		System.out.print("Enter Response : ");
		a[rowIndex][3] = sc.next().charAt(0);
		try {
			Option(a[rowIndex][3]);
		}
		catch(OptionException e) {
			System.out.println(e.getMessage());
		}
		a[rowIndex][3] = Character.toLowerCase(a[rowIndex][3]);
		System.out.println();
		System.out.println("Question 5"); // ans c
		System.out.println("----------");
		System.out.println("Which component executes the Java bytecode?");
		System.out.println("A. JDK		B. JRE		C. JVM		D. JIT");
		System.out.print("Enter Response : ");
		a[rowIndex][4] = sc.next().charAt(0);
		try {
			Option(a[rowIndex][4]);
		}
		catch(OptionException e) {
			System.out.println(e.getMessage());
		}
		a[rowIndex][4] = Character.toLowerCase(a[rowIndex][4]);
		System.out.println();
	}
}

class QuizImplementer extends answerQuiz {
    QuizImplementer(char[][] a, Scanner sc, int rowIndex) {
        super(a, sc, rowIndex);
    }
}

public class CapstoneProject_Grp3 {

	public static char[][] generateResponses() {
		char[][]a = new char[5][5];
		char[] options = {'a', 'b', 'c', 'd'};
        Random random = new Random();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                int index = random.nextInt(options.length);
                a[i][j] = options[index];
            }
        }
        for (int i = 0; i < a.length; i++) {
        	System.out.print("Student " + (i+1) + " response : ");
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        return a;
	}
	
	static class ChoiceException extends Exception {
		ChoiceException(String msg){
			super(msg);
		}
	}
	//throw message for wrong option chosen 
	public static void Choice(String s) throws ChoiceException{
		if (!s.equalsIgnoreCase("yes") && !s.equalsIgnoreCase("no")) {
	        throw new ChoiceException("Invalid response entered");
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// Title
		System.out.println("\t-------------");
		System.out.println("\tQUIZ ANALYSIS");
		System.out.println("\t-------------");
		System.out.println("MARKING SCHEME:");
		System.out.println("---------------");
		System.out.println("Correct Answer :   +4\nIncorrect Answer : -1\n\n");
		
		// Creating initial components
		int student = 5;
		char[][] a = new char[student][5];
		String response = "";
		
		while (true) {
			System.out.println("Do you want to answer quiz?");
			System.out.print("Yes/No : ");
			response = sc.next();
			
			try {
				Choice(response);
				break; 
			} catch (ChoiceException e) {
				System.out.println(e.getMessage() + "\n");
			}
		}
		
		// if users answer the quiz 
		if(response.equalsIgnoreCase("yes")) {
			System.out.print("Enter total number of students : ");
			student = sc.nextInt();
			a = new char[student][5];
			System.out.println();
			for(int i=0; i<student; i++) {
				System.out.println("Student " + (i+1));
				System.out.println("---------");
				System.out.println();
                // Pass loop index 'i' so we know which row to fill
				QuizImplementer aq = new QuizImplementer(a, sc, i);
				System.out.println();
			}
			
			// else create random answer responses 
		} else { 
            // Save the returned array
			a = generateResponses();
		}
		
		// Storing the correct answers
		char[] correctAnswers = {'b', 'b', 'c', 'd', 'c'};
		System.out.println("\n---");
		System.out.println("KEY");
		System.out.println("---");
		for(int i=0; i<5; i++) {
			System.out.print((i+1) + ". " + correctAnswers[i] + "\t");
		}
		
        // Use Interface to Evaluate
        Evaluator evaluator = new QuizScorer();
        evaluator.evaluate(a, correctAnswers);

		sc.close();
	}
}