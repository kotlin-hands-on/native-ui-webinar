import SwiftUI
import Shared
import Kingfisher

struct CountryDetailsView: View {
    @State var country: Country
    
    var body: some View {
        HStack(alignment: .center, spacing: 0) {
            KFImage
                .url(URL(string: country.flags.png))
                .setProcessor(DownsamplingImageProcessor(size: CGSizeMake(75.0, 75.0)))
                .frame(width: 75, alignment: .top)
                .border(Color.gray)
                .padding(15)
            VStack(alignment: .leading) {
                Text(country.name.common).font(.body).fontWeight(.bold)
                Text(country.name.official).font(.caption)
            }.frame(alignment: .bottom)
        }.frame(maxWidth: .infinity, alignment: .leading)
    }
}