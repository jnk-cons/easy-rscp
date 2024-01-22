package de.jnkconsulting.e3dc.easyrscp.service.creator

import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.BatTag
import de.jnkconsulting.e3dc.easyrscp.frame.DataBuilder
import de.jnkconsulting.e3dc.easyrscp.frame.FrameBuilder

class DCBInfoRequestCreator : FrameCreator<Pair<Int, Int>>{

    override fun invoke(indexes: Pair<Int, Int>) =
        FrameBuilder()
            .addData(
                DataBuilder().tag(BatTag.REQ_DATA).container(
                    DataBuilder().tag(BatTag.INDEX).uint16(indexes.first.toShort()).build(),
                    DataBuilder().tag(BatTag.REQ_DCB_INFO).uint16(indexes.second.toShort()).build(),
                    DataBuilder().tag(BatTag.REQ_DCB_ALL_CELL_TEMPERATURES).build(),
                    DataBuilder().tag(BatTag.REQ_DCB_ALL_CELL_VOLTAGES).build(),
                ).build()
            ).build()
}
