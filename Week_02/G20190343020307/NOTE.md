学习笔记
1 collections.defaultdict 用法
接受一个参数，这个参数可以是工厂函数int(), long(), float(), complex()，str(), unicode(), basestring()，list(), tuple()，type()
defaultdict可以利用工厂函数，给初始key带来一个默认值。	


	import collections
	s = [('yellow', 1), ('blue', 2), ('yellow', 3), ('blue', 4), ('red', 1)]
	d = collections.defaultdict(list)
	for k, v in s:
    	d[k].append(v)

	list(d.items())

