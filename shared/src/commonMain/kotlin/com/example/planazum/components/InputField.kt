package com.example.planazum.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planazum.theme.OnAccent

@Composable
fun InputField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String,
    modifier: Modifier = Modifier,
    keyboardType: KeyboardType = KeyboardType.Text,
    password: Boolean = false,
    passwordVisible: Boolean = false,
    onTogglePassword: (() -> Unit)? = null,
    accent: Color = MaterialTheme.colorScheme.primary,
    multiline: Boolean = false,
    height: Dp = if (multiline) 130.dp else 60.dp
) {
    val textColor = MaterialTheme.colorScheme.onSurface
    val shape = RoundedCornerShape(6.dp)

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 10.dp)
                .clip(shape)
                .background(MaterialTheme.colorScheme.surface)
                .border(1.dp, accent, shape)
                .padding(horizontal = 14.dp),
            contentAlignment = if (multiline) Alignment.TopStart else Alignment.CenterStart        ) {
            Row(
                modifier = if (multiline) {
                    Modifier.fillMaxSize().padding(vertical = 12.dp)
                } else {
                    Modifier.fillMaxWidth()
                },
                verticalAlignment = if (multiline) Alignment.Top else Alignment.CenterVertically
            ) {
                Box(modifier = if (multiline) {
                    Modifier.weight(1f).fillMaxHeight()
                } else {
                    Modifier.weight(1f)
                }) {
                    if (value.isEmpty()) {
                        Text(
                            text = placeholder,
                            color = textColor.copy(alpha = 0.4f),
                            fontSize = 18.sp
                        )
                    }
                    BasicTextField(
                        value = value,
                        onValueChange = onValueChange,
                        singleLine = !multiline,
                        textStyle = TextStyle(fontSize = 18.sp, color = textColor),
                        cursorBrush = SolidColor(accent),
                        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
                        visualTransformation = if (password && !passwordVisible) {
                            PasswordVisualTransformation()
                        } else {
                            VisualTransformation.None
                        },
                        modifier =  if (multiline) Modifier.fillMaxSize() else Modifier.fillMaxWidth()
                    )
                }

                if (password && onTogglePassword != null) {
                    Text(
                        text = if (passwordVisible) "◉" else "◎",
                        fontSize = 18.sp,
                        color = accent,
                        modifier = Modifier
                            .clickable(onClick = onTogglePassword)
                            .padding(start = 8.dp)
                    )
                }
            }
        }

        Text(
            text = label,
            fontSize = 16.sp,
            color = OnAccent,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 12.dp)
                .background(accent)
                .padding(horizontal = 4.dp)
        )
    }
}