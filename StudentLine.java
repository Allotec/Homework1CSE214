/*
Matthew Champagne
ID- 112540003
Matthew.champagne@stonybrook.edu
Homework 1
CSE 214.R04
Recitation TA's- Balaji Jayasankar and Xincheng Chi
Grading TA's- Balaji Jayasankar and Saahil Kamat
*/

//Lunchline class that holds an array of student objects and manipulates them

public class StudentLine{
    public final int CAPACITY = 20; //Max capacity of lunch line
    private Student[] students; //Array of student objects modeling lunch line
    private int studentCount; //Holds the amount of students in lunch line

    /**
     * Student lunch line default constructor 
     */
    public StudentLine(){
        students = new Student[CAPACITY];
        studentCount = 0;
    }

    /**
     * Student Line constructor with parameters
     * @param students
     * @param studentCount
     */
    public StudentLine(Student[] students, int studentCount){
        this.students = new Student[CAPACITY];
        this.studentCount = studentCount;
        for(int i = 0; i < studentCount; i++){
            this.students[i] = new Student(students[i].getName(), students[i].getMoney());
        }
    }

    /**
     * Getter for number of students
     * @return number of students as a double
     */
    public int numStudents(){
        return(studentCount);
    }

    /**
     * Returns a student object at a given index
     * @param index
     * @return student object
     */
    public Student getStudent(int index){
        try{
            return(students[index]);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("No Student Exists at that Index");
            return(null);
        }
    }

    /**
     * Updates a student in the array with all the parameters passed in
     * @param index 
     * @param name
     * @param money
     * @throws NegativeMoneyException A student cant have negative money 
     */
    public void updateStudent(int index, String name, double money) throws NegativeMoneyException{
        if(money > 0){
            this.students[index].setName(name);
            this.students[index].setMoney(money);
        }
        else{
            throw new NegativeMoneyException("A student can't have debt the lunch line was not updated");
        }
    }

    /**
     * Removes a student from the array and moves all students to fill in the gaps
     * @param index
     * @return
     * @throws ArrayIndexOutOfBoundsException Thrown if index is out of bounds of the array
     * @throws EmptyLineException Thrown if the number of students in the line is zero
     */
    public Student removeStudent(int index) throws ArrayIndexOutOfBoundsException, EmptyLineException{
        if(studentCount == 0){
            throw new EmptyLineException("There are no students in the line");
        }
        else if(index < 0 || index >= studentCount){
            throw new ArrayIndexOutOfBoundsException("No Students Exist at that index");
        }
        else{
            Student temp = students[index];

            for(int i = index; i < CAPACITY - 1; i++){
                students[i] = students[i + 1];
            }

            studentCount--;
            return(temp);
        }
    }

    /**
     * Adds a student to the array at the given index and moves all students above the index up a spot
     * @param index
     * @param student
     * @throws IllegalArgumentException Thrown if to the left of the index is no student
     * @throws DeanException Thrown if the line is at capacity
     * @throws NegativeMoneyException Thrown if the student money is negative
     */
    public void addStudent(int index, Student student) throws IllegalArgumentException, DeanException, NegativeMoneyException{
        if(student.getMoney() < 0){
            throw new NegativeMoneyException("A student can't have debt the lunch line was not updated");
        }
        if(studentCount == CAPACITY){
            throw new DeanException("The Student Line is at Capacity");
        }
        else if(index - 1 > 0){
            if(students[index - 1] == null){
                throw new IllegalArgumentException("Placing Student at Index would put holes in line");
            }
        }
        if(students[index] != null){
            for(int i = CAPACITY - 1; i > index ; i--){
                students[i] = students[i - 1];
            }
            students[index] = student;
            studentCount++;
        }
        else{
            students[index] = student;
            studentCount++;
        }
    }

    /**
     * Swaps two students in the students array 
     * @param index1
     * @param index2
     * @throws IndexOutOfBoundsException Thrown if either index is out of bounds of the array
     */
    public void swapStudents(int index1, int index2) throws IndexOutOfBoundsException{
        if(index1 < 0 || index1 >= studentCount || index2 < 0 || index2 >= studentCount){
            throw new IndexOutOfBoundsException("One of the two indeces were invalid");
        }
        else{
            Student temp = new Student(students[index1].getName(), students[index1].getMoney());
            students[index1] = students[index2];
            students[index2] = temp;
        }
    }

    /**
     * Makes a new student line with the same attributes
     * @return StudentLine object
     */
    public StudentLine clone(){
        return(new StudentLine(students, studentCount));
    }

    /**
     * Checks if both objects have the same attributes and returns boolean
     * @return boolean true if the two objects are equal
     */
    public boolean equals(Object o){
        StudentLine g = (StudentLine)o;
        boolean flag = true;

        for(int i = 0; i < CAPACITY; i++){
            if(this.students[i] != null && g.getStudent(i) != null){
                if(!(this.students[i].equals(g.getStudent(i)))){
                    flag = false;
                }        
            }
        }

        return(flag && (this.studentCount == g.studentCount));
    }

    /**
     * @return A string with all attributes of the StudentLine object attributes listed
     */
    public String toString(){
        String temp = "";

        for(int i = 0; i < CAPACITY; i++){
            if(students[i] != null){
                temp += (i + 1) + "- " + students[i].getName() + "\t$" + students[i].getMoney() + "\n";
            }
            else{
                //temp += (i + 1) + "- " + "Empty Spot" + "\n";
            }
        }

        return(temp);
    }   
}