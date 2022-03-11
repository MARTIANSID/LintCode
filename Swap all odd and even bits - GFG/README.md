# Swap all odd and even bits
## Easy 
<div class="problem-statement">
                <p></p><p><span style="font-size:18px">Given an unsigned integer <strong>N</strong>. The task is to swap all odd bits with even bits. For example, if the given number is 23 (<strong>0</strong>0<strong>0</strong>1<strong>0</strong>1<strong>1</strong>1), it should be converted to 43(0<strong>0</strong>1<strong>0</strong>1<strong>0</strong>1<strong>1</strong>). Here, every even position bit is swapped with adjacent bit on the right side(even position bits are highlighted in the binary representation of 23), and every odd position bit is swapped with an adjacent on the left side.<br>
<br>
<strong>Example 1</strong>:</span></p>

<pre style="position: relative;"><span style="font-size:18px"><strong>Input</strong>: N = 23
<strong>Output</strong>: 43
<strong>Explanation</strong>: 
Binary representation of the given number 
is <strong>0</strong>0<strong>0</strong>1<strong>0</strong>1<strong>1</strong>1 after swapping 
0<strong>0</strong>1<strong>0</strong>1<strong>0</strong>11 = 43 in decimal.</span><div class="open_grepper_editor" title="Edit &amp; Save To Grepper"></div></pre>

<p><span style="font-size:18px"><strong>Example 2</strong>:</span></p>

<pre style="position: relative;"><span style="font-size:18px"><strong>Input</strong>: N = 2
<strong>Output</strong>: 1
<strong>Explanation</strong>: 
Binary representation of the given number 
is <strong>1</strong>0 after swapping 0<strong>1 </strong>= 1 in decimal</span>.<div class="open_grepper_editor" title="Edit &amp; Save To Grepper"></div></pre>

<p><br>
<strong>Your Task:&nbsp;</strong><span style="font-size:18px">Your task is to complete the function </span><strong>swapBits</strong><span style="font-size:18px">() which takes an integer and </span><strong>returns an&nbsp;</strong><span style="font-size:18px">integer with all the odd and even bits swapped.</span></p>

<p><br>
<span style="font-size:18px"><strong>Expected Time Complexity:</strong>&nbsp;O(1).<br>
<strong>Expected Auxiliary Space:</strong>&nbsp;O(1).<br>
<br>
<strong>Constraints:</strong></span><br>
<span style="font-size:18px">1 ≤ N ≤ 10<sup>9</sup></span></p>
 <p></p>
            </div>