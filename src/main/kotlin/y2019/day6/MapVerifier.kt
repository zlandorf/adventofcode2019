package y2019.day6

class MapVerifier {

    fun checksum(mapData: List<String>): Int {
        val root = nodeMap(mapData).values.first { it.parent == null }
        return checksum(root, 0)
    }

    private fun checksum(node: Node, depth: Int): Int {
        return node.children.sumBy { checksum(it, depth + 1) } + if (node.parent == null) 0 else depth
    }

    fun minimumTransferCount(mapData: List<String>, fromName: String, toName: String): Int {
        val nodeMap = nodeMap(mapData)
        val from = nodeMap[fromName] ?: throw NoSuchElementException()
        val to = nodeMap[toName] ?: throw NoSuchElementException()
        val root = nodeMap(mapData).values.first { it.parent == null }

        return minimumTransferCount(root, from, to) ?: 0
    }

    private fun minimumTransferCount(root: Node, from: Node, to: Node): Int? {
        val rootFromDistance = root.distance(from)
        val rootToDistance = root.distance(to)
        val minimumTransferCount = if (rootFromDistance != null && rootToDistance != null) {
            rootFromDistance + rootToDistance - 2
        } else null

        return root.children
            .map { minimumTransferCount(it, from, to) }
            .find { it != null } ?: minimumTransferCount
    }

    private fun nodeMap(mapData: List<String>): MutableMap<String, Node> {
        val nodeMap = mutableMapOf<String, Node>()
        mapData.forEach {
            val (parentName, childName) = it.split(")")
            val parent = nodeMap.getOrDefault(parentName, Node(parentName))
            val child = nodeMap.getOrDefault(childName, Node(childName))
            child.parent = parent
            parent.children.add(child)
            nodeMap[parentName] = parent
            nodeMap[childName] = child
        }
        return nodeMap
    }

    data class Node(val value: String, val children: MutableList<Node> = mutableListOf(), var parent: Node? = null) {
        fun distance(to: Node): Int? {
            return distance(to, 0)
        }

        private fun distance(to: Node, depth: Int): Int? {
            if (this.value == to.value) {
                return depth
            }

            return children.map { it.distance(to, depth + 1) }.find { it != null }
        }

    }

}
