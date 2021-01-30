interface Device {
    fun isEnabled(): Boolean
    fun enable()
    fun disable()
    fun getVolume(): Int
    fun setVolume(percent: Int)
    fun getChannel(): Int
    fun setChannel(channel: Int)
}

class Radio: Device {
    private var power: Boolean = false
    private var vol: Int = 0
    private var deviceChannel: Int = 0

    fun displayMsg() {
        println("Radio")
        println("volume: $vol")
        println("channel: $deviceChannel")
        println()
    }

    override fun isEnabled(): Boolean {
        return power
    }

    override fun enable() {
        power = true
    }

    override fun disable() {
        power = false
    }

    override fun getVolume(): Int {
        return vol
    }

    override fun setVolume(percent: Int) {
        vol = percent
    }

    override fun getChannel(): Int {
        return deviceChannel
    }

    override fun setChannel(channel: Int) {
        deviceChannel = channel
    }
}

class TV: Device {
    private var power = false
    private var vol: Int = 0
    private var deviceChannel: Int = 0

    fun displayMsg() {
        println("TV")
        println("volume: $vol")
        println("channel: $deviceChannel")
        println()
    }

    override fun isEnabled(): Boolean {
        return power
    }

    override fun enable() {
        power = true
    }

    override fun disable() {
        power = false
    }

    override fun getVolume(): Int {
        return vol
    }

    override fun setVolume(percent: Int) {
        vol = percent
    }

    override fun getChannel(): Int {
        return deviceChannel
    }

    override fun setChannel(channel: Int) {
        deviceChannel = channel
    }
}

open class Remote(d: Device) {
    protected var device: Device = d

    fun togglePower() {
        if (device.isEnabled())
            device.disable()
        else
            device.enable()
    }

    fun volumeDown() {
        device.setVolume(device.getVolume() - 1)
    }

    fun volumeUp() {
        device.setVolume(device.getVolume() + 1)
    }

    fun channelDown() {
        device.setChannel(device.getChannel() - 1)
    }

    fun channelUp() {
        device.setChannel(device.getChannel() + 1)
    }
}

class AdvancedRemote(d: Device) : Remote(d) {
    var savedVol: Int = device.getVolume()

    fun mute() {
        savedVol = device.getVolume()
        device.setVolume(0)
    }

    fun cancleMute() {
        device.setVolume(savedVol)
    }
}

fun main() {
    val tv: TV = TV()
    val tvRemote: Remote = Remote(tv)
    tv.displayMsg()

    tvRemote.channelUp()
    tvRemote.volumeUp()
    tv.displayMsg()

    val radio: Radio = Radio()
    val radioRemote: AdvancedRemote = AdvancedRemote(radio)
    radio.displayMsg()

    radioRemote.channelUp()
    radioRemote.volumeUp()
    radioRemote.volumeUp()
    radioRemote.volumeUp()
    radioRemote.volumeUp()
    radio.displayMsg()

    radioRemote.mute()
    radio.displayMsg()

    radioRemote.cancleMute()
    radio.displayMsg()
}