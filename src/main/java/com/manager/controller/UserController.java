package com.manager.controller;

import com.base.service.CommService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manager.model.Paget;
import com.manager.model.SysPermission;
import com.manager.service.UserService;
import com.utils.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by DaiLiang on 2018/1/10.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Resource
    private CommService commService;//公共service 已测试，可用

    @RequestMapping("/getUser")
    @ResponseBody
    public String getUser(){
        SysPermission permission=commService.getById(SysPermission.class,1);
        System.out.println("----------"+permission.getName());
        //SysUser u =userService.selectByPrimaryKey("1");
        PageHelper.startPage(1, 10);
        Map<String,String> map = new HashMap<>();
        map.put("lock","0");
       //List<SysUser> list2 = (List<SysUser>) userService.findByPage2(map);
        List<Paget> list2 =  userService.findByPage2(map);
        PageInfo<Paget> pageInfo = new PageInfo<Paget>(list2);
        long total = pageInfo.getTotal(); //获取总记录数
        System.out.println("共有商品信息：" + total);
        System.out.println("共有多少页：" + pageInfo.getPages());
        for (Paget u: list2) {
            System.out.println(u.getUserName());
        }

        return "1";
    }
    @RequestMapping("/main")
    public String main(HttpServletRequest request){
       /* String sessionId=request.getSession().getId();
        request.getSession().setAttribute("sid",sessionId);*/
        return "main";
    }
    @RequestMapping("/login")
    public String login(HttpServletRequest request){
        String sessionId=request.getSession().getId();
        request.getSession().setAttribute("sid",sessionId);
        try {
            InetAddress address = InetAddress.getLocalHost();//获取的是本地的IP地址 //PC-20140317PXKX/192.168.0.121
           // String ip = address.getHostAddress();
            String ipPort = request.getLocalAddr()+":"+request.getLocalPort(); //取得服务器IP +取得服务器端口;);
            //String ip = IpUtil.getIpAddress(request);
            //String ip =IpUtil.getCurrentIp().getHostAddress();
            request.getSession().setAttribute("name","负载均衡测试");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        System.out.println("--------------------");
        return "home";
    }

    @RequestMapping("/table")
    public String table(HttpServletRequest request){
       // request.getSession().invalidate();
        return  "table";
    }

}
