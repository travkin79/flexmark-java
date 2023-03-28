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
`# Some heading {#my_heading_anchor-7}`.


Simple heading anchor

```````````````````````````````` example Heading Anchors: 1
# Some Level-1 heading with anchor {#important_my-section-7}
.
<h1 id="important_my-section-7">Some Level-1 heading with anchor</h1>
.
Document[0, 60]
  Heading[0, 60] textOpen:[0, 1, "#"] text:[2, 60, "Some Level-1 heading with anchor {#important_my-section-7}"]
    Text[2, 34] chars:[2, 34, "Some  … nchor"]
    HeadingAnchor[35, 60]
````````````````````````````````
