
/*
 * This class expects to import a NumberGuessGame.jar file, 
 * and run the packaged source code as an executable.  
 */
import java.util.ArrayList;
import java.util.Scanner;

public class NumberGuessGameJar {
  public static void main(String args[]) throws Exception {

    // Letting my user creating their range
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the range that you want your number to be in between 1 and 500. ");
    Scanner input = new Scanner(System.in);
    int range = input.nextInt();
    int number = (int) (Math.random() * range) + 1;
    // creating an arraylist that keeps into account how many guesses they had
    ArrayList<Integer> Guessesofuser = new ArrayList<Integer>();
    int AmountOfTimesGuesses = 0;

    System.out.print("Guess a number between 1 and " + range + ": ");
    System.out.println("Use your guesses wisely");

    // add to the guesscount
    int guess = input.nextInt();
    Guessesofuser.add(guess);
    AmountOfTimesGuesses++;
    // if the guess isn't egual ot the number, instruct them if it is lower or
    // higher

    while (guess != number) {
      if (guess < number) {

        System.out.println("The automated number you are searching for is higher");

      } else {
        System.out.println(" The automated number you are searching for is lower");
        guess = input.nextInt();

       if (Guessesofuser.contains(guess)) {
          System.out.println(
              " As I said before use your guesses wisely, you have already guessed this number. Stop with the tomfoolery.");
        }
        System.out.println("You guessed the number in " + AmountOfTimesGuesses + " tries!");
      }
    }
  }

  // Errorchecking System
  static int errorCheck(Scanner sc) {
    System.out.println("I am expecting a number from 1 - 500!");
    if (sc.hasNextInt()) {
      int input = sc.nextInt();
      
      if (input > 500|| input < 1) {
        System.out.println("Hey! this number is not what I wanted. Try again.");
        return errorCheck(sc);
      } else {
        System.out.println("Yay! This is what I expected");
        return input;
      }
    } else {
      System.out.println("This is not a number. Discarding this input");
      sc.next(); // discarding the next input
      return errorCheck(sc);
    }
  }

}
