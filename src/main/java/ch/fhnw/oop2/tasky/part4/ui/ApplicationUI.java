package ch.fhnw.oop2.tasky.part4.ui;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Border;
import javafx.scene.paint.Color;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ComboBox;
import javafx.geometry.Insets;

import ch.fhnw.oop2.tasky.part4.ui.util.Area;
import ch.fhnw.oop2.tasky.part4.ui.util.Status;

import java.time.LocalDate;
import java.util.stream.Stream;

// set basic layout to stackpane
public class ApplicationUI extends BorderPane {

    // BorderPane
    private Label labelTop;
    private Label labelFooter;

    // Left-side components
    private Label labelTodo;
    private Label labelDoing;
    private Label labelDone;
    private Button buttonNew;
    private Button buttonRefresh;

    // Right-side components
    private Label labelID;
    private Label labelTitle;
    private Label labelDesc;
    private Label labelDate;
    private Label labelState;
    private Button buttonSave;
    private Button buttonDelete;

    private TextField txtID;
    private TextField txtTitle;
    private TextArea txtDesc;

    private DatePicker datePicker;
    private ComboBox<Status> comboBox;

    // layout elements
    // left
    private VBox vBoxLeft;
    private HBox hBoxTodo;
    private HBox hBoxDoing;
    private HBox hBoxDone;
    private HBox hBoxLeftButtons;
    private GridPane gridLeft;
    private GridPane gridTodo;
    private GridPane gridDoing;
    private GridPane gridDone;

    // right
    private VBox vBoxRight;
    private GridPane gridRight;

    // bring in stage
    public ApplicationUI() {
        initializeControls();
        layoutControls();
    }
    /*
    * init all control elements
    * */
    private void initializeControls() {
        // init all controls
        labelTop = new Label("Tasky GUI v1.0");
        labelFooter = new Label("© Marc Bugmann @ FHNW OOP2 2020");
        labelFooter.setStyle("-fx-border-width: 0.5 0 0 0; -fx-border-color: black;");
        labelFooter.setMaxWidth(Double.MAX_VALUE);
        labelFooter.setPadding(new Insets(0,0,0,0));

        // left
        labelTodo = new Label("Todo");
        labelDoing = new Label("Doing");
        labelDone = new Label("Done");
        buttonNew = new Button("New");
        buttonRefresh = new Button("Refresh");

         // right
        labelID = new Label("ID");
        labelTitle = new Label("Title");
        labelDesc = new Label("Desc");
        labelDate = new Label("Date");
        labelState = new Label("State");

        txtID = new TextField();
        txtTitle = new TextField();
        txtDesc = new TextArea();
        datePicker = new DatePicker();
        datePicker.setValue(LocalDate.now());
        datePicker.setShowWeekNumbers(true);
        comboBox = new ComboBox<Status>();
        comboBox.getItems().addAll(Status.getAllStati());

        buttonSave = new Button("Save");
        buttonDelete = new Button("Delete");

    }

    /*
     * layouting of controls
     * */
    private void layoutControls() {
        layoutLeft();
        layoutRight();

        // add controls to layout areas
        this.setTop(labelTop);
        this.setBottom(labelFooter);

        Stream.of(labelTop, labelFooter, labelID, labelTitle, labelDesc, labelDate, labelState )
                .forEach(label -> setMargin(label, new Insets(5)))
        ;

    }

