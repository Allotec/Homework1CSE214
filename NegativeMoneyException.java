/*
Matthew Champagne
ID- 112540003
Matthew.champagne@stonybrook.edu
Homework 1
CSE 214.R04
Recitation TA's- Balaji Jayasankar and Xincheng Chi
Grading TA's- Balaji Jayasankar and Saahil Kamat
*/

/**
 * Exception thrown for students that are attempting to be made with negative lunch money
 */
public class NegativeMoneyException extends Exception{
    /**
     * NegativeMoneyException constructor 
     * @param message
     */
    public NegativeMoneyException(String message){
        super(message);
    }    
}
