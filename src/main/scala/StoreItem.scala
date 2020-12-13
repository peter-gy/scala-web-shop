/**
 * @author Péter Ferenc Gyarmati
 * @id 11913446
 */

class StoreItem(id_ : Int, name_ : String, value_ : Int) extends Artikel with Logger {
  override var id: Int = id_
  override var name: String = name_
  override var value: Int = value_
}
