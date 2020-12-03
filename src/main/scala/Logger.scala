/**
 * @author Péter Ferenc Gyarmati
 * @id 11913446
 */

trait Logger {
  def logAction(actionName: String, name: String): Unit = println(s"$name $actionName")
}
