# Gray Code
## Medium 
<div class="problem-statement">
                <p></p><div><span style="font-size:18px">Given a number&nbsp;<strong>N</strong>, generate bit patterns from 0 to 2^N-1 such that successive patterns differ by one bit.&nbsp;<br>
A Gray code sequence must begin with 0.</span></div>

<div>&nbsp;</div>

<div><span style="font-size:18px"><strong>Example 1:</strong></span></div>

<pre style="position: relative;"><span style="font-size:18px"><strong>Input:</strong>
N = 2
<strong>Output: </strong>
00 01 11 10
<strong>Explanation: </strong>
00 and 01 differ by one bit.
01 and 11 differ by one bit.
11 and 10 also differ by one bit.</span><div class="open_grepper_editor" title="Edit &amp; Save To Grepper"></div></pre>

<div>&nbsp;</div>

<div><span style="font-size:18px"><strong>Example 2:</strong></span></div>

<pre style="position: relative;"><span style="font-size:18px"><strong>Input:</strong>
N=3
<strong>Output:</strong>
000 001 011 010 110 111 101 100
<strong>Explanation:</strong>
000 and 001 differ by one bit.
001 and 011 differ by one bit.
011 and 010 differ by one bit.
Similarly, every successive pattern 
differs by one bit.</span><div class="open_grepper_editor" title="Edit &amp; Save To Grepper"></div></pre>

<div><span style="font-size:18px"><strong>Your task:</strong></span></div>

<div><span style="font-size:18px">You don't need to read input or print anything. Your task is to complete the function <strong>graycode() </strong>which takes an integer N as input and returns a la list of patterns.</span></div>

<div>&nbsp;</div>

<div><span style="font-size:18px"><strong>Expected Time Complexity:</strong> O(2<sup>n</sup>)</span></div>

<div><span style="font-size:18px"><strong>Expected Auxiliary Space:</strong>&nbsp;O(2<sup>n</sup>)</span></div>

<div>&nbsp;</div>

<div><span style="font-size:18px"><strong>Constraints :</strong></span></div>

<div><span style="font-size:18px">1&lt;=N&lt;=16</span></div>
 <p></p>
            </div>