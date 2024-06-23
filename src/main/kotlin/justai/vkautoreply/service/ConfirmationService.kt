package justai.vkautoreply.service

import justai.vkautoreply.domain.Event
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class ConfirmationService(

    @Value("\${vkApi.confirmationToken}")
    private val confirmationToken: String
) : EventHandlerService {

    override fun handle(event: Event): String {
        return confirmationToken
    }
}