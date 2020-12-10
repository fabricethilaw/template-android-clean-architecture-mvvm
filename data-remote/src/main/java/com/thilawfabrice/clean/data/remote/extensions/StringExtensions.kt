package com.thilawfabrice.clean.data.remote.extensions


internal fun String.enforceHttps(): String =
    if (!this.contains("https"))
        this.replace("http", "https")
    else this
