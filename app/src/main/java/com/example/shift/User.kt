package com.example.shift

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Embedded

data class UserResponse(
    val results: List<User>
)

data class User(
    val name: Name,
    val email: String,
    val picture: Picture,
    val phone: String,
    val location: Location
)

data class Name(
    val title: String,
    val first: String,
    val last: String
)

data class Picture(
    val large: String,
    val medium: String,
    val thumbnail: String
)

data class Location(
    val street: Street,
    val city: String,
    val state: String,
    val country: String,
    val postcode: String
) {
    fun getFullAddress(): String = "${street.number} ${street.name}, $city, $state, $country"
}

data class Street(
    val number: Int,
    val name: String
)

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey val email: String,
    val firstName: String,
    val lastName: String,
    val phone: String,
    val address: String,
    val photoUrl: String
)

fun User.toEntity(): UserEntity = UserEntity(
    email = email,
    firstName = name.first,
    lastName = name.last,
    phone = phone,
    address = location.getFullAddress(),
    photoUrl = picture.large
)

fun UserEntity.toUser(): User = User(
    name = Name(title = "", first = firstName, last = lastName),
    email = email,
    picture = Picture(large = photoUrl, medium = photoUrl, thumbnail = photoUrl),
    phone = phone,
    location = Location(
        street = Street(0, ""),
        city = "",
        state = "",
        country = address,
        postcode = ""
    )
)
