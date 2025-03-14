package istella.commands;

import istella.Storage;
import istella.Task;
import istella.TaskList;
import istella.Ui;

/**
 * Command to find tasks by keyword.
 */
public class FindCommand extends Command {
    private final String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        TaskList foundTasks = tasks.findTasks(keyword);
        ui.showMessage("Here are the matching tasks in your list:");
        ui.showTaskList(foundTasks);
    }
}
