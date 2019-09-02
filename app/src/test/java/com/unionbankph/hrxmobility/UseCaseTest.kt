package com.unionbankph.hrxmobility

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.unionbankph.hrxmobility.domain.common.executor.PostExecutionThread
import org.junit.Rule
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule

open class UseCaseTest {

    fun <T> any(): T {
        Mockito.any<T>()
        return uninitialized()
    }

    fun <T> uninitialized(): T = null as T

    @Mock
    lateinit var postExecutionThread: PostExecutionThread

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @get:Rule
    val mMockitoRule: MockitoRule = MockitoJUnit.rule()

    @get:Rule
    val mRxRule = RxTestSchedulerRule()
}