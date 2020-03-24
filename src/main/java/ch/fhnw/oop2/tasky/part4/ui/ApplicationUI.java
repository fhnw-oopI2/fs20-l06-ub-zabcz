package ch.fhnw.oop2.tasky.part4.ui;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
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
    private HBox hBoxLeftButtons;

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
        labelFooter = new Label("footer");

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
        // LEFT SIDE
        vBoxLeft = new VBox();
        vBoxLeft.setSpacing(10);
        vBoxLeft.setPadding(new Insets(10));
        this.setLeft(vBoxLeft);

        // inside vbox: grid
        GridPane gridLeft = new GridPane();
        gridLeft.add(labelTodo, 0, 0, 1, 1);
        gridLeft.add(labelDoing, 1, 0, 1, 1);
        gridLeft.add(labelDone, 2, 0, 1, 1);

        gridLeft.add(Area.createRegion("396B7F"), 0, 1, 1, 1);
        gridLeft.add(Area.createRegion("72DFF1"), 1, 1, 1, 1);
        gridLeft.add(Area.createRegion("2B8A9A"), 2, 1, 1, 1);

        hBoxLeftButtons = new HBox();

        hBoxLeftButtons.setSpacing(25);
        hBoxLeftButtons.setPrefWidth(50);
        hBoxLeftButtons.setMaxHeight(Double.MAX_VALUE);
        hBoxLeftButtons.getChildren().addAll(buttonNew, buttonRefresh);

        // finally, set add  gridpane and hboxLeft to left
        vBoxLeft.getChildren().addAll(gridLeft, hBoxLeftButtons);
    }

    /*
     * Layout of left side
     * */
    private void layoutRight() {
        // rechter bereich
        vBoxRight = new VBox();
        vBoxRight.setMinWidth(Tasky_GUI.width*2/5);
        vBoxRight.setMinHeight(Tasky_GUI.height*2/3);
        this.setCenter(vBoxRight);

        // RIGHT SIDE
        gridRight = new GridPane();
        gridRight.setHgap(7);
        gridRight.setVgap(20);
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

}
