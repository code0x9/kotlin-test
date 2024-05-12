package com.mark.study

import java.awt.Desktop
import java.net.URI

fun main(args: Array<String>) {
  // openBrowser()
  readClasspathResource()
}

fun readClasspathResource() {
  val resource1 = {}.javaClass.getResource("/test-pod.yaml")
  val fileContent1 = resource1?.readText(Charsets.UTF_8)
  println(fileContent1)

  val resource2 = {}.javaClass.getResource("/test-pod-2.yaml")
  val fileContent2 = resource2?.readText(Charsets.UTF_8)
  println(fileContent2)
}

fun openBrowser() {
  if (Desktop.isDesktopSupported()) {
    val desktop = Desktop.getDesktop()
    if (desktop.isSupported(Desktop.Action.BROWSE)) {
      desktop.browse(URI.create("https://aagag.com/issue/"))
    }
  }
}
