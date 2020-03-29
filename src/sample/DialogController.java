package sample;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.datamodel.TodoData;
import sample.datamodel.TodoItem;

import java.time.LocalDate;

public class DialogController {

    @FXML
    private TextField descriptionField;
    @FXML
    private TextArea detailsArea;
    @FXML
    private DatePicker deadlinePicker;

    public TodoItem processResults() {
        String description = descriptionField.getText().trim();
        String details = detailsArea.getText().trim();
        LocalDate deadline = deadlinePicker.getValue();

        TodoItem newItem = new TodoItem(description, details, deadline);
        TodoData.getInstance().addTodoItem(newItem);
        return newItem;
    }
}
