package com.example.user.garbarinotest.utils


fun String.splitByDot():List<String>{

    return this.split(". ").toList().filter {
        !it.isNullOrBlank()
    }
}