import com.raquo.laminar.api.L._
import org.scalajs.dom
import io.circe.generic.auto._

object Channels {
  val commando = new Commando(
    "02c16cca44562b590dd279c942200bdccfd4f990c3a69fad620c10ef2f8228eaff",
    "ws://107.189.30.195:9739",
    "FEiKzBTLSKeoIwQuMENgcKpNyVfhTz-NLutrSVlelHw9MyZtZXRob2RebGlzdHxtZXRob2ReZ2V0fG1ldGhvZD1zdW1tYXJ5Jm1ldGhvZC9saXN0ZGF0YXN0b3Jl"
  )

  val channels: Signal[List[ChannelFunds]] = EventStream
    .periodic(20000)
    .flatMap(_ => EventStream.fromFuture(commando.rpc("listfunds")))
    .map(_.as[ListFundsResult].toOption.get.channels)
    .toSignal(List.empty)

  def render(): HtmlElement =
    table(
      thead(),
      tbody(
        children <-- channels.map(_.map(_.render()))
      )
    )
}
