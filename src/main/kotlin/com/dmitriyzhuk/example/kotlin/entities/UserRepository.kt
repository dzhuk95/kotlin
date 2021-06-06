package com.dmitriyzhuk.example.kotlin.entities

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<UserEntity, Long> {

    fun findByFirstName(firstName: String): UserEntity?
}
