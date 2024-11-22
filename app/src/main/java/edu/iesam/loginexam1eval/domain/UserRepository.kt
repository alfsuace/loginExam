package edu.iesam.loginexam1eval.domain

interface UserRepository {
    fun saveUser(user: User)
    fun findById(idUser: String): User?
    fun findAll(): List<User>
    fun delete()
    fun deleteById(idUser: String)
}