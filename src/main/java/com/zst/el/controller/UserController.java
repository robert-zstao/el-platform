package com.zst.el.controller;


import com.zst.el.bean.vo.Message;
import com.zst.el.bean.vo.PrototypeFactory;
import com.zst.el.utils.RedisUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    private Logger logger = Logger.getLogger(UserController.class);


    @GetMapping("/queryUserInfo")
    public Message querySubUser(@RequestParam(value = "token", required = true) String token,
                                @RequestParam(value = "userId", required = false) String userId){

        Message message = new Message();
       // message = userService.selectByCorp(systemUser, userId, fdUsername, userPhone,page,limit);

        return message;
    }

    /**
     * 添加用户
     * @robert
     * @date 2020.09.09
     * @param fdUserId
     * @param fdUserName
     * @param fdEnable
     * @param fdUserPwd
     * @param fdCorpId
     * @param fdPhone
     * @param roleCode
     * @return
     */
    @PostMapping("/insertUser")
    @ResponseBody
    public Message insertUser(@RequestParam(value = "username", required = true) String username,
                                     @RequestParam(value = "fdUserId", required = false) String fdUserId,
                                     @RequestParam(value = "fdUserName", required = false) String fdUserName,
                                     @RequestParam(value = "fdEnable", required = false) String fdEnable,
                                     @RequestParam(value = "fdUserPwd", required = false) String fdUserPwd,
                                     @RequestParam(value = "fdCorpId", required = false) String fdCorpId,
                                     @RequestParam(value = "fdPhone", required = false) String fdPhone,
                                     @RequestParam(value = "roleCode", required = false) String roleCode

    ){
        Message message = PrototypeFactory.getMessage();

        try {
            int count = 1;
            //int count = userService.insertUser(user,roleCode);
            if(count == 1){
                message.setCode("200");
                message.setMessage("新增成功");
            }else if(count == 2){
                message.setCode("500");
                message.setMessage("该用户账号已存在！");
            }else{
                message.setCode("500");
                message.setMessage("新增失败");
            }
        }catch (Exception e){
            message.setCode("500");
            message.setMessage("新增失败");
        }
        return message;
    }


}
