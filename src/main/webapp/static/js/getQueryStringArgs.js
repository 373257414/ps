function getQueryStringArgs()
{
	//����ѯ�ַ����Ƿ���ڲ�ȥ���ʺ�
	var qs = (location.search.length>0 ? location.search.substring(1) : "");
	//�������ݵĶ���
	args = {};
	//���ݡ�&�����ָ��ѯ�ַ�����ȡ��ÿһ��
	items = qs.length ? qs.split("&") : [];
	item = null;
	name = null;
	value = null;
	//��forѭ����ʹ��
	i = 0;
	len = items.length;
	//�����ÿһ����ӵ�args������
	for(i = 0;i<len;i++)
		{
			//�á�=���ָ�ÿһ��
			item = items[i].split("=");
			//�ֱ����name��value
			name = decodeURIComponent(item[0]);
			value = decodeURIComponent(item[1]);
			if(name.length)
				{
					args[name] = value;
				}
			return args;
		}
}
/*ʹ�÷���
 *var args = getQueryStringArgs();
 * alert(args["message"]);*/