import java.util.Scanner;

public class NumberGuessing {

    public static void guessingNumberGame() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter maximum value till you can choose: " ); //To choose no from 1 to the no. choosen by the user
        int gui = sc.nextInt(); //Input-1
        int number = 1 + (int) (gui * Math.random());
        System.out.println("Enter in how many attempts you think you can guess:" ); //No of attempts the thinks they can guess in
        int num = sc.nextInt(); //Input-2
        int i, guess;

        System.out.println("A number is chosen between 1 to " + gui + ". Guess the number within " + num + " trials." );

        for (i = 0; i < num; i++) {
            System.out.println("Guess the number between 1 and "+gui+":");
            guess = sc.nextInt(); //Input-3
            System.out.println("On attempt #"+(i+1)+" of "+num+" you learn...");
            
            if (number == guess) {
                System.out.println("Congratulations! You guessed the number in " + (i+1) + " attempts" );
                break;
            } else if (number > guess && i != num - 1) {
                System.out.println("The number is greater than " + guess + 
                		", you are "+ GuessTemp(guess, number, gui)+".");
            } else if (number < guess && i != num - 1) {
                System.out.println("The number is less than " + guess + 
                		", you are "+ GuessTemp(guess, number, gui)+".");
            }
        }

        if (i == num) {
            System.out.println("You have exhausted the no. of trials.");
            System.out.println("The number to guess was " + number );
        }

    }

    private static String GuessTemp(int g, int n, int m) {
    	int warmrange = m/9;
    	int hotrange = m/20;
    	int range = Math.abs(g-n);
    	if (range <= hotrange) {
    		return "hot";
    	} else if (range <= warmrange) {
    		return "warm";
    	} else {
    		return "cold";
    	}
    }
    
    public static void main(String[] args) {
        {
            guessingNumberGame();
        }
    }
}


