package justai.vkautoreply.domain

enum class EventType {

    CONFIRMATION, MESSAGE_NEW;

    companion object {

        fun getFromString(string: String): EventType {
            return EventType.valueOf(string.uppercase())
        }
    }
}