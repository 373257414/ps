function getQueryStringArgs()
{
	//检查查询字符串是否存在并去掉问号
	var qs = (location.search.length>0 ? location.search.substring(1) : "");
	//保存数据的对象
	args = {};
	//根据“&”来分割查询字符串，取得每一项
	items = qs.length ? qs.split("&") : [];
	item = null;
	name = null;
	value = null;
	//在for循环中使用
	i = 0;
	len = items.length;
	//逐个将每一项添加到args对象中
	for(i = 0;i<len;i++)
		{
			//用“=”分割每一项
			item = items[i].split("=");
			//分别解码name和value
			name = decodeURIComponent(item[0]);
			value = decodeURIComponent(item[1]);
			if(name.length)
				{
					args[name] = value;
				}
			return args;
		}
}
/*使用方法
 *var args = getQueryStringArgs();
 * alert(args["message"]);*/