package com.example.task5.data

val list = listOf(

    ItemModel(
        fieldId = 1,
        fieldType = "input",
        hint = "UserName",
        icon = "https://img.icons8.com/officel/344/link.png",
        isActive = true,
        keyboard = "text",
        required = false
    ),
    ItemModel(
        fieldId = 2,
        fieldType = "input",
        hint = "Email",
        icon = "https://img.icons8.com/officel/344/link.png",
        isActive = true,
        keyboard = "text",
        required = true
    ),
    ItemModel(
        fieldId = 3,
        fieldType = "input",
        hint = "Phone",
        icon = "https://img.icons8.com/officel/344/link.png",
        isActive = true,
        keyboard = "text",
        required = true
    ),
    ItemModel(
        fieldId = 4,
        fieldType = "input",
        hint = "FullName",
        icon = "https://img.icons8.com/officel/344/link.png",
        isActive = true,
        keyboard = "text",
        required = true
    ),
    ItemModel(
        fieldId = 5,
        fieldType = "chooser",
        hint = "Birthday",
        icon = "https://img.icons8.com/officel/344/link.png",
        isActive = true,
        keyboard = null,
        required = false
    ),
    ItemModel(
        fieldId = 6,
        fieldType = "chooser",
        hint = "Gender",
        icon = "https://img.icons8.com/officel/344/link.png",
        isActive = true,
        keyboard = null,
        required = false
    )
)
val mapOfUserInfo = mutableMapOf<Int, UserInfo>()
