package com.team.house.pController;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.House;
import com.team.house.entity.Users;
import com.team.house.service.HouseService;
import com.team.house.utills.ListPageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author:ZY
 * @date:2019/10/23
 * @Time:16:27
 */
@Controller("houseController2")
@RequestMapping("page")
public class HouseController {
    @Autowired
    private HouseService houseService;

    @RequestMapping("testFile")//value 跟jsp 的name对应 测试成功
    public String testFile(@RequestParam(value="pfile",required = false)CommonsMultipartFile pfile){
        System.out.println("文件名："+pfile.getOriginalFilename());
        System.out.println("文件类型："+pfile.getContentType());
        System.out.println("文件字节："+pfile.getBytes());
        System.out.println("文件大小："+pfile.getSize());
        System.out.println(pfile.getFileItem());
        System.out.println(pfile.getName());
        /* 简单上传：创建文件路径，路径后面添加文件名字，在保存就可以了
        String path="d:/file/";//路径如果不存在 上传会失败
        string path="d:\\images\\";
        File filePath = new File(path + pfile.getOriginalFilename());
        */
        String path="d:/file/";
        /*下面步骤生成唯一文件名 加时间  或者再加随机数*/
        String oldname=pfile.getOriginalFilename();
        //不要原来的文件名，取文件类型 即.jpg 文件扩展名
        String expname=oldname.substring(oldname.lastIndexOf("."));
        //时间+后缀
        String newname=System.currentTimeMillis()+expname;
        File filePath = new File(path + newname);
        try {
            /*保存*/
            pfile.transferTo(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("insertHouse")
    public String addHouse(House house
            , HttpSession session,
                           @RequestParam(value = "pfile",required = false) MultipartFile pfile){
        try {
            //1.上传文件 MultipartFile 代表单个文件域，只上传一张
            String oldFileName=pfile.getOriginalFilename();  //获取上床文件的名字，文件名
            String extName=oldFileName.substring(oldFileName.lastIndexOf("."));//扩展名
            String bh=System.currentTimeMillis()+"";//时间毫秒  不重复
            String newfilename=bh+extName;
            String path="d:\\file\\"+newfilename;
            File saveFile=new File(path);
            pfile.transferTo(saveFile);   //上传 保存

            //2.调用业务将数据保存到数据库
            //设置编号
            house.setId(bh);
            //设置图片
            house.setPath(newfilename);
            //设置用户编号
            Users user=(Users) session.getAttribute("userinfo");
            house.setUserId(user.getId());
            System.out.println("inserthouse:"+house);
            houseService.insertHouse(house); //保存
            return "redirect:/page/selEHouse";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "fabu";
    }
    /*查询用户的house*/
    /*@RequestMapping("selEHouse")
    @ResponseBody
    public ModelAndView selEHouse(HttpSession session, ModelAndView mv){
        Users userinfo = (Users) session.getAttribute("userinfo");
        List<EHouse> eHouseList = houseService.selEHouse(userinfo.getId());
        System.out.println("selhouse:"+eHouseList.get(0).getTitle());
        mv.addObject("houselist",eHouseList);
        mv.setViewName("guanli");
        return mv;
    }*/

    @RequestMapping("selEHouse")
    public String selEhouse(HttpSession session, Model model){
        Users userinfo = (Users) session.getAttribute("userinfo");
        List<House> eHouseList = houseService.selEHouse(userinfo.getId());
        System.out.println("selhouse:"+eHouseList.get(0).getTitle());
        System.out.println("selhousepath:"+eHouseList.get(0).getPath());
        if (eHouseList.size()>0){
            model.addAttribute("houselist",eHouseList);
            return "guanli";
        }
        return "err";
    }
    /*修改显示*/
    @RequestMapping("showHouse")
    public String showHouse(String id ,Model model){
        House eHouse = houseService.selEHouseById(id);
        model.addAttribute("house",eHouse);
        System.out.println(eHouse);
        return "showUpdate";
    }
    /*修改*/
    @RequestMapping("updateHouse")
    public String updateHouse(House house
            , HttpSession session,
                              @RequestParam(value = "pfile",required = false) MultipartFile pfile){

        try {
            if (!pfile.isEmpty()){
                //1.上传文件 MultipartFile 代表单个文件域，只上传一张
                String oldFileName = pfile.getOriginalFilename();  //获取上传文件的名字，文件名
                String extName = oldFileName.substring(oldFileName.lastIndexOf("."));//扩展名
                String bh = System.currentTimeMillis() + "";//时间毫秒  不重复
                String newfilename = bh + extName;
                String path = "d:\\file\\" + newfilename;
                File saveFile = new File(path);
                pfile.transferTo(saveFile);   //上传 保存
                //2.调用业务将数据保存到数据库
                //设置编号
                //设置图片
                house.setPath(newfilename);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(house.toString());
        System.out.println("图片地址："+house.getPath());
        int i = houseService.updateHouse(house);
        System.out.println("i:"+i);

        return "redirect:selEHouse";
    }
    /*逻辑删除*/
    @RequestMapping("deleteHouse")
    public String deleteHouse(String id ){
        System.out.println("id:"+id);
        int i = houseService.deleteHouseById(id, 1);
        //return "{\"result\":i}";
        return "redirect:selEHouse";
    }
    /*list*/
    @RequestMapping("listc")
    public String listHouse(ListPageUtil listPageUtil,Model model){
        listPageUtil.setRows(3);
        System.out.println("listPageUtil:"+listPageUtil);
        PageInfo<House> housePageInfo = houseService.listHouse(listPageUtil);
        model.addAttribute("housepageinfo",housePageInfo);
        model.addAttribute("listpageUtil",listPageUtil);
        return "list";
    }

}
