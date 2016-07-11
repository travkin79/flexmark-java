---
title: Tables Extension Spec
author: Vladimir Schneider
version: 0.1
date: '2016-06-06'
license: '[CC-BY-SA 4.0](http://creativecommons.org/licenses/by-sa/4.0/)'
...

---

## Tables Extension

Converts pipe separated tables to html tables with optional column spans
and multiple header lines and table caption.

```````````````````````````````` example Tables Extension: 1
Abc|Def
.
<p>Abc|Def</p>
.
Document[0, 8]
  Paragraph[0, 8]
    Text[0, 7] chars:[0, 7, "Abc|Def"]
````````````````````````````````


```````````````````````````````` example Tables Extension: 2
Abc | Def
.
<p>Abc | Def</p>
.
Document[0, 10]
  Paragraph[0, 10]
    Text[0, 9] chars:[0, 9, "Abc | Def"]
````````````````````````````````


```````````````````````````````` example Tables Extension: 3
Abc|Def
-|-
.
<p>Abc|Def
-|-</p>
.
Document[0, 12]
  Paragraph[0, 12]
    Text[0, 7] chars:[0, 7, "Abc|Def"]
    SoftLineBreak[7, 8]
    Text[8, 11] chars:[8, 11, "-|-"]
````````````````````````````````


```````````````````````````````` example Tables Extension: 4
Abc|Def
--|--
.
<p>Abc|Def
--|--</p>
.
Document[0, 14]
  Paragraph[0, 14]
    Text[0, 7] chars:[0, 7, "Abc|Def"]
    SoftLineBreak[7, 8]
    Text[8, 13] chars:[8, 13, "--|--"]
````````````````````````````````


```````````````````````````````` example Tables Extension: 5
Abc|Def
 |---|---
.
<p>Abc|Def
|---|---</p>
.
Document[0, 18]
  Paragraph[0, 18]
    Text[0, 7] chars:[0, 7, "Abc|Def"]
    SoftLineBreak[7, 8]
    Text[9, 17] chars:[9, 17, "|---|---"]
````````````````````````````````


```````````````````````````````` example Tables Extension: 6
No
Abc|Def
---|---
.
<p>No
Abc|Def
---|---</p>
.
Document[0, 19]
  Paragraph[0, 19]
    Text[0, 2] chars:[0, 2, "No"]
    SoftLineBreak[2, 3]
    Text[3, 10] chars:[3, 10, "Abc|Def"]
    SoftLineBreak[10, 11]
    Text[11, 18] chars:[11, 18, "---|---"]
````````````````````````````````


```````````````````````````````` example Tables Extension: 7
Abc|Def
---|---
.
<table>
  <thead>
    <tr><th>Abc</th><th>Def</th></tr>
  </thead>
  <tbody></tbody>
</table>
.
Document[0, 16]
  TableBlock[0, 16]
    TableHead[0, 7]
      TableRow[0, 7]
        TableCell[0, 4] header textOpen:[0, 0] text:[0, 3, "Abc"] textClose:[3, 4, "|"]
          Text[0, 3] chars:[0, 3, "Abc"]
        TableCell[4, 7] header textOpen:[0, 0] text:[4, 7, "Def"] textClose:[0, 0]
          Text[4, 7] chars:[4, 7, "Def"]
    TableSeparator[8, 15]
      TableRow[8, 15]
        TableCell[8, 12] textOpen:[0, 0] text:[8, 11, "---"] textClose:[11, 12, "|"]
          Text[8, 11] chars:[8, 11, "---"]
        TableCell[12, 15] textOpen:[0, 0] text:[12, 15, "---"] textClose:[0, 0]
          Text[12, 15] chars:[12, 15, "---"]
    TableBody[0, 0]
````````````````````````````````


Separator columns need to be at least 3 characters, not 3 dashes

```````````````````````````````` example Tables Extension: 8
Abc|Def
:--|---
.
<table>
  <thead>
    <tr><th align="left">Abc</th><th>Def</th></tr>
  </thead>
  <tbody></tbody>
</table>
.
Document[0, 16]
  TableBlock[0, 16]
    TableHead[0, 7]
      TableRow[0, 7]
        TableCell[0, 4] LEFT header textOpen:[0, 0] text:[0, 3, "Abc"] textClose:[3, 4, "|"]
          Text[0, 3] chars:[0, 3, "Abc"]
        TableCell[4, 7] header textOpen:[0, 0] text:[4, 7, "Def"] textClose:[0, 0]
          Text[4, 7] chars:[4, 7, "Def"]
    TableSeparator[8, 15]
      TableRow[8, 15]
        TableCell[8, 12] LEFT textOpen:[0, 0] text:[8, 11, ":--"] textClose:[11, 12, "|"]
          Text[8, 11] chars:[8, 11, ":--"]
        TableCell[12, 15] textOpen:[0, 0] text:[12, 15, "---"] textClose:[0, 0]
          Text[12, 15] chars:[12, 15, "---"]
    TableBody[0, 0]
````````````````````````````````


Separator columns need to be at least 3 characters, not 3 dashes

```````````````````````````````` example Tables Extension: 9
Abc|Def
--:|---
.
<table>
  <thead>
    <tr><th align="right">Abc</th><th>Def</th></tr>
  </thead>
  <tbody></tbody>
</table>
.
Document[0, 16]
  TableBlock[0, 16]
    TableHead[0, 7]
      TableRow[0, 7]
        TableCell[0, 4] RIGHT header textOpen:[0, 0] text:[0, 3, "Abc"] textClose:[3, 4, "|"]
          Text[0, 3] chars:[0, 3, "Abc"]
        TableCell[4, 7] header textOpen:[0, 0] text:[4, 7, "Def"] textClose:[0, 0]
          Text[4, 7] chars:[4, 7, "Def"]
    TableSeparator[8, 15]
      TableRow[8, 15]
        TableCell[8, 12] RIGHT textOpen:[0, 0] text:[8, 11, "--:"] textClose:[11, 12, "|"]
          Text[8, 11] chars:[8, 11, "--:"]
        TableCell[12, 15] textOpen:[0, 0] text:[12, 15, "---"] textClose:[0, 0]
          Text[12, 15] chars:[12, 15, "---"]
    TableBody[0, 0]
````````````````````````````````


```````````````````````````````` example Tables Extension: 10
Abc|Def
:-:|---
.
<table>
  <thead>
    <tr><th align="center">Abc</th><th>Def</th></tr>
  </thead>
  <tbody></tbody>
</table>
.
Document[0, 16]
  TableBlock[0, 16]
    TableHead[0, 7]
      TableRow[0, 7]
        TableCell[0, 4] CENTER header textOpen:[0, 0] text:[0, 3, "Abc"] textClose:[3, 4, "|"]
          Text[0, 3] chars:[0, 3, "Abc"]
        TableCell[4, 7] header textOpen:[0, 0] text:[4, 7, "Def"] textClose:[0, 0]
          Text[4, 7] chars:[4, 7, "Def"]
    TableSeparator[8, 15]
      TableRow[8, 15]
        TableCell[8, 12] CENTER textOpen:[0, 0] text:[8, 11, ":-:"] textClose:[11, 12, "|"]
          Text[8, 11] chars:[8, 11, ":-:"]
        TableCell[12, 15] textOpen:[0, 0] text:[12, 15, "---"] textClose:[0, 0]
          Text[12, 15] chars:[12, 15, "---"]
    TableBody[0, 0]
````````````````````````````````


```````````````````````````````` example Tables Extension: 11
|Abc
|---
.
<table>
  <thead>
    <tr><th>Abc</th></tr>
  </thead>
  <tbody></tbody>
</table>
.
Document[0, 10]
  TableBlock[0, 10]
    TableHead[0, 4]
      TableRow[0, 4]
        TableCell[0, 4] header textOpen:[0, 1, "|"] text:[1, 4, "Abc"] textClose:[0, 0]
          Text[1, 4] chars:[1, 4, "Abc"]
    TableSeparator[5, 9]
      TableRow[5, 9]
        TableCell[5, 9] textOpen:[5, 6, "|"] text:[6, 9, "---"] textClose:[0, 0]
          Text[6, 9] chars:[6, 9, "---"]
    TableBody[0, 0]
````````````````````````````````


```````````````````````````````` example Tables Extension: 12
|Abc|
|---|
.
<table>
  <thead>
    <tr><th>Abc</th></tr>
  </thead>
  <tbody></tbody>
