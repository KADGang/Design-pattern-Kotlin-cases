interface Builder {
    fun reset()
    fun setSeats(number: Int)
    fun setEngine(engineName: String)
    fun setTripComputer(computerName: String)
    fun setGPS(GPSName: String)
}

class Car {
    var seats: Int = 1
    var engine: String = "Primary Engine"
    var tripComputer: String = "Primary TripComputer"
    var GPS: String = "Primary GPS"

    public fun printMessage() {
        println("Car")
        println("Seats: $seats")
        println("Engine: $engine")
        println("TripComputer: $tripComputer")
        println("GPS: $GPS")
    }
}

class Manual {
    var seats: Int = 1
    var engine: String = "Primary Engine"
    var tripComputer: String = "Primary TripComputer"
    var GPS: String = "Primary GPS"

    public fun printMessage() {
        println("Car Manual")
        println("This car has $seats seats.")
        println("This car has a $engine")
        println("This car has a $tripComputer")
        println("This car has a $GPS")
    }
}

class CarBuilder: Builder {
    private var car: Car = Car()

    override fun reset() {
        car.seats = 1
        car.engine = "Primary Engine"
        car.tripComputer = "Primary TripComputer"
        car.GPS = "Primary GPS"
    }

    override fun setSeats(number: Int) {
        car.seats = number
    }

    override fun setEngine(engineName: String) {
        car.engine = engineName
    }

    override fun setTripComputer(computerName: String) {
        car.tripComputer = computerName
    }

    override fun setGPS(GPSName: String) {
        car.GPS = GPSName
    }

    fun getResult(): Car {
        return car
    }
}

class CarManualBuilder: Builder {
    private var manual: Manual = Manual()

    override fun reset() {
        manual.seats = 1
        manual.engine = "Primary Engine"
        manual.tripComputer = "Primary TripComputer"
        manual.GPS = "Primary GPS"
    }

    override fun setSeats(number: Int) {
        manual.seats = number
    }

    override fun setEngine(engineName: String) {
        manual.engine = engineName
    }

    override fun setTripComputer(computerName: String) {
        manual.tripComputer = computerName
    }

    override fun setGPS(GPSName: String) {
        manual.GPS = GPSName
    }

    fun getResult(): Manual {
        return manual
    }
}

class Director {
    var carBuilder: CarBuilder = CarBuilder()
    var manualBuilder: CarManualBuilder = CarManualBuilder()

    fun makeSUV(): Car {
        carBuilder.reset()
        carBuilder.setSeats(6)
        carBuilder.setEngine("SUV Engine")
        carBuilder.setTripComputer("Upscale computer")
        carBuilder.setGPS("Upscale computer")
        return carBuilder.getResult()
    }

    fun makeSportCar(): Car {
        carBuilder.reset()
        carBuilder.setSeats(2)
        carBuilder.setEngine("Sport Engine")
        carBuilder.setTripComputer("Top-level computer")
        carBuilder.setGPS("Top-level computer")
        return carBuilder.getResult()
    }

    fun makeSUVManual(): Manual {
        manualBuilder.reset()
        manualBuilder.setSeats(6)
        manualBuilder.setEngine("SUV Engine")
        manualBuilder.setTripComputer("Upscale computer")
        manualBuilder.setGPS("Upscale computer")
        return manualBuilder.getResult()
    }

    fun makeSportCarManual(): Manual {
        manualBuilder.reset()
        manualBuilder.setSeats(2)
        manualBuilder.setEngine("Sport Engine")
        manualBuilder.setTripComputer("Top-level computer")
        manualBuilder.setGPS("Top-level computer")
        return manualBuilder.getResult()
    }
}

class Cilent {
    var director: Director = Director()

    fun start() {
        director.makeSUV().printMessage()
        println()
        director.makeSUVManual().printMessage()
        println()
        director.makeSportCar().printMessage()
        println()
        director.makeSportCarManual().printMessage()
    }
}

fun main() {
    val cilent: Cilent = Cilent()

    cilent.start()
}