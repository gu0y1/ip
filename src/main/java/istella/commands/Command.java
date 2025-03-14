package istella.commands;

import istella.Storage;
import istella.TaskList;
import istella.Ui;

/**
 * Represents a command that can be executed by Istella.
 */
public abstract class Command {
    public abstract void execute(TaskList tasks, Ui ui, Storage storage);

    public boolean isExit() {
        return false;
    }
}
