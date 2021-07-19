package com.example.BootRestApi.dto

data class UpdatePersonRequest(val id: Long, val name : String, val lastName: String?= null)