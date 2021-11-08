package com.idiomcentric.jvm.clients

import kotlin.test.Test
import kotlin.test.assertNotNull

class AppTest {
    private val clients = listOf(NativeClient())

    @Test 
    fun helloWorld() {
        NativeClient().get()

        assertNotNull("", "not null")
    }
}
