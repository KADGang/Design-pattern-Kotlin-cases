abstract class State(player: Player) {
    var player: Player = player

    abstract fun clickLock()
    abstract fun clickPlay()
    abstract fun clickNext()
    abstract fun clickPrevious()
}

class ReadyState(player: Player) : State(player) {
    override fun clickLock() {
        println("Player locked.")
        player.changeState(LockedState(player))
    }

    override fun clickPlay() {
        println("Player playing.")
        player.playing = true
        player.changeState(ReadyState(player))
    }

    override fun clickNext() {
        player.nextSong()
    }

    override fun clickPrevious() {
        player.previousSong()
    }
}

class PlayingState(player: Player) : State(player) {
    override fun clickLock() {
        println("Player locked.")
        player.changeState(LockedState(player))
    }

    override fun clickPlay() {
        println("Player pause.")
        player.playing = false
        player.changeState(ReadyState(player))
    }

    override fun clickNext() {
        player.nextSong()
    }

    override fun clickPrevious() {
        player.previousSong()
    }
}

class LockedState(player: Player) : State(player) {
    override fun clickLock() {
        println("Player unlocked.")
        if (player.playing)
            player.changeState(PlayingState(player))
        else
            player.changeState(ReadyState(player))
    }

    override fun clickPlay() {
        println("Player has been locked.")
    }
    override fun clickNext() {
        println("Player has been locked.")
    }
    override fun clickPrevious() {
        println("Player has been locked.")
    }
}

class Player {
    var playing: Boolean = false
    var state: State = ReadyState(this)

    fun changeState(state: State) {
        this.state = state
    }

    fun clickLock() {
        state.clickLock()
    }

    fun clickPlay() {
        state.clickPlay()
    }

    fun clickNext() {
        state.clickNext()
    }

    fun clickPrevious() {
        state.clickPrevious()
    }

    fun nextSong() {
        playing = true
        changeState(PlayingState(this))
        println("Playing next song...")
    }

    fun previousSong() {
        changeState(PlayingState(this))
        println("Playing previous song...")
    }
}

fun main() {
    val player: Player = Player()

    player.clickPlay()
    player.clickNext()
    player.clickPrevious()
    player.clickPlay()
    player.clickLock()

    player.clickPlay()
    player.clickNext()
    player.clickPrevious()
    player.clickLock()

    player.clickPlay()
    player.clickNext()
    player.clickPrevious()
}