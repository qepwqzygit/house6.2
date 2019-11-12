$(function(){  //加载事件
    //显示数据
    $('#dg').datagrid({
        title:"已审核房源信息",
        url:"selEHouseByStatePassed",
        toolbar:"#tb",
        pagination:true,
        pageSize:5,
        pageList:[7,10,15,20],
        columns:[[
            {field:'opt',checkbox:"true"},
            {field:'id',title:'编号',width:100},
            {field:'title',title:'标题',width:100},
            {field:'floorage',title:'联系人',width:100},
            {field:'tname',title:'类型',width:100},
            {field:'dname',title:'区域',width:100},
            {field:'sname',title:'街道',width:100},
            {field:'del',title:'操作',width:200,
                formatter: function(value,row,index){
                    return "<a href='javascript:changPassed("+row.id+")'>取消审核</a> | <a href='javascript:selDistrict("+row.id+")'>显示街道信息</a>";
                }
            }
        ]]
    });

});
function changPassed(id) {
    $.post("gochangPassed",{"id":id},function (data) {
        if (data.result>0){
            $("#dg").datagrid("reload");
        } else {
            $.messager.alert("提示信息","取消审核失败!","error");
        }
    },"json");

}