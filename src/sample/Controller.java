package sample;

import sample.datamodel.TodoItem;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private List<TodoItem> todoItems;

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
    }
}
