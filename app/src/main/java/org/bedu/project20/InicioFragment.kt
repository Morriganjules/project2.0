package org.bedu.project20

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.view.isEmpty
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout


class InicioFragment : Fragment() {
    private lateinit var btnRegister: MaterialButton
    private lateinit var btnLogin : MaterialButton
    private lateinit var usuario : EditText
    private lateinit var password : EditText
    private lateinit var usuarioLayout: TextInputLayout
    private lateinit var passwordLayout: TextInputLayout

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
        usuario = view.findViewById(R.id.email)
        password = view.findViewById(R.id.contraseña)
        usuarioLayout = view.findViewById(R.id.emailLayout)
        passwordLayout = view.findViewById(R.id.contraseñaLayout)


        btnLogin.setOnClickListener {
            if(validateUsuario(usuario) && validatePassword(password)){
                val action: NavDirections = InicioFragmentDirections.actionInicioFragmentToMainActivity()
                findNavController().navigate(action)

            }else{
                if(!validateUsuario(usuario)){
                usuarioLayout.isErrorEnabled()
                usuarioLayout.setError("Ingrese un usuario valido")}
                else {
                    passwordLayout.isErrorEnabled()
                    passwordLayout.setError("Ingrese su contraseña")
                }
            }

        }
        btnRegister.setOnClickListener{
            val action: NavDirections = InicioFragmentDirections.actionInicioFragmentToRegisterFragment()
            findNavController().navigate(action)
        }


        return view
    }
    private fun validateUsuario(email: EditText):Boolean {
    val emailInput = email.text.toString()
    if (!emailInput.isEmpty() && emailInput.contains("@")) {
        return true
    }
    return false
  }
    private fun validatePassword(passwprd: EditText):Boolean {
        val passwprdInput = passwprd.text.toString()
        if (!passwprdInput.isEmpty()) {
            return true
        }
        return false
    }


}

