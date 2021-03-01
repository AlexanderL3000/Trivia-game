
/*
 * Multiple Choice Assignment 4: This program is essentially a multiple choice quiz that is displayed on a user friendly interface. 
 * This program makes good use of arrays, as there is an answer key that is stored inside of an array that is used to 
 * cross reference and check each user choice and the correct answer for the specific question. This program does not use try 
 * and catch or while loops, mainly because they are not always necessary when the program involves GUIs, because we simply
 * do not allow the user to input things that are out of bounds, and we can set the program to repeat without the need for a loop.
 * This program is very similar to a kahoot, in which there is 1 question that appears at the top of the window and 4 buttons that 
 * you may press to choose answers. each time an answer is chosen, whether it is correct or not, will change the text of every 
 * relevant object to the next question and its answers. Also, this program does have some lag, so please do not click too fast
 * when choosing answers.
 * 
 * Alexander Li
 * Nov 5th 2020
 */

//Imports for JavaX(the GUI) and all of the organization and user interaction
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {

	// Since this program involves GUIs, we have to initialize a few global
	// variables
	// instead of putting parameters in a method, as these variables may be
	// constantly changed during different times,
	// and they will all be needed throughout the thread. We cannot predict how the
	// user will input, so the program
	// cannot be simply straightforward, with 1 thing happening after another. This
	// causes the program to enter the Window
	// method and stay there forever, so we cannot simply define local variables.
	// Another reason that we use
	// global variables in this program specifically is because the ActionListener
	// method we create does not
	// allow the use of local variables, and therefore, the only way we have around
	// this is by using global variables.

	// Global variable for the current question we are on
	public static byte bytQuestionNum = 0;

	// Global variable for number of correct answers given
	public static byte bytCorrectCounter = 0;
	
	// A final constant used to define the amount of questions there are
		public static final byte bytQuestionNumbers = 10;

	// Global array for user input to hold the user inputs
	public static char[] chrInput = new char[bytQuestionNumbers];

	// Global array that acts as an answer key and can be checked against the user's
	// input
	public static char[] chrAnswerKey = new char[] { 'b', 'c', 'a', 'd', 'a', 'a', 'd', 'c', 'c', 'c' };

	// Global variable for user's final score
	public static byte bytFinalAnswer;

	

	public static void main(String[] args) {

		// We call the window method and that is all we do in the main method.
		Window();

	}

	// Void method to check answer, as we do not actually return anything.
	public static void CheckAnswer() {

		// We check if the program has started or not, because if the program is reset
		// and chrInput is already defined,
		// it may increment bytCorrectCounter which can lead to errors.
		if (bytQuestionNum >= 0) {

			// We check for the user's choice, and we do not need to worry about upper case
			// or lower case,
			// because when chrInput is populated, it will always be as a lower case
			// character. We compare the input array at the current question position to the answer key at the same position.
			if (chrInput[bytQuestionNum -1] == chrAnswerKey[bytQuestionNum - 1]) {

				//We output that the user got the question right (Just as a friendly helpful debugging thing, but also to help Mrs. G mark)
				System.out.println("Correct");
				// We increment the amount of correct answers received by 1
				bytCorrectCounter++;
			}

			else {
				
				//We output in console that the answer was incorrect
				System.out.println("Incorrect");
			}
		}

	}

	// Method containing everything involving the frame and GUI
	public static void Window() {

		// This line of code makes the frame on the GUI look nice, but doesn't really do
		// all that much else.
		JFrame.setDefaultLookAndFeelDecorated(true);

		// This creates a JFrame and initializes a frame object so hat
		// we can manipulate the same frame without making a new JFrame each time.
		JFrame frame = new JFrame();

		// This creates a button for the first option "A";
		JButton buttonResA = new JButton();

		// This creates a button for the second option "B";
		JButton buttonResB = new JButton();

		// This creates a button for the third option "C";
		JButton buttonResC = new JButton();

		// This creates a button for the fourth option "D";
		JButton buttonResD = new JButton();

		// This button is used for starting the program and it works also as a retry
		// button.
		JButton buttonStartAndEnd = new JButton("Begin");

		// An output text box that can print out messages to the user on the GUI itself
		JLabel textLabel1 = new JLabel(
				"Hi! This is a multiple choice quiz on General Knowledge! This quiz has 10 questions. Good luck!");

		// A second out put text box to print out the questions.
		JLabel textLabel2 = new JLabel();

		// We add the first text box to the frame itself
		frame.add(textLabel1);

		// We also add the button to start the program
		frame.add(buttonStartAndEnd);

		// We set out a Grid Layout to organize the buttons and keep them in uniform
		// sizes and shapes.
		frame.setLayout(new GridLayout(2, 0));

		// Setting the frame's size to 800 by 800
		frame.setSize(800, 800);

		// Automatically end the program if the window is closed
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

		// Sets the window to the center of the page
		frame.setLocationRelativeTo(null);

		// Set the frame as visible
		frame.setVisible(true);

		// Adding an Action Listener to the button for option A
		buttonResA.addActionListener(new ActionListener() {

			// Checking for the user to interact with the button A
			public void actionPerformed(ActionEvent e) {

				// If the user does press the button, the input variable is set to the character
				// 'a' at the correct position of the array.
				// This is almost no different from the actual user input, but because of this
				// system,
				// we do not need to implement try and catch because of the lack of bad inputs.
				//We must also do the question number minus 1, because the beginning index of an array is at 0.
				chrInput[bytQuestionNum-1] = 'a';

				// Calling the armor checking method
				CheckAnswer();

				// We increment the question number to move on to the next question
				Main.bytQuestionNum++;

				// We run a method that stores all of the questions and answer choices
				Questions(buttonResA, buttonResB, buttonResC, buttonResD, buttonStartAndEnd, textLabel1, textLabel2,
						frame);

			}
		});

		// Adding an Action Listener to the button for option B
		buttonResB.addActionListener(new ActionListener() {

			// Checking if user interacted with button B
			public void actionPerformed(ActionEvent e) {

				// If the user does press the button, the input variable is set to the character
				// 'b' at the correct position of the array.
				// This is almost no different from the actual user input, but because of this
				// system,
				// we do not need to implement try and catch because of the lack of bad inputs.
				//We must also do the question number minus 1, because the beginning index of an array is at 0.
				chrInput[bytQuestionNum-1]  = 'b';

				// Calling the armor checking method
				CheckAnswer();

				// We increment the question number to move on to the next question
				Main.bytQuestionNum++;

				// We run a method that stores all of the questions and answer choices
				Questions(buttonResA, buttonResB, buttonResC, buttonResD, buttonStartAndEnd, textLabel1, textLabel2,
						frame);

			}
		});

		// Adding an Action Listener to the button for option B
		buttonResC.addActionListener(new ActionListener() {

			// Checking for user to interact with button C
			public void actionPerformed(ActionEvent e) {

				// If the user does press the button, the input variable is set to the character
				// 'c' at the correct position of the array.
				// This is almost no different from the actual user input, but because of this
				// system,
				// we do not need to implement try and catch because of the lack of bad inputs.
				//We must also do the question number minus 1, because the beginning index of an array is at 0.
				chrInput[bytQuestionNum-1]  = 'c';

				// Calling the armor checking method
				CheckAnswer();

				// We increment the question number to move on to the next question
				Main.bytQuestionNum++;

				// We run a method that stores all of the questions and answer choices
				Questions(buttonResA, buttonResB, buttonResC, buttonResD, buttonStartAndEnd, textLabel1, textLabel2,
						frame);

			}
		});

		// Adding an Action Listener to the button for option D
		buttonResD.addActionListener(new ActionListener() {

			// Checking if user interacted with button D
			public void actionPerformed(ActionEvent e) {

				// If the user does press the button, the input variable is set to the character
				// 'd' at the correct position of the array.
				// This is almost no different from the actual user input, but because of this
				// system,
				// we do not need to implement try and catch because of the lack of bad inputs.
				//We must also do the question number minus 1, because the beginning index of an array is at 0.
				chrInput[bytQuestionNum-1]  = 'd';

				// Calling the armor checking method
				CheckAnswer();

				// We increment the question number to move on to the next question
				Main.bytQuestionNum++;

				// We run a method that stores all of the questions and answer choices
				Questions(buttonResA, buttonResB, buttonResC, buttonResD, buttonStartAndEnd, textLabel1, textLabel2,
						frame);

			}
		});
		// Adding an Action Listener to the button for the start and ending button
		buttonStartAndEnd.addActionListener(new ActionListener() {

			// Checking if user wishes to start or reset the program
			public void actionPerformed(ActionEvent e) {

				// We check if we are at the end of the program, and if we are, we
				// reset the program since the user wishes to by pressing this button
				if (bytQuestionNum > 10) {

					// If we are at the end of the program, we ut all of the changed variables back
					// to 0.
					bytQuestionNum = 0;
					bytCorrectCounter = 0;
				}

				// This effectively starts off the quiz by incrementing the question number to 1
				// and letting other parts of the code run.
				Main.bytQuestionNum++;

				// This sets the GridLayout of the frame to 3 rows, 2 columns
				frame.setLayout(new GridLayout(3, 2));

				// We add the text box that displays questions
				frame.add(textLabel2);

				// We remove the starting and resetting button
				frame.remove(buttonStartAndEnd);

				// We add all 4 question buttons
				frame.add(buttonResA);
				frame.add(buttonResB);
				frame.add(buttonResC);
				frame.add(buttonResD);

				// We also enter the Questions method
				Questions(buttonResA, buttonResB, buttonResC, buttonResD, buttonStartAndEnd, textLabel1, textLabel2,
						frame);

			}
		});

	}

	// Method that stores all of the answers and questions
	public static void Questions(JButton buttonResA, JButton buttonResB, JButton buttonResC, JButton buttonResD,
			JButton buttonStartAndEnd, JLabel textLabel1, JLabel textLabel2, JFrame frame) {

		// Local variable for the math at the end
		// We multiply our answer by 100 to give a percentage.
		byte bytPercentageConstant = 100;

		if (bytQuestionNum == 0) {
			// Quiz has not started yet, but we need to add this, otherwise the else
			// statement will be triggered when bytQuestionNum is 0
		}

		// Question 1
		else if (bytQuestionNum == 1) {

			// We change all of the text of the buttons to their appropriate sentences
			textLabel1.setText("Question " + bytQuestionNum + ":");
			textLabel2.setText("What is the name for the Jewish New Year?");
			buttonResA.setText("A. Hannukah");
			buttonResB.setText("B. Rosh Hashanah");
			buttonResC.setText("C. Yom Kippur");
			buttonResD.setText("D. Kwanzaa");
		}

		// Question 2
		if (bytQuestionNum == 2) {

			// We change all of the text of the buttons to their appropriate sentences
			textLabel1.setText("Question " + bytQuestionNum + ":");
			textLabel2.setText("How many blue stripes are there on the U.S. Flag");
			buttonResA.setText("A. 6");
			buttonResB.setText("B. 7");
			buttonResC.setText("C. 0");
			buttonResD.setText("D. 13");

		}

		// Question 3
		else if (bytQuestionNum == 3) {

			// We change all of the text of the buttons to their appropriate sentences
			textLabel1.setText("Question " + bytQuestionNum + ":");
			textLabel2.setText("Which one of these characters is not friends with Harry Potter?");
			buttonResA.setText("A. Draco Malfoy");
			buttonResB.setText("B. Neville Longbottom");
			buttonResC.setText("C. Hermione Granger");
			buttonResD.setText("D. Ron Weasley");
		}

		// Question 4
		else if (bytQuestionNum == 4) {

			// We change all of the text of the buttons to their appropriate sentences
			textLabel1.setText("Question " + bytQuestionNum + ":");
			textLabel2.setText("What is the color of Donald Ducks bow tie?");
			buttonResA.setText("A. White");
			buttonResB.setText("B. Yellow");
			buttonResC.setText("C. Blue");
			buttonResD.setText("D. Red");
		}

		// Question 5
		else if (bytQuestionNum == 5) {

			// We change all of the text of the buttons to their appropriate sentences
			textLabel1.setText("Question " + bytQuestionNum + ":");
			textLabel2.setText("What was the name of the band Lionel Richie was part of?");
			buttonResA.setText("A. Commodores");
			buttonResB.setText("B. Spectrums");
			buttonResC.setText("C. King Harvest");
			buttonResD.setText("D. The Marshall Tucker Band");
		}

		// Question 6
		else if (bytQuestionNum == 6) {

			// We change all of the text of the buttons to their appropriate sentences
			textLabel1.setText("Question " + bytQuestionNum + ":");
			textLabel2.setText("Which animal does not appear in the Chinese Zodiac?");
			buttonResA.setText("A. Hummingbird");
			buttonResB.setText("B. Dragon");
			buttonResC.setText("C. Dog");
			buttonResD.setText("D. Rabbit");
		}

		// Question 7
		else if (bytQuestionNum == 7) {

			// We change all of the text of the buttons to their appropriate sentences
			textLabel1.setText("Question " + bytQuestionNum + ":");
			textLabel2.setText("Which country held the 2016 Summer Olympics?");
			buttonResA.setText("A. China");
			buttonResB.setText("B. Ireland");
			buttonResC.setText("C. Italy");
			buttonResD.setText("D. Brazil");
		}

		// Question 8
		else if (bytQuestionNum == 8) {

			// We change all of the text of the buttons to their appropriate sentences
			textLabel1.setText("Question " + bytQuestionNum + ":");
			textLabel2.setText("Which planet in our solar system is the hottest?");
			buttonResA.setText("A. Saturn");
			buttonResB.setText("B. Mercury");
			buttonResC.setText("C. Venus");
			buttonResD.setText("D. Mars");
		}

		// Question 9
		else if (bytQuestionNum == 9) {

			// We change all of the text of the buttons to their appropriate sentences
			textLabel1.setText("Question " + bytQuestionNum + ":");
			textLabel2.setText("Who was the only U.S president to resign?");
			buttonResA.setText("A. Herbert Hoover");
			buttonResB.setText("B. George W. Bush");
			buttonResC.setText("C. Richard Nixon");
			buttonResD.setText("D. Barack Obama");
		}

		// Question 10
		else if (bytQuestionNum == 10) {

			// We change all of the text of the buttons to their appropriate sentences
			textLabel1.setText("Question " + bytQuestionNum + ":");
			textLabel2.setText("What does the D in D-Day stand for?");
			buttonResA.setText("A. Dooms");
			buttonResB.setText("B. Dark");
			buttonResC.setText("C. Dunkirk");
			buttonResD.setText("D. Denmark");
		}

		// If all of the questions have been answered
		else if (bytQuestionNum > 10) {
			// Percentage is the number of correct questions divided by the total number of
			// questions along with a multiplication by
			// 100 to make it a whole number
			bytFinalAnswer = (byte) ((float) bytCorrectCounter / bytQuestionNumbers * bytPercentageConstant);

			// We set the GridLayout to 2 rows. Since we only have 2 objects to display, we
			// do not need to specify the amount of columns
			frame.setLayout(new GridLayout(2, 0));

			// Output to user
			textLabel1.setText("Congratulations! Your mark is: " + bytFinalAnswer + "%!");

			// We also remove all of the question buttons and add the reset button
			frame.remove(buttonResA);
			frame.remove(buttonResB);
			frame.remove(buttonResC);
			frame.remove(buttonResD);
			frame.remove(textLabel2);
			frame.add(buttonStartAndEnd);
			
			//Printing out the given answers to console to help with marking and debugging
			System.out.println("Your answers are: ");
			
			//For loop to print out the user's inputs for debugging and marking purposes
			for(byte i = 0; i <bytQuestionNumbers; i++) {
			System.out.println(chrInput[i]);
			}
			
			// Prompt to ask user if they wish to continue or quit
			buttonStartAndEnd.setText("Would you like to try again? Click the x in the top corner to exit.");
		}
		// For some reason, putting an else statement in this method causes the code to
		// always focus on the else statement.
		// I think that since the ActionListener is always running in the background,
		// there is a possibility that between clicks,
		// The code thinks that the question number is not a number from 0-10.

	}
}