package weather

val weather = listOf<Weather>(
    Weather(
        base = "stations",
        clouds = Clouds(all = 2),
        cod = 200,
        coord = Coord(lon = 28.22, lat = -25.7),
        dt = 1691057210,
        id = 2013117,
        main = Main(
            feels_like = 14.07,
            humidity = 43,
            pressure = 1033,
            temp = 15.36,
            temp_max = 17.11,
            temp_min = 13.43
        ),
        name = "Sinoville",
        sys = Sys(
            country = "ZA",
            sunrise = 1691037871,
            sunset = 1691077324,
            type = 2,
            id = 2013117
        ),
        timezone = 7200,
        visibility = 10000,
        weather = listOf(
            WeatherX(
                id = 800,
                main = "Clear",
                description = "clear sky",
                icon = "01d"
            )
        ),
        wind = Wind(speed = 3.27, deg = 21, gust = 4.4)
    ),
    Weather(
        base = "stations",
        clouds = Clouds(all = 75),
        cod = 200,
        coord = Coord(lon = 55.67, lat = 12.56),
        dt = 1691058335,
        id = 2618425,
        main = Main(
            feels_like = 19.23,
            humidity = 83,
            pressure = 992,
            temp = 19.1,
            temp_max = 20.47,
            temp_min = 17.74,
        ),
        name = "Copenhagen",
        sys = Sys(
            country = "DK",
            sunrise = 1691032694,
            sunset = 1691090018,
            type = 2,
            id = 2035645
        ),
        timezone = 7200,
        visibility = 10000,
        weather = listOf(
            WeatherX(
                id = 803,
                main = "Clouds",
                description = "broken clouds",
                icon = "04d"
            )
        ),
        wind = Wind(speed = 4.12, deg = 190, gust = 0.0)
    )
)

fun getWeather(cityName: String, lat: Double, long: Double): Weather{
    return if(cityName == "Copenhagen"){
        weather[1]
    } else {
        weather[0]
    }
}

