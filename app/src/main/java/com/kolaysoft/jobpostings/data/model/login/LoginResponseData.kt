package com.kolaysoft.jobpostings.data.model.login

data class LoginResponseData(
    val displayName: String,
    val email: String,
    val expiresIn: String,
    val idToken: String,
    val kind: String,
    val localId: String,
    val refreshToken: String,
    val registered: Boolean
)