package com.unionbankph.hrxmobility.domain.usecase.user

import com.unionbankph.hrxmobility.UseCaseTest
import com.unionbankph.hrxmobility.data.params.LoginParams
import com.unionbankph.hrxmobility.domain.resp.LoginResp
import com.unionbankph.hrxmobility.domain.respository.FormRepository
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify

class LoginUseCaseTest : UseCaseTest() {

    @InjectMocks
    lateinit var loginUseCase: LoginUseCase

    @Mock
    lateinit var loginRepository: FormRepository

    @Mock
    lateinit var deviceRepository: DeviceRepository

    @Mock
    lateinit var profileRepository: ProfileRepository

    @Mock
    lateinit var saveProfileService: SaveProfileService

    @Before
    fun before() {
        given(loginRepository.login(any())).willReturn(Single.just(LoginResp("test", "token sample")))
    }

    @Test
    fun `should save token when login success`() {
        loginUseCase.buildObservable(LoginParams.createEmpty())
            .subscribe()

        verify(deviceRepository, times(1)).setToken("token sample")
    }

}