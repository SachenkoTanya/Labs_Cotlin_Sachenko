import java.util.Scanner

// Батьківський клас Користувач
open class User(private val username: String, private val password: String) {

    // Метод для аутентифікації
    fun authenticate(inputUsername: String, inputPassword: String): Boolean {
        return username == inputUsername && password == inputPassword
    }

    // Метод для авторизації
    open fun authorize(): String {
        return "User"
    }
}

// Підклас для звичайного користувача
class RegularUser(username: String, password: String) : User(username, password) {

    // Права доступу звичайного користувача
    override fun authorize(): String {
        return "Regular User"
    }
}

// Підклас для адміністратора
class Administrator(username: String, password: String) : User(username, password) {

    // Права доступу адміністратора
    override fun authorize(): String {
        return "Administrator"
    }
}

// Підклас для гостя
class Guest(username: String, password: String) : User(username, password) {

    // Права доступу гостя
    override fun authorize(): String {
        return "Guest"
    }
}

fun main() {
    val scanner = Scanner(System.`in`)

    // Запит на введення даних користувача
    print("Enter username: ")
    val inputUsername = scanner.nextLine()
    print("Enter password: ")
    val inputPassword = scanner.nextLine()

    // Створення екземплярів користувачів
    val regularUser = RegularUser("user123", "password123")
    val adminUser = Administrator("admin", "admin123")
    val guestUser = Guest("guest", "guest")

    // Перевірка аутентифікації та авторизації
    if (regularUser.authenticate(inputUsername, inputPassword)) {
        println("Authorization: ${regularUser.authorize()}")
    } else {
        println("Authentication failed for regular user.")
    }

    if (adminUser.authenticate(inputUsername, inputPassword)) {
        println("Authorization: ${adminUser.authorize()}")
    } else {
        println("Authentication failed for admin user.")
    }

    if (guestUser.authenticate(inputUsername, inputPassword)) {
        println("Authorization: ${guestUser.authorize()}")
    } else {
        println("Authentication failed for guest user.")
    }

    scanner.close()
}
