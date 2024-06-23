package justai.vkautoreply.domain

import com.fasterxml.jackson.annotation.JsonProperty

data class Event(

    val type: String?,

    @JsonProperty("event_id")
    val eventId: String?, // NOTE: насчёт лонга неуверен

    val v: String?,

    @JsonProperty("object")
    val eventObject: MessageEventObject?,

    @JsonProperty("group_id")
    val groupId: String?
)