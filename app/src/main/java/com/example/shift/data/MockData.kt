package com.example.shift.data

import com.example.shift.Location
import com.example.shift.Name
import com.example.shift.Picture
import com.example.shift.Street
import com.example.shift.User

object MockData {
    val users = listOf(
        User(
            email = "john.doe@example.com",
            name = Name("Mr", "John", "Doe"),
            phone = "+1-555-0123",
            location = Location(
                street = Street(123, "Main Street"),
                city = "New York",
                state = "NY",
                country = "USA"
            ),
            picture = Picture(
                large = "https://randomuser.me/api/portraits/men/1.jpg",
                medium = "https://randomuser.me/api/portraits/med/men/1.jpg",
                thumbnail = "https://randomuser.me/api/portraits/thumb/men/1.jpg"
            )
        ),
        User(
            email = "jane.smith@example.com",
            name = Name("Ms", "Jane", "Smith"),
            phone = "+1-555-0456",
            location = Location(
                street = Street(456, "Oak Avenue"),
                city = "Los Angeles",
                state = "CA",
                country = "USA"
            ),
            picture = Picture(
                large = "https://randomuser.me/api/portraits/women/2.jpg",
                medium = "https://randomuser.me/api/portraits/med/women/2.jpg",
                thumbnail = "https://randomuser.me/api/portraits/thumb/women/2.jpg"
            )
        ),
        User(
            email = "mike.johnson@example.com",
            name = Name("Mr", "Mike", "Johnson"),
            phone = "+1-555-0789",
            location = Location(
                street = Street(789, "Pine Road"),
                city = "Chicago",
                state = "IL",
                country = "USA"
            ),
            picture = Picture(
                large = "https://randomuser.me/api/portraits/men/3.jpg",
                medium = "https://randomuser.me/api/portraits/med/men/3.jpg",
                thumbnail = "https://randomuser.me/api/portraits/thumb/men/3.jpg"
            )
        ),
        User(
            email = "sarah.wilson@example.com",
            name = Name("Ms", "Sarah", "Wilson"),
            phone = "+1-555-0321",
            location = Location(
                street = Street(321, "Elm Street"),
                city = "Houston",
                state = "TX",
                country = "USA"
            ),
            picture = Picture(
                large = "https://randomuser.me/api/portraits/women/4.jpg",
                medium = "https://randomuser.me/api/portraits/med/women/4.jpg",
                thumbnail = "https://randomuser.me/api/portraits/thumb/women/4.jpg"
            )
        ),
        User(
            email = "david.brown@example.com",
            name = Name("Mr", "David", "Brown"),
            phone = "+1-555-0654",
            location = Location(
                street = Street(654, "Cedar Lane"),
                city = "Phoenix",
                state = "AZ",
                country = "USA"
            ),
            picture = Picture(
                large = "https://randomuser.me/api/portraits/men/5.jpg",
                medium = "https://randomuser.me/api/portraits/med/men/5.jpg",
                thumbnail = "https://randomuser.me/api/portraits/thumb/men/5.jpg"
            )
        ),
        User(
            email = "emma.davis@example.com",
            name = Name("Ms", "Emma", "Davis"),
            phone = "+1-555-0987",
            location = Location(
                street = Street(987, "Maple Drive"),
                city = "Philadelphia",
                state = "PA",
                country = "USA"
            ),
            picture = Picture(
                large = "https://randomuser.me/api/portraits/women/6.jpg",
                medium = "https://randomuser.me/api/portraits/med/women/6.jpg",
                thumbnail = "https://randomuser.me/api/portraits/thumb/women/6.jpg"
            )
        ),
        User(
            email = "alex.miller@example.com",
            name = Name("Mr", "Alex", "Miller"),
            phone = "+1-555-0124",
            location = Location(
                street = Street(124, "Birch Way"),
                city = "San Antonio",
                state = "TX",
                country = "USA"
            ),
            picture = Picture(
                large = "https://randomuser.me/api/portraits/men/7.jpg",
                medium = "https://randomuser.me/api/portraits/med/men/7.jpg",
                thumbnail = "https://randomuser.me/api/portraits/thumb/men/7.jpg"
            )
        ),
        User(
            email = "lisa.garcia@example.com",
            name = Name("Ms", "Lisa", "Garcia"),
            phone = "+1-555-0457",
            location = Location(
                street = Street(457, "Willow Court"),
                city = "San Diego",
                state = "CA",
                country = "USA"
            ),
            picture = Picture(
                large = "https://randomuser.me/api/portraits/women/8.jpg",
                medium = "https://randomuser.me/api/portraits/med/women/8.jpg",
                thumbnail = "https://randomuser.me/api/portraits/thumb/women/8.jpg"
            )
        )
    )
} 