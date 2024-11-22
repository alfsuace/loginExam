package edu.iesam.loginexam1eval.data

import edu.iesam.loginexam1eval.data.local.LoginXmlLocalDataSource
import edu.iesam.loginexam1eval.domain.User
import edu.iesam.loginexam1eval.domain.UserRepository
import org.koin.core.annotation.Single

@Single
class UserDataRepository(private val loginXmlLocalDataSource: LoginXmlLocalDataSource):UserRepository {
    override fun saveUser(user: User) {
        loginXmlLocalDataSource.save(user)
    }

    override fun findById(idUser: String): User? {
        return loginXmlLocalDataSource.findById(idUser)
    }

    override fun findAll(): List<User> {
        return loginXmlLocalDataSource.findAll()
    }

    override fun delete() {
        loginXmlLocalDataSource.delete()
    }

    override fun deleteById(idUser: String) {
        loginXmlLocalDataSource.deleteById(idUser)
    }
}