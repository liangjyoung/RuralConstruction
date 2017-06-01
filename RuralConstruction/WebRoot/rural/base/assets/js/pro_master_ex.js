//@author:pengcai

//被格式化的表格对象
var formatGrids = new Array(); 

//主方法
function formatGrid(grid_selector) {
	formatGrids.push("#"+grid_selector);
	window.onresize = function onresize(){
		adaptGrid();
		//console.info(i);
	};
	adaptGrid();
	formatToolTip(grid_selector);
	wipeHorScroll(grid_selector);
};

//改变所有的表格大小
function adaptGrid(){
	var i = 0;
	while(formatGrids[i]){
		$(formatGrids[i]).setGridWidth($(window).width()*0.98);
		i++;
	}
};


//改变表格提示框中的方向和内容
function formatToolTip(grid_selector){
	var obj = document.getElementById("add_"+grid_selector+"_top");
	if(obj){
		obj.setAttribute("data-placement","bottom");
		obj.setAttribute("title","新增");
	}

	var obj = document.getElementById("edit_"+grid_selector+"_top");
	if(obj){
		obj.setAttribute("data-placement","bottom");
		obj.setAttribute("title","编辑");
	}

	var obj = document.getElementById("view_"+grid_selector+"_top");
	if(obj){
		obj.setAttribute("data-placement","bottom");
		obj.setAttribute("title","查看");
	}

	var obj = document.getElementById("del_"+grid_selector+"_top");
	if(obj){
		obj.setAttribute("data-placement","bottom");
		obj.setAttribute("title","删除");
	}

	var obj = document.getElementById("search_"+grid_selector+"_top");
	if(obj){
		obj.setAttribute("data-placement","bottom");
		obj.setAttribute("title","查找");
	}

	var obj = document.getElementById("refresh_"+grid_selector+"_top");
	if(obj){
		obj.setAttribute("data-placement","bottom");
		obj.setAttribute("title","刷新");
	}
}

//去掉表格中的水平滚动条
function wipeHorScroll(grid_selector){
	$("#"+grid_selector).closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" });
}