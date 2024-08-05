package com.kolaysoft.jobpostings.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun JobTextField(
    fieldValue: MutableState<String>,
    labelText: String,
    isPassword: Boolean = false,
    modifier: Modifier,
    errorMsg: String = "Bu alan boş bırakılamaz",
    showError: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Text

) {
    var passwordVisible by rememberSaveable { mutableStateOf(true) }
    Column {
        TextField(
            value = fieldValue.value,
            onValueChange = { fieldValue.value = it },
            label = { Text(text = labelText) },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
            ),
            visualTransformation = if (isPassword && passwordVisible) PasswordVisualTransformation() else VisualTransformation.None,
            trailingIcon = {
                if (isPassword) {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            imageVector = if (passwordVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                            contentDescription = ""
                        )
                    }
                }
            },
            modifier = modifier.padding(10.dp),
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType)

        )
        if (showError) {
            Spacer(modifier = modifier.height(10.dp))
            Text(text = errorMsg, style = TextStyle(color = Color.Red), modifier = modifier.padding(10.dp, 0.dp))
        }

    }


}

@Preview
@Composable
fun JobTextFieldPreview() {
    val value = remember { mutableStateOf("") }
    JobTextField(fieldValue = value, labelText = "Job Postings", modifier = Modifier)
}