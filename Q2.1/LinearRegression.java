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

		// Initializing the variables nbreOfFeatures and nbreOfSamples to variables n+1 and m respectively
		nbreOfFeatures=n+1;
		nbreOfSamples=m;
		
		// Initializing the variables iteration, currentNbreOfSamples
		iteration=0;
		currentNbreOfSamples=0;

		// Initializing array theta and tempTheta to to a double array of size n(nbreOfFeatures)
		theta = new double[nbreOfFeatures];
		tempTheta = new double[nbreOfFeatures];

		// Initializing arrays samplesMatrix and samplesValues to arrays of size [nbreOfSamples][nbreOfFeatures] and [nbreOfSamples] respectively
		samplesMatrix=new double[nbreOfSamples][nbreOfFeatures];
		samplesValues=new double[nbreOfSamples];

		// For loop used to initiate the value of theta's to zero in arrays theta and tempTheta
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
		

		// Adding the new sample point to samplesMatrix and samplesValues
		samplesMatrix[currentNbreOfSamples]=x;
		samplesValues[currentNbreOfSamples]=y;

		// Increasing the number of currentNbreOfSamples by 1
		currentNbreOfSamples++;

	}

	/** 
     * Returns the current hypothesis for the value of the input
     * @param x the input vector for which we want the current hypothesis
     * 
	 * @return h(x)
	 */

	private double hypothesis(double[] x){

		// your code goes there

		// Double temp used to calculate the value of the current hypothesis
		double temp=0;

		// For loop used to calculate the hypothesis
		for (int i=0; i<nbreOfFeatures; i++) {

			temp+=theta[i]*x[i];
			
		}

		// Returning the value of the current hypothesis
		return temp;

	}

	/** 
     * Returns a string representation of hypthesis function
     * 
	 * @return the string "theta0 x_0 + theta1 x_1 + .. thetan x_n"
	 */

	public String currentHypothesis(){

		// your code goes there

		// CHAGNE LATER
		return theta[0] + "x_0 + " + theta[1] + "x_1 + " + theta[2] + "x_2";

	}

	/** 
     * Returns the current cost
     * 
	 * @return the current value of the cost function
	 */

	public double currentCost(){

		// your code goes there

		// Double cost used to store the value of the calculated cost
		double cost=0;

		// For loop used to calculate the current cost
		for (int i=0; i<nbreOfSamples; i++) {

			cost += Math.pow(hypothesis(samplesMatrix[i])-samplesValues[i],2);
			
		}

		// Returning the cost
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

		// For loops used to calculate gradient Descent
		for (int s=0; s<numberOfSteps; s++) {
			double [] sum = new double[nbreOfFeatures];

			for (int j=0; j<nbreOfFeatures; j++) {

				for (int i=0; i<nbreOfSamples; i++) {

					sum[j]+= (hypothesis(samplesMatrix[i])-samplesValues[i])*samplesMatrix[i][j];
					
				}

				// Storing the new calculated values of theta in array tempTheta
				tempTheta[j]-=((alpha*2.0)/nbreOfSamples)*sum[j];
			}

			// For loop used to assig the new values of theta stored in array tempTheta to the array theta
			for (int th=0; th<theta.length; th++) {

				theta[th] = tempTheta[th];
				
			}

			// Increasing the number of iteration by one
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