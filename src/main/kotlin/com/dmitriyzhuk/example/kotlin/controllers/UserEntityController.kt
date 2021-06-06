package com.dmitriyzhuk.example.kotlin.controllers

import com.dmitriyzhuk.example.kotlin.service.CountService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["user"])
class UserEntityController(val countService: CountService) {

    @GetMapping
    fun increaseCount(@RequestParam("name") name: String) {
        countService.incrementCount(name)
    }
}
