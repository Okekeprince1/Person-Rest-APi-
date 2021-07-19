package com.example.BootRestApi.service

import com.example.BootRestApi.dto.AddPersonRequest
import com.example.BootRestApi.dto.PersonResponse
import com.example.BootRestApi.dto.UpdatePersonRequest

interface PersonManagementService {

    fun findById(id: Long): PersonResponse?

    fun findAll(): List<PersonResponse>

    fun save(addPersonRequest: AddPersonRequest): PersonResponse

    fun update(updatePersonRequest: UpdatePersonRequest): PersonResponse

    fun deleteById(id: Long)

}