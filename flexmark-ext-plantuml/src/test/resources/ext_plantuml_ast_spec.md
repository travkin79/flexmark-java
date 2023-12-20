---
title: PlantUML Block Extension Spec
author: Dietrich Travkin
version:
date: '2023-06-26'
license: '[CC-BY-SA 4.0](http://creativecommons.org/licenses/by-sa/4.0/)'
...

---

## PlantUML Block Extension

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
  <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" contentStyleType="text/css" height="170px" preserveAspectRatio="none" style="width:106px;height:170px;background:#FFFFFF;" version="1.1" viewBox="0 0 106 170" width="106px" zoomAndPan="magnify">
      <defs/>
      <g>
          <!--class ArrayList-->
          <g id="elem_ArrayList">
              <rect codeLine="1" fill="#F1F1F1" height="48" id="ArrayList" rx="2.5" ry="2.5" style="stroke:#181818;stroke-width:0.5;" width="92" x="7" y="7"/>
              <ellipse cx="22" cy="23" fill="#ADD1B2" rx="11" ry="11" style="stroke:#181818;stroke-width:1.0;"/>
              <path d="M24.9731,28.6431 Q24.3921,28.9419 23.7529,29.0913 Q23.1138,29.2407 22.4082,29.2407 Q19.9014,29.2407 18.5815,27.5889 Q17.2617,25.937 17.2617,22.8159 Q17.2617,19.6865 18.5815,18.0347 Q19.9014,16.3828 22.4082,16.3828 Q23.1138,16.3828 23.7612,16.5322 Q24.4087,16.6816 24.9731,16.9805 L24.9731,19.7031 Q24.3423,19.1221 23.7488,18.8523 Q23.1553,18.5825 22.5244,18.5825 Q21.1797,18.5825 20.4949,19.6492 Q19.8101,20.7158 19.8101,22.8159 Q19.8101,24.9077 20.4949,25.9744 Q21.1797,27.041 22.5244,27.041 Q23.1553,27.041 23.7488,26.7712 Q24.3423,26.5015 24.9731,25.9204 Z " fill="#000000"/>
              <text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing" textLength="60" x="36" y="28.291">ArrayList</text>
              <line style="stroke:#181818;stroke-width:0.5;" x1="8" x2="98" y1="39" y2="39"/>
              <line style="stroke:#181818;stroke-width:0.5;" x1="8" x2="98" y1="47" y2="47"/>
          </g>
          <!--class List-->
          <g id="elem_List">
              <rect codeLine="2" fill="#F1F1F1" height="48" id="List" rx="2.5" ry="2.5" style="stroke:#181818;stroke-width:0.5;" width="55" x="25.5" y="115"/>
              <ellipse cx="40.5" cy="131" fill="#B4A7E5" rx="11" ry="11" style="stroke:#181818;stroke-width:1.0;"/>
              <path d="M36.4277,126.7651 L36.4277,124.6069 L43.8071,124.6069 L43.8071,126.7651 L41.3418,126.7651 L41.3418,134.8418 L43.8071,134.8418 L43.8071,137 L36.4277,137 L36.4277,134.8418 L38.8931,134.8418 L38.8931,126.7651 Z " fill="#000000"/>
              <text fill="#000000" font-family="sans-serif" font-size="14" font-style="italic" lengthAdjust="spacing" textLength="23" x="54.5" y="136.291">List</text>
              <line style="stroke:#181818;stroke-width:0.5;" x1="26.5" x2="79.5" y1="147" y2="147"/>
              <line style="stroke:#181818;stroke-width:0.5;" x1="26.5" x2="79.5" y1="155" y2="155"/>
          </g>
          <!--link ArrayList to List-->
          <g id="link_ArrayList_List">
              <path codeLine="4" d="M53,55.26 C53,66.45 53,80.24 53,93.34 " fill="none" id="ArrayList-to-List" style="stroke:#181818;stroke-width:1.0;stroke-dasharray:7.0,7.0;"/>
              <polygon fill="none" points="60,93.28,53,113.28,46,93.28,60,93.28" style="stroke:#181818;stroke-width:1.0;"/>
          </g>
          <!--SRC=[Kr1GK4ZEIImkLd0iAagizCaiBk422YbavfMa5gKb9gSgW8N0Od0L2dfwDNPW2G00]-->
      </g>
  </svg>
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
<p>@startuml
class ArrayList
interface List</p>
<pre><code>ArrayList ..|&gt; List
</code></pre>
<p>@endsomething</p>
.
Document[0, 91]
  Paragraph[0, 49] isTrailingBlankLine
    Text[0, 9] chars:[0, 9, "@startuml"]
    SoftLineBreak[9, 10]
    Text[14, 29] chars:[14, 29, "class … yList"]
    SoftLineBreak[29, 30]
    Text[34, 48] chars:[34, 48, "inter …  List"]
  IndentedCodeBlock[58, 78]
  Paragraph[78, 91]
    Text[78, 91] chars:[78, 91, "@ends … thing"]
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
  <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" contentStyleType="text/css" height="170px" preserveAspectRatio="none" style="width:106px;height:170px;background:#FFFFFF;" version="1.1" viewBox="0 0 106 170" width="106px" zoomAndPan="magnify">
      <defs/>
      <g>
          <!--class ArrayList-->
          <g id="elem_ArrayList">
              <rect codeLine="1" fill="#F1F1F1" height="48" id="ArrayList" rx="2.5" ry="2.5" style="stroke:#181818;stroke-width:0.5;" width="92" x="7" y="7"/>
              <ellipse cx="22" cy="23" fill="#ADD1B2" rx="11" ry="11" style="stroke:#181818;stroke-width:1.0;"/>
              <path d="M24.9731,28.6431 Q24.3921,28.9419 23.7529,29.0913 Q23.1138,29.2407 22.4082,29.2407 Q19.9014,29.2407 18.5815,27.5889 Q17.2617,25.937 17.2617,22.8159 Q17.2617,19.6865 18.5815,18.0347 Q19.9014,16.3828 22.4082,16.3828 Q23.1138,16.3828 23.7612,16.5322 Q24.4087,16.6816 24.9731,16.9805 L24.9731,19.7031 Q24.3423,19.1221 23.7488,18.8523 Q23.1553,18.5825 22.5244,18.5825 Q21.1797,18.5825 20.4949,19.6492 Q19.8101,20.7158 19.8101,22.8159 Q19.8101,24.9077 20.4949,25.9744 Q21.1797,27.041 22.5244,27.041 Q23.1553,27.041 23.7488,26.7712 Q24.3423,26.5015 24.9731,25.9204 Z " fill="#000000"/>
              <text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing" textLength="60" x="36" y="28.291">ArrayList</text>
              <line style="stroke:#181818;stroke-width:0.5;" x1="8" x2="98" y1="39" y2="39"/>
              <line style="stroke:#181818;stroke-width:0.5;" x1="8" x2="98" y1="47" y2="47"/>
          </g>
          <!--class List-->
          <g id="elem_List">
              <rect codeLine="2" fill="#F1F1F1" height="48" id="List" rx="2.5" ry="2.5" style="stroke:#181818;stroke-width:0.5;" width="55" x="25.5" y="115"/>
              <ellipse cx="40.5" cy="131" fill="#B4A7E5" rx="11" ry="11" style="stroke:#181818;stroke-width:1.0;"/>
              <path d="M36.4277,126.7651 L36.4277,124.6069 L43.8071,124.6069 L43.8071,126.7651 L41.3418,126.7651 L41.3418,134.8418 L43.8071,134.8418 L43.8071,137 L36.4277,137 L36.4277,134.8418 L38.8931,134.8418 L38.8931,126.7651 Z " fill="#000000"/>
              <text fill="#000000" font-family="sans-serif" font-size="14" font-style="italic" lengthAdjust="spacing" textLength="23" x="54.5" y="136.291">List</text>
              <line style="stroke:#181818;stroke-width:0.5;" x1="26.5" x2="79.5" y1="147" y2="147"/>
              <line style="stroke:#181818;stroke-width:0.5;" x1="26.5" x2="79.5" y1="155" y2="155"/>
          </g>
          <!--link ArrayList to List-->
          <g id="link_ArrayList_List">
              <path codeLine="4" d="M53,55.26 C53,66.45 53,80.24 53,93.34 " fill="none" id="ArrayList-to-List" style="stroke:#181818;stroke-width:1.0;stroke-dasharray:7.0,7.0;"/>
              <polygon fill="none" points="60,93.28,53,113.28,46,93.28,60,93.28" style="stroke:#181818;stroke-width:1.0;"/>
          </g>
          <!--SRC=[Kr1GK4ZEIImkLd0iAagizCaiBk422YbavfMa5gKb9gSgW8N0Od0L2dfwDNPW2G00]-->
      </g>
  </svg>
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
  PlantUmlBlockNode[38, 124]
  Paragraph[125, 143]
    Text[125, 143] chars:[125, 143, "Anoth … raph."]
````````````````````````````````