<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "
http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0044)http://localhost:8080/HouseRent/page/add.jsp -->
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>青鸟租房 -发布房屋信息</TITLE>
    <META content="text/html; charset=utf-8" http-equiv=Content-Type><LINK
            rel=stylesheet type=text/css href="../css/style.css">
    <META name=GENERATOR content="MSHTML 8.00.7601.17514"></HEAD>
<script src="../scripts/jquery-1.8.3.js"></script>
<script>
    $(function(){
        $.post("selType",null,function (data) {
            for (var i = 0; i <data.length ; i++) {
                var option = $("<option value="+data[i].id+">"+data[i].name+"</option>");
                $("#type_id").append(option);
            }
            $("#type_id").val(${house.typeId});
        },"json");

        $.post("getAllDistrict",null,function (data) {
            for (var i = 0; i <data.length ; i++) {
                var option = $("<option value="+data[i].id+">"+data[i].name+"</option>");
                $("#district_id").append(option);
            }
            $("#district_id").val(${house.did});
            changeStreet();
        },"json");

        //3.加载街道
        $("#district_id").change(function(){  //触发区域的改变事件
            changeStreet();
        });
    });

    /*加载街道的有两种情况*/
    function changeStreet(){
        var did=$("#district_id").val();
        //发送异步请求获取街道
        //清空选项
        $("#street_id>option:gt(0)").remove();
        //加载数据
        $.post("getAllStreetById",{"did":did},function(data){
            //循环一次一行对就一个选项
            for (var i=0;i<data.length;i++){
                //创建dom节点
                var option=$("<option value="+data[i].id+">"+data[i].name+"</option>");
                //添加节点
                $("#street_id").append(option);
            }
            //设置区域的选中项
            $("#street_id").val(${house.streetId});
        },"json");
    }


</script>
<BODY>
<DIV id=header class=wrap>
    <DIV id=logo><IMG src="../images/logo.gif"></DIV></DIV>
<DIV id=regLogin class=wrap>
    <DIV class=dialog>
        <DL class=clearfix>
            <DT>修改房源信息</DT>
            <DD class=past>修改信息</DD></DL>
        <DIV class=box>
            <FORM id=add_action enctype="multipart/form-data" method=post
                  action=updateHouse>
                <DIV class=infos>
                    <TABLE class=field>
                        <TBODY>
                        <TR>
                            <TD class=field>标　　题：</TD><INPUT id=id class=text type=hidden name=id value="${house.id}">
                            <TD><INPUT id=add_action_title class=text type=text name=title value="${house.title}"> </TD></TR>
                        <TR>
                            <TD class=field>户　　型：</TD>
                            <TD><SELECT class=text name=typeId id="type_id"><OPTION selected>${house.tname}</OPTION></SELECT></TD></TR>
                        <TR>
                            <TD class=field>面　　积：</TD>
                            <TD><INPUT id=add_action_floorage class=text type=text
                                       name=floorage value="${house.floorage}"></TD></TR>
                        <TR>
                            <TD class=field>价　　格：</TD>
                            <TD><INPUT id=add_action_price class=text type=text name=price value="${house.price}"> </TD></TR>
                        <TR>
                            <TD class=field>房产证日期：</TD>
                            <TD><INPUT class=text type=date name=pubdate value="<f:formatDate value="${house.pubdate}" pattern="yyyy-MM-dd"></f:formatDate>"></TD></TR>
                        <TR>
                            <TD class=field>位　　置：</TD>
                            <TD>区：<SELECT class=text name="district_id" id="district_id"><OPTION selected
                            >--请选择--</OPTION></SELECT>
                                街：<SELECT class=text
                                          name="streetId" id="street_id"><OPTION selected >-请选择--</OPTION></SELECT> </TD></TR><!--
						<tr>
							<td class="field">坐  标：</td>`
							<td><input type="text" class="text" name="point" />
							</td>
						</tr>
						--><!--  <tr>
							<td class="field">Y 坐  标：</td>
							<td><input type="text" class="text" name="point.y" /></td>
						</tr>-->
                        <TR>
                            <TD class=field>联系方式：</TD>
                            <TD><INPUT id=add_action_contact class=text type=text name=contact value="${house.contact}"> </TD></TR>
                        <TR>
                            <TD class=field>详细信息：</TD>
                            <TD><TEXTAREA name=description>${house.description}</TEXTAREA></TD></TR>
                        <TR>
                            <TD class=field>图片上传：</TD>
                            <TD><INPUT id=mfile type=file name=pfile value="${house.path}"><img src="http://localhost:80/${house.path}" higth="100" width="80"></TD></TR></TBODY></TABLE>
                    <DIV class=buttons><INPUT name="sum" value=立即发布 type=submit>
                    </DIV></DIV></FORM></DIV></DIV></DIV>
<DIV id=footer class=wrap>
    <DL>
        <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
        <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>
