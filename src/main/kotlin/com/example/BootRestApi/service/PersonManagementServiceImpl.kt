package com.example.BootRestApi.service

import com.example.BootRestApi.domain.Person
import com.example.BootRestApi.dto.AddPersonRequest
import com.example.BootRestApi.dto.PersonResponse
import com.example.BootRestApi.dto.UpdatePersonRequest
import com.example.BootRestApi.transformer.AddPersonRequestTransformer
import com.example.BootRestApi.transformer.toPersonResponse
import com.example.BootRestApi.dao.PersonDao
import org.springframework.stereotype.Service

@Service
class PersonManagementServiceImpl(private val personDao: PersonDao,
                                  private val addPersonRequestTransformer: AddPersonRequestTransformer) : PersonManagementService {
    override fun findById(id: Long): PersonResponse? = this.findPersonById(id)?.toPersonResponse()

    override fun findAll(): List<PersonResponse> = this.personDao.findAll().map(Person::toPersonResponse)

    override fun save(addPersonRequest: AddPersonRequest): PersonResponse {
        return this.saveOrUpdate(
            addPersonRequestTransformer.transform(addPersonRequest)
        )
    }

    override fun update(updatePersonRequest: UpdatePersonRequest): PersonResponse {
        val person = this.findPersonById(updatePersonRequest.id) ?: throw IllegalStateException("${updatePersonRequest.id} not found")

        return this.saveOrUpdate(person.apply{
            this.name = updatePersonRequest.name
            this.lastName = updatePersonRequest.lastName
        })
    }

    override fun deleteById(id: Long) {
        this.personDao.deleteById(id)
    }

    private fun findPersonById(id: Long): Person? = this.personDao.findById(id)?.get()

    private fun saveOrUpdate(person: Person): PersonResponse = this.personDao.save(person).toPersonResponse()
}