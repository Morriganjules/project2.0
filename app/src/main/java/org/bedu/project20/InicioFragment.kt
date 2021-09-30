package org.bedu.project20

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isEmpty
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout


class InicioFragment : Fragment() {
    private lateinit var btnRegister: MaterialButton
    private lateinit var btnLogin : MaterialButton
    private lateinit var usuario : TextInputLayout
    private lateinit var password : TextInputLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_inicio, container, false)
        btnLogin = view.findViewById(R.id.btnLogin)
        btnRegister = view.findViewById(R.id.btnRegister)




        btnLogin.setOnClickListener {
            val action: NavDirections = InicioFragmentDirections.actionInicioFragmentToMainActivity()
            findNavController().navigate(action)
        }
        btnRegister.setOnClickListener{
            val action: NavDirections = InicioFragmentDirections.actionInicioFragmentToRegisterFragment()
            findNavController().navigate(action)
        }


        return view
    }


}