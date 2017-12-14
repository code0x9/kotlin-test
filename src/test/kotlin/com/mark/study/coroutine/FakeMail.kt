package com.mark.study.coroutine

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import java.text.SimpleDateFormat
import java.util.Date

suspend fun sendEmail(r: String, msg: String): Boolean {
    printWithTimestamp("Sending '$msg' to $r...")
    delay(2000)
    printWithTimestamp("Sent '$msg' to $r")
    return true
}

suspend fun getReceiverAddressFromDatabase(): String {
    delay(1000)
    return "coroutine@kotlin.org"
}

suspend fun sendEmailSuspending(): Boolean {
    val msg = async(CommonPool) {
        delay(500)
        "The message content"
    }
    val recipient = async(CommonPool) {
        getReceiverAddressFromDatabase()
    }
    printWithTimestamp("Waiting for email data")
    val sendStatus = async(CommonPool) {
        sendEmail(recipient.await(), msg.await())
    }
    return sendStatus.await()
}

fun main(args: Array<String>) = runBlocking(CommonPool) {
    printWithTimestamp("Start")
    val job = launch(CommonPool) {
        sendEmailSuspending()
        printWithTimestamp("Email sent successfully.")
    }
    job.join()
    printWithTimestamp("Finished")
}

val dateFormatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS")
fun printWithTimestamp(msg: String) {
    println("${dateFormatter.format(Date())} | $msg")
}
