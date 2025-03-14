package istella.commands;

import istella.Storage;
import istella.Task;
import istella.TaskList;
import istella.Ui;

/**
 * Command to add a task.
 */
public class AddCommand extends Command {
    private final Task task;

    public AddCommand(Task task) {
        this.task = task;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.addTask(task);
        ui.showMessage("Got it. I've added this task:\n  " + task);
        ui.showMessage("Now you have " + tasks.size() + " tasks in the list.");
        storage.saveToFile(tasks);
    }
}
