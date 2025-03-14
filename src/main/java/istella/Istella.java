package istella;

import istella.commands.Command;
import istella.commands.*;

/**
 * The main class for Istella chatbot.
 */
public class Istella {
    private final Ui ui;
    private final Storage storage;
    private TaskList tasks;

    public Istella(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);

        try {
            tasks = new TaskList(storage.loadTasks());
        } catch (Exception e) {
            ui.showMessage("Error loading tasks.");
            tasks = new TaskList();
        }
    }

    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                Command command = Parser.parse(fullCommand);
                command.execute(tasks, ui, storage);
                isExit = command.isExit();
            } catch (IstellaException e) {
                ui.showMessage("OOPS!!! " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new Istella("data/istella.txt").run();
    }
}