</table>
.
Document[0, 12]
  TableBlock[0, 12]
    TableHead[0, 5]
      TableRow[0, 5]
        TableCell[0, 5] header textOpen:[0, 1, "|"] text:[1, 4, "Abc"] textClose:[4, 5, "|"]
          Text[1, 4] chars:[1, 4, "Abc"]
    TableSeparator[6, 11]
      TableRow[6, 11]
        TableCell[6, 11] textOpen:[6, 7, "|"] text:[7, 10, "---"] textClose:[10, 11, "|"]
          Text[7, 10] chars:[7, 10, "---"]
    TableBody[0, 0]
````````````````````````````````


```````````````````````````````` example Tables Extension: 13
Abc|
---|
.
<table>
  <thead>
    <tr><th>Abc</th></tr>
  </thead>
  <tbody></tbody>
</table>
.
Document[0, 10]
  TableBlock[0, 10]
    TableHead[0, 4]
      TableRow[0, 4]
        TableCell[0, 4] header textOpen:[0, 0] text:[0, 3, "Abc"] textClose:[3, 4, "|"]
          Text[0, 3] chars:[0, 3, "Abc"]
    TableSeparator[5, 9]
      TableRow[5, 9]
        TableCell[5, 9] textOpen:[0, 0] text:[5, 8, "---"] textClose:[8, 9, "|"]
          Text[5, 8] chars:[5, 8, "---"]
    TableBody[0, 0]
````````````````````````````````


```````````````````````````````` example Tables Extension: 14
|Abc
---
.
<h2>|Abc</h2>
.
Document[0, 9]
  Heading[0, 8] textOpen:[0, 0] text:[0, 4, "|Abc"] textClose:[5, 8, "---"]
    Text[0, 4] chars:[0, 4, "|Abc"]
````````````````````````````````


```````````````````````````````` example Tables Extension: 15
Abc
|---
.
<p>Abc
|---</p>
.
Document[0, 9]
  Paragraph[0, 9]
    Text[0, 3] chars:[0, 3, "Abc"]
    SoftLineBreak[3, 4]
    Text[4, 8] chars:[4, 8, "|---"]
````````````````````````````````


```````````````````````````````` example Tables Extension: 16
|Abc
|---
|1
.
<table>
  <thead>
    <tr><th>Abc</th></tr>
  </thead>
  <tbody>
    <tr><td>1</td></tr>
  </tbody>
</table>
.
Document[0, 13]
  TableBlock[0, 13]
    TableHead[0, 4]
      TableRow[0, 4]
        TableCell[0, 4] header textOpen:[0, 1, "|"] text:[1, 4, "Abc"] textClose:[0, 0]
          Text[1, 4] chars:[1, 4, "Abc"]
    TableSeparator[5, 9]
      TableRow[5, 9]
        TableCell[5, 9] textOpen:[5, 6, "|"] text:[6, 9, "---"] textClose:[0, 0]
          Text[6, 9] chars:[6, 9, "---"]
    TableBody[10, 12]
      TableRow[10, 12]
        TableCell[10, 12] textOpen:[10, 11, "|"] text:[11, 12, "1"] textClose:[0, 0]
          Text[11, 12] chars:[11, 12, "1"]
````````````````````````````````


```````````````````````````````` example Tables Extension: 17
|Abc|
|---|
|1|
.
<table>
  <thead>
    <tr><th>Abc</th></tr>
  </thead>
  <tbody>
    <tr><td>1</td></tr>
  </tbody>
</table>
.
Document[0, 16]
  TableBlock[0, 16]
    TableHead[0, 5]
      TableRow[0, 5]
        TableCell[0, 5] header textOpen:[0, 1, "|"] text:[1, 4, "Abc"] textClose:[4, 5, "|"]
          Text[1, 4] chars:[1, 4, "Abc"]
    TableSeparator[6, 11]
      TableRow[6, 11]
        TableCell[6, 11] textOpen:[6, 7, "|"] text:[7, 10, "---"] textClose:[10, 11, "|"]
          Text[7, 10] chars:[7, 10, "---"]
    TableBody[12, 15]
      TableRow[12, 15]
        TableCell[12, 15] textOpen:[12, 13, "|"] text:[13, 14, "1"] textClose:[14, 15, "|"]
          Text[13, 14] chars:[13, 14, "1"]
````````````````````````````````


```````````````````````````````` example Tables Extension: 18
Abc|
---|
1|
.
<table>
  <thead>
    <tr><th>Abc</th></tr>
  </thead>
  <tbody>
    <tr><td>1</td></tr>
  </tbody>
</table>
.
Document[0, 13]
  TableBlock[0, 13]
    TableHead[0, 4]
      TableRow[0, 4]
        TableCell[0, 4] header textOpen:[0, 0] text:[0, 3, "Abc"] textClose:[3, 4, "|"]
          Text[0, 3] chars:[0, 3, "Abc"]
    TableSeparator[5, 9]
      TableRow[5, 9]
        TableCell[5, 9] textOpen:[0, 0] text:[5, 8, "---"] textClose:[8, 9, "|"]
          Text[5, 8] chars:[5, 8, "---"]
    TableBody[10, 12]
      TableRow[10, 12]
        TableCell[10, 12] textOpen:[0, 0] text:[10, 11, "1"] textClose:[11, 12, "|"]
          Text[10, 11] chars:[10, 11, "1"]
````````````````````````````````


```````````````````````````````` example Tables Extension: 19
|Abc
---
|1
.
<h2>|Abc</h2>
<p>|1</p>
.
Document[0, 12]
  Heading[0, 8] textOpen:[0, 0] text:[0, 4, "|Abc"] textClose:[5, 8, "---"]
    Text[0, 4] chars:[0, 4, "|Abc"]
  Paragraph[9, 12]
    Text[9, 11] chars:[9, 11, "|1"]
````````````````````````````````


```````````````````````````````` example Tables Extension: 20
|Abc
|---
1
.
<table>
  <thead>
    <tr><th>Abc</th></tr>
  </thead>
  <tbody></tbody>
</table>
<p>1</p>
.
Document[0, 12]
  TableBlock[0, 10]
    TableHead[0, 4]
      TableRow[0, 4]
        TableCell[0, 4] header textOpen:[0, 1, "|"] text:[1, 4, "Abc"] textClose:[0, 0]
          Text[1, 4] chars:[1, 4, "Abc"]
    TableSeparator[5, 9]
      TableRow[5, 9]
        TableCell[5, 9] textOpen:[5, 6, "|"] text:[6, 9, "---"] textClose:[0, 0]
          Text[6, 9] chars:[6, 9, "---"]
    TableBody[0, 0]
  Paragraph[10, 12]
    Text[10, 11] chars:[10, 11, "1"]
````````````````````````````````


```````````````````````````````` example Tables Extension: 21
Abc|Def
---|---
1|2
.
<table>
  <thead>
    <tr><th>Abc</th><th>Def</th></tr>
  </thead>
  <tbody>
    <tr><td>1</td><td>2</td></tr>
  </tbody>
</table>
.
Document[0, 20]
  TableBlock[0, 20]
    TableHead[0, 7]
      TableRow[0, 7]
        TableCell[0, 4] header textOpen:[0, 0] text:[0, 3, "Abc"] textClose:[3, 4, "|"]
          Text[0, 3] chars:[0, 3, "Abc"]
        TableCell[4, 7] header textOpen:[0, 0] text:[4, 7, "Def"] textClose:[0, 0]
          Text[4, 7] chars:[4, 7, "Def"]
    TableSeparator[8, 15]
      TableRow[8, 15]
        TableCell[8, 12] textOpen:[0, 0] text:[8, 11, "---"] textClose:[11, 12, "|"]
          Text[8, 11] chars:[8, 11, "---"]
        TableCell[12, 15] textOpen:[0, 0] text:[12, 15, "---"] textClose:[0, 0]
          Text[12, 15] chars:[12, 15, "---"]
    TableBody[16, 19]
      TableRow[16, 19]
        TableCell[16, 18] textOpen:[0, 0] text:[16, 17, "1"] textClose:[17, 18, "|"]
          Text[16, 17] chars:[16, 17, "1"]
        TableCell[18, 19] textOpen:[0, 0] text:[18, 19, "2"] textClose:[0, 0]
          Text[18, 19] chars:[18, 19, "2"]
````````````````````````````````


```````````````````````````````` example Tables Extension: 22
Abc|Def|Ghi
---|---
1|2|3
.
<table>
  <thead>
    <tr><th>Abc</th><th>Def</th><th>Ghi</th></tr>
  </thead>
  <tbody>
    <tr><td>1</td><td>2</td><td>3</td></tr>
  </tbody>
