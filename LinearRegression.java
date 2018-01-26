/**
 * The class  <b>LinearRegression</b> implements gradient
 * descent with 1 variable.
 *
 * @author gvj (gvj@eecs.uottawa.ca)
 *
 */

public class LinearRegression {


	/** 
     * Number of samples (usually "m" in litterature) 
     */
	private int nbreOfSamples;


	/** 
     * the sample vector
     */
	private double[] samples;

	/** 
     * the samples target values
     */
	private double[] samplesValues;

	/** 
     * the current hypthesis function: theta0 + theta1 x
     */
	private double theta0, theta1;


	/** 
     * used to ensure that the object is ready
     */
	private int currentNbreOfSamples;


	/** 
     * counts how many iterations have been performed
     */
	private int iteration;


	/** 
     * Object's contructor. The constructor initializes the instance
     * variables. The starting hypthesis is y = 0;
     * 
     * 
     * @param m the number of samples that we will have
	 *
     */
 	public LinearRegression(int m){

 		// your code goes there
 		// 
 		nbreOfSamples=m;

 		// Initializing initial hypothesis
 		theta0=0;
 		theta1=0;

 		// Initializing the lists samples and samplesValues to lists of size 0
 		samples = new double[0];
		samplesValues = new double[0];

		// Initializing the number of iterations to zero
		iteration=0;

	}

	/** 
     * Adds a new sample to sample and to samplesValues. This
     * method must be iteratively called with all the samples
     * before the gradient descent can be started
     * 
     * @param x the new sample
     * @param y the corresponding expected value
     *
	 */
	public void addSample(double x, double y){

		// your code goes there

		// Variable newSize is initiated to the new length of lists sample and samplesValue (which are the same size)
		int newSize = samples.length+1;

		// Creating new arrays of the new size and assigning them to the lists samples and samplesValues
		samples = new double[newSize];
		samplesValues = new double[newSize];

		// Adds the x and y values of the point passed to method addSample to the list samples and samplesValues respectively
		samples[newSize-1] = x;
		samplesValues[newSize-1] = y;

	}

	/** 
     * Returns the current hypothesis for the value of the input
     * @param x the input for which we want the current hypothesis
     * 
	 * @return theta0 + theta1 x
	 */
	private double hypothesis(double x){
		// your code goes there

		return theta0+theta1*x;
	}

	/** 
     * Returns a string representation of hypthesis function
     * 
	 * @return the string "theta0 + theta1 x"
	 */
	public String currentHypothesis(){

		// your code goes there

		return theta0 + " + " + theta1 + " x";
	}

	/** 
     * Returns the current cost
     * 
	 * @return the current value of the cost function
	 */
	public double currentCost(){
		// your code goes there

		// Variable used to store the sum of (h◊(xi)-yi)^2
		double cost = 0;

		// For loop used to calculate the sum of (h◊(xi)-yi)^2
		for (int i=0; i<nbreOfSamples; i++) {
			
			cost += Math.pow(hypothesis(samples[i])-samplesValues[i],2);
			
		}

		// Returning the current cost of the function	
		return (1/nbreOfSamples)*cost;
		
	}	

	/** 
     * runs several iterations of the gradient descent algorithm
     * 
     * @param alpha the learning rate
     *
     * @param numberOfSteps how many iteration of the algorithm to run
     */
	public void gradientDescent(double alpha, int numberOfSteps) {


		// your code goes there

		// NEED TO IMPLEMENT numberofSteps
		// Variables...
		double t0= 0;
		double t1=0;
		double temp=0;
		int completedSteps = 0;

		while(completedSteps<numberOfSteps){

			// Calculates the sum of (h◊(xi) - yi) for theta zero and ((h◊(xi) - yi)xi) for theta one
			for (int i=0; i<nbreOfSamples; i++) {

				temp = hypothesis(samples[i])-samplesValues[i];

				t0 += temp;

				t1 += temp*samples[i];

				temp = 0;

			}

			// Updating the value of THETA ZERO
			theta0 -= ((alpha*2)/nbreOfSamples)*t0;

			// Updating the value of THETA ONE
			theta1 -= ((alpha*2)/nbreOfSamples)*t1;

			// Increasing the number of comnpleted steps
			completedSteps++;
			iteration++;

		}

		







	}

	/** 
     * Getter for theta0
     *
	 * @return theta0
	 */

	public double getTheta0(){
		// your code goes there

		return theta0;
	}

	/** 
     * Getter for theta1
     *
	 * @return theta1
	 */

	public double getTheta1(){
		// your code goes there

		return theta1;
	}

	/** 
     * Getter for samples
     *
	 * @return samples
	 */

	public double[] getSamples(){
		// your code goes there

		return samples;
	}

	/** 
     * Getter for getSamplesValues
     *
	 * @return getSamplesValues
	 */

	public double[] getSamplesValues(){
		// your code goes there

		return samplesValues;
	}

	/** 
     * Getter for iteration
     *
	 * @return iteration
	 */

	public int getIteration(){
		// your code goes there

		return iteration;
	}
}