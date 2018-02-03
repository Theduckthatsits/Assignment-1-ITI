/**
 * The class  <b>LinearRegression</b> implements gradient
 * descent for multiple variables
 *
 * @author gvj (gvj@eecs.uottawa.ca)
 *
 */
// http://www.holehouse.org/mlclass/04_Linear_Regression_with_multiple_variables.html	
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

		// Initializing the variables nbreOfFeatures and nbreOfSamples to variables n and m respectively
		this.nbreOfFeatures=n;
		this.nbreOfSamples=m;
		
		// Initializing the variables iteration, currentNbreOfSamples and tempTheta to zero
		iteration=0;
		currentNbreOfSamples=0;

		// Initializing array theta to to a double array of size n
		theta = new double[nbreOfFeatures];
		tempTheta = new double[nbreOfFeatures];
		theta[0]=1;
		tempTheta[0]=1;

		// Initializing arrays samplesMatrix and samplesValues to arrays of size n
		samplesMatrix=new double[nbreOfSamples][nbreOfFeatures];
		samplesValues=new double[nbreOfSamples];

		// For loop used to initiate the value of theta's to zero in array theta
		for (int i=1; i<theta.length; i++) {

			theta[i]=0;
			tempTheta[i]=0;
			
		}

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

		// Increasing the current number of samples by one
		currentNbreOfSamples++;

		// Adding new sample to samplesMatrix and samplesValues
		samplesMatrix[currentNbreOfSamples-1][0]=x[0];
		samplesMatrix[currentNbreOfSamples-1][1]=x[1];
		samplesValues[currentNbreOfSamples-1]=y;

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

		String temp = new String("");

		for (int i=0; i<theta.length; i++) {

			if (i==(theta.length-1)) {

				temp+= theta[i] + "x";
				
			}

			else () {

				temp+= theta[i] + "x + ";

			}
			
		}

		return temp;

	}

	/** 
     * Returns the current cost
     * 
	 * @return the current value of the cost function
	 */

	public double currentCost(){

		// your code goes there

		double cost=0;

		for (int i=0; i<nbreOfSamples; i++) {

			cost += Math.pow(hypothesis(samplesMatrix[i])-samplesValues[i],2);
			
		}

		return (1.0/nbreOfSamples)*cost;




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

		// Variable completedSteps used to keep track of how many steps have been performed
		int completedSteps = 0;

		// double temp used to store the sum
		double temp = 0;

		while(completedSteps<numberOfSteps){

			for (int i=0; i<nbreOfSamples; i++) {

				temp+= (hypothesis(samplesMatrix[i])-samplesValues[i])*xj;
				
			}

			for (int x=0; x<nbreOfFeatures; x++) {

				theta[x] -= ((alpha*2)/nbreOfSamples)*temp;
				
			}

			// Increasing the number of variables comnpletedSteps and iteration by one
			
			completedSteps++;
			iteration++;
		}
		
	}


	/** 
     * Getter for theta
     *
	 * @return theta
	 */

	public double[] getTheta(){

		// your code goes there

		return theta;

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