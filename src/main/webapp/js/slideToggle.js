$(document).ready(function()
{
	/*点击左侧标题可以伸缩输入区*/
	$(".lHeader").click(function(event)
		{
			$(this).parent().next().stop(true, false).slideToggle(500);
			event.preventDefault();
		})
});


