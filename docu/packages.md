# Module easy-rscp

easy-rscp is an INOFFICIAL library written in Kotlin (fully Java compatible) for accessing E3DC home power plants.

E3DC is a brand of HagerEnergy Gmbh ([website](https://www.e3dc.com/)). I have nothing to do with the company, except that I own a home power plant from E3DC and wanted to include it in my SmartHome. This "desire" gave birth to easy-rscp. 

# Package de.jnkconsulting.e3dc.easyrscp.api.bytes

This package contains auxiliary classes and functions to work on the byte level of frames

# Package de.jnkconsulting.e3dc.easyrscp.api.connection

Here are classes and interfaces that are needed for the connection establishment.

# Package de.jnkconsulting.e3dc.easyrscp.api.crypt

Includes interfaces for frame encryption

# Package de.jnkconsulting.e3dc.easyrscp.api.frame

Classes and interfaces representing frames and data are located here

# Package de.jnkconsulting.e3dc.easyrscp.api.frame.tags

All known RSCP tags can be found in different enum classes in this package

# Package de.jnkconsulting.e3dc.easyrscp.api.service

Here are the high-level definitions of the services, which can be used without better RSCP knowledge

# Package de.jnkconsulting.e3dc.easyrscp.api.service.model

Model classes for the services are defined here

# Package de.jnkconsulting.e3dc.easyrscp.connection

Basically you can find the class that implements the interfaces from the API package de.jnkconsulting.e3dc.easyrscp.api.connection here

# Package de.jnkconsulting.e3dc.easyrscp.crypt

Basically you can find the class that implements the interfaces from the API package de.jnkconsulting.e3dc.easyrscp.api.crypt here

# Package de.jnkconsulting.e3dc.easyrscp.frame

Here you can find parsers and builders for frames and data blocks

# Package de.jnkconsulting.e3dc.easyrscp.service

Basically you can find the class that implements the interfaces from the API package de.jnkconsulting.e3dc.easyrscp.api.service here

# Package de.jnkconsulting.e3dc.easyrscp.service.builder

Here you can find the builders of the individual service instances

# Package de.jnkconsulting.e3dc.easyrscp.service.converter

Converters from frames to model classes are stored here

# Package de.jnkconsulting.e3dc.easyrscp.service.converter.db

Converters from frames to model classes are stored here, especially for the DATABASE namespace

# Package de.jnkconsulting.e3dc.easyrscp.service.creator

Frame creator you can find here

# Package de.jnkconsulting.e3dc.easyrscp.service.creator.db

Frame creators can be found here, especially for the DATABASE namespace
