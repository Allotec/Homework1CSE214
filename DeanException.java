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
 * Exception thrown if the student line is full and students are trying to be added 
 */
public class DeanException extends Exception{
    /**
     * DeanException constructor
     * @param message
     */
    public DeanException(String message){
        super(message);
    }
}
