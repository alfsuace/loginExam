package edu.iesam.loginexam1eval.domain

class DeleteUserByIdUseCase(private val userRepository: UserRepository) {
    operator fun invoke(idUser: String) {
        userRepository.deleteById(idUser)
    }
}