package com.example.myapplication.recyclerview.models

data class MailParent(
    val mail: Mail? = null,
    var type: Int = Constants.PARENT,
    var sublist: MutableList<MailChild> = ArrayList(),
    var isExpanded: Boolean = false
)