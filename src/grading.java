import java.util.Scanner;
public class grading {

    double prelimScore, midtermScore, semisScore, finalScore;
    public grading(double prelimScore, double midtermScore, double semisScore, double finalScore) {
        this.prelimScore = prelimScore;
        this.midtermScore = midtermScore;
        this.semisScore = semisScore;
        this.finalScore = finalScore;
    }

    public grading () {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the prelim Score: ");
        this.prelimScore = s.nextDouble();

        System.out.println("Enter the midterm Score: ");
        this.midtermScore = s.nextDouble();

        System.out.println("Enter the semi final Score: ");
        this.semisScore = s.nextDouble();

        System.out.println("Enter the final Score: ");
        this.finalScore = s.nextDouble();
    }
    public double calculate()  {

        return (prelimScore + midtermScore + semisScore + finalScore) / 4.0;


    }
    public static void main(String[] args) {

        grading average = new grading();
        double cal = average.calculate();



        System.out.println("Your average from Prelim to finals is " + cal);

        if (cal < 75) {
            System.out.println("You failed");
        }
        else {
            System.out.println("You passed!");
        }

    }
}
