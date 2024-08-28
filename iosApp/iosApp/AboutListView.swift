import SwiftUI
import shared

struct AboutListView: View {
    private struct RowItem: Hashable {
        let title:String
        let subTitle:String
    }
    private let items: [RowItem] = {
        let platform = Platform()
        platform.logSystemInfo()
        
        var result: [RowItem] = [
            .init(
                title: "Operating System",
                subTitle: "\(platform.osName) \(platform.osVersion)"
            ),
            .init(
                title: "Device",
                subTitle: "\(platform.deviceModel)"
            ),
            .init(
                title: "Density",
                subTitle: "\(platform.density)"
            )
        ]
        return result
    }()
    
    var body: some View {
        List{
            ForEach(items, id: \.self) { item in
                VStack(alignment: .leading, content: {
                    Text(item.title)
                        .font(.footnote)
                        .foregroundStyle(.secondary)
                    Text(item.subTitle)
                        .font(.body)
                        .foregroundStyle(.primary)
                        
                }
                )
                .padding(.vertical, 4)
            }
        }
    }
}

#Preview {
    AboutListView()
}