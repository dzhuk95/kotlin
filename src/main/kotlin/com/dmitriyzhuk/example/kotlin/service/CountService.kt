package com.dmitriyzhuk.example.kotlin.service

import com.dmitriyzhuk.example.kotlin.controllers.UserDto
import com.dmitriyzhuk.example.kotlin.entities.UserEntity
import com.dmitriyzhuk.example.kotlin.entities.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityNotFoundException

@Service
class CountService(private val userRepository: UserRepository) {

    @Transactional
    fun incrementCount(email: String?) {
        if (!email.isNullOrBlank()) {
            val user = userRepository.findByEmail(email)
                ?: throw EntityNotFoundException("User with $email")
            user.increaseCount()
        }
    }

    fun getUser(email: String?): UserEntity? {
        if (!email.isNullOrBlank()) {
            return userRepository.findByEmail(email)
                ?: throw EntityNotFoundException("User with $email")
        }
        return null
    }

    @Transactional
    fun createUser(dto: UserDto): UserEntity? {
        val userEntity = UserEntity(dto.firstName, dto.lastName, dto.email)
        return userRepository.save(userEntity)
    }
}
