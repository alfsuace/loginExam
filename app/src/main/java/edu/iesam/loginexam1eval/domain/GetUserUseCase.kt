package edu.iesam.loginexam1eval.domain

class GetUserUseCase(private val userRepository: UserRepository) {
    operator fun invoke(idUser: String): User? {
        return userRepository.findById(idUser)
    }
}