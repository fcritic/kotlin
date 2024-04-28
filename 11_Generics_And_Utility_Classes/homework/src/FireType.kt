sealed class FireType {
    object Single : FireType()
    data class Queue(val sizeQueue: Int) : FireType()
}