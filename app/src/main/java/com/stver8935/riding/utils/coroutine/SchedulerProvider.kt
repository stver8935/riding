package com.stver8935.riding.utils.coroutine

import kotlinx.coroutines.CoroutineDispatcher

interface SchedulerProvider {
    /***
     * Cpu 연산 작업이 많이 필요한 스레드 관리하는 디스패쳐
     */
    fun computation(): CoroutineDispatcher

    /***
     * 네트워크 통신 및 데이터 입출력 관련 디스패처
     */
    fun io(): CoroutineDispatcher

    /**
     * UI 작업 관련 디스패쳐
     */
    fun ui(): CoroutineDispatcher
}