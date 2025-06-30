package com.example.shift

data class UserResponse(
    val results: List<User>
)

data class User(
    val name: Name,
    val email: String,
    val picture: Picture
)

data class Name(
    val first: String,
    val last: String
)

data class Picture(
    val large: String
)

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
