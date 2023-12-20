package com.example.cashrecord

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.example.cashrecord.databinding.FragmentRegisterationBinding
import com.google.firebase.auth.FirebaseAuth

class Registration : Fragment() {

      private var _binding : FragmentRegisterationBinding? = null
      private val binding get() = _binding!!
      private lateinit var mauth: FirebaseAuth


      override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
      ): View? {
                // Inflate the layout for this fragment
            _binding = FragmentRegisterationBinding.inflate(inflater,container,false)

            mauth = FirebaseAuth.getInstance()

            val text = binding.btnLogin

            text.setOnClickListener {

                  findNavController().navigate(R.id.action_registeration_to_login)
            }

            binding.btnSignUp.setOnClickListener {
                  val name = binding.txtUsername.text.toString()
                  val email = binding.txtEmail.text.toString()
                  val password = binding.txtPassword.text.toString()

                  if(name.isEmpty()){
                        binding.txtUsername.error = "Please enter your name"
                        return@setOnClickListener
                  }
                  if(email.isEmpty()){
                      binding.txtEmail.error = "Please enter your email"
                      return@setOnClickListener
                  }
                  if(password.isEmpty()){
                      binding.txtPassword.error = "Please enter your password"
                      return@setOnClickListener
                  }
                  if (password.length < 6){
                        binding.txtPassword.error = "Password must be at least 6 characters"
                        return@setOnClickListener
                  }
                  mauth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(requireActivity()) { task ->
                                   if (task.isSuccessful) {
                                          // Sign in success, update UI with the signed-in user's information
                                          Log.d(TAG, "createUserWithEmail:success")
                                          val user = mauth.currentUser
                                          findNavController().navigate(R.id.action_registeration_to_login)
                                          Toast.makeText(requireContext(), "Authentication Success.",
                                                 Toast.LENGTH_SHORT).show()
                                   } else {
                                          // If sign in fails, display a message to the user.
                                          Log.w(TAG, "createUserWithEmail:failure", task.exception)
                                          Toast.makeText(requireContext(), "Authentication failed.",
                                                 Toast.LENGTH_SHORT).show()
                                   }
                            }


            }



            return binding.root


      }

      override fun onDestroy() {
            super.onDestroy()
            _binding=null
      }


}