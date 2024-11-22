package edu.iesam.loginexam1eval.presentation.SingUp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.loginexam1eval.domain.CheckUserExistsUseCase
import edu.iesam.loginexam1eval.domain.GetAllUserUseCase
import edu.iesam.loginexam1eval.domain.GetUserUseCase
import edu.iesam.loginexam1eval.domain.SaveUserUseCase
import edu.iesam.loginexam1eval.domain.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class SingUpViewModel(
    private val getUserUseCase: GetUserUseCase,
    private val saveUserUseCase: SaveUserUseCase,
    private val getAllUserUseCase: GetAllUserUseCase,
    private val checkUserExistsUseCase: CheckUserExistsUseCase
) : ViewModel() {
    private var _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    fun loadUser(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val user = getUserUseCase.invoke(id)
            _uiState.postValue(UiState(loginSuccess = user))
        }
    }

    fun saveUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            saveUserUseCase.invoke(user)
        }

    }

    fun getAllUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.postValue(UiState(listUsers = getAllUserUseCase.invoke()))
        }
    }

    fun checkExists(id: String) {
        _uiState.postValue(UiState(exists = checkUserExistsUseCase.invoke(id)))

    }


    data class UiState(
        val error: String? = null,
        val loginSuccess: User? = null,
        val listUsers: List<User>? = null,
        val exists: Boolean = false
    )
}