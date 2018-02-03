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
     * 		add the sample [(i, 2i), 5i] for 0<=i<=999
     * 		add the sample [(2i, i), 4i] for 0<=i<=999
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

            double[] temp = new double[]{i*1.0,i*2.0};

            linearRegression.addSample(temp,5.0*i);
            
        }

        // For loop used to add the other 1000 points ((2x, x), 4x)
        for (int x=0; x<1000; x++) {

            double[] temp = new double[]{x*2.0,x*1.0};

            linearRegression.addSample(temp,4.0*x);
            
        }

        // Gradient Descent Algorithm iterated 10,000 times
        for (int z=0; z<10; z++) {
            
            linearRegression.gradientDescent(0.000000003,1000);

            // Printing out curent hypothesis and cost
            //System.out.println("Hypothesis: "+linearRegression.currrentHypothesis());
            System.out.println("Cost: "+linearRegression.currentCost());
            
        }

	}




	public static void main(String[] args) {

		StudentInfo.display();

		System.out.println("setPlane");
		setPlane();


	}

}