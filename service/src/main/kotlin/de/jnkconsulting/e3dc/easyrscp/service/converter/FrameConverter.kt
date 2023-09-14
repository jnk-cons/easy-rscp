package de.jnkconsulting.e3dc.easyrscp.service.converter

import de.jnkconsulting.e3dc.easyrscp.api.frame.Frame

/**
 * Definition of a frame converter, which converts the frame data into another object
 *
 * @param R Data type into which the frame is converted
 *
 * @since 2.0
 */
interface FrameConverter<R> : (Frame) -> R

/**
 * Definition of a frame converter, which converts the frame data into another object.
 * The first frame parameter is the requestFrame the second the response frame
 *
 * @param R Data type into which the frame is converted
 *
 * @since 2.0
 */
interface RequestResponseFrameConvert<R>: (Frame, Frame) -> R
