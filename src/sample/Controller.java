package sample;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import sample.datamodel.TodoItem;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    @FXML
    private ListView<TodoItem> todoListView;
    private List<TodoItem> todoItems;

    @FXML
    private TextArea itemDetailsTextArea;

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

        todoListView.getItems().setAll(todoItems);
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    @FXML
    public void handleClickListView(){
        TodoItem item = todoListView.getSelectionModel().getSelectedItem();
        StringBuilder sb = new StringBuilder(item.getDetails());
        sb.append("\n\n\n\n");
        sb.append("Due: ");
        sb.append(item.getDeadline().toString());
        itemDetailsTextArea.setText(sb.toString());
    }
}
