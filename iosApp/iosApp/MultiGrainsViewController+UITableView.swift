import Foundation
import UIKit

extension MultiGrainsViewController: UITableViewDelegate {
  func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
    let entry = grainList[indexPath.row]
    let current = api.isFavorite(id: entry.id)

    api.setFavorite(id: entry.id, value: !current)
    tableView.reloadRows(at: [indexPath], with: .automatic)
  }
}

extension MultiGrainsViewController: UITableViewDataSource {
  func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
    return grainList.count
  }

  func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
    let cell = tableView.dequeueReusableCell(withIdentifier: cellIdentifier, for: indexPath)
    let entry = grainList[indexPath.row]

    cell.textLabel?.text = entry.name

    cell.imageView?.image = nil
    api.getImage(url: entry.url ?? "", success: { image in
      DispatchQueue.main.async {
        cell.imageView?.image = image
        cell.setNeedsLayout()
      }
    }, failure: { error in
      print(error?.description() ?? "")
    })

    cell.accessoryType = api.isFavorite(id: entry.id) ? .checkmark : .none
    return cell
  }
}
