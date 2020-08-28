package academy.learnprograming;

public class Main<string> {

    public static void main(String[] args) {
        CalculateScore(true,5000, 5, 5);
        int highScore = CalculateScore(true,2000, 3, 10);
        System.out.println(highScore);

        displayHighScorePosition("John",5);
        System.out.println(calculateHighScorePosition(1500));
        System.out.println(calculateHighScorePosition(900));
        System.out.println(calculateHighScorePosition(400));
        System.out.println(calculateHighScorePosition(50));
    }

    public static int CalculateScore(boolean gameOver, int score, int levelCompleted, int bonus){
        if (gameOver == true){
            int finalScore = score + (levelCompleted*bonus);
            System.out.println("Your final score was " + finalScore);
            return finalScore;
        }
        return -1;
    }

    public static void displayHighScorePosition(String playerName, int position ){
        System.out.println(playerName + " managed to get to position: " + position);
    }

    public static int calculateHighScorePosition(int playerScore){
        int position = 4; // assuming position 4 will be returned

        if (playerScore >= 1000){
            position = 1;
        }else if (playerScore >= 500){
            position = 2;
        }else if (playerScore >= 100){
            position = 3;
        }

        return position;
    }
}
