$(document).ready(function () {
    size_li = $("#myList li").size();
    x=3;
    $('#myList li:lt('+x+')').show();
	
    $('#loadMore').click(function () {
        x= (x+1 <= size_li) ? x+1 : size_li;
        $('#myList li:lt('+x+')').show();
		if(x==size_li){
			$('#loadMore').hide();
		}		
		$('#showLess').show();
    });
    $('#showLess').click(function () {
        x=(x-1<0) ? 3 : x-1;
		$('#myList li').not(':lt('+x+')').hide();
		if(x==1){
			$('#showLess').hide();		
		}
		$('#loadMore').show();		        
    });
});