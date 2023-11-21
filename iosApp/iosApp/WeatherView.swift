import SwiftUI
import Shared
import Kingfisher

struct WeatherView: View {

    let capitalName: String

    let details: Weather

    let action: () -> ()

    init(capitalName: String, details: Weather, action: @escaping () -> ()) {
        self.capitalName = capitalName
        self.details = details
        self.action = action
    }

    var body: some View {
        ZStack {
            RoundedRectangle(cornerRadius: 25, style: .continuous)
                .fill(.white)
                .shadow(radius: 10)
            VStack {
                Button("Back") {
                    action()
                }.frame(width: 300, alignment: .leading).padding(20)
                Text(capitalName).font(.title)
                KFImage(URL(string: "https://openweathermap.org/img/wn/\(details.weather[0].icon)@2x.png")!)
                Text("Feels like: \(details.main.feels_like)'C / \(CelsiusToFahrenheitKt.celsiusToFahrenheit(celcius: details.main.feels_like))'F" ).frame(width: 300, alignment: .leading).padding(5)
                Text("Temp: \(details.main.temp)'C / \(CelsiusToFahrenheitKt.celsiusToFahrenheit(celcius: details.main.temp))'F").frame(width: 300, alignment: .leading).padding(EdgeInsets(top: 5, leading: 5, bottom: 15, trailing: 5))
            }
        }.frame(width: 300, height: 300)
    }
}