</table>
.
Document[0, 26]
  TableBlock[0, 26]
    TableHead[0, 11]
      TableRow[0, 11]
        TableCell[0, 4] header textOpen:[0, 0] text:[0, 3, "Abc"] textClose:[3, 4, "|"]
          Text[0, 3] chars:[0, 3, "Abc"]
        TableCell[4, 8] header textOpen:[0, 0] text:[4, 7, "Def"] textClose:[7, 8, "|"]
          Text[4, 7] chars:[4, 7, "Def"]
        TableCell[8, 11] header textOpen:[0, 0] text:[8, 11, "Ghi"] textClose:[0, 0]
          Text[8, 11] chars:[8, 11, "Ghi"]
    TableSeparator[12, 19]
      TableRow[12, 19]
        TableCell[12, 16] textOpen:[0, 0] text:[12, 15, "---"] textClose:[15, 16, "|"]
          Text[12, 15] chars:[12, 15, "---"]
        TableCell[16, 19] textOpen:[0, 0] text:[16, 19, "---"] textClose:[0, 0]
          Text[16, 19] chars:[16, 19, "---"]
    TableBody[20, 25]
      TableRow[20, 25]
        TableCell[20, 22] textOpen:[0, 0] text:[20, 21, "1"] textClose:[21, 22, "|"]
          Text[20, 21] chars:[20, 21, "1"]
        TableCell[22, 24] textOpen:[0, 0] text:[22, 23, "2"] textClose:[23, 24, "|"]
          Text[22, 23] chars:[22, 23, "2"]
        TableCell[24, 25] textOpen:[0, 0] text:[24, 25, "3"] textClose:[0, 0]
          Text[24, 25] chars:[24, 25, "3"]
````````````````````````````````


```````````````````````````````` example Tables Extension: 23
 Abc  | Def
 --- | ---
 1 | 2
.
<table>
  <thead>
    <tr><th>Abc</th><th>Def</th></tr>
  </thead>
  <tbody>
    <tr><td>1</td><td>2</td></tr>
  </tbody>
</table>
.
Document[0, 30]
  TableBlock[1, 30]
    TableHead[1, 11]
      TableRow[1, 11]
        TableCell[1, 7] header textOpen:[0, 0] text:[1, 4, "Abc"] textClose:[6, 7, "|"]
          Text[1, 4] chars:[1, 4, "Abc"]
        TableCell[7, 11] header textOpen:[0, 0] text:[8, 11, "Def"] textClose:[0, 0]
          Text[8, 11] chars:[8, 11, "Def"]
    TableSeparator[13, 22]
      TableRow[13, 22]
        TableCell[13, 18] textOpen:[0, 0] text:[13, 16, "---"] textClose:[17, 18, "|"]
          Text[13, 16] chars:[13, 16, "---"]
        TableCell[18, 22] textOpen:[0, 0] text:[19, 22, "---"] textClose:[0, 0]
          Text[19, 22] chars:[19, 22, "---"]
    TableBody[24, 29]
      TableRow[24, 29]
        TableCell[24, 27] textOpen:[0, 0] text:[24, 25, "1"] textClose:[26, 27, "|"]
          Text[24, 25] chars:[24, 25, "1"]
        TableCell[27, 29] textOpen:[0, 0] text:[28, 29, "2"] textClose:[0, 0]
          Text[28, 29] chars:[28, 29, "2"]
````````````````````````````````


```````````````````````````````` example Tables Extension: 24
Abc|Def
---|---
    1|2
.
<table>
  <thead>
    <tr><th>Abc</th><th>Def</th></tr>
  </thead>
  <tbody>
    <tr><td>1</td><td>2</td></tr>
  </tbody>
</table>
.
Document[0, 24]
  TableBlock[0, 24]
    TableHead[0, 7]
      TableRow[0, 7]
        TableCell[0, 4] header textOpen:[0, 0] text:[0, 3, "Abc"] textClose:[3, 4, "|"]
          Text[0, 3] chars:[0, 3, "Abc"]
        TableCell[4, 7] header textOpen:[0, 0] text:[4, 7, "Def"] textClose:[0, 0]
          Text[4, 7] chars:[4, 7, "Def"]
    TableSeparator[8, 15]
      TableRow[8, 15]
        TableCell[8, 12] textOpen:[0, 0] text:[8, 11, "---"] textClose:[11, 12, "|"]
          Text[8, 11] chars:[8, 11, "---"]
        TableCell[12, 15] textOpen:[0, 0] text:[12, 15, "---"] textClose:[0, 0]
          Text[12, 15] chars:[12, 15, "---"]
    TableBody[16, 23]
      TableRow[16, 23]
        TableCell[20, 22] textOpen:[0, 0] text:[20, 21, "1"] textClose:[21, 22, "|"]
          Text[20, 21] chars:[20, 21, "1"]
        TableCell[22, 23] textOpen:[0, 0] text:[22, 23, "2"] textClose:[0, 0]
          Text[22, 23] chars:[22, 23, "2"]
````````````````````````````````


```````````````````````````````` example Tables Extension: 25
|Abc|Def|
|---|---|
|1|2|
.
<table>
  <thead>
    <tr><th>Abc</th><th>Def</th></tr>
  </thead>
  <tbody>
    <tr><td>1</td><td>2</td></tr>
  </tbody>
</table>
.
Document[0, 26]
  TableBlock[0, 26]
    TableHead[0, 9]
      TableRow[0, 9]
        TableCell[0, 5] header textOpen:[0, 1, "|"] text:[1, 4, "Abc"] textClose:[4, 5, "|"]
          Text[1, 4] chars:[1, 4, "Abc"]
        TableCell[5, 9] header textOpen:[0, 0] text:[5, 8, "Def"] textClose:[8, 9, "|"]
          Text[5, 8] chars:[5, 8, "Def"]
    TableSeparator[10, 19]
      TableRow[10, 19]
        TableCell[10, 15] textOpen:[10, 11, "|"] text:[11, 14, "---"] textClose:[14, 15, "|"]
          Text[11, 14] chars:[11, 14, "---"]
        TableCell[15, 19] textOpen:[0, 0] text:[15, 18, "---"] textClose:[18, 19, "|"]
          Text[15, 18] chars:[15, 18, "---"]
    TableBody[20, 25]
      TableRow[20, 25]
        TableCell[20, 23] textOpen:[20, 21, "|"] text:[21, 22, "1"] textClose:[22, 23, "|"]
          Text[21, 22] chars:[21, 22, "1"]
        TableCell[23, 25] textOpen:[0, 0] text:[23, 24, "2"] textClose:[24, 25, "|"]
          Text[23, 24] chars:[23, 24, "2"]
````````````````````````````````


Embedded pipes in inline elements

```````````````````````````````` example Tables Extension: 26
Abc|Def
---|---
`|`|`|`
.
<table>
  <thead>
    <tr><th>Abc</th><th>Def</th></tr>
  </thead>
  <tbody>
    <tr><td><code>|</code></td><td><code>|</code></td></tr>
  </tbody>
</table>
.
Document[0, 24]
  TableBlock[0, 24]
    TableHead[0, 7]
      TableRow[0, 7]
        TableCell[0, 4] header textOpen:[0, 0] text:[0, 3, "Abc"] textClose:[3, 4, "|"]
          Text[0, 3] chars:[0, 3, "Abc"]
        TableCell[4, 7] header textOpen:[0, 0] text:[4, 7, "Def"] textClose:[0, 0]
          Text[4, 7] chars:[4, 7, "Def"]
    TableSeparator[8, 15]
      TableRow[8, 15]
        TableCell[8, 12] textOpen:[0, 0] text:[8, 11, "---"] textClose:[11, 12, "|"]
          Text[8, 11] chars:[8, 11, "---"]
        TableCell[12, 15] textOpen:[0, 0] text:[12, 15, "---"] textClose:[0, 0]
          Text[12, 15] chars:[12, 15, "---"]
    TableBody[16, 23]
      TableRow[16, 23]
        TableCell[16, 20] textOpen:[0, 0] text:[16, 19, "`|`"] textClose:[19, 20, "|"]
          Code[16, 19] textOpen:[16, 17, "`"] text:[17, 18, "|"] textClose:[18, 19, "`"]
        TableCell[20, 23] textOpen:[0, 0] text:[20, 23, "`|`"] textClose:[0, 0]
          Code[20, 23] textOpen:[20, 21, "`"] text:[21, 22, "|"] textClose:[22, 23, "`"]
````````````````````````````````


unclosed delimiters in cells

