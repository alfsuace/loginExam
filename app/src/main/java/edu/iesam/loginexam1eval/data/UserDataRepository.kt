package edu.iesam.loginexam1eval.data

import edu.iesam.loginexam1eval.data.local.LoginXmlLocalDataSource
import edu.iesam.loginexam1eval.domain.UserRepository

class UserDataRepository(private val loginXmlLocalDataSource: LoginXmlLocalDataSource):UserRepository {
}