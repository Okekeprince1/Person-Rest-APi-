package com.example.BootRestApi.transformer

import com.example.BootRestApi.domain.Person
import com.example.BootRestApi.dto.PersonResponse

fun Person?.toPersonResponse() : PersonResponse{
    return PersonResponse(
        id = this?.id ?: 1L,
        fullName = "${this?.lastName}, ${this?.name}"
    )
}