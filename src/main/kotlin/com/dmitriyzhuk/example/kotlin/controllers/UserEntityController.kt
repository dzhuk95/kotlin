package com.dmitriyzhuk.example.kotlin.controllers

import com.dmitriyzhuk.example.kotlin.entities.UserEntity
import com.dmitriyzhuk.example.kotlin.service.CountService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["users"])
class UserEntityController(private val countService: CountService) {

    @GetMapping("increment")
    fun increaseCount(@RequestParam("email") email: String) {
        countService.incrementCount(email)
    }

    @GetMapping
    fun getUser(@RequestParam("email") email: String): UserEntity? {
        return countService.getUser(email)
    }

    @PostMapping
    fun createUser(@RequestBody body: UserDto) {
        countService.createUser(body)
    }
}
