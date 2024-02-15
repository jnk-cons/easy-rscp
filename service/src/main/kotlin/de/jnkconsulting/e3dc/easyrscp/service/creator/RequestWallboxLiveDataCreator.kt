package de.jnkconsulting.e3dc.easyrscp.service.creator


import de.jnkconsulting.e3dc.easyrscp.api.frame.Frame
import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.WBTag
import de.jnkconsulting.e3dc.easyrscp.frame.DataBuilder
import de.jnkconsulting.e3dc.easyrscp.frame.FrameBuilder

/**
 * [de.jnkconsulting.e3dc.easyrscp.api.frame.Frame] generator to request livedata from the connected wallbozes
 *
 * @since 2.3
 */
class RequestWallboxLiveDataCreator: FrameCreator<List<Int>> {

    override fun invoke(ids: List<Int>): Frame =
        ids.map {
            DataBuilder().tag(WBTag.REQ_DATA).container(
                DataBuilder().tag(WBTag.INDEX).uchar8(it.toByte()).build(),
                DataBuilder().tag(WBTag.REQ_EXTERN_DATA_SUN).build(),
                DataBuilder().tag(WBTag.REQ_EXTERN_DATA_ALL).build(),
            ).build()
        }.let {
            FrameBuilder()
                .addData(it)
                .build()
        }
}
