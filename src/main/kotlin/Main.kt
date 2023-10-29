enum class DifficultyLevel { BASIC, INTERMEDIATE, HARD }

data class Student(var name: String, val id: Long)

data class EducationalContent(var name: String, var duration: Int)

data class Formation(var name: String, val content: List<EducationalContent>) {

    val subscribers = mutableListOf<Student>()

    fun enroll(vararg students: Student) {
        subscribers.addAll(students)
    }

    override fun toString(): String {
        val subscriberNames = subscribers.joinToString { it.name }
        val contentNames = content.joinToString { it.name }
        return "Formation: $name; \nClasses: $contentNames; \nCurrent Students: $subscriberNames"
    }

}
    fun main() {

        val content1 = EducationalContent("Programming 101", 120)
        val content2 = EducationalContent("Data Structure and Algorithms", 90)
        val content3 = EducationalContent("DataBase (SQL and NoSQL)", 90)

        val formation = Formation("Basic Programmer", listOf(content1, content2, content3))

        val student1 = Student("James Hetfield", 1)
        val student2 = Student("Kirk Hammett", 2)
        val student3 = Student("Lars Ulrich", 3)
        val student4 = Student("Robert Trujillo", 4)

        formation.enroll(student1, student2, student3, student4)

        print(formation)
    }

