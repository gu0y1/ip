package istella;

import java.io.*;
import java.util.ArrayList;

/**
 * Handles loading and saving tasks to file.
 */
public class Storage {
    private final String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public void saveToFile(TaskList tasks) {
        try {
            File file = new File(filePath);
            file.getParentFile().mkdirs();
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            for (Task task : tasks.getTasks()) {
                writer.write(task.toSaveFormat());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    public ArrayList<Task> loadTasks() throws IOException {
        File file = new File(filePath);
        ArrayList<Task> tasks = new ArrayList<>();

        if (!file.exists()) {
            return tasks;
        }

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(" \\| ");
            Task task;

            switch (parts[0]) {
                case "T":
                    task = new Todo(parts[2]);
                    break;
                case "D":
                    task = new Deadline(parts[2], parts[3]);
                    break;
                case "E":
                    task = new Event(parts[2], parts[3], parts[4]);
                    break;
                default:
                    continue;
            }
            if (parts[1].equals("1")) {
                task.markAsDone();
            }
            tasks.add(task);
        }
        reader.close();
        return tasks;
    }
}