```````````````````````````````` example Tables Extension: 27
Abc|Def
---|---
`| | abc
.
<table>
  <thead>
    <tr><th>Abc</th><th>Def</th></tr>
  </thead>
  <tbody>
    <tr><td>`</td><td></td><td>abc</td></tr>
  </tbody>
</table>
.
Document[0, 25]
  TableBlock[0, 25]
    TableHead[0, 7]
      TableRow[0, 7]
        TableCell[0, 4] header textOpen:[0, 0] text:[0, 3, "Abc"] textClose:[3, 4, "|"]
          Text[0, 3] chars:[0, 3, "Abc"]
        TableCell[4, 7] header textOpen:[0, 0] text:[4, 7, "Def"] textClose:[0, 0]
          Text[4, 7] chars:[4, 7, "Def"]
    TableSeparator[8, 15]
      TableRow[8, 15]
        TableCell[8, 12] textOpen:[0, 0] text:[8, 11, "---"] textClose:[11, 12, "|"]
          Text[8, 11] chars:[8, 11, "---"]
        TableCell[12, 15] textOpen:[0, 0] text:[12, 15, "---"] textClose:[0, 0]
          Text[12, 15] chars:[12, 15, "---"]
    TableBody[16, 24]
      TableRow[16, 24]
        TableCell[16, 18] textOpen:[0, 0] text:[16, 17, "`"] textClose:[17, 18, "|"]
          Text[16, 17] chars:[16, 17, "`"]
        TableCell[18, 20] textOpen:[0, 0] text:[0, 0] textClose:[19, 20, "|"]
        TableCell[20, 24] textOpen:[0, 0] text:[21, 24, "abc"] textClose:[0, 0]
          Text[21, 24] chars:[21, 24, "abc"]
````````````````````````````````


unclosed delimiters in cells

```````````````````````````````` example Tables Extension: 28
Abc|Def
---|---
**def | abc
.
<table>
  <thead>
    <tr><th>Abc</th><th>Def</th></tr>
  </thead>
  <tbody>
    <tr><td>**def</td><td>abc</td></tr>
  </tbody>
</table>
.
Document[0, 28]
  TableBlock[0, 28]
    TableHead[0, 7]
      TableRow[0, 7]
        TableCell[0, 4] header textOpen:[0, 0] text:[0, 3, "Abc"] textClose:[3, 4, "|"]
          Text[0, 3] chars:[0, 3, "Abc"]
        TableCell[4, 7] header textOpen:[0, 0] text:[4, 7, "Def"] textClose:[0, 0]
          Text[4, 7] chars:[4, 7, "Def"]
    TableSeparator[8, 15]
      TableRow[8, 15]
        TableCell[8, 12] textOpen:[0, 0] text:[8, 11, "---"] textClose:[11, 12, "|"]
          Text[8, 11] chars:[8, 11, "---"]
        TableCell[12, 15] textOpen:[0, 0] text:[12, 15, "---"] textClose:[0, 0]
          Text[12, 15] chars:[12, 15, "---"]
    TableBody[16, 27]
      TableRow[16, 27]
        TableCell[16, 23] textOpen:[0, 0] text:[16, 21, "**def"] textClose:[22, 23, "|"]
          Text[16, 21] chars:[16, 21, "**def"]
        TableCell[23, 27] textOpen:[0, 0] text:[24, 27, "abc"] textClose:[0, 0]
          Text[24, 27] chars:[24, 27, "abc"]
````````````````````````````````


```````````````````````````````` example Tables Extension: 29
*Abc*|Def
---|---
1|2
.
<table>
  <thead>
    <tr><th><em>Abc</em></th><th>Def</th></tr>
  </thead>
  <tbody>
    <tr><td>1</td><td>2</td></tr>
  </tbody>
</table>
.
Document[0, 22]
  TableBlock[0, 22]
    TableHead[0, 9]
      TableRow[0, 9]
        TableCell[0, 6] header textOpen:[0, 0] text:[0, 5, "*Abc*"] textClose:[5, 6, "|"]
          Emphasis[0, 5] textOpen:[0, 1, "*"] text:[1, 4, "Abc"] textClose:[4, 5, "*"]
            Text[1, 4] chars:[1, 4, "Abc"]
        TableCell[6, 9] header textOpen:[0, 0] text:[6, 9, "Def"] textClose:[0, 0]
          Text[6, 9] chars:[6, 9, "Def"]
    TableSeparator[10, 17]
      TableRow[10, 17]
        TableCell[10, 14] textOpen:[0, 0] text:[10, 13, "---"] textClose:[13, 14, "|"]
          Text[10, 13] chars:[10, 13, "---"]
        TableCell[14, 17] textOpen:[0, 0] text:[14, 17, "---"] textClose:[0, 0]
          Text[14, 17] chars:[14, 17, "---"]
    TableBody[18, 21]
      TableRow[18, 21]
        TableCell[18, 20] textOpen:[0, 0] text:[18, 19, "1"] textClose:[19, 20, "|"]
          Text[18, 19] chars:[18, 19, "1"]
        TableCell[20, 21] textOpen:[0, 0] text:[20, 21, "2"] textClose:[0, 0]
          Text[20, 21] chars:[20, 21, "2"]
````````````````````````````````


```````````````````````````````` example Tables Extension: 30
Abc|Def
---|---
1\\|2|20
.
<table>
  <thead>
    <tr><th>Abc</th><th>Def</th></tr>
  </thead>
  <tbody>
    <tr><td>1\</td><td>2</td><td>20</td></tr>
  </tbody>
</table>
.
Document[0, 25]
  TableBlock[0, 25]
    TableHead[0, 7]
      TableRow[0, 7]
        TableCell[0, 4] header textOpen:[0, 0] text:[0, 3, "Abc"] textClose:[3, 4, "|"]
          Text[0, 3] chars:[0, 3, "Abc"]
        TableCell[4, 7] header textOpen:[0, 0] text:[4, 7, "Def"] textClose:[0, 0]
          Text[4, 7] chars:[4, 7, "Def"]
    TableSeparator[8, 15]
      TableRow[8, 15]
        TableCell[8, 12] textOpen:[0, 0] text:[8, 11, "---"] textClose:[11, 12, "|"]
          Text[8, 11] chars:[8, 11, "---"]
        TableCell[12, 15] textOpen:[0, 0] text:[12, 15, "---"] textClose:[0, 0]
          Text[12, 15] chars:[12, 15, "---"]
    TableBody[16, 24]
      TableRow[16, 24]
        TableCell[16, 20] textOpen:[0, 0] text:[16, 19, "1\\"] textClose:[19, 20, "|"]
          Text[16, 19] chars:[16, 19, "1\\"]
        TableCell[20, 22] textOpen:[0, 0] text:[20, 21, "2"] textClose:[21, 22, "|"]
          Text[20, 21] chars:[20, 21, "2"]
        TableCell[22, 24] textOpen:[0, 0] text:[22, 24, "20"] textClose:[0, 0]
          Text[22, 24] chars:[22, 24, "20"]
````````````````````````````````


Extra column should be truncated when GFM compatibility is selected

```````````````````````````````` example(Tables Extension: 31) options(gfm)
Abc|Def
---|---
1\\|2|20
.
<table>
  <thead>
    <tr><th>Abc</th><th>Def</th></tr>
  </thead>
  <tbody>
    <tr><td>1\</td><td>2</td></tr>
  </tbody>
</table>
.
Document[0, 25]
  TableBlock[0, 25]
    TableHead[0, 7]
      TableRow[0, 7]
        TableCell[0, 4] header textOpen:[0, 0] text:[0, 3, "Abc"] textClose:[3, 4, "|"]
          Text[0, 3] chars:[0, 3, "Abc"]
        TableCell[4, 7] header textOpen:[0, 0] text:[4, 7, "Def"] textClose:[0, 0]
          Text[4, 7] chars:[4, 7, "Def"]
    TableSeparator[8, 15]
      TableRow[8, 15]
        TableCell[8, 12] textOpen:[0, 0] text:[8, 11, "---"] textClose:[11, 12, "|"]
          Text[8, 11] chars:[8, 11, "---"]
        TableCell[12, 15] textOpen:[0, 0] text:[12, 15, "---"] textClose:[0, 0]
          Text[12, 15] chars:[12, 15, "---"]
    TableBody[16, 24]
      TableRow[16, 24]
        TableCell[16, 20] textOpen:[0, 0] text:[16, 19, "1\\"] textClose:[19, 20, "|"]
          Text[16, 19] chars:[16, 19, "1\\"]
        TableCell[20, 22] textOpen:[0, 0] text:[20, 21, "2"] textClose:[21, 22, "|"]
          Text[20, 21] chars:[20, 21, "2"]
