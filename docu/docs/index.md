# easy-rscp [![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

easy-rscp is an INOFFICIAL library written in Kotlin (fully Java compatible) for accessing E3DC home power plants.

E3DC is a brand of HagerEnergy Gmbh ([website](https://www.e3dc.com/)). I have nothing to do with the company, except that I own a home power plant from E3DC and wanted to include it in my SmartHome. This "desire" gave birth to easy-rscp. 

## What is easy-rscp?
E3DC's home power plants offer a TCP/IP interface for read and write access. The protocol used for the content is proprietary and is called RSCP. The RSCP structure is well documented by E3DC, but in terms of content there is almost no documentation at all. In addition, the documentation is incomplete, partly incorrect and not publicly available. The E3DC service portal, to which every customer has access, contains the RSCP documentation. easy-rscp and this documentation have the goal to make RSCP more easily accessible for the open source world.

## What do I get?

### As a Kotlin developer
A library written entirely in Kotlin to access home power plants from E3DC. Easy to use, well documented -> Have fun.

### As a Java developer
Basically the same as a Kotlin developer. The bytecode is Java compatible and in the examples you can choose between Kotlin and Java. 

Small disadvantage for you (besides the Java syntax, but you should be used to that), as a dependency smaller Kotlin libraries will be necessary.

### As XYZ Developer
Ok, you can't use the library directly. But in the course of the project this documentation was created. Especially the chapter [RSCP](rscp/basic-rscp.md) should be interesting for you. Here you find a description of the RSCP protocol and all tags and meanings known to me. Maybe this will help you.


## Where do I start?
Best in the [Getting started](getting-started/setup.md) section.


## Can I participate

Absolutely!

### I have found a bug
Too bad, but that can happen. Create a new [Bug](https://github.com/jnk-cons/easy-rscp/issues/new?title=Enter+the+bug+description+here&labels=bug&body=Used+easy-rscp+Version%3A+%3Center+the+version+here%3E%0A%0ASteps+to+Reproduction%3A%0A1.+...%0A2.+...%0A%0AExpected+behavior%3A%0A%3Cdescripe+the+expected+behavior%3E) and we'll take a look.

You already know the solution? Very cool! Post a PR and we'll bring it to the main branch.

### I have cool extensions, improvements fixes
The best thing to do is to create a PR.

You can also participate in the project as a maintainer. Create a ticket [here](https://github.com/jnk-cons/easy-rscp/issues/new?title=I+would+like+to+support+easy-rscp&labels=participation&body=Describe+how+you+can+support.+We+will+get+back+to+you+shortly.) and we will see how you can support best.


### I have further knowledge about the RSCP protocol
Every drop helps to decode this protocol completely. You can create a PR for the doc, or create a [ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=RSCP+documentation&labels=documentation&body=Describe+your+proposal). 

If you want to describe a specific RSCP tag, it is best to go to the [API description](kdoc/easy-rscp/de.jnkconsulting.e3dc.easyrscp.api.frame.tags/index.html) and the corresponding tag class. At each entry you will find a link to create a ticket for exactly this tag.

## License

The library is licensed under the MIT License. [License](about/license.md)

