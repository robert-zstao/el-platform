package com.zst.el.controller;


import com.zst.el.bean.User;
import com.zst.el.bean.vo.Message;
import com.zst.el.bean.vo.PrototypeFactory;
import com.zst.el.logger.OperLog;
import com.zst.el.utils.StateCode;
import com.zst.el.utils.UUIDUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/auth")
public class AuthController extends BaseController{
    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 用户登录
     */
     @PostMapping("/login")
    public Message login(HttpServletRequest request,HttpSession session){
         Message message = PrototypeFactory.getMessage();
         String number = request.getParameter("number");
         String pwd = request.getParameter("password");
         User user = new User();
         //用户及权限验证
        user.setId("1");
        user.setNumber("123456");
        user.setName("Admin");
         //验证通过
         //设置session
         String token = UUIDUtils.getUUID();
         session.setAttribute(token,user);
         message.setData(token);
         message.setCode(StateCode.YES);
         message.setMessage("登录成功");

         return message;
     }


    @PostMapping("/test")
    @OperLog(model = "测试",type = StateCode.SELECT,desc = "用户登录")
    public Message test(){
        Message message = PrototypeFactory.getMessage();
        return message;
    }
}
