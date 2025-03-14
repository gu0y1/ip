package istella.commands;

import istella.Storage;
import istella.TaskList;
import istella.Ui;

/**
 * Command to list all tasks.
 */
public class ListCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showMessage("Here are the tasks in your list:");
        ui.showTaskList(tasks);
    }
}
