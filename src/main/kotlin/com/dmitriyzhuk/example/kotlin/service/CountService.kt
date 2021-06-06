package com.dmitriyzhuk.example.kotlin.service

import com.dmitriyzhuk.example.kotlin.entities.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityNotFoundException

@Service
class CountService(val userRepository: UserRepository) {

    @Transactional
    fun incrementCount(firstName: String?) {
        if (!firstName.isNullOrBlank()) {
            val user = userRepository.findByFirstName(firstName)
                    ?: throw EntityNotFoundException("User with $firstName")
            user.increaseCount()
        }
    }
}
