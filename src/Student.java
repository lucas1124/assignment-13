public class Student {
// student propeties
private final String name;
private final double id;
private final double quiz;
private final double a1;
private final double a2;
private final double exam;
private final double result;
private final String grade;

//parameterized constructor of the student
public Student(String name, double id, double quiz, double a1, double   

a2, double exam, double result, String grade) {    
    this.name = name;
    this.id = id;
    this.quiz = quiz;
    this.a1 = a1;
    this.a2 = a2;
    this.exam = exam;
    this.result = result;
    this.grade = grade;
}

/*
* getter and setter metod for all the properties
* of students
*/ 

 public String getName() {
    return name;
}
public void setName(String studentName) {
    studentName = this.name;
}

public double getId() {
    return id;
}
public void setId(double studentId) {
    studentId = this.id;
}

public double getQuiz() {
    return quiz;
}
public void setQuiz(double quizMarks) {
    quizMarks = this.quiz;
}

public double getA1() {
    return a1;
}

public void setA1(double assignmentOneMarks) {
    assignmentOneMarks = this.a1;
}

public double getA2() {
    return a2;
}
public void setA2(double assignmentTwoMarks) {
    assignmentTwoMarks = this.a2;
}

public double getExam() {
    return exam;
}
public void setExam(double exam) {
    exam = this.exam;
}

public double getResult(){
    return result;
}

public void setResult(double result){
    result = this.result;
}

public String getGrade(){
    return grade;
}

public void setGrade(String grade){
    grade = this.grade;
  }

}