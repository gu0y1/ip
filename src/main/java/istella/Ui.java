package istella;

import java.util.List;
import java.util.Scanner;

/**
 * Handles interactions with the user.
 */
public class Ui {
    private final Scanner scanner;

    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    public void showMessage(String message) {
        System.out.println("____________________________________________________________");
        System.out.println(" " + message);
        System.out.println("____________________________________________________________");
    }

    public void showWelcome() {
        showMessage("Hello! I'm Istella\nWhat can I do for you?");
    }

    public String readCommand() {
        return scanner.nextLine();
    }

    public void showTaskList(TaskList tasks) {
        showMessage("Here are the tasks in your list:");
        List<Task> taskList = tasks.getTasks();
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println((i + 1) + ". " + taskList.get(i));
        }
        System.out.println("____________________________________________________________");
    }
}
