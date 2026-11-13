package com.example.planazum.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planazum.components.InputField
import com.example.planazum.components.ShadowBox
import com.example.planazum.theme.OnAccent
import com.example.planazum.theme.PlanazumTheme

enum class AccountType(val label: String) {
    Personal("Personal"),
    Empresa("Empresa")
}

@Composable
fun RegisterScreen(
    onRegisterClick: (type: AccountType, email: String, password: String) -> Unit = { _, _, _ -> },
    onLoginClick: () -> Unit = {}
) {
    var accountType by remember { mutableStateOf(AccountType.Personal) }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var username by remember { mutableStateOf("") }
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var birthDate by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }

    val pink = MaterialTheme.colorScheme.primary
    val yellow = MaterialTheme.colorScheme.secondary

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 48.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(64.dp))

        // TÍTULO
        Row(modifier = Modifier.fillMaxWidth()) {
            ShadowBox(color = pink, shadowColor = yellow, offset = 6.dp) {
                Text(
                    text = "Únete a Planazum!",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 10.dp)
                )
            }
        }

        Spacer(Modifier.height(18.dp))

        Text(
            text = "Elige el tipo de cuenta que más se adapta a ti:",
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(16.dp))

        AccountTypeToggle(
            selected = accountType,
            onSelected = { accountType = it }
        )

        Spacer(Modifier.height(32.dp))

        InputField(
            value = email,
            onValueChange = { email = it },
            label = "email",
            placeholder = "ejemplo@email.com",
            keyboardType = KeyboardType.Email
        )

        Spacer(Modifier.height(20.dp))

        InputField(
            value = password,
            onValueChange = { password = it },
            label = "contraseña",
            placeholder = "••••••••",
            keyboardType = KeyboardType.Password,
            password = true,
            passwordVisible = passwordVisible,
            onTogglePassword = { passwordVisible = !passwordVisible }
        )

        Spacer(Modifier.height(20.dp))

        InputField(
            value = username,
            onValueChange = { username = it },
            label = "username",
            placeholder = "tu_usuario"
        )

        Spacer(Modifier.height(20.dp))

        InputField(
            value = firstName,
            onValueChange = { firstName = it },
            label = "nombre",
            placeholder = "Nombre"
        )

        Spacer(Modifier.height(20.dp))

        InputField(
            value = lastName,
            onValueChange = { lastName = it },
            label = "apellidos",
            placeholder = "Apellidos"
        )

        Spacer(Modifier.height(20.dp))

        InputField(
            value = birthDate,
            onValueChange = { birthDate = it },
            label = "Fecha de nacimiento",
            placeholder = "dd/mm/aaaa",
            keyboardType = KeyboardType.Number
        )

        Spacer(Modifier.height(32.dp))

        // BOTÓN PRINCIPAL
        ShadowBox(
            color = pink,
            shadowColor = yellow,
            offset = 8.dp,
            modifier = Modifier.clickable {
                val incomplete = listOf(email, password, username, firstName, lastName, birthDate)
                    .any { it.isBlank() }
                if (incomplete) {
                    message = "Completa todos los campos"
                } else {
                    message = ""
                    onRegisterClick(accountType, email, password)
                }
            }
        ) {
            Text(
                text = "Únete",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White,
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 12.dp)
            )
        }

        if (message.isNotEmpty()) {
            Spacer(Modifier.height(12.dp))
            Text(text = message, fontSize = 14.sp, color = pink)
        }

        Spacer(Modifier.height(32.dp))


        // PIE DE PÁGINA
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "¿Ya tienes cuenta?  ",
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onBackground
            )
            ShadowBox(
                color = pink,
                shadowColor = yellow,
                modifier = Modifier.clickable(onClick = onLoginClick)
            ) {
                Text(
                    text = "Inicia sesión",
                    fontSize = 16.sp,
                    color = OnAccent,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
            }
        }

        Text(
            text = "Al continuar aceptas nuestros Términos y Condiciones y la Política de Privacidad",
            fontSize = 11.sp,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(24.dp))
    }
}

/** Selector segmentado Personal / Empresa con borde y relleno amarillo. */
@Composable
private fun AccountTypeToggle(
    selected: AccountType,
    onSelected: (AccountType) -> Unit
) {
    val yellow = MaterialTheme.colorScheme.secondary
    val shape = RoundedCornerShape(8.dp)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(38.dp)
            .clip(shape)
            .border(1.5.dp, yellow, shape)
    ) {
        AccountType.entries.forEach { type ->
            val isSelected = type == selected
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .background(if (isSelected) yellow else MaterialTheme.colorScheme.surface)
                    .clickable { onSelected(type) },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = type.label,
                    fontSize = 14.sp,
                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                    color = if (isSelected) Color.White
                    else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() {
    PlanazumTheme(darkTheme = false) { RegisterScreen() }
}
