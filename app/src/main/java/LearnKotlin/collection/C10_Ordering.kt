package LearnKotlin.collection

import LearnKotlin.Student

fun main() {
    var classroomA = listOf<StudentsData>(
        StudentsData("Jitiya", "Shubham", 21),
        StudentsData("Trivedi", "Bhakti", 23),
        StudentsData("Sartanpara", "Shyam", 20),
        StudentsData("Vyas", "Divyesh", 20),
        StudentsData("Nagpurkar", "Manthan", 16)
    )

    var students = classroomA.map { it.lastName }
    println("1. ${students.sorted()}")
    println("2. ${students.sortedDescending()}")

    //sort in custom types
    classroomA.sorted().forEach { println(it) }


    //using comparator
    val classRoomB = listOf<Students>(
        Students("Jitiya", "Shubham", "CE", 21),
        Students("Trivedi", "Bhakti", "CE", 23),
        Students("Sartanpara", "Shyam", "EE", 20),
        Students("Vyas", "Divyesh", "BME", 20),
        Students("Nagpurkar", "Manthan", "EC", 16)
    )
    println()
    //duplicate removed
    classRoomB.toSortedSet(comparator = Students.Companion.AgeComparator()).forEach { println(it) }
        .also { println() }
    classRoomB.toSortedSet(comparator = Students.Companion.FirstNameComparator())
        .forEach { println(it) }.also { println() }

    //simplest way
    classRoomB.sortedBy { it.age }.forEach { println(it) }.also { println() }
    classRoomB.sortedWith(compareBy { it.age }).also { println() }

    classRoomB.reversed().forEach { println(it) }

    //shuffle list
    val luckyNumbers = listOf<Int>(1, 2, 3, 4, 5, 6, 7)
    println(luckyNumbers.shuffled())
}

//using comparable - less flexible
data class StudentsData(val firstName: String, val lastName: String, val age: Int) :
    Comparable<StudentsData> {

    //sort by age
    /*override fun compareTo(other: StudentsData): Int {
         return this.age.compareTo(other.age)
    }*/
    override fun compareTo(other: StudentsData): Int {
        return this.firstName.compareTo(other.firstName)
    }
}

//using comparator - more flexible, can implement for different cases
data class Students(
    val firstName: String,
    val lastName: String,
    val department: String,
    val age: Int
) {
    companion object {
        class FirstNameComparator : Comparator<Students> {
            override fun compare(p0: Students?, p1: Students?): Int {
                if (p0 != null && p1 != null) {
                    return p0.firstName.compareTo(p1.firstName)
                }
                return -1 //any alternative way?
            }
        }

        class LastNameComparator : Comparator<Students> {
            override fun compare(p0: Students?, p1: Students?): Int {

                if (p0 != null && p1 != null) {
                    return p0.firstName.compareTo(p1.firstName)
                }
                return -1
            }
        }

        class AgeComparator : Comparator<Students> {
            override fun compare(p0: Students?, p1: Students?): Int {

                if (p0 != null && p1 != null) {
                    return p0.age.compareTo(p1.age)
                }
                return -1
            }
        }
    }
}