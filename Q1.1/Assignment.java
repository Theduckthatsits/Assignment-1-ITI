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
     * In this first method, we are simply using sample points that are
     * on a straight line, namely y = x;
     * In his method, 
     *    1) we create an instance of LinearRegression.
     *    2) we add 1,000 samples (from 0 to 999) from the line y=x
     *  3) We create an instance of Display
     *  4) we iterate gradient descent 5,000, updating the instance
     * of Display every 100 iteration, using a step alpha of 0.000000003
     */

     private static void setLine(){

          // your code goes there

          //Creating an instance of the class LinearRegression
          LinearRegression linearRegression = new LinearRegression(1000);

          // For loop used to add 1000 samples to the instance linearRegression
          for (int i=0; i<1000; i++) {

               linearRegression.addSample(i,i);
               
          }

          // Creating an instance of the class Display
          Display graph = new Display(linearRegression);

          //graph.setTarget(1,0); //Optional

          // Foor loop used to iterate the algorithm GradientDescent a total of 5000 times
          for (int x=0; x<50; x++) {

               // Updating the graph
               graph.update(); // For some reason the program works without updating
               
               // Calling method gradientDescent from instance linearRegression
               linearRegression.gradientDescent(0.000000003, 100);
               double cost = linearRegression.currentCost();
               // Printing out the current hypothesis and cost
               System.out.println("Current hypothesis: " + linearRegression.currentHypothesis());
               System.out.println("Current cost: " + cost );

          }
          
     }



     public static void main(String[] args) {

         StudentInfo.display();

          System.out.println("setLine");
          setLine();

     }

}