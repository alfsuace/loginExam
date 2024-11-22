package edu.iesam.loginexam1eval.domain

class GetAllUserUseCase(private val repository: UserRepository) {

    operator fun invoke(): List<User> {
        return repository.findAll()
    }
}