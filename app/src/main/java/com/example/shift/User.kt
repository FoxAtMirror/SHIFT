package com.example.shift

data class UserResponse(
    val results: List<User>
)

data class User(
    val email: String,
    val name: Name,
    val phone: String,
    val location: Location,
    val picture: Picture
)

data class Name(
    val title: String, 
    val first: String, 
    val last: String
) {
    fun getFullName(): String = "$first $last"
}

data class Location(
    val street: Street, 
    val city: String, 
    val state: String, 
    val country: String
) {
    fun getFullAddress(): String = "${street.number} ${street.name}, $city, $state, $country"
}

data class Street(
    val number: Int, 
    val name: String
)

data class Picture(
    val large: String, 
    val medium: String, 
    val thumbnail: String
)
