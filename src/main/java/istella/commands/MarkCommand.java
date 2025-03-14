package istella.commands;

import istella.Storage;
import istella.Task;
import istella.TaskList;
import istella.Ui;

/**
 * Command to mark a task as done.
 */
public class MarkCommand extends Command {
    private final int index;

    public MarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task task = tasks.getTask(index);
        task.markAsDone();
        ui.showMessage("Nice! I've marked this task as done:\n  " + task);
        storage.saveToFile(tasks);
    }
}
