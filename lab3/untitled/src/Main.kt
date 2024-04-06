import java.time.LocalDate

class Task(val name: String, val deadline: LocalDate?)

fun isTaskCompletedOnTime(task: Task): Boolean {
    return task.deadline != null && !task.deadline.isBefore(LocalDate.now())
}

fun main() {
    val task1 = Task("Task 1", LocalDate.of(2024, 4, 10))
    val task2 = Task("Task 2", LocalDate.of(2024, 3, 21))

    println("${task1.name} completed on time: ${isTaskCompletedOnTime(task1)}")
    println("${task2.name} completed on time: ${isTaskCompletedOnTime(task2)}")
}
