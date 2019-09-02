package com.unionbankph.hrxmobility.domain.service

import com.unionbankph.hrxmobility.UseCaseTest
import com.unionbankph.hrxmobility.domain.resp.profile.profile.EmployeeProfileResp
import com.unionbankph.hrxmobility.domain.respository.enums.Roles
import com.unionbankph.hrxmobility.domain.utility.RoleUtility
import io.reactivex.Single
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify

class SaveProfileServiceTest : UseCaseTest() {

    @InjectMocks
    lateinit var saveProfileService: SaveProfileService

    @Mock
    lateinit var profileRepository: ProfileRepository

    @Mock
    lateinit var deviceRepository: DeviceRepository

    @Before
    fun before(){
        val sampleProfile = EmployeeProfileResp(
            id = 1,
            firstName = "sample firstname",
            lastName = "sample lastname",
            workScheduleDays = "[1,2,3,4]",
            isLineManager = true
            )

        given(profileRepository.getProfileByToken()).willReturn(Single.just(sampleProfile))

        saveProfileService.save()
            .subscribe()
    }

    @Test
    fun `should save id`() {
        verify(deviceRepository, times(1)).setId("1")
    }

    @Test
    fun `should save username`() {
        verify(deviceRepository, times(1)).setUserName("sample firstname sample lastname")
    }

    @Test
    fun `should save workschedule`() {
        verify(deviceRepository, times(1)).setWorkSchedule("[1,2,3,4]")
    }

    @Test
    fun `should save role`() {
        verify(deviceRepository, times(1)).setRole(RoleUtility.getRole(true))
    }

    @Test
    fun `should return true if line manager`(){
        val sampleProfile = EmployeeProfileResp(
            id = 1,
            firstName = "sample firstname",
            lastName = "sample lastname",
            workScheduleDays = "[1,2,3,4]",
            isLineManager = true
        )

        given(profileRepository.getProfileByToken()).willReturn(Single.just(sampleProfile))

        saveProfileService.save()
            .subscribe()

        assertTrue(deviceRepository.getRole() == Roles.LINE_MANAGER)
    }

}