````````````````````````````````


```````````````````````````````` example Tables Extension: 32
Abc|Def
---|---
1\\\\|2
.
<table>
  <thead>
    <tr><th>Abc</th><th>Def</th></tr>
  </thead>
  <tbody>
    <tr><td>1\\</td><td>2</td></tr>
  </tbody>
</table>
.
Document[0, 24]
  TableBlock[0, 24]
    TableHead[0, 7]
      TableRow[0, 7]
        TableCell[0, 4] header textOpen:[0, 0] text:[0, 3, "Abc"] textClose:[3, 4, "|"]
          Text[0, 3] chars:[0, 3, "Abc"]
        TableCell[4, 7] header textOpen:[0, 0] text:[4, 7, "Def"] textClose:[0, 0]
          Text[4, 7] chars:[4, 7, "Def"]
    TableSeparator[8, 15]
      TableRow[8, 15]
        TableCell[8, 12] textOpen:[0, 0] text:[8, 11, "---"] textClose:[11, 12, "|"]
          Text[8, 11] chars:[8, 11, "---"]
        TableCell[12, 15] textOpen:[0, 0] text:[12, 15, "---"] textClose:[0, 0]
          Text[12, 15] chars:[12, 15, "---"]
    TableBody[16, 23]
      TableRow[16, 23]
        TableCell[16, 22] textOpen:[0, 0] text:[16, 21, "1\\\\"] textClose:[21, 22, "|"]
          Text[16, 21] chars:[16, 21, "1\\\\"]
        TableCell[22, 23] textOpen:[0, 0] text:[22, 23, "2"] textClose:[0, 0]
          Text[22, 23] chars:[22, 23, "2"]
````````````````````````````````


```````````````````````````````` example Tables Extension: 33
Abc|Def
:---|---
1|2
.
<table>
  <thead>
    <tr><th align="left">Abc</th><th>Def</th></tr>
  </thead>
  <tbody>
    <tr><td align="left">1</td><td>2</td></tr>
  </tbody>
</table>
.
Document[0, 21]
  TableBlock[0, 21]
    TableHead[0, 7]
      TableRow[0, 7]
        TableCell[0, 4] LEFT header textOpen:[0, 0] text:[0, 3, "Abc"] textClose:[3, 4, "|"]
          Text[0, 3] chars:[0, 3, "Abc"]
        TableCell[4, 7] header textOpen:[0, 0] text:[4, 7, "Def"] textClose:[0, 0]
          Text[4, 7] chars:[4, 7, "Def"]
    TableSeparator[8, 16]
      TableRow[8, 16]
        TableCell[8, 13] LEFT textOpen:[0, 0] text:[8, 12, ":---"] textClose:[12, 13, "|"]
          Text[8, 12] chars:[8, 12, ":---"]
        TableCell[13, 16] textOpen:[0, 0] text:[13, 16, "---"] textClose:[0, 0]
          Text[13, 16] chars:[13, 16, "---"]
    TableBody[17, 20]
      TableRow[17, 20]
        TableCell[17, 19] LEFT textOpen:[0, 0] text:[17, 18, "1"] textClose:[18, 19, "|"]
          Text[17, 18] chars:[17, 18, "1"]
        TableCell[19, 20] textOpen:[0, 0] text:[19, 20, "2"] textClose:[0, 0]
          Text[19, 20] chars:[19, 20, "2"]
````````````````````````````````


```````````````````````````````` example Tables Extension: 34
Abc|Def
---:|---
1|2
.
<table>
  <thead>
    <tr><th align="right">Abc</th><th>Def</th></tr>
  </thead>
  <tbody>
    <tr><td align="right">1</td><td>2</td></tr>
  </tbody>
</table>
.
Document[0, 21]
  TableBlock[0, 21]
    TableHead[0, 7]
      TableRow[0, 7]
        TableCell[0, 4] RIGHT header textOpen:[0, 0] text:[0, 3, "Abc"] textClose:[3, 4, "|"]
          Text[0, 3] chars:[0, 3, "Abc"]
        TableCell[4, 7] header textOpen:[0, 0] text:[4, 7, "Def"] textClose:[0, 0]
          Text[4, 7] chars:[4, 7, "Def"]
    TableSeparator[8, 16]
      TableRow[8, 16]
        TableCell[8, 13] RIGHT textOpen:[0, 0] text:[8, 12, "---:"] textClose:[12, 13, "|"]
          Text[8, 12] chars:[8, 12, "---:"]
        TableCell[13, 16] textOpen:[0, 0] text:[13, 16, "---"] textClose:[0, 0]
          Text[13, 16] chars:[13, 16, "---"]
    TableBody[17, 20]
      TableRow[17, 20]
        TableCell[17, 19] RIGHT textOpen:[0, 0] text:[17, 18, "1"] textClose:[18, 19, "|"]
          Text[17, 18] chars:[17, 18, "1"]
        TableCell[19, 20] textOpen:[0, 0] text:[19, 20, "2"] textClose:[0, 0]
          Text[19, 20] chars:[19, 20, "2"]
````````````````````````````````


```````````````````````````````` example Tables Extension: 35
Abc|Def
:---:|---
1|2
.
<table>
  <thead>
    <tr><th align="center">Abc</th><th>Def</th></tr>
  </thead>
  <tbody>
    <tr><td align="center">1</td><td>2</td></tr>
  </tbody>
</table>
.
Document[0, 22]
  TableBlock[0, 22]
    TableHead[0, 7]
      TableRow[0, 7]
        TableCell[0, 4] CENTER header textOpen:[0, 0] text:[0, 3, "Abc"] textClose:[3, 4, "|"]
          Text[0, 3] chars:[0, 3, "Abc"]
        TableCell[4, 7] header textOpen:[0, 0] text:[4, 7, "Def"] textClose:[0, 0]
          Text[4, 7] chars:[4, 7, "Def"]
    TableSeparator[8, 17]
      TableRow[8, 17]
        TableCell[8, 14] CENTER textOpen:[0, 0] text:[8, 13, ":---:"] textClose:[13, 14, "|"]
          Text[8, 13] chars:[8, 13, ":---:"]
        TableCell[14, 17] textOpen:[0, 0] text:[14, 17, "---"] textClose:[0, 0]
          Text[14, 17] chars:[14, 17, "---"]
    TableBody[18, 21]
      TableRow[18, 21]
        TableCell[18, 20] CENTER textOpen:[0, 0] text:[18, 19, "1"] textClose:[19, 20, "|"]
          Text[18, 19] chars:[18, 19, "1"]
        TableCell[20, 21] textOpen:[0, 0] text:[20, 21, "2"] textClose:[0, 0]
          Text[20, 21] chars:[20, 21, "2"]
````````````````````````````````


```````````````````````````````` example Tables Extension: 36
Abc|Def
---|:---:
1|2
.
<table>
  <thead>
    <tr><th>Abc</th><th align="center">Def</th></tr>
  </thead>
  <tbody>
    <tr><td>1</td><td align="center">2</td></tr>
  </tbody>
</table>
.
Document[0, 22]
  TableBlock[0, 22]
    TableHead[0, 7]
      TableRow[0, 7]
        TableCell[0, 4] header textOpen:[0, 0] text:[0, 3, "Abc"] textClose:[3, 4, "|"]
          Text[0, 3] chars:[0, 3, "Abc"]
        TableCell[4, 7] CENTER header textOpen:[0, 0] text:[4, 7, "Def"] textClose:[0, 0]
          Text[4, 7] chars:[4, 7, "Def"]
    TableSeparator[8, 17]
      TableRow[8, 17]
        TableCell[8, 12] textOpen:[0, 0] text:[8, 11, "---"] textClose:[11, 12, "|"]
          Text[8, 11] chars:[8, 11, "---"]
        TableCell[12, 17] CENTER textOpen:[0, 0] text:[12, 17, ":---:"] textClose:[0, 0]
          Text[12, 17] chars:[12, 17, ":---:"]
    TableBody[18, 21]
      TableRow[18, 21]
        TableCell[18, 20] textOpen:[0, 0] text:[18, 19, "1"] textClose:[19, 20, "|"]
          Text[18, 19] chars:[18, 19, "1"]
        TableCell[20, 21] CENTER textOpen:[0, 0] text:[20, 21, "2"] textClose:[0, 0]
          Text[20, 21] chars:[20, 21, "2"]
````````````````````````````````


```````````````````````````````` example Tables Extension: 37
Abc|Def
 :--- |---
1|2
.
<table>
  <thead>
    <tr><th align="left">Abc</th><th>Def</th></tr>
  </thead>
  <tbody>
    <tr><td align="left">1</td><td>2</td></tr>
  </tbody>
