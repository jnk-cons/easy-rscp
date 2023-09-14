package de.jnkconsulting.e3dc.easyrscp.service

import de.jnkconsulting.e3dc.easyrscp.connection.RSCPAnswerParsedEvent
import de.jnkconsulting.e3dc.easyrscp.connection.RSCPBeforeRequestEncryptionEvent
import de.jnkconsulting.e3dc.easyrscp.connection.RSCPRequestResponseListener
import de.jnkconsulting.e3dc.easyrscp.service.converter.StringFrameConverter

class PrintRequestAndAnswerFrameListener: RSCPRequestResponseListener {
    private val formatFrameToString = StringFrameConverter()

    override fun onBeforeRequestFrameEncryption(event: RSCPBeforeRequestEncryptionEvent) {
        println("REQUEST ->")
        println(formatFrameToString(event.requestFrame))
        println("<- REQUEST")
    }

    override fun onAnswerParsed(event: RSCPAnswerParsedEvent) {
        println("RESPONSE ->")
        println(formatFrameToString(event.answerFrame))
        println("<- RESPONSE")
    }

}
