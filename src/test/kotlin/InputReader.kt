class InputReader {
    companion object {
        fun readLines(path: String) =
            this::class.java.classLoader.getResourceAsStream(path)?.bufferedReader()?.readLines() ?: listOf()

        fun readText(path: String) =
            this::class.java.classLoader.getResource(path)?.readText() ?: ""
    }
}