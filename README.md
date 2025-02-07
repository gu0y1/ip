# 📌 Istella Project
**A Java-based CLI task management assistant**

---

## **Introduction**
**Istella** is a lightweight and interactive **command-line chatbot** that helps you manage your daily tasks efficiently. You can add different types of tasks, mark them as done, and list them in an organized manner. Istella is built using Java and follows an incremental development approach.

### **🚀 Features**
- **Task Management**
  - **ToDo**: Simple tasks without a date (e.g., `todo buy groceries`)
  - **Deadline**: Tasks with a due date (e.g., `deadline submit report /by Friday`)
  - **Event**: Tasks with a start and end time (e.g., `event team meeting /from 2pm /to 4pm`)
- **Task Completion**
  - Mark tasks as done (`mark 2`) or not done (`unmark 2`)
- **Task Listing**
  - View all added tasks (`list`)
- **User-friendly CLI**
  - Istella interacts with users through an easy-to-use command-line interface.

---

## **🛠 Setting Up in IntelliJ IDEA**
### **📌 Prerequisites**
- **JDK 17** (Ensure Java 17 is installed)
- **Latest version of IntelliJ IDEA**

### **🔧 Installation Steps**
1. **Open IntelliJ IDEA**
   - If a project is already open, go to `File` > `Close Project` to return to the welcome screen.

2. **Import the Project**
   - Click **Open**
   - Select the project directory (`ip` folder if cloned from GitHub)
   - Click **OK** and accept all default settings.

3. **Set up the correct JDK**
   - Go to **`File` > `Project Structure` > `Project`**
   - Set **Project SDK** to `JDK 17`
   - Set **Project language level** to `SDK default`
   - Click `Apply` and `OK`

4. **Run Istella**
   - Navigate to `src/main/java/Istella.java`
   - Right-click on `Istella.java`, select **Run 'Istella.main()'**
   - If everything is set up correctly, you should see the following output:

**Hello! I'm Istella
What can I do for you?**


---

## **📝 Usage Guide**
Here are some example commands to interact with Istella:

| **Command**                           | **Description**                                      | **Example** |
|----------------------------------|----------------------------------------------------|------------|
| `todo <task>`                     | Adds a **ToDo** task                               | `todo buy milk` |
| `deadline <task> /by <date>`      | Adds a **Deadline** task                           | `deadline project submission /by Sunday` |
| `event <task> /from <start> /to <end>` | Adds an **Event** task                      | `event concert /from 6pm /to 10pm` |
| `list`                            | Lists all added tasks                             | `list` |
| `mark <task number>`              | Marks a task as done                              | `mark 2` |
| `unmark <task number>`            | Marks a task as not done                          | `unmark 2` |
| `bye`                             | Exits Istella                                     | `bye` |

---


---

## **⚠ Important Notes**
- **Keep all Java files inside `src/main/java/`**  
  - Do not rename or move this directory, as tools like Gradle rely on it.
- **Use Java 17**  
  - Running the project with a different Java version may cause compatibility issues.

---

## **📚 Further Enhancements**
- Implement **persistent storage** (save tasks to a file)
- Add **natural language processing** for smarter interactions
- Implement **graphical user interface (GUI)** using JavaFX

---

## **📩 Contributing**
Feel free to contribute by:
- Forking the repository
- Creating feature branches
- Submitting pull requests

Happy coding! 🚀

