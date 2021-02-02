interface EventListener {
    fun update(filename: String)
    fun getName(): String
}

class EmailAlertsListener(email: String): EventListener {
    var email: String = email

    override fun update(filename: String) {
        println("已发送到email: $email(Msg: 有人打开了文件$filename)")
    }

    override fun getName(): String {
        return email
    }
}

class LogginListener(log_file: String): EventListener {
    var log: String = log_file

    override fun update(filename: String) {
        println("已写入日志文件: $log(Msg: 有人打开了文件$filename)")
    }

    override fun getName(): String {
        return log
    }
}

class EventManager {
    var listeners: Array<EventListener?> = arrayOfNulls(20)

    fun subscribe(listener: EventListener) {
        for (i in 0..20) {
            if (listeners[i] == null) {
                listeners[i] = listener
                break
            }
        }
    }

    fun unsubscribe(listener: EventListener) {
        for (i in 0..19) {
            if (listeners[i] != null) {
                if (listeners[i]?.getName() ?: "" == listener.getName()) {
                    listeners[i] = null
                }
            }
        }
    }

    fun notify(data: String) {
        for (tempListener in listeners) {
            tempListener?.update(data)
        }
    }
}

fun main() {
    var manager: EventManager = EventManager()

    manager.subscribe(EmailAlertsListener("abc@126.com"))
    manager.subscribe(EmailAlertsListener("def@126.com"))
    manager.subscribe(EmailAlertsListener("ghi@126.com"))
    manager.subscribe(LogginListener("x.log"))
    manager.subscribe(LogginListener("y.log"))
    manager.subscribe(LogginListener("z.log"))
    manager.notify("hahaha.exe")

    manager.unsubscribe(EmailAlertsListener("abc@126.com"))
    manager.unsubscribe(LogginListener("x.log"))
    manager.notify("xixixi.exe")
}