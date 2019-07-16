package hr.ferit.igorkuridza.factorynewsreader.common

fun convertCodeToMessage(code: Int): String {
    return when(code){
        SERVER_ERROR -> "Server error!"
        SERVICE_UNAVAILABLE -> "Service unavailable!"
        else -> "Unknown error!"
    }
}