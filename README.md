# 开发环境

- IDE：IntelliJ IDEA 2020.1.3
- 编程语言：Java 11.0.1
- 单元测试：JUnit-4.9



# 运行

- 在release文件夹下找到main.jar，按照以下方式运行

```bash
# java -jar main.jar [原文文件] [抄袭版论文的文件] [答案文件]
java -jar main.jar orig.txt orig_0.8_add.txt ans.txt
```



# 开发者日志

## 第三阶段

（2020.9.10）

- 补全10个测试类
- 学习并使用JProfiler这个性能测试工具，并发现Apache家的那个Jaro算法是最耗性能的，要吃75.3%啊啊啊啊啊啊啊啊
- 修正输出格式，应为**0.80**，而非**80%**
- 在release中发布最新的可运行jar包
- 计划明天写异常类以及更新测试类

## 第二阶段

（2020.9.9）

- 添加了Junit单元测试模块，新增自动测试全部文本的测试类
- 在release中发布最新的可运行jar包
- 新发现：运行速度跟jvm有关系，我用Java8跑第一个样例要5.6s，我用Java11就只要3.4s
- 正在研究怎么用Java配套的性能测试工具，难搞啊...:cry:

（2020.9.8）

- 在搭完框架后，发现了一些小bug，修复了一下，并且将算法核心部分抽出单独的模块
- 今天集中研究算法，想法如下：（:angry:今天俺要**拥抱开源**！）
  - 首先，将txt文本格式文章转化成的字符串做**分词**，选用的库是<u>HanLP</u>的标准分词方法，其实jieba应该也行，以前在py上用过了，这次想试试新的
  - 抽去词列表中的标点符号（这步很关键，速度上也优化很多）
  - 进入LCS方法，但这里的判断不是简单的二者相同，而是利用<u>Jaro距离算法</u>处理相似情况，比较两个字符串，也就是两个词，按经验来说，返回结果大于0.6，就认为相似距离接近，就类比于原来版本的LCS的相等情况
  - 返回LCS的结果，最后的答案就是——LCS返回结果/标准文章处理后的字符串列表长，但似乎准确性还是不尽如人意，哎，优化明天再看看吧



## 第一阶段

（2020.9.7）

- 秉承着《UNIX编程艺术》中的**优化原则**，所以我在开始阶段只想把这个程序设计的简单一点，突出软件设计思想，把它模块化足矣，模块给他划分得清清楚楚，后面集中精力搞算法就好了
- 大概框架先搭好，在OOP的前提下，尽可能做到<u>高内聚、低耦合</u>，万不可因为这题的核心在算法而忽视了程序设计的一些原则问题
- 算法呢，我在这一阶段决定使用动态规划中的**LCS最长公共子串**的思想来解决，复杂度是O(n1*n2)，取决于两篇文章的长度，准确度并不高。开始而已，没必要太复杂，KISS嘛，Keep It Simple,Silly!先跑起来再说！

- 输入参数化先不做，方便测试，反正也就是arg[0]、arg[1]的事儿

谈谈我的现在的理解：

- 我觉得这道题目重点核心在于算法，需要做语义分析，分词，还需要近义词库，哎，难搞
- 这么说来似乎用py更友好？我还是决定先用Java！毕竟比较符合软件工业化体系hhh

后期优化想法：

- 看了知网算法后，有点劝退，决定另寻他径

- 决定在下一阶段尝试用jieba分词或者是TextRank算法