</table>
.
Document[0, 23]
  TableBlock[0, 23]
    TableHead[0, 7]
      TableRow[0, 7]
        TableCell[0, 4] LEFT header textOpen:[0, 0] text:[0, 3, "Abc"] textClose:[3, 4, "|"]
          Text[0, 3] chars:[0, 3, "Abc"]
        TableCell[4, 7] header textOpen:[0, 0] text:[4, 7, "Def"] textClose:[0, 0]
          Text[4, 7] chars:[4, 7, "Def"]
    TableSeparator[8, 18]
      TableRow[8, 18]
        TableCell[9, 15] LEFT textOpen:[0, 0] text:[9, 13, ":---"] textClose:[14, 15, "|"]
          Text[9, 13] chars:[9, 13, ":---"]
        TableCell[15, 18] textOpen:[0, 0] text:[15, 18, "---"] textClose:[0, 0]
          Text[15, 18] chars:[15, 18, "---"]
    TableBody[19, 22]
      TableRow[19, 22]
        TableCell[19, 21] LEFT textOpen:[0, 0] text:[19, 20, "1"] textClose:[20, 21, "|"]
          Text[19, 20] chars:[19, 20, "1"]
        TableCell[21, 22] textOpen:[0, 0] text:[21, 22, "2"] textClose:[0, 0]
          Text[21, 22] chars:[21, 22, "2"]
````````````````````````````````


```````````````````````````````` example Tables Extension: 38
Abc|Def
--- :|---
.
<p>Abc|Def
--- :|---</p>
.
Document[0, 18]
  Paragraph[0, 18]
    Text[0, 7] chars:[0, 7, "Abc|Def"]
    SoftLineBreak[7, 8]
    Text[8, 17] chars:[8, 17, "--- :|---"]
````````````````````````````````


```````````````````````````````` example Tables Extension: 39
Abc|Def
---|: ---
.
<p>Abc|Def
---|: ---</p>
.
Document[0, 18]
  Paragraph[0, 18]
    Text[0, 7] chars:[0, 7, "Abc|Def"]
    SoftLineBreak[7, 8]
    Text[8, 17] chars:[8, 17, "---|: ---"]
````````````````````````````````


```````````````````````````````` example Tables Extension: 40
Abc|Def
---|--- :
.
<p>Abc|Def
---|--- :</p>
.
Document[0, 18]
  Paragraph[0, 18]
    Text[0, 7] chars:[0, 7, "Abc|Def"]
    SoftLineBreak[7, 8]
    Text[8, 17] chars:[8, 17, "---|--- :"]
````````````````````````````````


```````````````````````````````` example Tables Extension: 41
Abc|Def
---|---
1|2|3
.
<table>
  <thead>
    <tr><th>Abc</th><th>Def</th></tr>
  </thead>
  <tbody>
    <tr><td>1</td><td>2</td><td>3</td></tr>
  </tbody>
</table>
.
Document[0, 22]
  TableBlock[0, 22]
    TableHead[0, 7]
      TableRow[0, 7]
        TableCell[0, 4] header textOpen:[0, 0] text:[0, 3, "Abc"] textClose:[3, 4, "|"]
          Text[0, 3] chars:[0, 3, "Abc"]
        TableCell[4, 7] header textOpen:[0, 0] text:[4, 7, "Def"] textClose:[0, 0]
          Text[4, 7] chars:[4, 7, "Def"]
    TableSeparator[8, 15]
      TableRow[8, 15]
        TableCell[8, 12] textOpen:[0, 0] text:[8, 11, "---"] textClose:[11, 12, "|"]
          Text[8, 11] chars:[8, 11, "---"]
        TableCell[12, 15] textOpen:[0, 0] text:[12, 15, "---"] textClose:[0, 0]
          Text[12, 15] chars:[12, 15, "---"]
    TableBody[16, 21]
      TableRow[16, 21]
        TableCell[16, 18] textOpen:[0, 0] text:[16, 17, "1"] textClose:[17, 18, "|"]
          Text[16, 17] chars:[16, 17, "1"]
        TableCell[18, 20] textOpen:[0, 0] text:[18, 19, "2"] textClose:[19, 20, "|"]
          Text[18, 19] chars:[18, 19, "2"]
        TableCell[20, 21] textOpen:[0, 0] text:[20, 21, "3"] textClose:[0, 0]
          Text[20, 21] chars:[20, 21, "3"]
````````````````````````````````


Extra columns truncated with GFM compatibility on.

```````````````````````````````` example(Tables Extension: 42) options(gfm)
Abc|Def
---|---
1|2|3
.
<table>
  <thead>
    <tr><th>Abc</th><th>Def</th></tr>
  </thead>
  <tbody>
    <tr><td>1</td><td>2</td></tr>
  </tbody>
</table>
.
Document[0, 22]
  TableBlock[0, 22]
    TableHead[0, 7]
      TableRow[0, 7]
        TableCell[0, 4] header textOpen:[0, 0] text:[0, 3, "Abc"] textClose:[3, 4, "|"]
          Text[0, 3] chars:[0, 3, "Abc"]
        TableCell[4, 7] header textOpen:[0, 0] text:[4, 7, "Def"] textClose:[0, 0]
          Text[4, 7] chars:[4, 7, "Def"]
    TableSeparator[8, 15]
      TableRow[8, 15]
        TableCell[8, 12] textOpen:[0, 0] text:[8, 11, "---"] textClose:[11, 12, "|"]
          Text[8, 11] chars:[8, 11, "---"]
        TableCell[12, 15] textOpen:[0, 0] text:[12, 15, "---"] textClose:[0, 0]
          Text[12, 15] chars:[12, 15, "---"]
    TableBody[16, 21]
      TableRow[16, 21]
        TableCell[16, 18] textOpen:[0, 0] text:[16, 17, "1"] textClose:[17, 18, "|"]
          Text[16, 17] chars:[16, 17, "1"]
        TableCell[18, 20] textOpen:[0, 0] text:[18, 19, "2"] textClose:[19, 20, "|"]
          Text[18, 19] chars:[18, 19, "2"]
````````````````````````````````


```````````````````````````````` example Tables Extension: 43
Abc|Def|Ghi
---|---|---
1|2
.
<table>
  <thead>
    <tr><th>Abc</th><th>Def</th><th>Ghi</th></tr>
  </thead>
  <tbody>
    <tr><td>1</td><td>2</td></tr>
  </tbody>
</table>
.
Document[0, 28]
  TableBlock[0, 28]
    TableHead[0, 11]
      TableRow[0, 11]
        TableCell[0, 4] header textOpen:[0, 0] text:[0, 3, "Abc"] textClose:[3, 4, "|"]
          Text[0, 3] chars:[0, 3, "Abc"]
        TableCell[4, 8] header textOpen:[0, 0] text:[4, 7, "Def"] textClose:[7, 8, "|"]
          Text[4, 7] chars:[4, 7, "Def"]
        TableCell[8, 11] header textOpen:[0, 0] text:[8, 11, "Ghi"] textClose:[0, 0]
          Text[8, 11] chars:[8, 11, "Ghi"]
    TableSeparator[12, 23]
      TableRow[12, 23]
        TableCell[12, 16] textOpen:[0, 0] text:[12, 15, "---"] textClose:[15, 16, "|"]
          Text[12, 15] chars:[12, 15, "---"]
        TableCell[16, 20] textOpen:[0, 0] text:[16, 19, "---"] textClose:[19, 20, "|"]
          Text[16, 19] chars:[16, 19, "---"]
        TableCell[20, 23] textOpen:[0, 0] text:[20, 23, "---"] textClose:[0, 0]
          Text[20, 23] chars:[20, 23, "---"]
    TableBody[24, 27]
      TableRow[24, 27]
        TableCell[24, 26] textOpen:[0, 0] text:[24, 25, "1"] textClose:[25, 26, "|"]
          Text[24, 25] chars:[24, 25, "1"]
        TableCell[26, 27] textOpen:[0, 0] text:[26, 27, "2"] textClose:[0, 0]
          Text[26, 27] chars:[26, 27, "2"]
````````````````````````````````


```````````````````````````````` example Tables Extension: 44
> Abc|Def
> ---|---
> 1|2
.
<blockquote>
  <table>
    <thead>
      <tr><th>Abc</th><th>Def</th></tr>
    </thead>
    <tbody>
      <tr><td>1</td><td>2</td></tr>
    </tbody>
  </table>
