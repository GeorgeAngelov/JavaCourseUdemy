package academy.learnprograming;

public class Main {

    public static void main(String[] args) {
	    boolean gameOver = true;

	 //   if (score < 5000 && score > 2000){
     //       System.out.println("Your score was less 5000 but greater than 2000");
     //   }
	 //   else if(score<1000){
	//		System.out.println("Your score was less then 1000");
	//	}
	//    else {
	//		System.out.println("Got here");
	//	}

	    if (gameOver == true){
			int score = 5000;
			int levelCompleted = 5;
			int bonus = 100;
	    	int finalScore = score + (levelCompleted*bonus);
			System.out.println("Your final score was " + finalScore);
		}

		if (gameOver == true){
			int score = 6000;
			int levelCompleted = 3;
			int bonus = 800;
			int finalScore = score + (levelCompleted*bonus);
			System.out.println("Your final score was " + finalScore);
		}
    }
}
