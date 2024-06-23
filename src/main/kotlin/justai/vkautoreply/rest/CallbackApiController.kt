package justai.vkautoreply.rest

import justai.vkautoreply.domain.Event
import justai.vkautoreply.domain.EventType
import justai.vkautoreply.service.ConfirmationService
import justai.vkautoreply.service.MirrorResponseService
import justai.vkautoreply.service.ReturnOkService
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/bot")
class CallbackApiController(

    confirmationService: ConfirmationService,

    mirrorResponseService: MirrorResponseService,

    private val returnOkService: ReturnOkService,

    @Value("\${vkApi.okResponseBody}")
    private val okResponse: String
) {

    val eventTypeToEventHandlerService = mapOf(
        EventType.CONFIRMATION to confirmationService,
        EventType.MESSAGE_NEW to mirrorResponseService,
    )

    @PostMapping
    fun responseToEvent(@RequestBody event: Event): String {
        return try {
            eventTypeToEventHandlerService
                .getOrDefault(EventType.getFromString(event.type ?: ""), returnOkService)
                .handle(event)
        } catch (e: IllegalArgumentException) { // No such event type. Exception is thrown by EventType.getFromString.
            okResponse
        }
    }
}