</blockquote>
.
Document[0, 26]
  BlockQuote[0, 26] marker:[0, 1, ">"]
    TableBlock[2, 26]
      TableHead[2, 9]
        TableRow[2, 9]
          TableCell[2, 6] header textOpen:[0, 0] text:[2, 5, "Abc"] textClose:[5, 6, "|"]
            Text[2, 5] chars:[2, 5, "Abc"]
          TableCell[6, 9] header textOpen:[0, 0] text:[6, 9, "Def"] textClose:[0, 0]
            Text[6, 9] chars:[6, 9, "Def"]
      TableSeparator[12, 19]
        TableRow[12, 19]
          TableCell[12, 16] textOpen:[0, 0] text:[12, 15, "---"] textClose:[15, 16, "|"]
            Text[12, 15] chars:[12, 15, "---"]
          TableCell[16, 19] textOpen:[0, 0] text:[16, 19, "---"] textClose:[0, 0]
            Text[16, 19] chars:[16, 19, "---"]
      TableBody[22, 25]
        TableRow[22, 25]
          TableCell[22, 24] textOpen:[0, 0] text:[22, 23, "1"] textClose:[23, 24, "|"]
            Text[22, 23] chars:[22, 23, "1"]
          TableCell[24, 25] textOpen:[0, 0] text:[24, 25, "2"] textClose:[0, 0]
            Text[24, 25] chars:[24, 25, "2"]
````````````````````````````````


```````````````````````````````` example Tables Extension: 45
Abc|Def
---|---
1|2
table, you are over
.
<table>
  <thead>
    <tr><th>Abc</th><th>Def</th></tr>
  </thead>
  <tbody>
    <tr><td>1</td><td>2</td></tr>
  </tbody>
</table>
<p>table, you are over</p>
.
Document[0, 40]
  TableBlock[0, 20]
    TableHead[0, 7]
      TableRow[0, 7]
        TableCell[0, 4] header textOpen:[0, 0] text:[0, 3, "Abc"] textClose:[3, 4, "|"]
          Text[0, 3] chars:[0, 3, "Abc"]
        TableCell[4, 7] header textOpen:[0, 0] text:[4, 7, "Def"] textClose:[0, 0]
          Text[4, 7] chars:[4, 7, "Def"]
    TableSeparator[8, 15]
      TableRow[8, 15]
        TableCell[8, 12] textOpen:[0, 0] text:[8, 11, "---"] textClose:[11, 12, "|"]
          Text[8, 11] chars:[8, 11, "---"]
        TableCell[12, 15] textOpen:[0, 0] text:[12, 15, "---"] textClose:[0, 0]
          Text[12, 15] chars:[12, 15, "---"]
    TableBody[16, 19]
      TableRow[16, 19]
        TableCell[16, 18] textOpen:[0, 0] text:[16, 17, "1"] textClose:[17, 18, "|"]
          Text[16, 17] chars:[16, 17, "1"]
        TableCell[18, 19] textOpen:[0, 0] text:[18, 19, "2"] textClose:[0, 0]
          Text[18, 19] chars:[18, 19, "2"]
  Paragraph[20, 40]
    Text[20, 39] chars:[20, 39, "table"..." over"]
````````````````````````````````


inlines should be processed

```````````````````````````````` example Tables Extension: 46
**Abc**|_Def_
---|---
[ref]|`code`
table, you are over

[ref]: /url
.
<table>
  <thead>
    <tr><th><strong>Abc</strong></th><th><em>Def</em></th></tr>
  </thead>
  <tbody>
    <tr><td><a href="/url">ref</a></td><td><code>code</code></td></tr>
  </tbody>
</table>
<p>table, you are over</p>
.
Document[0, 68]
  TableBlock[0, 35]
    TableHead[0, 13]
      TableRow[0, 13]
        TableCell[0, 8] header textOpen:[0, 0] text:[0, 7, "**Abc**"] textClose:[7, 8, "|"]
          StrongEmphasis[0, 7] textOpen:[0, 2, "**"] text:[2, 5, "Abc"] textClose:[5, 7, "**"]
            Text[2, 5] chars:[2, 5, "Abc"]
        TableCell[8, 13] header textOpen:[0, 0] text:[8, 13, "_Def_"] textClose:[0, 0]
          Emphasis[8, 13] textOpen:[8, 9, "_"] text:[9, 12, "Def"] textClose:[12, 13, "_"]
            Text[9, 12] chars:[9, 12, "Def"]
    TableSeparator[14, 21]
      TableRow[14, 21]
        TableCell[14, 18] textOpen:[0, 0] text:[14, 17, "---"] textClose:[17, 18, "|"]
          Text[14, 17] chars:[14, 17, "---"]
        TableCell[18, 21] textOpen:[0, 0] text:[18, 21, "---"] textClose:[0, 0]
          Text[18, 21] chars:[18, 21, "---"]
    TableBody[22, 34]
      TableRow[22, 34]
        TableCell[22, 28] textOpen:[0, 0] text:[22, 27, "[ref]"] textClose:[27, 28, "|"]
          LinkRef[22, 27] textOpen:[0, 0] text:[0, 0] textClose:[0, 0] referenceOpen:[22, 23, "["] reference:[23, 26, "ref"] referenceClose:[26, 27, "]"]
            Text[23, 26] chars:[23, 26, "ref"]
        TableCell[28, 34] textOpen:[0, 0] text:[28, 34, "`code`"] textClose:[0, 0]
          Code[28, 34] textOpen:[28, 29, "`"] text:[29, 33, "code"] textClose:[33, 34, "`"]
  Paragraph[35, 55]
    Text[35, 54] chars:[35, 54, "table"..." over"]
  Reference[56, 67] refOpen:[56, 57, "["] ref:[57, 60, "ref"] refClose:[60, 62, "]:"] urlOpen:[0, 0] url:[63, 67, "/url"] urlClose:[0, 0] titleOpen:[0, 0] title:[0, 0] titleClose:[0, 0]
````````````````````````````````


Column spans are created with repeated | pipes one for each additional
column to span

```````````````````````````````` example Tables Extension: 47
|Abc|Def
|---|---|
| span ||
.
<table>
  <thead>
    <tr><th>Abc</th><th>Def</th></tr>
  </thead>
  <tbody>
    <tr><td colspan="2">span</td></tr>
  </tbody>
</table>
.
Document[0, 29]
  TableBlock[0, 29]
    TableHead[0, 8]
      TableRow[0, 8]
        TableCell[0, 5] header textOpen:[0, 1, "|"] text:[1, 4, "Abc"] textClose:[4, 5, "|"]
          Text[1, 4] chars:[1, 4, "Abc"]
        TableCell[5, 8] header textOpen:[0, 0] text:[5, 8, "Def"] textClose:[0, 0]
          Text[5, 8] chars:[5, 8, "Def"]
    TableSeparator[9, 18]
      TableRow[9, 18]
        TableCell[9, 14] textOpen:[9, 10, "|"] text:[10, 13, "---"] textClose:[13, 14, "|"]
          Text[10, 13] chars:[10, 13, "---"]
        TableCell[14, 18] textOpen:[0, 0] text:[14, 17, "---"] textClose:[17, 18, "|"]
          Text[14, 17] chars:[14, 17, "---"]
    TableBody[19, 28]
      TableRow[19, 28]
        TableCell[19, 28] span textOpen:[19, 20, "|"] text:[21, 25, "span"] textClose:[26, 28, "||"]
          Text[21, 25] chars:[21, 25, "span"]
````````````````````````````````


Now we try varying the header lines and make sure we get the right
output

```````````````````````````````` example Tables Extension: 48
|Abc|Def
|Hij|Lmn
|---|---|
| span ||
.
<table>
  <thead>
    <tr><th>Abc</th><th>Def</th></tr>
    <tr><th>Hij</th><th>Lmn</th></tr>
  </thead>
  <tbody>
    <tr><td colspan="2">span</td></tr>
  </tbody>
