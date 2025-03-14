package istella;

import istella.commands.*;

/**
 * Parses user input and returns the corresponding command.
 */
public class Parser {
    public static Command parse(String userInput) throws IstellaException {
        String[] words = userInput.trim().split(" ", 2);
        String command = words[0];

        switch (command) {
            case "bye":
                return new ExitCommand();
            case "list":
                return new ListCommand();
            case "todo":
                if (words.length < 2 || words[1].trim().isEmpty()) {
                    throw new IstellaException("The description of a todo cannot be empty.");
                }
                return new AddCommand(new Todo(words[1]));
            case "deadline":
                if (!userInput.contains("/by")) {
                    throw new IstellaException("Deadline format: deadline <description> /by <time>");
                }
                String[] deadlineParts = words[1].split(" /by ", 2);
                return new AddCommand(new Deadline(deadlineParts[0], deadlineParts[1]));
            case "event":
                if (!userInput.contains("/from") || !userInput.contains("/to")) {
                    throw new IstellaException("Event format: event <description> /from <start> /to <end>");
                }
                String[] eventParts = words[1].split(" /from | /to ");
                return new AddCommand(new Event(eventParts[0], eventParts[1], eventParts[2]));
            case "mark":
                return new MarkCommand(Integer.parseInt(words[1]) - 1);
            case "unmark":
                return new UnmarkCommand(Integer.parseInt(words[1]) - 1);
            case "delete":
                return new DeleteCommand(Integer.parseInt(words[1]) - 1);
            case "find":
                return new FindCommand(words[1]);
            default:
                throw new IstellaException("I'm sorry, but I don't know what that means :-(");
        }
    }
}
