/**
 * The class  <b>Assignment</b> is used to
 * test our LinearRegression class. It uses the
 * provided class <b>Display</b> to show the results
 *
 * @author gvj (gvj@eecs.uottawa.ca)
 *
 */

public class Assignment {


	/** 
     * Random generator 
     */
	private static java.util.Random generator = new java.util.Random();

		/** 
     * In this second method, we will select a line at random.
     * 	1) we select a line y = ax + b, with a randomly selected
     * between -100 and +100 and b randomly selected between 
     * -250 and +250
     * 	2) we add 500 samples randomly selected on the line
     * between -100 and +300. For each sample we add a "noise" 
     * randomly selected between -1000 and +1000 (that is, for
     * each randomly selected x, we add the sample (x, ax+b+noise).
     * where "noise" is randomly selected between -1000 and 1000
     *  3) We create an instance of Display
     *  4) we iterate gradient descent (find a number of iterations,
     * a number of updates to the instance of Display, and a 
     * step alpha that seems to work
     */
	private static void randomLine(){

		// your code goes there

          LinearRegression linearRegression = new LinearRegression(500);
          
          Display display = new Display(linearRegression);

          double a = generator.nextDouble()*200-100;
          double b = generator.nextDouble()*500-250;

          display.setTarget(a,b);

          for (int i=0; i<500; i++) {

               double x = generator.nextDouble()*400-100;
               double noise = generator.nextDouble()*2000-1000;


               linearRegression.addSample(x,(a*x)+b+noise);
               
          }

          // Foor loop used to iterate the algorithm GradientDescent a total of 5000 times
          for (int x=0; x<100; x++) {

               // Updating the graph
               display.update(); // For some reason the program works without updating
               
               // Calling method gradientDescent from instance linearRegression
               linearRegression.gradientDescent(0.00000003, 100);
               
               // Printing out the current hypothesis and cost
               System.out.println("Current hypothesis: " + linearRegression.currentHypothesis());
               System.out.println("Current cost: " + linearRegression.currentCost());

          }

	}


	public static void main(String[] args) {

	    StudentInfo.display();

		System.out.println("randomLine");
		randomLine();

	}

}