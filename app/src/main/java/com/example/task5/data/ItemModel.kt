package com.example.task5.data

import com.squareup.moshi.Json

data class ItemModel(
    @Json(name = "field_id")
    val fieldId: Int,
    @Json(name = "field_type")
    var fieldType: String,
    var hint: String,
    val icon: String,
    @Json(name = "is_active")
    val isActive: Boolean,
    val keyboard: String?,
    val required: Boolean,
)

