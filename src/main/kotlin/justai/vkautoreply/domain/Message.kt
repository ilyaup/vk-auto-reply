package justai.vkautoreply.domain

import com.fasterxml.jackson.annotation.JsonProperty

data class Message(

    val text: String?,

    @JsonProperty("from_id")
    val fromId: Int
)