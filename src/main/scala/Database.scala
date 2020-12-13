/**
 * @author Péter Ferenc Gyarmati
 * @id 11913446
 */

class Database extends Warenkorb with Logger {
  private var storedItems: Array[StoreItem] = Array()

  override def delete(id: Int): Array[StoreItem] = {
    storedItems = delete(id, storedItems)
    storedItems
  }

  def delete(id: Int, items: Array[StoreItem]): Array[StoreItem] = {
    val item: Option[StoreItem] = items.find(_.id == id)
    if (item.isDefined) {
      logAction("gelöscht", item.get.name)
      items.filterNot(_.id == id) // return all the items which do not have the supplied id
    } else {
      println(s"Id $id nicht gefunden")
      items // return the unmodified Array
    }
  }

  override def search(name: String): Array[StoreItem] = search(name, storedItems)

  def search(name: String, items: Array[StoreItem]): Array[StoreItem] = {
    val foundItems: Array[StoreItem] = items filter(_.name == name)
    if (foundItems.nonEmpty) {
      foundItems foreach(item => logAction("gefunden", item.name))
    } else {
      println(s"$name nicht gefunden")
    }
    foundItems
  }

  override def store(item: StoreItem): Array[StoreItem] = {
    storedItems = store(item, storedItems)
    storedItems
  }

  def store(item: StoreItem, items: Array[StoreItem]): Array[StoreItem] = {
    logAction("gespeichert", item.name)
    val updatedItems = items :+ item // appending to the end of items
    updatedItems
  }

  override def sumUp(): Int = storedItems.map(_.value).sum

}
