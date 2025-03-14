package istella.commands;

import istella.Storage;
import istella.Task;
import istella.TaskList;
import istella.Ui;

/**
 * Command to unmark a task (mark as not done).
 */
public class UnmarkCommand extends Command {
    private final int index;

    public UnmarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task task = tasks.getTask(index);
        task.markAsNotDone();
        ui.showMessage("OK, I've marked this task as not done yet:\n  " + task);
        storage.saveToFile(tasks);
    }
}
