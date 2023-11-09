package com.trials.socials

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.trials.socials.Retrofit.ApiClient
import com.trials.socials.Retrofit.UserService
import com.trials.socials.ViewModel.LoginViewModel
import com.trials.socials.databinding.FragmentLoginBinding
import java.io.Console


class Login : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: LoginViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false);



        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this, LoginViewModel.createFactory(ApiClient.getService())).get(LoginViewModel::class.java)



        binding.registerText.setOnClickListener{
            val register = Signup()
            requireFragmentManager().beginTransaction().setCustomAnimations(
                R.anim.slide_in_right,
                R.anim.slide_out_left,
                R.anim.slide_in_right,
                R.anim.slide_out_left
            ).replace(R.id.containerAuth, register).addToBackStack(null).commit()
        }




        binding.logBtn.setOnClickListener{
            val password: String = binding.password.text.toString()
            val username: String = binding.username.text.toString()

        }




    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}