package justai.vkautoreply.service

import justai.vkautoreply.domain.Event

interface EventHandlerService {

    fun handle(event: Event): String
}