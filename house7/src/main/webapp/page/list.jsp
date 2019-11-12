<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0030)http://localhost:8080/House-2/ -->
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>青鸟租房 - 首页</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type>
<LINK rel=stylesheet type=text/css href="../css/style.css">
<META name=GENERATOR content="MSHTML 8.00.7601.17514"></HEAD>
<script src="../scripts/jquery-1.8.3.js"></script>
<script>
    $(function(){
        $.post("selType",null,function (data) {
            for (var i = 0; i <data.length ; i++) {
                var option = $("<option value="+data[i].id+">"+data[i].name+"</option>");
                $("#type_id").append(option);
            }
            $("#type_id").val(${house.tid});
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
            $("#street_id").val(${house.sid});
        },"json");
    }
function goPage(num) {
    $("#setPage").val(num);
    $("#sform").submit();/*点击提交*/

}

</script>
<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="../images/logo.gif"></DIV></DIV>
<%--<DIV id=navbar class=wrap>    程序错误  区域多class
<DL class="search clearfix">
  <FORM id=sform method=post action=/page/listc>
    标题：<input type="text" name="title" >
    区域：<SELECT class=text name="did" id="district_id"><OPTION selected
  >--请选择--</OPTION></SELECT>
  街道：<SELECT class=text
             name="sid" id="street_id"><OPTION value="" selected >--请选择--</OPTION></SELECT>
  户型：<SELECT class=text name=tid id="type_id"><OPTION selected>--请选择--</OPTION></SELECT>
  价格：<input type="text" name="startPrice" id="">-<input type="text" name="endPrice" id="">
  <input type="submit" value="搜索"></FORM>
</DL></DIV>--%>

<DIV id=navbar class=wrap>
  <DL class="search clearfix">
    <FORM id=sform method=post action=/page/listc>
      <input type="hidden" value="1"  id="setPage" name="page">
      标题:<input type="text" value="${listpageUtil.title}" name="title">
      区域:<select name="did" id="district_id">
      <option value="">请选择</option>
    </select>
      街道:<select name="sid" id="street_id">
      <option value="">请选择</option>
    </select>
      类型:<select name="tid" id="type_id">
      <option value="">请选择</option>
    </select>
      价格:<input type="text" name="startPrice" value="${listpageUtil.startPrice}">-<input type="text" value="${conditioin.endPrice}" name="endPrice">
      <input type="submit" name="seach" value="搜 索">
    </FORM></DL></DIV>

<DIV class="main wrap">
<TABLE class=house-list>
  <TBODY>
  <c:forEach items="${housepageinfo.list}" var="house">
    <TR>
      <TD class=house-thumb><span><A href="details.htm" target="_blank"><img src="http://localhost:80/${house.path}" width="100" height="75" alt=""></a></span></TD>
      <TD>
        <DL>
          <DT><A href="details.htm" target="_blank">${house.title}</A></DT>
          <DD>${house.dname}${house.sname},${house.floorage}<BR>联系方式：${house.contact} </DD></DL></TD>
      <TD class=house-type>${house.tname}</TD>
      <TD class=house-price><SPAN>${house.price}</SPAN>元/月</TD></TR>
    <br>
  </c:forEach>
  </TBODY></TABLE>
<DIV class=pager>
<UL>
  <LI class=current><A href="javascript:goPage(1)">首页</A></LI>
  <LI><A href="javascript:goPage(${housepageinfo.prePage==0?1:housepageinfo.nextPage})">上一页</A></LI>
  <LI><A href="javascript:goPage(${housepageinfo.nextPage==0?housepageinfo.pages:housepageinfo.nextPage})">下一页</A></LI>
  <LI><A href="javascript:goPage(${housepageinfo.pages})">末页</A></LI>
  <LI><A href="javascript:goPage(2)">mou页</A></LI></UL><SPAN
class=total>${housepageinfo.pageNum}/${housepageinfo.pages}页</SPAN> </DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>
