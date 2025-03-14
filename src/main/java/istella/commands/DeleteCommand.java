package istella.commands;

import istella.Storage;
import istella.Task;
import istella.TaskList;
import istella.Ui;

/**
 * Command to delete a task.
 */
public class DeleteCommand extends Command {
    private final int index;

    public DeleteCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task removedTask = tasks.getTask(index);
        tasks.removeTask(index);
        ui.showMessage("Noted. I've removed this task:\n  " + removedTask);
        ui.showMessage("Now you have " + tasks.size() + " tasks in the list.");
        storage.saveToFile(tasks);
    }
}
