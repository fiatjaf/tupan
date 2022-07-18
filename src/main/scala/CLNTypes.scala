import com.raquo.laminar.api.L._

sealed trait CLNJson

case class CLightningAddress(`type`: String, `address`: String, port: Int)
    extends CLNJson

case class CLightningInfo(
    id: String,
    alias: String,
    color: String,
    num_peers: Int,
    num_pending_channels: Int,
    num_active_channels: Int,
    num_inactive_channels: Int,
    version: String,
    `lightning-dir`: String,
    blockheight: Int,
    network: String,
    fees_collected_msat: String,
    address: List[CLightningAddress],
    binding: List[CLightningAddress]
) extends CLNJson

case class Output(
    txid: String,
    output: Int,
    amount_msat: Long,
    scriptpubkey: String,
    status: String,
    reserved: Boolean,
    address: Option[String],
    redeemscript: Option[String],
    blockheight: Option[Long],
    reserved_to_block: Option[Long]
) extends CLNJson

case class ChannelFunds(
    peer_id: String,
    our_amount_msat: Long,
    amount_msat: Long,
    funding_txid: String,
    funding_output: Int,
    connected: Boolean,
    state: String,
    short_channel_id: Option[String]
) extends CLNJson {
  def render(): HtmlElement = tr(
    td(s"channel $short_channel_id"),
    td(s"$amount_msat")
  )
}

case class ListFundsResult(
    outputs: List[Output],
    channels: List[ChannelFunds]
) extends CLNJson

case class Channel(
    source: String,
    destination: String,
    short_channel_id: String,
    public: Boolean,
    amount_msat: Long,
    message_flags: Int,
    channel_flags: Int,
    active: Boolean,
    last_update: Long,
    base_fee_millisatoshi: Long,
    fee_per_millionth: Int,
    delay: Int
) extends CLNJson

case class ListChannelsResult(channels: List[Channel]) extends CLNJson

case class CLightningPeerChannel(
    state: String,
    opener: String,
    closer: Option[String],
    status: List[String],
    to_us_msat: Long,
    total_msat: Long,
    fee_base_msat: Long,
    fee_proportional_millionths: Long,
    features: List[String]
) extends CLNJson

case class CLightningPeer(
    id: String,
    connected: Boolean,
    features: String,
    netaddr: List[String],
    channels: List[CLightningPeerChannel]
) extends CLNJson

case class CLightningPeers(peers: List[CLightningPeer]) extends CLNJson
