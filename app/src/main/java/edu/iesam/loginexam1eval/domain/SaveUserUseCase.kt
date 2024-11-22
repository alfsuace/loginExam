package edu.iesam.loginexam1eval.domain

class SaveUserUseCase(private val userRepository: UserRepository) {

    operator fun invoke(user: User) {
        userRepository.saveUser(user)
    }
}