package com.osias.base.projetobasefragment.model.entity

sealed class ApiResponse<T>(
    val result: T?,
    val error: Throwable?
) {
}