---
title: HeadingAnchors Extension Spec
author:
version:
date: '2023-03-24'
license: '[CC-BY-SA 4.0](http://creativecommons.org/licenses/by-sa/4.0/)'
...

---

## Heading Anchors

Automatically generates heading anchor nodes for heading nodes with anchor declarations of the form

```
# Some Heading Title {#important_my-section-7}
```

Simple heading anchor example

```````````````````````````````` example Heading Anchors: 1
# Some Heading Title {#important_my-section-7}
.
<h1 id="important_my-section-7">Some Heading Title</h1>
.
Document[0, 46]
  Heading[0, 46] textOpen:[0, 1, "#"] text:[2, 46, "Some Heading Title {#important_my-section-7}"]
    Text[2, 20] chars:[2, 20, "Some  … Title"]
    HeadingAnchor[21, 46] chars:[21, 46, "{#important_my-section-7}"] anchorId:[23,45, "important_my-section-7"]
````````````````````````````````
