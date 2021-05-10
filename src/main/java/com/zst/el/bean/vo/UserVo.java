package com.zst.el.bean.vo;

import com.zst.el.bean.BaseBean;
import com.zst.el.bean.EmUser;
import com.zst.el.bean.EmUserInfo;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * 用户类
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UserVo extends BaseBean implements Serializable {

    private static final long serialVersionUID = 5883208389725905601L;

    private String id;

    private String name;

    private String password;

    private String number;

    private String token;

    private String image;

    private List<String> corpInfo;

    private String roleId;

    private EmUser user;

    private EmUserInfo userInfo;

    private String sex;


}
