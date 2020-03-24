package ch.fhnw.oop2.tasky.part4.ui;

import ch.fhnw.oop2.tasky.part4.ui.util.Area;
import ch.fhnw.oop2.tasky.part4.ui.util.Status;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ComboBox;
import java.time.LocalDate;


import java.util.stream.Stream;

// set basic layout to stackpane
public class ApplicationUI extends BorderPane {

    private Label labelTop;
    private Label labelFooter;

    // Links
    private Label labelTodo;
    private Label labelDoing;
    private Label labelDone;
    private Button buttonNew;
    private Button buttonRefresh;

    // Rechts
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
    // rechts ende

    private Stage stage;

    // bring in stage
    public ApplicationUI(Stage stage) {
        this.stage = stage;
        initializeControls();
        layoutControls();
    }

    /*
     * init all other layout components
     * */
    private void initContentBody() {
        // LEFT SIDE
        GridPane gridLeft = new GridPane();

        // inside gridpane init hbox
        HBox hbox = new HBox();
        hbox.setMinWidth(Tasky_GUI.width*2/5);
        hbox.setMinHeight(Tasky_GUI.height*2/3);

        // inside hbox build three collumns

        // linker bereich mit drei spalten für die tasks
        this.setLeft(hbox);


        hbox.getChildren().add(gridLeft);
        gridLeft.add(labelTodo, 0, 0, 1, 1);
        gridLeft.add(labelDoing, 1, 0, 1, 1);
        gridLeft.add(labelDone, 2, 0, 1, 1);

        gridLeft.add(Area.createRegion("2ecc71"), 0, 1, 1, 1);
        gridLeft.add(Area.createRegion("3498db"), 1, 1, 1, 1);
        gridLeft.add(Area.createRegion("e74c3c"), 2, 1, 1, 1);
        gridLeft.add(buttonNew, 0, 2, 1, 1);
        gridLeft.add(buttonRefresh, 1, 2, 1, 1);

        // rechter bereich
        VBox vbox = new VBox();
        vbox.setMinWidth(Tasky_GUI.width*2/5);
        vbox.setMinHeight(Tasky_GUI.height*2/3);
        this.setCenter(vbox);

        // RIGHT SIDE
        GridPane gridRight = new GridPane();
        gridRight.setHgap(7);
        gridRight.setVgap(20);
        vbox.getChildren().add(gridRight);
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

    /*
    * init all control elements
    * */
    private void initializeControls() {
        // init all controls
        labelTop = new Label("Tasky GUI v1.0");
        labelFooter = new Label("footer");

        //links
        labelTodo = new Label("Todo");
        labelDoing = new Label("Doing");
        labelDone = new Label("Done");
        buttonNew = new Button("New");
        buttonRefresh = new Button("Refresh");

         // rechts
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

        // init all controls
        buttonSave = new Button("Save");
        buttonDelete = new Button("Delete");

    }

    /*
     * layouting of controls
     * */
    private void layoutControls() {

        // add controls to layout areas
        this.setTop(labelTop);
        this.setBottom(labelFooter);

        Stream.of(labelTop, labelFooter, labelID, labelTitle, labelDesc, labelDate, labelState )
                .forEach(label -> setMargin(label, new Insets(5)))
        ;
        // build whole gui pane
        initContentBody();

    }

}
