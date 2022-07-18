import com.raquo.laminar.api.L._
import org.scalajs.dom

object Main {
  val app = div(
    h1("tupan"),
    Channels.render()
  )

  def main(args: Array[String]): Unit = {
    documentEvents.onDomContentLoaded.foreach { _ =>
      render(dom.document.getElementById("main"), app)
    }(unsafeWindowOwner)
  }
}
