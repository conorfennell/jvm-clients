package com.idiomcentric.jvm.clients

import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.BenchmarkMode
import org.openjdk.jmh.annotations.Fork
import org.openjdk.jmh.annotations.Level
import org.openjdk.jmh.annotations.Measurement
import org.openjdk.jmh.annotations.Mode
import org.openjdk.jmh.annotations.OutputTimeUnit
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.Setup
import org.openjdk.jmh.annotations.State
import org.openjdk.jmh.annotations.Threads
import org.openjdk.jmh.annotations.Warmup
import java.time.Instant
import java.util.Random
import java.util.concurrent.TimeUnit
import kotlin.math.abs

@State(Scope.Benchmark)
@Threads(1)
open class ClientBenchmark {

    @Setup(Level.Invocation)
    @Throws(Exception::class)
    fun setupInvokation() {
        // executed before each invocation of the benchmark
    }

    @Setup(Level.Iteration)
    @Throws(Exception::class)
    fun setupIteration() {
        // executed before each invocation of the iteration
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 10, warmups = 2)
    @Warmup(iterations = 0)
    @Measurement(batchSize = 2, iterations = 2, time = 1, timeUnit = TimeUnit.MILLISECONDS)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Throws(Exception::class)
    fun client() {
        println("HELLO ${Instant.now()}")
        NativeClient().get("https://pobail.idiomcentric.com/health")
    }
}