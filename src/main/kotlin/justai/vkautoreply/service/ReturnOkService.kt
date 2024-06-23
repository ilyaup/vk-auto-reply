package justai.vkautoreply.service

import justai.vkautoreply.domain.Event
import lombok.Getter
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
@Getter
class ReturnOkService(

    @Value("\${vkApi.okResponseBody}")
    private val okResponse: String
) : EventHandlerService {

    override fun handle(event: Event): String {
        return okResponse
    }
}