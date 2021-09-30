package org.bedu.project20

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout


class RegisterFragment : Fragment() {
    private lateinit var nombre : EditText
    private lateinit var correo : EditText
    private lateinit var telefono : EditText
    private lateinit var contraseña : EditText
    private lateinit var btnRegistrar : MaterialButton
    private lateinit var nombreLayout: TextInputLayout
    private lateinit var correoLayout : TextInputLayout
    private lateinit var telefonoLayout : TextInputLayout
    private lateinit var contraseñaLayout :TextInputLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_register, container, false)
        nombre =view.findViewById(R.id.textNombre)
        correo = view.findViewById(R.id.textEmail)
        telefono = view.findViewById(R.id.textTelefono)
        contraseña = view.findViewById(R.id.textPassword)
        btnRegistrar = view.findViewById(R.id.btnRegistrarse)
        nombreLayout = view.findViewById(R.id.nombre)
        correoLayout = view.findViewById(R.id.emailReg)
        telefonoLayout = view.findViewById(R.id.telefono)
        contraseñaLayout = view.findViewById(R.id.passwordReg)

        btnRegistrar.setOnClickListener{
            if(validarNombre(nombre) && validarCorreo(correo) && validarTelefono(telefono) && validarContraseña(contraseña)){
            val action: NavDirections = RegisterFragmentDirections.actionRegisterFragmentToInicioFragment()
            findNavController().navigate(action)}
            else {
                if(!validarNombre(nombre)){
                    nombreLayout.isErrorEnabled
                    nombreLayout.error = "Ingrese su nombre"
                } else if (!validarCorreo(correo)){
                    correoLayout.isErrorEnabled
                    correoLayout.error = "Ingrese su correo"
                } else if (!validarTelefono(telefono)){
                    telefonoLayout.isErrorEnabled
                    telefonoLayout.error = "Ingrese un telefono"
                } else if (!validarContraseña(contraseña)){
                    contraseñaLayout.isErrorEnabled
                    contraseñaLayout.error = "ingrese una contraseña"
                }

            }
        }


        return view
    }

    private fun validarNombre (nombre: EditText):Boolean{
        val nombreInput = nombre.text.toString()
        return !nombreInput.isEmpty()
    }
    private fun validarCorreo(email: EditText): Boolean{
        val emailInput = email.text.toString()
        return !emailInput.isEmpty() && emailInput.contains("@")
    }
    private fun validarTelefono(telefono: EditText): Boolean{
        val telefonoInput = telefono.text.toString()
        return !telefonoInput.isEmpty()
    }
    private fun validarContraseña(contraseña:EditText):Boolean{
        val contraseñaInput = contraseña.text.toString()
        return !contraseñaInput.isEmpty()
    }


}