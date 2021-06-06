package com.dmitriyzhuk.example.kotlin.entities

import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "users")
class UserEntity(
        var firstName: String?,
        var lastName: String?,
        var counts: Long = 0,
) : BaseEntity() {

    fun increaseCount() {
        counts = counts.plus(1)
    }
}
