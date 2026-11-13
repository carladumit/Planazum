package com.example.planazum.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planazum.components.InputField
import com.example.planazum.components.ShadowBox
import com.example.planazum.theme.OnAccent
import com.example.planazum.theme.PlanazumTheme

@Composable
fun LoginScreen(
    onLoginClick: (email: String, password: String) -> Unit = { _, _ -> },
    onSignUpClick: () -> Unit = {}
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var message by remember { mutableStateOf("") }

    val pink = MaterialTheme.colorScheme.primary
    val yellow = MaterialTheme.colorScheme.secondary

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 60.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        //Spacer(Modifier.height(96.dp))

        // LOGOTIPO + ICONO
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ShadowBox(color = pink, shadowColor = yellow) {
                Text(
                    text = "Planazum!",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 10.dp)
                )
            }
            PinIcon()
        }

        Spacer(Modifier.height(18.dp))

        Text(
            text = "¿Qué plan toca hoy?",
            fontSize = 18.sp,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.fillMaxWidth()
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

        Spacer(Modifier.height(32.dp))

        // BOTÓN PRINCIPAL
        ShadowBox(
            color = pink,
            shadowColor = yellow,
            modifier = Modifier.clickable {
                if (email.isBlank() || password.isBlank()) {
                    message = "Introduce tu correo y contraseña"
                } else {
                    message = ""
                    onLoginClick(email, password)
                }
            }
        ) {
            Text(
                text = "Iniciar sesión",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White,
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 12.dp)
            )
        }

        if (message.isNotEmpty()) {
            Spacer(Modifier.height(16.dp))
            Text(text = message, fontSize = 14.sp, color = pink)
        }

        Spacer(Modifier.height(56.dp))

        // PIE DE PÁGINA
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "¿No tienes cuenta?  ",
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onBackground
            )
            ShadowBox(
                color = pink,
                shadowColor = yellow,
                modifier = Modifier.clickable(onClick = onSignUpClick)
            ) {
                Text(
                    text = "Regístrate",
                    fontSize = 16.sp,
                    color = OnAccent,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
            }
        }
    }
}

/** Icono de pin sobre cuadrado amarillo. Sustitúyelo por tu imagen si prefieres. */
@Composable
private fun PinIcon() {
    Box(
        modifier = Modifier
            .size(64.dp)
            .background(MaterialTheme.colorScheme.secondary, RoundedCornerShape(8.dp)),
        contentAlignment = Alignment.Center
    ) {
        val yellow = MaterialTheme.colorScheme.secondary
        Canvas(modifier = Modifier.size(36.dp)) {
            val w = size.width
            val h = size.height
            val head = Offset(w / 2, h * 0.38f)
            drawCircle(Color.White, radius = w * 0.36f, center = head)
            val tail = Path().apply {
                moveTo(w * 0.2f, h * 0.55f)
                lineTo(w / 2, h)
                lineTo(w * 0.8f, h * 0.55f)
                close()
            }
            drawPath(tail, Color.White)
            drawCircle(yellow, radius = w * 0.15f, center = head)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    PlanazumTheme(darkTheme = false) { LoginScreen() }
}
