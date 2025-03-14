package istella.commands;

import istella.Storage;
import istella.TaskList;
import istella.Ui;

/**
 * Command to exit the chatbot.
 */
public class ExitCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showMessage("Bye. Hope to see you again soon!");
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
