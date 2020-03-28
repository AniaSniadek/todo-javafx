package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import sample.datamodel.TodoData;
import sample.datamodel.TodoItem;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    @FXML
    private ListView<TodoItem> todoListView;
    private List<TodoItem> todoItems;

    @FXML
    private TextArea itemDetailsTextArea;
    @FXML
    private Label deadlineLabel;

    public void initialize(){
        TodoItem item1 = new TodoItem("Mail birthday card", "Buy something",
                LocalDate.of(2020, Month.APRIL, 01));
        TodoItem item2 = new TodoItem("Mail birthday card", "Buy something",
                LocalDate.of(2020, Month.APRIL, 15));
        TodoItem item3 = new TodoItem("Mail birthday card", "Buy something",
                LocalDate.of(2020, Month.MAY, 03));
        TodoItem item4 = new TodoItem("Mail birthday card", "Buy something",
                LocalDate.of(2020, Month.APRIL, 20));
        TodoItem item5 = new TodoItem("Mail birthday card", "Buy something",
                LocalDate.of(2020, Month.MAY, 13));

        todoItems = new ArrayList<TodoItem>();
        todoItems.add(item1);
        todoItems.add(item2);
        todoItems.add(item3);
        todoItems.add(item4);
        todoItems.add(item5);

        TodoData.getInstance().setTodoItems(todoItems);

        todoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TodoItem>() {
            @Override
            public void changed(ObservableValue<? extends TodoItem> observableValue, TodoItem oldValue, TodoItem newValue) {
                if(newValue != null){
                    TodoItem item = todoListView.getSelectionModel().getSelectedItem();
                    itemDetailsTextArea.setText(item.getDetails());
                    DateTimeFormatter df = DateTimeFormatter.ofPattern("MMMM d, yyyy");
                    deadlineLabel.setText(df.format(item.getDeadline()));
                }
            }
        });

        todoListView.getItems().setAll(todoItems);
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        todoListView.getSelectionModel().selectFirst();
    }

    @FXML
    public void handleClickListView(){
        TodoItem item = todoListView.getSelectionModel().getSelectedItem();
        itemDetailsTextArea.setText(item.getDetails());
        deadlineLabel.setText(item.getDeadline().toString());
    }
}
