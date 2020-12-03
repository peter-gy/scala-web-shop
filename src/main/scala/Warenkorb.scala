/**
 * @author Péter Ferenc Gyarmati
 * @id 11913446
 */

trait Warenkorb {
  def delete(id: Int): Array[StoreItem]
  def search(name: String): Array[StoreItem]
  def store(item: StoreItem): Array[StoreItem]
  def sumUp(): Int
}
