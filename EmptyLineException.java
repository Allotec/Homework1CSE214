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
 * Exception thrown for LunchLine objects that are empty and a method is trying to remove a student
 */
public class EmptyLineException extends Exception{
    /**
     * EmptyLineException constructor
     * @param message
     */
    public EmptyLineException(String message){
        super(message);
    }
}
