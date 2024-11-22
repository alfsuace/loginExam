package edu.iesam.loginexam1eval.domain

class CheckUserExistsUseCase(private val userRepository: UserRepository) {

    operator fun invoke(idUser: String): Boolean {
        var exists = false
        userRepository.findAll().forEach {
            if (it.id == idUser) {
                exists = true
            }
        }
        return exists
    }
}