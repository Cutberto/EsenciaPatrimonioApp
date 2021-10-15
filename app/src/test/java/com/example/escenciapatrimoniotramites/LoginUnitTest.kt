package com.example.escenciapatrimoniotramites

import com.example.escenciapatrimoniotramites.Activities.LoginUtils
import com.google.common.truth.Truth.assertThat
import com.parse.ParseException
import junit.framework.TestCase

import org.junit.Test

/**
 * Test [LoginActivity] -> iniciar sesión
 *
 * El input no es valido si ...
 * ... no se ingresó el nombre de usuario o el correo electrónico
 * ... no se ingresó la contraseña
 * ... el nombre de usuario o la contraseña no son correctas
 */
class LoginUnitTest {
    @Test
    fun `nombre de usuario vacio, se indica que se debe colocar username o password`() {
        val result = LoginUtils.validateLoginError(
            "username/email is required."
        )
        assertThat(result).matches("Se deben ingresar nombre de usuario/email")
    }

    @Test
    fun `contraseña vacia, se indica que hay que ponerla`() {
        val result = LoginUtils.validateLoginError(
            "password is required."
        )
        assertThat(result).matches("Se debe ingresar la contraseña")
    }

    @Test
    fun `usuario o contraseña incorrecta, se indica esto`() {
        val result = LoginUtils.validateLoginError(
            "Invalid username/password."
        )
        assertThat(result).matches("El nombre de usuario o la contraseña no son correctos")
    }
}

/**
 * Test [LoginActivity] -> olvidaste tu contraseña
 *
 * No existen errores si...
 * ... se envia un correo con las instrucciones de cambio de contraseña
 */
class resetPasswordTest {
    @Test
    fun `no hay errores`() {
        val result = LoginUtils.validateResetPasswordError(
            null
        )
        assertThat(result).matches("Se te envió un correo con las instrucciones")
    }
}