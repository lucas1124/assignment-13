package task2;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Task2 extends Application {

//Create table view
private final TableView<Student> table = new TableView<>();
//Collection to display data in table
private final ObservableList<Student> data =  

FXCollections.observableArrayList();

@Override
public void start(Stage primaryStage) {
    // border pane layout
    BorderPane borderPane = new BorderPane();

    //creating label student name 
    Text studentNameLabel = new Text("Student Name");
    // student inout field
    TextField studentName = new TextField();

    //creating student id label 
    Text studentIdLabel = new Text("Student ID");
    //id input field
    TextField studentId = new TextField();

    //creating label quiz marks
    Text quizMarksLabel = new Text("Quiz Marks");
    //quiz mark input field
    TextField quizMarks = new TextField();

    //creating label assignment1 marks
    Text assignmentOneMarksLabel = new Text("1st Assignment Marks");
    //assignment one mark input field
    TextField assignmentOneMarks = new TextField();

    //creating label assignment2 marks
    Text assignmentTwoMarksLabel = new Text("2nd Assignment Marks");
    //assignment two mark input field
    TextField assignmentTwoMarks = new TextField();

    //creating label assignment2 marks
    Text examMarksLabel = new Text("Main Exam Marks");
    //input for exammarks label
    TextField examMarks = new TextField();

    //Gridpane layout
    GridPane gridPane = new GridPane();

    //gridPane.setMinSize(600, 400); 
    gridPane.setPadding(new Insets(20, 20, 20, 20));
    //set vertical and horizontal gap for gridpane
    gridPane.setVgap(07);
    gridPane.setHgap(70);

    //adding labels in the grid 
    gridPane.add(studentIdLabel, 0, 0);
    gridPane.add(studentNameLabel, 0, 1);
    gridPane.add(quizMarksLabel, 0, 2);
    gridPane.add(assignmentOneMarksLabel, 0, 3);
    gridPane.add(assignmentTwoMarksLabel, 0, 4);
    gridPane.add(examMarksLabel, 0, 5);

    //adding text fields in the grid
    gridPane.add(studentId, 1, 0);
    gridPane.add(studentName, 1, 1);
    gridPane.add(quizMarks, 1, 2);
    gridPane.add(assignmentOneMarks, 1, 3);
    gridPane.add(assignmentTwoMarks, 1, 4);
    gridPane.add(examMarks, 1, 5);

    table.setEditable(true);
    borderPane.setTop(gridPane);
    Scene scene = new Scene(borderPane);

    //assigning data in the cell of table
    TableColumn name = new TableColumn("Name");
    name.setCellValueFactory(new PropertyValueFactory<>("name"));

    TableColumn id = new TableColumn("Id");
    id.setCellValueFactory(new PropertyValueFactory<>("id"));

    TableColumn quiz = new TableColumn("Quiz");
    quiz.setCellValueFactory(new PropertyValueFactory<>("quiz"));

    TableColumn a1 = new TableColumn("A1");
    a1.setCellValueFactory(new PropertyValueFactory<>("a1"));

    TableColumn a2 = new TableColumn("A2");
    a2.setCellValueFactory(new PropertyValueFactory<>("a2"));

    TableColumn exam = new TableColumn("Exam");
    exam.setCellValueFactory(new PropertyValueFactory<>("exam"));

    TableColumn result = new TableColumn("Results");
    //calculating the result of the student..
    result.setCellValueFactory(new PropertyValueFactory<>("result"));

    TableColumn Grade = new TableColumn("Grade");

    Grade.setCellValueFactory(new PropertyValueFactory<Student, String> 

   ("grade"));

    table.setItems(data);
    //adding all the data in the cell of the table
    table.getColumns().addAll(name, id, quiz, a1, a2, exam, result,  

     Grade);

    //creating horizontal box for the display of lower fields
    HBox box = new HBox();
    box.setPadding(new Insets(10, 10, 10, 10));
    Label label = new Label("Average marks :");
    box.getChildren().add(label);
    TextField averageMarksLabel = new TextField();
    averageMarksLabel.setEditable(false);
    box.getChildren().add(averageMarksLabel);
    Button btnAverageMarks = new Button("Average Marks");

    box.getChildren().add(btnAverageMarks);
    Button btnAddNewStudent = new Button("Add new student");
    btnAddNewStudent.setDisable(false);
    box.getChildren().add(btnAddNewStudent);
    Button btnStudentMarks = new Button("Student Marks");
    box.getChildren().add(btnStudentMarks);

    borderPane.setCenter(table);
    borderPane.setBottom(box);

    // Setting title to the Stage   
    primaryStage.setTitle("Grade Processing - Programming in Java 2");

    btnStudentMarks.setOnAction((ActionEvent e) -> {
        double resultsMarks = (Double.parseDouble(quizMarks.getText()) 

             * (double) 0.05)
                + (Double.parseDouble(assignmentOneMarks.getText()) * 

      (double) 0.20)
                + (Double.parseDouble(assignmentTwoMarks.getText()) * 

        (double) 0.25)
                + (Double.parseDouble(examMarks.getText()) * (double) 

           0.5);

        //checking the conditon for the grade of the student.
        String grade = "";
        if (resultsMarks >= 85 && resultsMarks < 100) {
            grade = "HD";
        } else if (resultsMarks >= 75 && resultsMarks < 85) {
            grade = "DI";
        } else if (resultsMarks >= 65 && resultsMarks < 75) {
            grade = "CR";
        } else if (resultsMarks >= 50 && resultsMarks < 65) {
            grade = "PS";
        } else if (resultsMarks > 50) {
            grade = "Fail";
        }
        data.add(new Student(
                studentName.getText(),
                Integer.parseInt(studentId.getText()),
                Double.parseDouble(quizMarks.getText()),
                Double.parseDouble(assignmentOneMarks.getText()),
                Double.parseDouble(assignmentTwoMarks.getText()),
                Double.parseDouble(examMarks.getText()),
                resultsMarks,
                "HD"
        ));
        //clearing the text field
        studentName.clear();
        studentId.clear();
        quizMarks.clear();
        assignmentOneMarks.clear();
        assignmentTwoMarks.clear();
        examMarks.clear();
    });

    btnStudentMarks.setOnAction((event) -> {
        table.getItems().size();
        List<String> data = new ArrayList<>();
        double total_res = 0;
        for (Student item : table.getItems()) {
            total_res += item.getResult();
        }
        double avg_marks = total_res / table.getItems().size();

        averageMarksLabel.setText(Double.toString(avg_marks));

    });

    // Adding scene to the stage 
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    //Displaying the contents of the stage 
    primaryStage.show();
    //button event for the new studnet addition bitton

}
/**
 * @param args the command line arguments
 */

}
