package com.example.maks.postingvk.network

import android.util.Log
import com.vk.sdk.api.*
import com.vk.sdk.api.model.VKApiUser
import com.vk.sdk.api.model.VKList

class DataRepo {

    fun VkRequest() {
        val request = VKApi.users().get(VKParameters.from(VKApiConst.FIELDS, VKApiUser.FIELD_PHOTO_200))

        Log.wtf("qwe", request.toString())
        request.executeWithListener(object : VKRequest.VKRequestListener() {
            override fun onComplete(response: VKResponse?) {
                val user = (response!!.parsedModel as VKList<VKApiUser>)[0]
                //  val userMy = (response.json)  // создать дата класс к запросу, и дату пихать во вью
                val urlImage = user.photo_200
            }

            override fun onError(error: VKError?) {}
            override fun attemptFailed(request: VKRequest?, attemptNumber: Int, totalAttempts: Int) {}
        })
    }

    fun getGroup() {
        val requestGroup = VKApi.groups().get(VKParameters.from(VKApiConst.EXTENDED, 1, VKApiConst.COUNT, 10))
        Log.wtf("qwe", requestGroup.toString())
        requestGroup.executeWithListener(object : VKRequest.VKRequestListener() {
            override fun onComplete(response: VKResponse?) {
                val rr = response?.json
                Log.wtf("qwe", "rr response" + response?.json)

            }

            override fun onError(error: VKError?) {}
            override fun attemptFailed(request: VKRequest?, attemptNumber: Int, totalAttempts: Int) {}
        })
    }

    fun getDataFromGroup() {
        val requestGroup = VKApi.wall().get(VKParameters.from(VKApiConst.OWNER_ID, -31480508, VKApiConst.COUNT, 10, VKApiConst.EXTENDED, 1))//hardkoded Pikabu
        Log.wtf("qwe", requestGroup.toString())
        requestGroup.executeWithListener(object : VKRequest.VKRequestListener() {
            override fun onComplete(response: VKResponse?) {
                val rr = response?.json
                Log.wtf("qwe", "rr response" + response?.json)

            }

            override fun onError(error: VKError?) {}
            override fun attemptFailed(request: VKRequest?, attemptNumber: Int, totalAttempts: Int) {}
        })
    }
}