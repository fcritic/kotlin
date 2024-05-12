class Stack<T> {
    private var elements = mutableListOf<T>()

    fun push(item: T) {
        elements.add(item)
    }

    fun pop(): T? {
        return if (elements.isNotEmpty()) {
            elements.removeAt(elements.lastIndex)
        } else {
            return null
        }
    }

    fun isEmpty(): Boolean {
        return elements.isEmpty()
    }

    fun size(): Int {
        return elements.size
    }
}