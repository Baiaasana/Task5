package com.example.task5.data

val list = listOf(

    ItemModel(
        fieldId = 1,
        fieldType = "input",
        hint = "UserName",
        icon = "https://cdn-icons-png.flaticon.com/512/1077/1077063.png",
        isActive = true,
        keyboard = "text",
        required = false
    ),
    ItemModel(
        fieldId = 2,
        fieldType = "input",
        hint = "Email",
        icon = "https://cdn-icons-png.flaticon.com/512/561/561127.png",
        isActive = true,
        keyboard = "text",
        required = true
    ),
    ItemModel(
        fieldId = 3,
        fieldType = "input",
        hint = "Phone",
        icon = "https://cdn-icons-png.flaticon.com/512/159/159832.png",
        isActive = true,
        keyboard = "text",
        required = true
    ),
    ItemModel(
        fieldId = 4,
        fieldType = "input",
        hint = "FullName",
        icon = "https://cdn-icons-png.flaticon.com/512/1077/1077063.png",
        isActive = true,
        keyboard = "text",
        required = true
    ),
    ItemModel(
        fieldId = 5,
        fieldType = "chooser",
        hint = "Birthday",
        icon = "https://cdn-icons-png.flaticon.com/512/55/55281.png",
        isActive = true,
        keyboard = null,
        required = false
    ),
    ItemModel(
        fieldId = 6,
        fieldType = "chooser",
        hint = "Gender",
        icon = "https://cdn-icons-png.flaticon.com/512/505/505972.png",
        isActive = true,
        keyboard = null,
        required = false
    )
)
val mapOfUserInfo = mutableMapOf<Int, UserInfo>()
