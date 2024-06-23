package justai.vkautoreply.client

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.client.RestClient
import org.springframework.web.util.UriComponentsBuilder

@Service
class MessageSendClient(

    @Value("\${vkApi.messageSendMethodUri}")
    private val messageSendMethodUri: String,

    @Value("\${vkApi.accessToken}")
    private val accessToken: String,

    @Value("\${vkApi.apiVersion}")
    private val apiVersion: String,

    @Value("\${vkApi.randomId}")
    private val randomId: Int
) {

    fun sendMirroredMessage(message: String, peerId: Int) {
        val defaultClient = RestClient.create()
        val uri = UriComponentsBuilder.fromUriString("$messageSendMethodUri?")
            .queryParam("peer_id", peerId)
            .queryParam("message", "Вы сказали: $message")
            .queryParam("access_token", accessToken)
            .queryParam("v", apiVersion)
            .queryParam("random_id", randomId)
            .build()
            .toUri()
        defaultClient.get().uri(uri).retrieve()
    }
}