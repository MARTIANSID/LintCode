<h2>1048. Longest String Chain</h2><h3>Medium</h3><hr><div><p>Given a list of words, each word consists of English lowercase letters.</p>

<p>Let's say <code>word1</code> is a predecessor of <code>word2</code> if and only if we can add exactly one letter anywhere in <code>word1</code> to make it equal to <code>word2</code>. For example, <code>"abc"</code> is a predecessor of <code>"abac"</code>.</p>

<p>A <em>word chain </em>is a sequence of words <code>[word_1, word_2, ..., word_k]</code> with <code>k &gt;= 1</code>, where <code>word_1</code> is a predecessor of <code>word_2</code>, <code>word_2</code> is a predecessor of <code>word_3</code>, and so on.</p>

<p>Return the longest possible length of a word chain with words chosen from the given list of <code>words</code>.</p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>

<pre><strong>Input:</strong> words = ["a","b","ba","bca","bda","bdca"]
<strong>Output:</strong> 4
<strong>Explanation</strong>: One of the longest word chain is "a","ba","bda","bdca".
</pre>

<p><strong>Example 2:</strong></p>

<pre><strong>Input:</strong> words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
<strong>Output:</strong> 5
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= words.length &lt;= 1000</code></li>
	<li><code>1 &lt;= words[i].length &lt;= 16</code></li>
	<li><code>words[i]</code> only consists of English lowercase letters.</li>
</ul>
</div>