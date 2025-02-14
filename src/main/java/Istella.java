import java.util.Scanner;

public class Istella {
    private static final int MAX_TASKS = 100;
    private static Task[] tasks = new Task[MAX_TASKS];
    private static int taskCount = 0;

    private static void printLine() {
        System.out.println("____________________________________________________________");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printLine();
        System.out.println(" Hello! I'm Istella");
        System.out.println(" What can I do for you?");
        printLine();

        while (true) {
            String input = scanner.nextLine();
            try {
                processCommand(input);
            } catch (IstellaException e) {
                printLine();
                System.out.println(" OOPS!!! " + e.getMessage());
                printLine();
            }
        }

        scanner.close();
    }

    private static void processCommand(String input) throws IstellaException {
        if (input.equals("bye")) {
            printLine();
            System.out.println(" Bye. Hope to see you again soon!");
            printLine();
            System.exit(0);
        } else if (input.equals("list")) {
            printLine();
            System.out.println(" Here are the tasks in your list:");
            for (int i = 0; i < taskCount; i++) {
                System.out.println((i + 1) + ". " + tasks[i]);
            }
            printLine();
        } else if (input.startsWith("todo ")) {
            String description = input.substring(5).trim();
            if (description.isEmpty()) {
                throw new IstellaException("The description of a todo cannot be empty.");
            }
            tasks[taskCount] = new Todo(description);
            taskCount++;
            printTaskAdded();
        } else {
            throw new IstellaException("I'm sorry, but I don't know what that means :-(");
        }
    }

    private static void printTaskAdded() {
        printLine();
        System.out.println(" Got it. I've added this task:");
        System.out.println("   " + tasks[taskCount - 1]);
        System.out.println(" Now you have " + taskCount + " tasks in the list.");
        printLine();
    }
}
