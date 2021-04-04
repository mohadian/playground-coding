package com.mohadian

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class LonelySeatTest {
    val bestSeat = LonelySeat()

    @Test
    fun findBestSeat_shouldReturnBestSeat_whenSample1() {
        val bestSeat = bestSeat.findBestSeat(listOf(1, 0, 0, 0, 1))
        assertThat(bestSeat).isEqualTo(2)
    }

    @Test
    fun findBestSeat_shouldReturnBestSeat_whenSample2() {
        val bestSeat = bestSeat.findBestSeat(listOf(1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1))
        assertThat(bestSeat).isEqualTo(8)
    }

    @Test
    fun findBestSeat_shouldReturnBestSeat_whenSample3() {
        val bestSeat = bestSeat.findBestSeat(listOf(1, 0, 1, 0, 0, 0, 0, 1))
        assertThat(bestSeat).isEqualTo(4)
    }

    @Test
    fun findBestSeat_shouldReturnBestSeat_whenSample4() {
        val bestSeat = bestSeat.findBestSeat(listOf(1, 0, 1, 0, 0, 1))
        assertThat(bestSeat).isEqualTo(3)
    }

    @Test
    fun findBestSeat_shouldReturnBestSeat_whenSample5() {
        val bestSeat = bestSeat.findBestSeat(listOf(1, 0, 1, 0, 1))
        assertThat(bestSeat).isEqualTo(1)
    }

    @Test
    fun findBestSeat_shouldReturnBestSeat_whenSample6() {
        val bestSeat = bestSeat.findBestSeat(listOf(1, 1, 1, 0, 1))
        assertThat(bestSeat).isEqualTo(3)
    }

    @Test
    fun findBestSeat_shouldReturnBestSeat_whenSample7() {
        val bestSeat = bestSeat.findBestSeat(listOf(1, 1, 1, 1, 1))
        assertThat(bestSeat).isEqualTo(-1)
    }

    @Test
    fun findBestSeat_shouldReturnBestSeat_whenSample8() {
        val bestSeat = bestSeat.findBestSeat(listOf(0, 0, 0, 1, 0, 0, 0, 1))
        assertThat(bestSeat).isEqualTo(0)
    }

    @Test
    fun findBestSeat_shouldReturnBestSeat_whenSample9() {
        val bestSeat = bestSeat.findBestSeat(listOf(1, 0, 0, 0, 1, 0, 0, 0))
        assertThat(bestSeat).isEqualTo(7)
    }

    @Test
    fun findBestSeat_shouldReturnBestSeat_whenSample10() {
        val bestSeat = bestSeat.findBestSeat(listOf(0, 0, 0, 0, 0))
        assertThat(bestSeat).isEqualTo(0)
    }

    @Test
    fun findBestSeat_shouldReturnBestSeat_whenSample11() {
        val bestSeat = bestSeat.findBestSeat(listOf(0, 0, 0, 1, 0, 0, 0, 0, 0, 1))
        assertThat(bestSeat).isEqualTo(0)
    }

    @Test
    fun findBestSeat_shouldReturnBestSeat_whenSample12() {
        val bestSeat = bestSeat.findBestSeat(listOf(1, 0, 0, 0, 0, 0, 1, 0, 0, 0))
        assertThat(bestSeat).isEqualTo(9)
    }
}
