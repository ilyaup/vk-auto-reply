package justai.vkautoreply.service

import justai.vkautoreply.client.MessageSendClient
import justai.vkautoreply.domain.Event
import justai.vkautoreply.domain.MessageEventObject
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class MirrorResponseService(

    val messageSendClient: MessageSendClient,

    @Value("\${vkApi.okResponseBody}")
    private val okResponse: String
) : EventHandlerService {

    override fun handle(event: Event): String {
        val eventObject: MessageEventObject? = event.eventObject
        if (eventObject?.message?.fromId != null) {
            messageSendClient.sendMirroredMessage(eventObject.message.text ?: "", eventObject.message.fromId)
        }
        return okResponse
    }
}