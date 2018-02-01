/**
 * The class  <b>LinearRegression</b> implements gradient
 * descent for multiple variables
 *
 * @author gvj (gvj@eecs.uottawa.ca)
 *
 */

public class LinearRegression{


	/** 
     * Number of features (usually "n" in litterature) 
     */
	private int nbreOfFeatures;

	/** 
     * Number of samples (usually "m" in litterature) 
     */
	private int nbreOfSamples;


	/** 
     * the nbreOfFeatures X nbreOfSamples Matrix of samples
     */
	private double[][] samplesMatrix;

	/** 
     * the nbreOfSamples Matrix of samples target values
     */
	private double[] samplesValues;

	/** 
     * the nbreOfFeatures Matrix theta of current hypthesis function
     */
	private double[] theta;


	/** 
     * number of samples received so far
     */
	private int currentNbreOfSamples;

	/** 
     * a place holder for theta during descent calculation
     */
	private double[] tempTheta;


	/** 
     * counts how many iterations have been performed
     */
	private int iteration;


	/** 
     * Object's contructor. The constructor initializes the instance
     * variables. The starting hypthesis is theta[i]=0.0 for all i
     * 
     * @param n the number of features that we will have
     * @param m the number of samples that we will have
	 *
     */
 	public LinearRegression(int n, int m){

		// your code goes there

	}

	/** 
     * Add a new sample to samplesMatrix and samplesValues
     * 
     * @param x the vectors of samples
     * @param y the coresponding expected value
     *
	 */
	public void addSample(double[] x, double y){

		// your code goes there

	}

	/** 
     * Returns the current hypothesis for the value of the input
     * @param x the input vector for which we want the current hypothesis
     * 
	 * @return h(x)
	 */

	private double hypothesis(double[] x){

		// your code goes there

	}

	/** 
     * Returns a string representation of hypthesis function
     * 
	 * @return the string "theta0 x_0 + theta1 x_1 + .. thetan x_n"
	 */

	public String currentHypothesis(){

		// your code goes there

	}

	/** 
     * Returns the current cost
     * 
	 * @return the current value of the cost function
	 */

	public double currentCost(){

		// your code goes there

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

	}


	/** 
     * Getter for theta
     *
	 * @return theta
	 */

	public double[] getTheta(){

		// your code goes there

	}

	/** 
     * Getter for iteration
     *
	 * @return iteration
	 */

	public int getIteration(){

		// your code goes there

	}
}