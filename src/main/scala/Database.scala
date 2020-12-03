/**
 * @author Péter Ferenc Gyarmati
 * @id 11913446
 */

class Database extends Warenkorb with Logger {

  private var storedItems: Array[StoreItem] = Array()

  override def delete(id: Int): Array[StoreItem] = {
    val item: Option[StoreItem] = storedItems.find(_.id == id)
    if (item.isDefined) {
      logAction("gelöscht", item.get.name)
      storedItems = storedItems.filterNot(_.id == id)
    } else {
      println(s"Id $id nicht gefunden")
    }
    storedItems
  }

  override def search(name: String): Array[StoreItem] = {
    val foundItems: Array[StoreItem] = storedItems.filter(_.name == name)
    if (foundItems.nonEmpty) {
      for (i <- 1 to foundItems.length) logAction("gefunden", name)
    } else {
      println(s"$name nicht gefunden")
    }
    foundItems
  }

  override def store(item: StoreItem): Array[StoreItem] = {
    logAction("gespeichert", item.name)
    storedItems = storedItems :+ item
    storedItems
  }

  override def sumUp(): Int = {
    val res: Int = storedItems.map(_.value).sum
    println(res)
    res
  }
}
