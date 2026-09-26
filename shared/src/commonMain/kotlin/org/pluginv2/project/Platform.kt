package org.pluginv2.project

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform