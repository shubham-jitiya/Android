package LearnKotlin.collection


//builds new collection based on the transformation applied from the existing ones
//Transformation: map, zip
fun main() {
    var people = listOf<PersonData>(
        PersonData("Jitiya", "Shubham", 21),
        PersonData("Trivedi", "Bhakti", 23),
        PersonData("Sartanpara", "Shyam", 20),
        PersonData("Vyas", "Divyesh", 20)
    )

    //map with list
    var peopleFirstName = people.map { it.firstName } //first name
    println(peopleFirstName)

    var peopleLastName = people.map { it.lastName } //last name
    println(peopleLastName)

    var peopleFullName = people.map { "${it.firstName} ${it.lastName}" } //full name
    println(peopleFullName)

    var peopleDataWithIndex =
        people.mapIndexed { index, person -> "$index : ${person.lastName}" } //with index
    println(peopleDataWithIndex)

    var filterPeople = people.map { if (it.age != 20) it.lastName else null }
    println(filterPeople)
    var filterPeopleNull = filterPeople.mapNotNull { it } //gives non null values
    println(filterPeopleNull)
    //can also use mapIndexedNotNull


    //map with map
    var cityHasState = buildMap<String, String> {
        put("Bengaluru", "Karnataka")
        put("Chennai", "Tamilnadu")
        put("Ahmedabad", "Gujarat")
    }
    println(cityHasState.map { entry: Map.Entry<String, String> -> entry.key })
    println(cityHasState.map { entry: Map.Entry<String, String> -> entry.value })

    println(cityHasState.mapKeys { it.key.uppercase() }) //doesn't update original map
    println(cityHasState)


    //Zipping - must be of equal length
    var city = listOf<String>("Ahmedabad", "Bengaluru", "Rajkot", "Surat")
    var zipPeopleWithCity = city.zip(people)
    var unZipPeopleWithCity = zipPeopleWithCity.unzip()
    println(zipPeopleWithCity)
    println(unZipPeopleWithCity)
    println(unZipPeopleWithCity.first) //first list of pair
    println(unZipPeopleWithCity.second) //second list of pair
}

data class PersonData(val firstName: String, val lastName: String, val age: Int)