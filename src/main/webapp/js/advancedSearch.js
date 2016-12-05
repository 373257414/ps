$(document).ready(function()
{		
	/*控制高级搜索区域的伸缩,并控制第一区域的伸缩*/
	var counter_search = 0;
	var $icon_change_search = $(".icon_change_search");
	$("#A_Search_link").click(function(event)
		{
			counter_search++;
			if(counter_search%2 == 1)
				{
					$(".firstSection").stop(true, false).slideUp(500,function()
						{
							$("#A_SearchSection").stop(true, false).animate({height:"215px"},500,function()
								{
									$icon_change_search.attr("src","img/ZHYgoup16.png");
								});
						});
				}
			else if(counter_search%2 == 0)
				{
					$("#A_SearchSection").stop(true, false).animate({height:"0"},500,function()
						{
							$(".firstSection").stop(true, false).slideDown(500,function()
								{
									$icon_change_search.attr("src","img/ZHYgodown16.png");
								});
						});
				}
			event.preventDefault();
		})
});