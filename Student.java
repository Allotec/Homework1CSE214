/*
Matthew Champagne
ID- 112540003
Matthew.champagne@stonybrook.edu
Homework 1
CSE 214.R04
Recitation TA's- Balaji Jayasankar and Xincheng Chi
Grading TA's- Balaji Jayasankar and Saahil Kamat
*/

//Student class that holds their name and how much lunch money they have

public class Student{
    private String name; //Student name as string
    private double money; //Lunch money as double

    /**
     * Constructor for a Student object
     * @param name
     * @param money
     */
    public Student(String name, double money){
        this.name = new String(name);
        this.money = money;
    }

    /**
     * Getter for student name
     * @return Student name as a string
     */
    public String getName(){
        return(name);
    }

    /**
     * Getter for student lunch money
     * @return Student lunch money as a double
     */
    public double getMoney(){
        return(money);
    }

    /**
     * Setter for student name
     * @param name
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Setter for student lunch money
     * @param money
     */
    public void setMoney(double money){
        this.money = money;
    }

    /** 
     * Checks if two student objects are equal
     * @return boolean true if both objects are equal
    */
    public boolean equals(Object o){
        Student temp = (Student)o;

        return((temp.getMoney() == this.money) && (temp.getName().equals(this.name)));
    }

    /**
     * Makes a new student object with the same attributes as the orignal object
     * @return New student object
     */
    public Student clone(){
        return(new Student(name, money));
    }

    /**
     * @return a string with all the object attributes listed
     */
    public String toString(){
        return("Name- " + name + ", Money- $" + money);
    }

}