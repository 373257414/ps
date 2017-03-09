$(document).ready(function()
{
	$(".lHeader").click(function(event)
		{
			$(this).parent().next().stop(true, false).slideToggle(500);
			event.preventDefault();
		})
});


