package com.mark.study

import java.awt.Desktop
import java.net.URI


fun main(args: Array<String>) {
    if (Desktop.isDesktopSupported()) {
        val desktop = Desktop.getDesktop()
        if (desktop.isSupported(Desktop.Action.BROWSE)) {
            desktop.browse(URI.create("https://aagag.com/issue/"))
        }
    }
    println("Hello")
}
