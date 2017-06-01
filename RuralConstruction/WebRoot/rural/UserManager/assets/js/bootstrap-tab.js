//@author:pengcai
//如果页面中有name为mainTab的元素，会发生冲突，请避免这么做


var addTabs = function (options) {
  //var rand = Math.random().toString();
  //var id = rand.substring(rand.indexOf('.') + 1);

  //var url = window.location.protocol + '//' + window.location.host;
  //options.url = url + options.url;
  options.url = options.url;
  
  //如果没标签页，就先加一个刷新按钮
  if(sumOfTab() == 0){
		$(".nav-tabs").append('<li id="refreshLi"><button class="btn btn-primary btn-sm" id="refresh" onclick="javascript:re()"><i class="icon-refresh"></i></button><li>');
	}
	
	//获取标签栏的宽;
	var tabsWidth = $(".nav-tabs")[0].offsetWidth;
	var totalWidth = 0;
	var liArr = $(".nav-tabs")[0].getElementsByTagName("li");
	var i = 0;
	while(liArr[i]){
		//console.info("%d",liArr[i].clientWidth);
		totalWidth += liArr[i].clientWidth;
		i++;
	}
	//console.info("%d",totalWidth);
	//console.info("%d",tabsWidth);

	if(totalWidth + 100 > tabsWidth){
		alert("您打开了过多的标签页，请先尝试关掉一些");
		return;
	}
  

  id = "tab_" + options.id;
  $(".active").removeClass("active");
  //如果TAB不存在，创建一个新的TAB
  if (!$("#" + id)[0]) {
    
	//固定TAB中IFRAME高度
    mainHeight = $(document.body).height() - 90;
    
	//创建新TAB的title
    title = '<li role="presentation" name="mainTab" id="tab_' + id + '"><a href="#' + id + '" aria-controls="' + id + '" role="tab" data-toggle="tab">' + options.title;
    
	//是否允许关闭
    if (options.close) {
      title += ' <button class="remove icon-remove" tabclose="' + id + '" ></button>';
    }
    title += '</a></li>';

    //是否指定TAB内容
    if (options.content) {
      content = '<div role="tabpanel" class="tab-pane" id="' + id + '">' + options.content + '</div>';
    } else {//没有内容，使用IFRAME打开链接
      //content = '<div role="tabpanel" class="tab-pane" id="' + id + '"><iframe src="' + options.url + '" width="100%" height="' + mainHeight +
      //    '" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="yes" allowtransparency="yes"></iframe></div>';
	  content = '<div role="tabpanel" class="tab-pane"  id="' + id + '"><iframe class="tabFrame" id="iframe_' + options.id + '" src="' + options.url + '" style="height:100%;width:100%" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="yes" allowtransparency="yes"></iframe></div>';
    }
	
    //加入TABS
    $(".nav-tabs").append(title);
    $(".tab-content").append(content);
	
  }
  //激活TAB
  $("#tab_" + id).addClass('active');
  $("#" + id).addClass("active");
};
var closeTab = function (id) {
  //如果关闭的是当前激活的TAB，激活他的前一个TAB
  if ($("li.active").attr('id') == "tab_" + id) {
    $("#tab_" + id).prev().addClass('active');
    $("#" + id).prev().addClass('active');
  }
  //关闭TAB
  $("#tab_" + id).remove();
  $("#" + id).remove();
	if(sumOfTab() == 0){
		el = document.getElementById('refreshLi');
		var p = el.parentNode;
		p.removeChild(el);
	}
};


$(function () {
  mainHeight = $(document.body).height() - 50;
  $('.main-left,.main-right').height(mainHeight);
  $("[addtabs]").click(function () {
    addTabs({ id: $(this).attr("id"), title: $(this).attr('title'), close: true });
  });

  $(".nav-tabs").on("click", "[tabclose]", function (e) {
    id = $(this).attr("tabclose");
    closeTab(id);
  });
});


//刷新当前页面
function re(){
	var id =$("li.active").attr('id');
	var id = "iframe_"+id.replace(/[^0-9]/ig,""); 
	document.getElementById(id).contentWindow.location.reload(true);
}


//获得当前标签页数量
function sumOfTab(){
	return document.getElementsByName('mainTab').length;
}