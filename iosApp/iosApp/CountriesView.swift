import SwiftUI
import Shared
import KMPNativeCoroutinesCore
import KMPNativeCoroutinesAsync

struct CountriesView: View {

    enum LoadableCountry {
        case loading
        case result([Country])
        case error(String)
    }

    @ObservedObject private(set) var viewModel: ViewModel = ViewModel()

    let action: (String, Weather) -> ()

    init(action: @escaping (String, Weather) -> ()) {
        self.action = action
    }

    var body: some View {
        switch viewModel.loadableCountries {
        case .loading:
            return AnyView(Text("Loading...").multilineTextAlignment(.center))
        case .result(let countries):
            return AnyView(List(countries.indices) { index in
                CardView(isTop: index == 0, action: self.action, country: countries[index])
            })
        case .error(let description):
            return AnyView(Text(description).multilineTextAlignment(.center))
        }
    }

    @MainActor
    class ViewModel: ObservableObject {

        @Published var loadableCountries = LoadableCountry.loading

        let sdk: CountrySDK = CountrySDK()

        init() {
            self.loadCountries()
        }

        func loadCountries() {
            Task {
                do {
                    self.loadableCountries = .loading
                    let countries = try await asyncFunction(for: sdk.getCountries())
                    self.loadableCountries = .result(countries)
                } catch {
                    self.loadableCountries = .error(error.localizedDescription)
                }
            }
        }
    }
}
