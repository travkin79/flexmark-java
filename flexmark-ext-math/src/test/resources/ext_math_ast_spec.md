---
title: Math Formula Extension Spec
author: Dietrich Travkin
version:
date: '2024-05-21'
license: '[CC-BY-SA 4.0](http://creativecommons.org/licenses/by-sa/4.0/)'
...

---

# Math Extension

flexmark-java extension for math formula support in Markdown code.

---

## In-line Formula

Single formula, in-line

```````````````````````````````` example In-line Formula: 1
$E=mc^2$
.
<p>
  <span class="math inline">\(E=mc^2\)</span>
</p>
.
Document[0, 8]
  Paragraph[0, 8]
    MathFormulaInLineNode[0, 8] textOpen:[0, 1, "$"] text:[1, 7, "E=mc^2"] textClose:[7, 8, "$"]
      Text[1, 7] chars:[1, 7, "E=mc^2"]
````````````````````````````````


Single formula, in-line

```````````````````````````````` example In-line Formula: 2
$n! = \prod_{i=1..n}i$
.
<p>
  <span class="math inline">\(n! = \prod_{i=1..n}i\)</span>
</p>
.
Document[0, 22]
  Paragraph[0, 22]
    MathFormulaInLineNode[0, 22] textOpen:[0, 1, "$"] text:[1, 21, "n! = \prod_{i=1..n}i"] textClose:[21, 22, "$"]
      Text[1, 21] chars:[1, 21, "n! =  … ..n}i"]
````````````````````````````````


Formula in paragraph text, in-line

```````````````````````````````` example In-line Formula: 3
Einstein's formula $E=mc^2$ is famous.
.
<p>Einstein's formula 
  <span class="math inline">\(E=mc^2\)</span>
is famous.</p>
.
Document[0, 38]
  Paragraph[0, 38]
    Text[0, 19] chars:[0, 19, "Einst … mula "]
    MathFormulaInLineNode[19, 27] textOpen:[19, 20, "$"] text:[20, 26, "E=mc^2"] textClose:[26, 27, "$"]
      Text[20, 26] chars:[20, 26, "E=mc^2"]
    Text[27, 38] chars:[27, 38, " is f … mous."]
````````````````````````````````


Formula in paragraph text, in-line

```````````````````````````````` example In-line Formula: 4
$H_2O$ and $CO_2$ are chemical molecules.
.
<p>
  <span class="math inline">\(H_2O\)</span>
and 
  <span class="math inline">\(CO_2\)</span>
are chemical molecules.</p>
.
Document[0, 41]
  Paragraph[0, 41]
    MathFormulaInLineNode[0, 6] textOpen:[0, 1, "$"] text:[1, 5, "H_2O"] textClose:[5, 6, "$"]
      Text[1, 5] chars:[1, 5, "H_2O"]
    Text[6, 11] chars:[6, 11, " and "]
    MathFormulaInLineNode[11, 17] textOpen:[11, 12, "$"] text:[12, 16, "CO_2"] textClose:[16, 17, "$"]
      Text[12, 16] chars:[12, 16, "CO_2"]
    Text[17, 41] chars:[17, 41, " are  … ules."]
````````````````````````````````


---

## Display Mode Formula

Single display mode formula

```````````````````````````````` example Display Mode Formula: 1
$$\sum_{i=1}^{n}=\frac{n(n+1)}{2}$$
.
<p>
  <span class="math display">\[\sum_{i=1}^{n}=\frac{n(n+1)}{2}\]</span>
</p>
.
Document[0, 35]
  MathFormulaDisplayModeNode[0, 35]
    Text[2, 33] chars:[2, 33, "\sum_ … )}{2}"]
````````````````````````````````


Paragraph and multiple display mode formula

```````````````````````````````` example Display Mode Formula: 2
Other expressions:
$$a_0+{1\over a_1+
      {1\over a_2+
        {1 \over a_3 + 
           {1 \over a_4}}}}$$

$$x_{1/2} = -\frac{p}{2}\pm \sqrt{\frac{p^2}{4}-q}$$
.
<p>Other expressions:</p>
<p>
  <span class="math display">\[a_0+{1\over a_1+
  {1\over a_2+
  {1 \over a_3 + 
  {1 \over a_4}}}}\]</span>
</p>
<p>
  <span class="math display">\[x_{1/2} = -\frac{p}{2}\pm \sqrt{\frac{p^2}{4}-q}\]</span>
</p>
.
Document[0, 164]
  Paragraph[0, 19]
    Text[0, 18] chars:[0, 18, "Other … ions:"]
  MathFormulaDisplayModeNode[19, 111]
    Text[21, 108] chars:[21, 108, "a_0+{ … 4}}}}"]
  MathFormulaDisplayModeNode[112, 164]
    Text[114, 162] chars:[114, 162, "x_{1/ … 4}-q}"]
````````````````````````````````


