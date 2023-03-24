package LearnKotlin.delegation

class Student {
    var firstName: String? = null
        set(value) {
            if (value != null && value.length > 5) {
                field = value.trim().uppercase()
            }
        }
    var lastName: String? = null
        set(value) {
            if (value != null && value.length > 5) {
                field = value.trim().uppercase()
            }
        }
}