class TreeType(private var name: String, private var color: String, private var texture: String) {
    fun draw(canvas: String, x: Int, y: Int) {
        println("Canvas: $canvas($x, $y), tree type: $name, tree color: $color, texture: $texture")
    }

    fun getName(): String {
        return name
    }

    fun getColor(): String {
        return color
    }

    fun getTextrue(): String {
        return texture
    }
}

class Tree(private var x: Int, private var y: Int, treeType: TreeType) {
    var type: TreeType = treeType

    fun draw(canvas: String) {
        type.draw(canvas, x, y)
    }
}

object TreeFactory {
    var treeType: Array<TreeType?> = arrayOfNulls(20)
    var index: Int = 0

    fun getTreeType(name: String, color: String, texture: String): TreeType {
        for (keyType in treeType) {
            if (keyType != null) {
                if (keyType.getName() == name && keyType.getColor() == color && keyType.getTextrue() == texture) {
                    return keyType
                }
            }
        }

        val tempType: TreeType = TreeType(name, color, texture)
        if (index < 20) {
            treeType[index] = TreeType(name, color, texture)
            index++
        }
        return tempType
    }

    fun sizeOfType() {
        println("Size of type: $index")
    }
}

class Forest {
    private var trees: Array<Tree?> = arrayOfNulls(20)
    private var index: Int = 0

    fun plantTree(x: Int, y: Int, name: String, color: String, texture: String): Tree {
        val tempType: TreeType = TreeFactory.getTreeType(name, color, texture)
        val tempTree: Tree = Tree(x, y, tempType)

        if (index < 20) {
            trees[index] = tempTree
            index++
        }
        return tempTree
    }

    fun draw(canvas: String) {
        for (i in 0..index) {
            if (trees[i] != null)
                trees[i]?.draw("$canvas")
        }
    }
}

fun main() {
    val forest: Forest = Forest()

    forest.plantTree(2, 3, "Pine", "green", "texture1")
    TreeFactory.sizeOfType()
    forest.plantTree(21, 34, "Camphor Tree", "green", "texture2")
    TreeFactory.sizeOfType()
    forest.plantTree(31, 53, "Cherry Tree", "pink", "texture3")
    TreeFactory.sizeOfType()
    forest.draw("Canvas1")
    println()

    forest.plantTree(3, 12, "Pine", "green", "texture1")
    forest.plantTree(64, 54, "Pine", "green", "texture1")
    TreeFactory.sizeOfType()
    forest.draw("Canvas1")
}