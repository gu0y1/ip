package istella;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Istella {
    private static ArrayList<Task> tasks = new ArrayList<>();

    private static void printLine() {
        System.out.println("____________________________________________________________");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 加载任务数据
        try {
            tasks = Storage.loadTasks();
        } catch (IOException e) {
            System.out.println(" Warning: Unable to load previous tasks.");
        }

        printLine();
        System.out.println(" Hello! I'm Istella");
        System.out.println(" What can I do for you?");
        printLine();

        while (true) {
            String input = scanner.nextLine();
            try {
                processCommand(input);
                Storage.saveTasks(tasks); // 任务列表更新后保存
            } catch (IstellaException e) {
                printLine();
                System.out.println(" OOPS!!! " + e.getMessage());
                printLine();
            } catch (IOException e) {
                System.out.println(" Warning: Unable to save tasks.");
            }
        }
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
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
            printLine();
        } else if (input.startsWith("todo ")) {
            String description = input.substring(5).trim();
            if (description.isEmpty()) {
                throw new IstellaException("The description of a todo cannot be empty.");
            }
            tasks.add(new Todo(description));
            printTaskAdded();
        } else if (input.startsWith("delete ")) {
            int index = Integer.parseInt(input.split(" ")[1]) - 1;
            if (index < 0 || index >= tasks.size()) {
                throw new IstellaException("Invalid task number.");
            }
            Task removedTask = tasks.remove(index);
            printLine();
            System.out.println(" Noted. I've removed this task:");
            System.out.println("   " + removedTask);
            System.out.println(" Now you have " + tasks.size() + " tasks in the list.");
            printLine();
        } else {
            throw new IstellaException("I'm sorry, but I don't know what that means :-(");
        }
    }

    private static void printTaskAdded() {
        printLine();
        System.out.println(" Got it. I've added this task:");
        System.out.println("   " + tasks.get(tasks.size() - 1));
        System.out.println(" Now you have " + tasks.size() + " tasks in the list.");
        printLine();
    }
}
