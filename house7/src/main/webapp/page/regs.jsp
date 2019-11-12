<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0049)http://localhost:8080/HouseRent/page/register.jsp -->
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>青鸟租房 - 用户注册</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type><LINK 
rel=stylesheet type=text/css href="../css/style.css">
<META name=GENERATOR content="MSHTML 8.00.7601.17514"></HEAD>
<script src="../scripts/jquery-1.8.3.js"></script>
<script>
  $(function () {
      /*$("#but").click(function () {
          $.post("checkName",{"name":$("#txtName").val()},function (data) {
              if (data.result==0) {
                  $("#notice").text("用户名可用").css("color","green");
              }else {
                  $("#notice").text("用户名不可用").css("color","red");
              }
          },"json")
      })*/

      $("#reg").submit(function () {
          return checkname()&&checkpwd();
      })
      $("#txtName").css("border","");
      $("#txtName").blur(checkname);
      $("#pwd").blur(checkpwd);
      $("#pwd2").blur(checkpwd2);
  })
  function checkname() {
      /*alert("jj")*/
      //1.获取用户名值
      var username = $("#txtName").val();
      //2.定义正则
      var reg_username = /^\w{5,20}$/;

      //3.判断，给出提示信息
      var flag = reg_username.test(username);
      if(flag){
          //用户名合法
          $.post("checkName",{"name":$("#txtName").val()},function (data) {
              if (data.result==0) {
                  $("#notice").text("用户名可用").css("color","green");
                  $("#txtName").css("border","");
              }else {
                  $("#notice").text("用户名不可用").css("color","red");
              }
          },"json")
      }else{
          //用户名非法,加一个红色边框
          $("#txtName").css("border","2px solid red");
          $("#notice").text("用户名必须是5-20位").css("color","red");;
      }
      return flag;
  }
  function checkpwd() {
      /*alert("jj")*/
      //1.获取用户名值
      var userpwd = $("#pwd").val();
      //2.定义正则
      var reg_userpwd = /^\w{5,20}$/;

      //3.判断，给出提示信息
      var flag = reg_userpwd.test(userpwd);
      if(flag){
          $("#pwd").css("border","");
          $("#notice2").text("");
      }else{
          //用户名非法,加一个红色边框
          $("#pwd").css("border","2px solid red");
          $("#notice2").text("密码必须是5-20位").css("color","red");
      }
      return flag;
  }
  function checkpwd2() {
      var userpwd = $("#pwd").val();
      var userpwd2 = $("#pwd2").val();
      if (userpwd!=userpwd2){
          $("#pwd2").css("border","2px solid red");
          $("#notice3").text("两次密码必须相同！").css("color","red");
          return false;
      }else {
          $("#pwd2").css("border","");
          $("#notice3").text("");
          return true;
      }
  }
</script>
<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="../images/logo.gif"></DIV></DIV>
<DIV id=regLogin class=wrap>
<DIV class=dialog>
<DL class=clearfix>
  <DT>新用户注册</DT>
  <DD class=past>填写个人信息</DD></DL>
<DIV class=box>
<FORM action="addUsers" method="post" name="form1" id="reg">
<DIV class=infos>
<TABLE class=field>
  <TBODY>
  <TR>
    <TD class=field>用 户 名：</TD>
    <TD><INPUT class=text type=text name=name id="txtName">
    <span id="notice"></span>
    </TD></TR>
  <TR>
    <TD class=field>密　　码：</TD>
    <TD><INPUT class=text type=password name=password id="pwd">
      <span id="notice2"></span>
    </TD></TR>
  <TR>
    <TD class=field>确认密码：</TD>
    <TD><INPUT class=text type=password name=repassword id="pwd2">
      <span id="notice3"></span>
    </TD></TR>
  <TR>
    <TD class=field>电　　话：</TD>
    <TD><INPUT class=text type=text name=telephone> </TD></TR>
  <TR>
    <TD class=field>年    龄：</TD>
    <TD><INPUT class=text type=text name=age> </TD></TR></TBODY></TABLE>
<DIV class=buttons>
<INPUT name="add"  value=立即注册 type=submit >
</DIV></DIV></FORM></DIV></DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>
