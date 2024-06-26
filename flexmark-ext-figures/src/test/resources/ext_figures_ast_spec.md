---
title: PlantUML Block Extension Spec
author: Dietrich Travkin
version:
date: '2023-06-26'
license: '[CC-BY-SA 4.0](http://creativecommons.org/licenses/by-sa/4.0/)'
...

---

# Figures Extension

flexmark-java extension for figures support in Markdown code.

---

## Image

Single Image with title

```````````````````````````````` example Image: 1
![Some image](path/to/file.png)
.
<figure>
  <img src="path/to/file.png" alt="Some image" />
  <figcaption>Some image</figcaption>
</figure>
.
Document[0, 31]
  Image[0, 31] textOpen:[0, 2, "!["] text:[2, 12, "Some image"] textClose:[12, 13, "]"] linkOpen:[13, 14, "("] url:[14, 30, "path/to/file.png"] pageRef:[14, 30, "path/to/file.png"] linkClose:[30, 31, ")"]
    Text[2, 12] chars:[2, 12, "Some image"]
````````````````````````````````


Single Image without title

```````````````````````````````` example Image: 2
![](diagrams/classes.svg)
.
<figure>
  <img src="diagrams/classes.svg" alt="" />
</figure>
.
Document[0, 25]
  Image[0, 25] textOpen:[0, 2, "!["] text:[2, 2] textClose:[2, 3, "]"] linkOpen:[3, 4, "("] url:[4, 24, "diagrams/classes.svg"] pageRef:[4, 24, "diagrams/classes.svg"] linkClose:[24, 25, ")"]
````````````````````````````````

Image in paragraph

```````````````````````````````` example Image: 3
Some more text with ![icon](folder/file.jpg) and image in-lined.
.
<p>Some more text with <img src="folder/file.jpg" alt="icon" /> and image in-lined.</p>
.
Document[0, 64]
  Paragraph[0, 64]
    Text[0, 20] chars:[0, 20, "Some  … with "]
    Image[20, 44] textOpen:[20, 22, "!["] text:[22, 26, "icon"] textClose:[26, 27, "]"] linkOpen:[27, 28, "("] url:[28, 43, "folder/file.jpg"] pageRef:[28, 43, "folder/file.jpg"] linkClose:[43, 44, ")"]
      Text[22, 26] chars:[22, 26, "icon"]
    Text[44, 64] chars:[44, 64, " and  … ined."]
````````````````````````````````
