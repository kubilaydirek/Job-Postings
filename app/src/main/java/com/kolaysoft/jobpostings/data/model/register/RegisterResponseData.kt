package com.kolaysoft.jobpostings.data.model.register

data class RegisterResponseData(
    val displayName: String,
    val email: String,
    val expiresIn: String,
    val idToken: String,
    val kind: String,
    val localId: String,
    val refreshToken: String
)