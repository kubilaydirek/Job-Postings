package com.kolaysoft.jobpostings.data.model.register

data class ApiErrorResponse(
    val error: ErrorDetail
)

data class ErrorDetail(
    val code: Int,
    val message: String,
    val errors: List<ErrorItem>
)

data class ErrorItem(
    val message: String,
    val domain: String,
    val reason: String
)