/**
 * @author Péter Ferenc Gyarmati
 * @id 11913446
 */

class StoreItem(_id: Int, _name: String, _value: Int) extends Artikel with Logger {
  override var id: Int = _id
  override var name: String = _name
  override var value: Int = _value
}
