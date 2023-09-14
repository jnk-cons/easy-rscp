package de.jnkconsulting.e3dc.easyrscp.service.creator

import de.jnkconsulting.e3dc.easyrscp.api.frame.Frame

/**
 * Definition of a frame creator object that creates a frame from a given information that can be sent to the home power plant.
 *
 * @param S Type of information needed to create the frame
 *
 * @since 2.0
 */
interface FrameCreator<S> : (S) -> (Frame)
