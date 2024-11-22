package edu.iesam.loginexam1eval.presentation.SingUp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import edu.iesam.loginexam1eval.R
import edu.iesam.loginexam1eval.databinding.FragmentSingUpBinding
import edu.iesam.loginexam1eval.domain.User
import org.koin.androidx.viewmodel.ext.android.viewModel


class SingUpFragment : Fragment() {

    private var _binding: FragmentSingUpBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SingUpViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSingUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.root.apply {
            findViewById<Button>(R.id.login).setOnClickListener {
                val userName = binding.root.findViewById<EditText>(R.id.username)
                val passWord = binding.root.findViewById<EditText>(R.id.password)
                val user1 = User("1", userName.toString(), passWord.toString())
                viewModel.checkExists("1")
                val exists = viewModel.uiState.value?.exists
                if (exists != null) {
                    viewModel.saveUser(user1)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}