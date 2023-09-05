# todo-list-api
This project is a simple yet powerful RESTful API for managing todo lists and tasks. It's built using Spring Boot and MySQL and provides a robust backend solution for organizing your tasks. The project is designed with expandability in mind, making it a perfect starting point for learning and building upon.

---
# TodoList Data Model

**Attributes:**

- `id` (Primary Key): Unique identifier for the Todo List.
- `name` (String): The name or title of the Todo List.

| id | name            |
| -- | --------------- |
| 1  | Personal Tasks  |
| 2  | Work Tasks      |
| 3  | Groceries       |

---

# Task Data Model

**Attributes:**

- `id` (Primary Key): Unique identifier for the Task.
- `title` (String): A brief description of the task.
- `status` (Enum: INCOMPLETE, IN_PROGRESS, COMPLETE): Indicates the status of the task.
- `dueDate` (Date, Optional): An optional attribute to specify when the task is due.
- `todoListId` (Foreign Key referencing [TodoList.id](http://todolist.id/)): Establishes the one-to-many relationship between TodoList and Task. Each task is associated with a single Todo List.

| id | title                  | status       | dueDate    | todoListId |
| -- | ---------------------- | ------------ | ---------- | ---------- |
| 1  | Buy groceries          | INCOMPLETE   | 2023-09-15 | 3          |
| 2  | Finish project report  | IN PROGRESS  | 2023-09-20 | 2          |
| 3  | Call mom               | INCOMPLETE   | -          | 1          |
| 4  | Pay electricity bill   | COMPLETE     | 2023-09-10 | 1          |
| 5  | Schedule team meeting  | IN PROGRESS  | 2023-09-18 | 2          |