    /*
     * Layout of right side
     * */
    private void layoutLeft() {
        // init all layout objects
        vBoxLeft = new VBox(); // whole box on the left
        gridLeft = new GridPane(); // grid with 3 columns: todo, doing, done
        hBoxLeftButtons = new HBox(); // hbox for the buttons
        hBoxTodo = new HBox(); // box for all tasks
        hBoxDoing = new HBox(); // box for all tasks
        hBoxDone = new HBox(); // box for all tasks
        gridTodo = new GridPane(); // grid for multiple task in state todo
        gridDoing = new GridPane(); // grid for multiple task in state doing
        gridDone = new GridPane(); // grid for multiple task in state done

        // format left side box and set box as left side oh main container
        vBoxLeft.setSpacing(10);
        vBoxLeft.setPadding(new Insets(10));
        this.setLeft(vBoxLeft);

        // format grid with 3 columns: todo, doing, done
        gridLeft.setPadding(new Insets(0, 20, 20, 0));
        gridLeft.setHgap(20);
        // headers
        gridLeft.add(labelTodo, 0, 0, 1, 1);
        gridLeft.add(labelDoing, 1, 0, 1, 1);
        gridLeft.add(labelDone, 2, 0, 1, 1);
        // boxes
        gridLeft.add(hBoxTodo, 0, 1, 1, 1);
        gridLeft.add(hBoxDoing, 1, 1, 1, 1);
        gridLeft.add(hBoxDone, 2, 1, 1, 1);
        // buttons
        hBoxLeftButtons.setSpacing(8);
        //hBoxLeftButtons.setPrefWidth(50);
        hBoxLeftButtons.setMaxHeight(Double.MAX_VALUE);
        hBoxLeftButtons.getChildren().addAll(buttonNew, buttonRefresh);

        // format the three columns
        Stream.of(hBoxTodo, hBoxDoing, hBoxDone).forEach(this::setBoxFormat);
        // format grid for multiple tasks
        Stream.of(gridTodo, gridDoing, gridDone).forEach(grid -> grid.setPadding(new Insets(10, 20, 50, 0)));
        Stream.of(gridTodo, gridDoing, gridDone).forEach(grid -> grid.setVgap(20));
        // add boxes grid to boxes
        hBoxTodo.getChildren().addAll(gridTodo);
        hBoxDoing.getChildren().addAll(gridDoing);
        hBoxDone.getChildren().addAll(gridDone);

        // create test-tasks inside the state boxes
        gridTodo.add(createTaskRegion("72DFF1"), 0,0,1,1);
        gridTodo.add(createTaskRegion("2B8A9A"), 0,1,1,1);

        gridDoing.add(createTaskRegion("72DFF1"), 0,0,1,1);
        gridDoing.add(createTaskRegion("2B8A9A"), 0,1,1,1);

        gridDone.add(createTaskRegion("72DFF1"), 0,0,1,1);
        gridDone.add(createTaskRegion("2B8A9A"), 0,1,1,1);

        // insert grid and buttons to left side
        vBoxLeft.getChildren().addAll(gridLeft, hBoxLeftButtons);
    }

    private void setBoxFormat(HBox hBox) {
        hBox.setSpacing(20);
        hBox.setPadding(new Insets(10, 0, 20, 20));
        hBox.setPrefWidth(130);
        hBox.setPrefHeight(300);
        hBox.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, null)));
    }

    /*
     * Layout of left side
     * */
    private void layoutRight() {
        // init all layout objects
        vBoxRight = new VBox();
        gridRight = new GridPane();
        this.setCenter(vBoxRight);

        // format grid
        gridRight.setHgap(7);
        gridRight.setVgap(20);
        // setup grid
        vBoxRight.getChildren().add(gridRight);
        gridRight.add(labelID, 0, 0, 1, 1);
        gridRight.add(txtID, 1, 0, 1, 1);
        gridRight.add(labelTitle, 0, 1, 1, 1);
        gridRight.add(txtTitle, 1, 1, 1, 1);
        gridRight.add(labelDesc, 0, 2, 1, 1);
        gridRight.add(txtDesc, 1, 2, 1, 1);
        gridRight.add(labelDate, 0, 3, 1, 1);
        gridRight.add(datePicker, 1, 3, 1, 1);
        gridRight.add(labelState, 0, 4, 1, 1);
        gridRight.add(comboBox, 1, 4, 1, 1);
        gridRight.add(buttonSave, 0, 5, 1, 1);
        gridRight.add(buttonDelete, 1, 5, 1, 1);
    }

    public static Region createTaskRegion(String color) {
        final Region region = new Region();
        region.setPadding(new Insets(20));
        region.setMinWidth(80);
        region.setMinHeight(80);
        region.setCenterShape(true);
        region.setStyle("-fx-background-color: #" +color + ";");
        return region;
    }

}
