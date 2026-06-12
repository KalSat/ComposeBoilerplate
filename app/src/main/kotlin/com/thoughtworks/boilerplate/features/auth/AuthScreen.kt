package com.thoughtworks.boilerplate.features.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import com.thoughtworks.boilerplate.R
import com.thoughtworks.boilerplate.components.scaffold.BaseScaffold
import com.thoughtworks.boilerplate.shared.composequery.useMutation
import com.thoughtworks.boilerplate.theme.EdgeInset
import com.thoughtworks.boilerplate.theme.Size
import xyz.junerver.compose.hooks.useState

data class LoginParams(val username: String, val password: String)

@Composable
fun AuthScreen(repository: AuthRepository = AuthRepository()) {
    var username by useState("admin")
    var password by useState("123456")

    val loginMutation = useMutation<Unit, LoginParams>(
        mutationFn = { params -> repository.login(params.username, params.password) },
    )

    fun handleLogin() {
        val trimmedUsername = username.trim()
        val trimmedPassword = password.trim()
        if (trimmedUsername.isEmpty() || trimmedPassword.isEmpty()) return
        loginMutation.mutate(LoginParams(trimmedUsername, trimmedPassword))
    }

    BaseScaffold(title = stringResource(R.string.screen_title_login)) {
        Column(
            modifier = Modifier.padding(EdgeInset.M),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.weight(1f))

            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text(stringResource(R.string.login_username)) },
                leadingIcon = { Icon(Icons.Filled.Person, contentDescription = null) },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
            )

            Spacer(modifier = Modifier.height(EdgeInset.S))

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text(stringResource(R.string.login_password)) },
                leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = null) },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
            )

            if (loginMutation.error != null) {
                Spacer(modifier = Modifier.height(EdgeInset.XXS))
                Text(
                    text = stringResource(R.string.login_failed_error),
                    color = MaterialTheme.colorScheme.error,
                )
            }

            Spacer(modifier = Modifier.height(EdgeInset.M))

            Button(
                onClick = ::handleLogin,
                enabled = !loginMutation.isPending,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(Size.L),
            ) {
                if (loginMutation.isPending) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(Size.XS),
                        strokeWidth = EdgeInset.Smallest / 2,
                    )
                } else {
                    Text(stringResource(R.string.login_button))
                }
            }

            Spacer(modifier = Modifier.weight(1f))
        }
    }
}
