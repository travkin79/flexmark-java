---
title: PlantUML Block Extension Spec
author:
version:
date: '2016-06-06'
license: '[CC-BY-SA 4.0](http://creativecommons.org/licenses/by-sa/4.0/)'
...

---

## PlantUML Extension

flexmark-java extension for ...

---

Single PlantUML code block

```````````````````````````````` example PlantUML Block Extension: 1
@startuml
    class ArrayList
    interface List
    
    ArrayList ..|> List
@enduml
.
<figure>
  <svg></svg>
</figure>
.
Document[0, 85]
  PlantUmlBlockNode[0, 85]
````````````````````````````````


Invalid PlantUML code block

```````````````````````````````` example PlantUML Block Extension: 2
@startuml
    class ArrayList
    interface List
    
    ArrayList ..|> List
@endsomething
.
<p>
@startuml
    class ArrayList
    interface List
    
    ArrayList ..|> List
@endsomething
</p>
.
Document[0, 91]
  Paragraph[0, 91]
    Text[0, 91] chars:[0, 91, "@startu  … thing"]
````````````````````````````````

PlantUML code block with context

```````````````````````````````` example PlantUML Block Extension: 3
# Heading

Some text
in a paragraph.

@startuml
    class ArrayList
    interface List
    
    ArrayList ..|> List
@enduml

Another paragraph.
.
<h1>Heading</h1>
<p>Some text
in a paragraph.</p>
<figure>
  <svg></svg>
</figure>
<p>Another paragraph.</p>
.
Document[0, 143]
  Heading[0, 9] textOpen:[0, 1, "#"] text:[2, 9, "Heading"]
    Text[2, 9] chars:[2, 9, "Heading"]
  Paragraph[11, 37] isTrailingBlankLine
    Text[11, 20] chars:[11, 20, "Some text"]
    SoftLineBreak[20, 21]
    Text[21, 36] chars:[21, 36, "in a  … raph."]
  PlantUmlBlockNode[38, 123]
  Paragraph[125, 143]
    Text[125, 143] chars:[125, 143, "Another paragraph."]
````````````````````````````````