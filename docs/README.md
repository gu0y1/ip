# Istella User Guide

## **Introduction**
Istella is a simple command-line chatbot designed to help users manage tasks efficiently.

## **Quick Start**
1. Ensure you have **Java 17** or above installed.
2. Download the latest `istella.jar` from [GitHub Releases](https://github.com/gu0y1/ip/releases).
3. Open a terminal, navigate to the jar file folder, and run:
   ```
   java -jar istella.jar
   ```
4. You should see:
   ```
   ___________________________________________
   Hello! I'm Istella
   What can I do for you?
   ___________________________________________
   ```
5. Start entering commands!

---

## **Features**
### **1️⃣ Adding a Task**
- **Todo**: `todo <task description>`
- **Deadline**: `deadline <task description> /by <date>`
- **Event**: `event <task description> /from <start> /to <end>`

💡 **Example**:
```
todo Read book
deadline Submit report /by 2025-03-10
event Team meeting /from 2025-03-15 14:00 /to 16:00
```

---

### **2️⃣ Listing All Tasks**
- **Command**: `list`
- **Example Output**:
  ```
  1. [T][ ] Read book
  2. [D][X] Submit report (by: 2025-03-10)
  3. [E][ ] Team meeting (from: 2025-03-15 14:00 to 16:00)
  ```

---

### **3️⃣ Marking and Unmarking Tasks**
- **Mark a task as done**: `mark <task number>`
- **Unmark a task (mark as not done)**: `unmark <task number>`

💡 **Example**:
```
mark 1
unmark 2
```

---

### **4️⃣ Deleting a Task**
- **Command**: `delete <task number>`

💡 **Example**:
```
delete 3
```

---

### **5️⃣ Finding a Task**
- **Command**: `find <keyword>`

💡 **Example**:
```
find book
```
- **Example Output**:
  ```
  1. [T][ ] Read book
  ```

---

### **6️⃣ Exiting the Program**
- **Command**: `bye`
- The chatbot will save your tasks automatically and exit.

💡 **Example**:
```
bye
```

---

## **Saving the Data**
- Istella automatically **saves tasks** after any command that modifies the task list.
- Tasks are saved in a file located at `data/istella.txt`.
- The file format is human-readable and editable.

---

## **Editing the Data File**
- The task data is stored in `data/istella.txt` in the following format:
  ```
  T | 1 | Read book
  D | 0 | Submit report | 2025-03-10
  E | 0 | Team meeting | 2025-03-15 14:00 | 16:00
  ```
- **Legend:**
  - `T` → Todo task
  - `D` → Deadline task
  - `E` → Event task
  - `1` → Task is done, `0` → Task is not done
  - Additional fields are for dates and descriptions

🔹 **Caution**: Editing this file manually may lead to unexpected behavior if formatting is incorrect.

---

## **FAQs**
### ❓ How do I delete all tasks at once?
Currently, you need to delete tasks one by one using the `delete` command.

### ❓ How do I change the save file location?
The save file is fixed at `data/istella.txt` and cannot be changed in this version.

### ❓ What happens if I delete `data/istella.txt`?
If the file is deleted, Istella will create a new one upon the next startup.

---


## **Command Summary**
| **Action**    | **Command Format**                 |
|--------------|----------------------------------|
| **Add Todo** | `todo <task description>`        |
| **Add Deadline** | `deadline <task> /by <date>` |
| **Add Event** | `event <task> /from <start> /to <end>` |
| **List Tasks** | `list` |
| **Mark Done** | `mark <task number>` |
| **Unmark Done** | `unmark <task number>` |
| **Delete Task** | `delete <task number>` |
| **Find Task** | `find <keyword>` |
| **Exit** | `bye` |

---

