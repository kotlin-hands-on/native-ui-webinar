import SwiftUI
import Shared
import Kingfisher
import KMPNativeCoroutinesCore
import KMPNativeCoroutinesAsync

struct CountryRowView: View {

    @StateObject var viewModel: ViewModel = ViewModel()

    let isTop: Bool

    let action: (String, Weather) -> ()

    @State var country: Country

    var body: some View {
        VStack {
            CountryDetailsView(country: country)

            ForEach(country.capital, id: \.self) { capital in
                Button("\(capital) weather") {
                    viewModel.loadWeather(capitalName: capital,
                        lat: Double(country.capitalInfo!.latlng[0]),
                        long: Double(country.capitalInfo!.latlng[1]),
                        action: self.action)
                }
            }
        }
    }


    @MainActor
    class ViewModel: ObservableObject {

        let sdk: WeatherApi = WeatherApi()

        func loadWeather(capitalName: String, lat: Double, long: Double, action: @escaping (String, Weather) -> ()) {
            Task {
                let weather = try await asyncFunction(for: sdk.getWeather(lat: lat, long: long))
                action(capitalName, weather)
            }
        }
    }
}