</table>
.
Document[0, 38]
  TableBlock[0, 38]
    TableHead[0, 17]
      TableRow[0, 8]
        TableCell[0, 5] header textOpen:[0, 1, "|"] text:[1, 4, "Abc"] textClose:[4, 5, "|"]
          Text[1, 4] chars:[1, 4, "Abc"]
        TableCell[5, 8] header textOpen:[0, 0] text:[5, 8, "Def"] textClose:[0, 0]
          Text[5, 8] chars:[5, 8, "Def"]
      TableRow[9, 17]
        TableCell[9, 14] header textOpen:[9, 10, "|"] text:[10, 13, "Hij"] textClose:[13, 14, "|"]
          Text[10, 13] chars:[10, 13, "Hij"]
        TableCell[14, 17] header textOpen:[0, 0] text:[14, 17, "Lmn"] textClose:[0, 0]
          Text[14, 17] chars:[14, 17, "Lmn"]
    TableSeparator[18, 27]
      TableRow[18, 27]
        TableCell[18, 23] textOpen:[18, 19, "|"] text:[19, 22, "---"] textClose:[22, 23, "|"]
          Text[19, 22] chars:[19, 22, "---"]
        TableCell[23, 27] textOpen:[0, 0] text:[23, 26, "---"] textClose:[26, 27, "|"]
          Text[23, 26] chars:[23, 26, "---"]
    TableBody[28, 37]
      TableRow[28, 37]
        TableCell[28, 37] span textOpen:[28, 29, "|"] text:[30, 34, "span"] textClose:[35, 37, "||"]
          Text[30, 34] chars:[30, 34, "span"]
````````````````````````````````


No header lines

```````````````````````````````` example Tables Extension: 49
|---|---|
| col1 | col2|
.
<table>
  <thead></thead>
  <tbody>
    <tr><td>col1</td><td>col2</td></tr>
  </tbody>
</table>
.
Document[0, 25]
  TableBlock[0, 25]
    TableHead[0, 0]
    TableSeparator[0, 9]
      TableRow[0, 9]
        TableCell[0, 5] textOpen:[0, 1, "|"] text:[1, 4, "---"] textClose:[4, 5, "|"]
          Text[1, 4] chars:[1, 4, "---"]
        TableCell[5, 9] textOpen:[0, 0] text:[5, 8, "---"] textClose:[8, 9, "|"]
          Text[5, 8] chars:[5, 8, "---"]
    TableBody[10, 24]
      TableRow[10, 24]
        TableCell[10, 18] textOpen:[10, 11, "|"] text:[12, 16, "col1"] textClose:[17, 18, "|"]
          Text[12, 16] chars:[12, 16, "col1"]
        TableCell[18, 24] textOpen:[0, 0] text:[19, 23, "col2"] textClose:[23, 24, "|"]
          Text[19, 23] chars:[19, 23, "col2"]
````````````````````````````````


No body lines

```````````````````````````````` example Tables Extension: 50
| col1 | col2|
|---|---|
.
<table>
  <thead>
    <tr><th>col1</th><th>col2</th></tr>
  </thead>
  <tbody></tbody>
</table>
.
Document[0, 25]
  TableBlock[0, 25]
    TableHead[0, 14]
      TableRow[0, 14]
        TableCell[0, 8] header textOpen:[0, 1, "|"] text:[2, 6, "col1"] textClose:[7, 8, "|"]
          Text[2, 6] chars:[2, 6, "col1"]
        TableCell[8, 14] header textOpen:[0, 0] text:[9, 13, "col2"] textClose:[13, 14, "|"]
          Text[9, 13] chars:[9, 13, "col2"]
    TableSeparator[15, 24]
      TableRow[15, 24]
        TableCell[15, 20] textOpen:[15, 16, "|"] text:[16, 19, "---"] textClose:[19, 20, "|"]
          Text[16, 19] chars:[16, 19, "---"]
        TableCell[20, 24] textOpen:[0, 0] text:[20, 23, "---"] textClose:[23, 24, "|"]
          Text[20, 23] chars:[20, 23, "---"]
    TableBody[0, 0]
````````````````````````````````


multiple tables parsed correctly

```````````````````````````````` example Tables Extension: 51
not a table, followed by a table

| col1 | col2|
|---|---|

| col1 | col2|
|---|---|
| data1 | data2|

not a table, followed by a table

| col11 | col12|
| col21 | col22|
|---|---|
| data1 | data2|

.
<p>not a table, followed by a table</p>
<table>
  <thead>
    <tr><th>col1</th><th>col2</th></tr>
  </thead>
  <tbody></tbody>
</table>
<table>
  <thead>
    <tr><th>col1</th><th>col2</th></tr>
  </thead>
  <tbody>
    <tr><td>data1</td><td>data2</td></tr>
  </tbody>
</table>
<p>not a table, followed by a table</p>
<table>
  <thead>
    <tr><th>col11</th><th>col12</th></tr>
    <tr><th>col21</th><th>col22</th></tr>
  </thead>
  <tbody>
    <tr><td>data1</td><td>data2</td></tr>
  </tbody>
</table>
.
Document[0, 199]
  Paragraph[0, 33]
    Text[0, 32] chars:[0, 32, "not a"..."table"]
  TableBlock[34, 59]
    TableHead[34, 48]
      TableRow[34, 48]
        TableCell[34, 42] header textOpen:[34, 35, "|"] text:[36, 40, "col1"] textClose:[41, 42, "|"]
          Text[36, 40] chars:[36, 40, "col1"]
        TableCell[42, 48] header textOpen:[0, 0] text:[43, 47, "col2"] textClose:[47, 48, "|"]
          Text[43, 47] chars:[43, 47, "col2"]
    TableSeparator[49, 58]
      TableRow[49, 58]
        TableCell[49, 54] textOpen:[49, 50, "|"] text:[50, 53, "---"] textClose:[53, 54, "|"]
          Text[50, 53] chars:[50, 53, "---"]
        TableCell[54, 58] textOpen:[0, 0] text:[54, 57, "---"] textClose:[57, 58, "|"]
          Text[54, 57] chars:[54, 57, "---"]
    TableBody[0, 0]
  TableBlock[60, 102]
    TableHead[60, 74]
      TableRow[60, 74]
        TableCell[60, 68] header textOpen:[60, 61, "|"] text:[62, 66, "col1"] textClose:[67, 68, "|"]
          Text[62, 66] chars:[62, 66, "col1"]
        TableCell[68, 74] header textOpen:[0, 0] text:[69, 73, "col2"] textClose:[73, 74, "|"]
          Text[69, 73] chars:[69, 73, "col2"]
    TableSeparator[75, 84]
      TableRow[75, 84]
        TableCell[75, 80] textOpen:[75, 76, "|"] text:[76, 79, "---"] textClose:[79, 80, "|"]
          Text[76, 79] chars:[76, 79, "---"]
        TableCell[80, 84] textOpen:[0, 0] text:[80, 83, "---"] textClose:[83, 84, "|"]
          Text[80, 83] chars:[80, 83, "---"]
    TableBody[85, 101]
      TableRow[85, 101]
        TableCell[85, 94] textOpen:[85, 86, "|"] text:[87, 92, "data1"] textClose:[93, 94, "|"]
          Text[87, 92] chars:[87, 92, "data1"]
        TableCell[94, 101] textOpen:[0, 0] text:[95, 100, "data2"] textClose:[100, 101, "|"]
          Text[95, 100] chars:[95, 100, "data2"]
  Paragraph[103, 136]
    Text[103, 135] chars:[103, 135, "not a"..."table"]
  TableBlock[137, 198]
    TableHead[137, 170]
      TableRow[137, 153]
        TableCell[137, 146] header textOpen:[137, 138, "|"] text:[139, 144, "col11"] textClose:[145, 146, "|"]
          Text[139, 144] chars:[139, 144, "col11"]
        TableCell[146, 153] header textOpen:[0, 0] text:[147, 152, "col12"] textClose:[152, 153, "|"]
          Text[147, 152] chars:[147, 152, "col12"]
      TableRow[154, 170]
        TableCell[154, 163] header textOpen:[154, 155, "|"] text:[156, 161, "col21"] textClose:[162, 163, "|"]
          Text[156, 161] chars:[156, 161, "col21"]
        TableCell[163, 170] header textOpen:[0, 0] text:[164, 169, "col22"] textClose:[169, 170, "|"]
          Text[164, 169] chars:[164, 169, "col22"]
    TableSeparator[171, 180]
      TableRow[171, 180]
        TableCell[171, 176] textOpen:[171, 172, "|"] text:[172, 175, "---"] textClose:[175, 176, "|"]
          Text[172, 175] chars:[172, 175, "---"]
        TableCell[176, 180] textOpen:[0, 0] text:[176, 179, "---"] textClose:[179, 180, "|"]
          Text[176, 179] chars:[176, 179, "---"]
    TableBody[181, 197]
      TableRow[181, 197]
        TableCell[181, 190] textOpen:[181, 182, "|"] text:[183, 188, "data1"] textClose:[189, 190, "|"]
          Text[183, 188] chars:[183, 188, "data1"]
        TableCell[190, 197] textOpen:[0, 0] text:[191, 196, "data2"] textClose:[196, 197, "|"]
          Text[191, 196] chars:[191, 196, "data2"]
````````````````````````````````

