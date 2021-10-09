/*
Matthew Champagne
ID- 112540003
Matthew.champagne@stonybrook.edu
Homework 1
CSE 214.R04
Recitation TA's- Balaji Jayasankar and Xincheng Chi
Grading TA's- Balaji Jayasankar and Saahil Kamat
*/

import java.util.Scanner;

/**
 * Main class to simulate lunch line 
 */

public class LunchLineSimulator {
    //Lunch Line Objects for each realitiy
    private static StudentLine realityA = new StudentLine();
    private static StudentLine realityB = new StudentLine();

    public static void main(String args[]) throws IllegalArgumentException, DeanException, ArrayIndexOutOfBoundsException, EmptyLineException, NegativeMoneyException{
        //Temporary Variables for inputs
        char c = ' ';
        char currentReality = 'A';
        String name = " ";
        Double money = 0.0;
        int index = 0;
        Student temp = null;

        //Prints out menu once
        System.out.println("Menu:");
        System.out.println("\tA) Add a student to the line at the end");
        System.out.println("\tC) Have a new student cut a friend");
        System.out.println("\tT) Have two students trade places");
        System.out.println("\tB) Have the bully remove a student");
        System.out.println("\tU) Update a student's money amount");
        System.out.println("\tS) Serve a student");
        System.out.println("\tP) Print the current reality's lunch line");
        System.out.println("\tO) Switch to the other reality");
        System.out.println("\tE) Check if the realities are equal");
        System.out.println("\tD) Duplicate this reality into the other reality");
        System.out.println("\tQ) Quit middle school and move on to real life.");

        while(true){
            //Opens Scanner and asks for option to be chosen from menu
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Please select an option- ");
            c = keyboard.nextLine().charAt(0);

            switch(c){
                case 'A':
                case 'a':
                    //Adds student to lunch line at the end
                    try{
                        System.out.println("Please enter student name- ");
                        name = keyboard.nextLine();
                        
                        System.out.println("Please enter money amount-");
                        money = keyboard.nextDouble();

                        if(currentReality == 'A'){
                            realityA.addStudent(realityA.numStudents(), new Student(name, money));
                            System.out.println(name + " has been added to the line at position " + realityA.numStudents()+ ". " + name + " has $" + money + ".");
                        }
                        else if(currentReality == 'B'){
                            realityB.addStudent(realityB.numStudents(), new Student(name, money));
                            System.out.println(name + " has been added to the line at position " + realityB.numStudents() + ". " + name + " has $" + money + ".");
                        }
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 'C':
                case 'c':
                    //Adds student to lunch line at given index and pushes back the people behind the index
                    try{
                        System.out.println("Please enter student name- ");
                        name = keyboard.nextLine();
                        
                        System.out.println("Please enter money amount-");
                        money = keyboard.nextDouble();

                        System.out.println("Please enter the index of the friend you want to cut-");
                        index = keyboard.nextInt();

                        if(currentReality == 'A'){
                            realityA.addStudent(index - 1, new Student(name, money));
                            System.out.println(name + " has cut " + realityA.getStudent(index - 1).getName() 
                              + " and is now in position " + index + ". " + name + " has $" + money + ".");
                        }
                        else if(currentReality == 'B'){
                            realityB.addStudent(index - 1, new Student(name, money));
                            System.out.println(name + " has cut " + realityB.getStudent(index - 1).getName() 
                              + " and is now in position " + index + ". " + name + " has $" + money + ".");
                        }
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 'B':
                case 'b':
                    //Removes student from the lunch line and everyone behind the index is moved up one
                    try{
                        System.out.println("Please enter the index of the person to get bullied-");
                        index = keyboard.nextInt();

                        if(currentReality == 'A'){
                            temp = realityA.removeStudent(index - 1);
                            System.out.println("The bully has stolen " + temp.getName() + "'s lunch money, and " 
                              + temp.getName() + " has left, feeling hangry.");

                        }
                        else if(currentReality == 'B'){
                            temp = realityB.removeStudent(index - 1);
                            System.out.println("The bully has stolen " + temp.getName() + "'s lunch money, and " 
                              + temp.getName() + " has left, feeling hangry.");
                        }
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 'U':
                case 'u':
                    //Updates a student's lunch money at the given index
                    try{
                        System.out.println("Please enter student index- ");
                        index = keyboard.nextInt();

                        System.out.println("Please enter new money amount- ");
                        money = keyboard.nextDouble();

                        if(currentReality == 'A'){
                            realityA.updateStudent(index - 1, realityA.getStudent(index - 1).getName(), money);
                            System.out.println("As a result of a shady transaction with the floor, " 
                              + realityA.getStudent(index - 1).getName() + " now has $" + money + ".");
                        }
                        else if(currentReality == 'B'){
                            realityB.updateStudent(index - 1, realityB.getStudent(index - 1).getName(), money);
                            System.out.println("As a result of a shady transaction with the floor, " 
                              + realityB.getStudent(index - 1).getName() + " now has $" + money + ".");
                        }
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 'P':
                case 'p':
                    //Prints out lunch line
                    if(currentReality == 'A'){
                        System.out.println("Lunch line in Reality A- " + "\n" + realityA.toString());
                    }
                    else if(currentReality == 'B'){
                        System.out.println("Lunch line in Reality B- " + "\n" + realityB.toString());
                    }
                    break;

                case 'S':
                case 's':
                    //Removes student at index 0 of the current reality
                    try{
                        if(currentReality == 'A'){
                            temp = realityA.removeStudent(0);
                            System.out.print(temp.getName() + " has been served today's special: Bouncy \"Chicken?\""); 
                            System.out.println("Nuggets. We hope he lives to see another day!");
                        }
                        else if(currentReality == 'B'){
                            temp = realityB.removeStudent(0);
                            System.out.print(temp.getName() + " has been served today's special: Bouncy \"Chicken?\""); 
                            System.out.println("Nuggets. We hope he lives to see another day!");
                        }
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                
                case 'O':
                case 'o':
                    //Switches current reality to other object
                    if(currentReality == 'A'){
                        currentReality = 'B';
                    }
                    else if(currentReality == 'B'){
                        currentReality = 'A';
                    }
                    System.out.println("Realities Switched Current Reality- " + currentReality);
                    break;
                
                case 'T':
                case 't':
                    //Switches two students in the current reality
                    try{
                        System.out.println("Please enter student1 index- ");
                        index = keyboard.nextInt();

                        System.out.println("Please enter student2 index- ");
                        int index2 = keyboard.nextInt();

                        if(currentReality == 'A'){
                            Student student1 = realityA.getStudent(index - 1);
                            Student student2 = realityA.getStudent(index2 - 1);

                            realityA.swapStudents(index - 1, index2 - 1);

                            System.out.println(student1.getName() + " has traded places with " + student2.getName() + ".");
                        }
                        else if(currentReality == 'B'){
                            Student student1 = realityA.getStudent(index - 1);
                            Student student2 = realityA.getStudent(index2 - 1);

                            realityB.swapStudents(index - 1, index2 - 1);

                            System.out.println(student1.getName() + " has traded places with " + student2.getName()  + ".");
                        }
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 'E':
                case 'e':
                    //Checks if the two realities are equal
                    if(realityA.equals(realityB)){
                        System.out.println("The realities are equal.");
                    }
                    else{
                        System.out.println("The realities are not equal.");
                    }
                    break;

                case 'D':
                case 'd':
                    //Copies the current reality into the other reality
                    if(currentReality == 'A'){
                        realityB = realityA.clone();
                        System.out.println("Reality A has been copied into reality B.");
                    }
                    else if(currentReality == 'B'){
                        realityA = realityB.clone();
                        System.out.println("Reality B has been copied into reality A.");
                    }
                    break;

                case 'Q':
                case 'q':
                    //Quits the program
                    keyboard.close();
                    System.out.print("You are now leaving the Middle School Lunch Line Simulator. ");
                    System.out.println("We congratulate you on your decision to do something more productive with your time.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Not a Valid Menu Option");
                }
        }
    }
}
