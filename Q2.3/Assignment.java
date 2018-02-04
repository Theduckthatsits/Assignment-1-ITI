/**
 * The class  <b>Assignment</b> is used to
 * test our LinearRegression class. 
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
     * In this first method, we are simply using sample points that are
     * on a straight plane. We will use the plane z= x + 2x.
     * In his method, 
     * 	1) we create an instance of LinearRegression.
     * 	2) we add 2,000 samples from the plane z= x + 2x as follows:
     * 		add the sample [(i, 2i), 5i] for 0&lt;=i&lt;=999
     * 		add the sample [(2i, i), 4i] for 0&lt;=i&lt;=999
     *  3) we iterate gradient descent 10,000, printing out the
     * current hypothesis and the current cost every 1,000 
     * iterations, using a step alpha of 0.000000003
     */
    private static void setPlane(){

    // your code goes there

          // Creating an instance of the class LinearRegression
          LinearRegression linearRegression = new LinearRegression(2,2000);

          // For loop used to add first 1000 points ((x, 2x), 5x)
          for (int i=0; i<1000; i++) {

               double[] temp = new double[]{1,i*1.0,i*2.0};

               linearRegression.addSample(temp,5.0*i);
            
          }

        // For loop used to add the other 1000 points ((2x, x), 4x)
        for (int x=0; x<1000; x++) {

          double[] temp = new double[]{1,x*2.0,x*1.0};

          linearRegression.addSample(temp,4.0*x);
            
        }

        // Gradient Descent Algorithm iterated 10,000 times in total
        for (int z=0; z<10; z++) {

          linearRegression.gradientDescent(0.000000003,1000);

          // Printing out the curent hypothesis and cost
          System.out.println("Hypothesis: "+linearRegression.currentHypothesis());
          System.out.println("Cost: "+linearRegression.currentCost());
            
        }
     }

	/** 
     * In this second method, we will select a plane at random.
     * 	1) we select a line z = ax + by + c, with a, b and c 
     * randomly selected between -100 and +100 
     * 	2) we add 5000 samples randomly selected on the plane
     * with x and y both randomly selected between 50 and 4000. 
     * For each sample we add a "noise" 
     * randomly selected between -20 and +20 (that is, for
     * each randomly selected x and y we add the sample 
     *[ (x,y), ax+by+c+noise).
     * where "noise" is randomly selected between -20 and 20
     *  4) we iterate gradient descent (find a number of iterations,
     * and a step alpha that seems to work, regularly printing
     * the target,  the current hypothesis and the current cost)
     */

	private static void randomPlane(){

          // your code goes there

          // Creating an instance of the class LinearRegression
          LinearRegression linearRegression = new LinearRegression(2,5000);

          // Double a, b and c are randomly generated between -100 and +100
          double a = generator.nextDouble()*200-100;
          double b = generator.nextDouble()*200-100;
          double c = generator.nextDouble()*200-100;

          // For loop used to add 5000 sample points
          for (int i=0; i<5000; i++) {

               // Doubles x and y randomly generated between 50 and 4000
               double x = generator.nextDouble()*3950+50;
               double y = generator.nextDouble()*3950+50;

               // double noise randomly generated between -20 and 20
               double noise = generator.nextDouble()*40-20;

               // Doubles temp and temp2 are used to hold the values of the sample point
               double[] temp = new double[]{1,x,y};
               double temp2 = (a*x)+(b*y)+c+noise;

               // Adding the sample point to linearRegression
               linearRegression.addSample(temp,temp2);
               
          }

          // Gradient Descent Algorithm iterated  times in total
          for (int z=0; z<10; z++) {

               // Printing out the curent hypothesis, cost and target
               System.out.println("Hypothesis: "+linearRegression.currentHypothesis());
               System.out.println("Cost: "+linearRegression.currentCost());
               System.out.println("Target: "+c+"x_0 + "+a+"x_1 + "+b+"x_2");
               System.out.println();

               // Gradient Descent
               linearRegression.gradientDescent(0.000000003,1000);
          }
	}

	/** 
     * In this third method, we will follow the same approach
     * that the one followed in the method  randomPlane, but
     * this time we will have a variable number of dimensions,
     * specified by the parameter "dimension". We will
     * create 5000 samples of "dimension" dimension, where each
     * dimension will be ranmly selected between  -100 and +100,
     * and a randomly selected noise between -20 and +20 will be
     * added to the result.We will then iterate gradient descent 
     * (find a number of iterations,
     * and a step alpha that seems to work, regularly printing
     * the target,  the current hypothesis and the current cost)
     *
     * @param dimension the number of features
     */
	private static void randomDimension(int dimension){

		// your code goes there

	}


	public static void main(String[] args) {

		StudentInfo.display();

		System.out.println("randomDimension");
		randomDimension(50);


	}

}